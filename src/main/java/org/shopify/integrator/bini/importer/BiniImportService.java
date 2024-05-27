package org.shopify.integrator.bini.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.juli.logging.Log;
import org.shopify.integrator.bini.service.BiniApiService;
import org.shopify.integrator.bini.service.config.BiniConfig;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
import org.shopify.integrator.bini.service.config.dto.order.BuyerInfo;
import org.shopify.integrator.bini.service.config.dto.order.Good;
import org.shopify.integrator.bini.service.config.dto.order.GoodsList;
import org.shopify.integrator.bini.service.config.dto.order.OrderMain;
import org.shopify.integrator.configpool.ConfigPool;
import org.shopify.integrator.db.entity.LineItem;
import org.shopify.integrator.db.entity.LineItemRepository;
import org.shopify.integrator.db.entity.OrderJpaRepository;
import org.shopify.integrator.multivendor.dto.InventoryLocation;
import org.shopify.integrator.multivendor.dto.order.Order;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForPost;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForRead;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForUpdate;
import org.shopify.integrator.multivendor.dto.variant.VariantForPost;
import org.shopify.integrator.multivendor.dto.variant.VariantForUpdate;
import org.shopify.integrator.multivendor.service.MultiVendorApiService;
import org.shopify.integrator.multivendor.service.MultiVendorObjectFactory;
import org.shopify.integrator.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BiniImportService {

    private static final Logger LOG = LoggerFactory.getLogger(BiniImportService.class);
    private static final Set<String> fakeCompareAtPrices = new HashSet<>();
    private final BiniConfig biniConfig;
    private final BiniApiService biniApiService;
    private final MultiVendorApiService multiVendorApiService;
    private final BiniDataMapper mapper;
    private final OrderJpaRepository orderJpaRepository;
    private final LineItemRepository lineItemRepository;
    private final ObjectMapper objectMapper;

    private final ConfigPool configPool;

    public BiniImportService(BiniConfig biniConfig, BiniApiService biniApiService, MultiVendorApiService multiVendorApiService, BiniDataMapper mapper, OrderJpaRepository orderJpaRepository, LineItemRepository lineItemRepository, ObjectMapper objectMapper, ConfigPool configPool) {
        this.biniConfig = biniConfig;
        this.biniApiService = biniApiService;
        this.multiVendorApiService = multiVendorApiService;
        this.mapper = mapper;
        this.orderJpaRepository = orderJpaRepository;
        this.lineItemRepository = lineItemRepository;
        this.objectMapper = objectMapper;
        this.configPool = configPool;
    }

    public void updatePrices() throws JsonProcessingException {
        if (!biniConfig.isEnabled()) {
            LOG.info("BINI export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of BINI updatePrices.");
        biniApiService.initLists();

        if (biniConfig.isLogReceivedData()) {
            LOG.info("All responses from BINI API received:");
            biniApiService.printFetchedLists();
        }


        LOG.info("Mapping products into single entity from various BINI APIs, please wait...");
        List<AggregatedProductDto> products = biniApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", biniApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", biniConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(biniConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(biniConfig.getSellerId())).toList();

        LOG.info("Updating prices ...");
        updatePrices(products, allMultiVendorProducts);

        LOG.info("Setting not available products stocks to 0 ...");
        //updateStocks(products, allMultiVendorProducts);

        LOG.info("Fake prices set for products: " + fakeCompareAtPrices);

        LOG.info("End of BINI updatePrices.");
    }

    public void startImport() throws JsonProcessingException {
        if (!biniConfig.isEnabled()) {
            LOG.info("BINI export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of BINI products export.");


        if (biniConfig.isLogReceivedData()) {
            LOG.info("All responses from BINI API received:");
            biniApiService.printFetchedLists();
        }

        LOG.info("Mapping products into single entity from various BINI APIs, please wait...");
        List<AggregatedProductDto> products = biniApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", biniApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", biniConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(biniConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(biniConfig.getSellerId())).toList();

        LOG.info("Setting not available products stocks to 0 ...");
        // updateStocks(products, allMultiVendorProducts);
        LOG.info("Importing products...");

        products.forEach(p -> {

            try {

                Optional<ProductMultiVendorForPost> savedProduct = mapper.mapProductMultiVendorByHandle(allMultiVendorProducts, p.getCode(), biniConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = mapper.mapProduct(savedProduct, p, biniConfig.getSellerId(), biniConfig.getLocationId());

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model
                    String savedProductId = multiVendorApiService.post(productMultiVendor, biniConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProductId, biniConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, biniConfig.getSellerId());

                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, biniConfig.getLocationId());

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, biniConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(savedProductId, variantUpdate, biniConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getSku(), p.getName());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }

                    });
                } else {
                    //Updating existing product, with images and options
                    ProductMultiVendorForUpdate productMultiVendorUpdate = MultiVendorObjectFactory.getProductMultiVendorForUpdateByProductMultiVendorForPost(productMultiVendor);
                    multiVendorApiService.updateProduct(productMultiVendorUpdate, savedProduct.get().getId(), biniConfig.getMultivendorAccessToken());
                    //Retrieving saved product with newly generated props from shopify
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProduct.get().getId(), biniConfig.getMultivendorAccessToken());
                    //Updating existing variants based on retrieved product
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, biniConfig.getSellerId());
                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, biniConfig.getLocationId());

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, biniConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(finalSavedProduct.getId(), variantUpdate, biniConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getSku(), p.getName());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }
                    });
                }
            } catch (Exception ex) {
                LOG.error("Errors while saving product via multiVendor API", ex);
            }
        });


        LOG.info("End of BINI products export.");
    }



    public void importNewProducts() throws JsonProcessingException {
        if (!biniConfig.isEnabled()) {
            LOG.info("BINI export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of BINI new products export.");
        biniApiService.initLists();

        if (biniConfig.isLogReceivedData()) {
            LOG.info("All responses from BINI API received:");
            biniApiService.printFetchedLists();
        }

        LOG.info("Mapping products into single entity from various BINI APIs, please wait...");


        List<AggregatedProductDto> products = biniApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", biniApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", biniConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(biniConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(biniConfig.getSellerId())).toList();
        LOG.info("Importing new products...");

        products.forEach(p -> {

            try {

                final List<String> skus = p.getStocks().stream().map(s -> s.getSku()).collect(Collectors.toList());
                if(skus.isEmpty()){
                    return;
                }

                Optional<ProductMultiVendorForPost> savedProduct = mapper.mapProductMultiVendorBySkus(allMultiVendorProducts, skus, biniConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = mapper.mapProduct(savedProduct, p, biniConfig.getSellerId(), biniConfig.getLocationId());


                if (savedProduct.isEmpty() ) {

                    //Saving new product along with options and image based on model
                    String savedProductId = multiVendorApiService.post(productMultiVendor, biniConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProductId, biniConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, biniConfig.getSellerId());

                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, biniConfig.getLocationId());

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, biniConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(savedProductId, variantUpdate, biniConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getSku(), p.getName());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }

                    });
                }else{
                    LOG.info("BINI product " +savedProduct.get().getId() + " already exists, skipping...");
                }
            } catch (Exception ex) {
                LOG.error("Errors while saving product via multiVendor API", ex);
            }
        });


        LOG.info("End of BINI new products export.");
    }

    public void updatePrices(List<AggregatedProductDto> prodcuts, List<ProductMultiVendorForRead> multiVendorProducts) {


        for (AggregatedProductDto biniProduct : prodcuts) {

            final Set<String> beeStoreProductIds = biniProduct.getStocks().stream().map(i -> i.getSku()).collect(Collectors.toSet());

            multiVendorProducts.stream()
                    .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                    .filter(p -> biniConfig.getSellerId().equals(p.getSellerId()))
                    .forEach(p -> {
                        List<VariantForPost> variants = p.getVariants().stream().filter(v -> beeStoreProductIds.contains(v.getSku())).toList();
                        variants.forEach(v -> {

                            try {
                                VariantForUpdate update = MultiVendorObjectFactory.getVariantForUpdateForVariantForPost(v);
                                for (int i = 0; i < p.getOptions().size(); i++) {
                                    switch (i) {
                                        case 0 -> update.setOption1(v.getCombinations().get(0).getOptionValue());
                                        case 1 -> update.setOption2(v.getCombinations().get(1).getOptionValue());
                                        case 2 -> update.setOption3(v.getCombinations().get(2).getOptionValue());
                                    }
                                }


                                try {
                                    String imageId = p.getImages().get(0).getId();
                                    if (!imageId.trim().equalsIgnoreCase("0")) {
                                        update.setImageId(imageId);
                                    }
                                } catch (Exception tmp) {

                                }

                                if (biniProduct.getStocks() != null) {

                                    Optional<AggregatedProductDto.StocksAndPricing> stocks = biniProduct.getStocks().stream().filter(i -> i.getSku().equalsIgnoreCase(v.getSku())).findFirst();
                                    if (stocks.isPresent()) {
                                        update.setCompareAtPrice(stocks.get().getCompareAtPrice().replace(",", "."));
                                        update.setPrice(stocks.get().getPrice().replace(",", "."));
                                        update.setQuantity(stocks.get().getQuantity());

                                        if (CollectionUtils.isEmpty(v.getInventoryLocations())) {
                                            update.setInventoryLocations(List.of(new InventoryLocation(biniConfig.getLocationId(), stocks.get().getQuantity())));
                                        } else {
                                            update.setInventoryLocations(v.getInventoryLocations().stream().map(l -> {
                                                l.setVariantQuantity(stocks.get().getQuantity());
                                                return l;
                                            }).toList());
                                        }

                                        if (stocks.get().isFakeCompareAtPrice()) {
                                            fakeCompareAtPrices.add(p.getId());
                                        }
                                    }
                                }


                                LOG.info("Updating products " + p.getId() + " variant " + v.getId());
                                multiVendorApiService.updateVariant(p.getId(), v.getId(), update, biniConfig.getMultivendorAccessToken());
                            } catch (Exception ex) {
                                LOG.error("Prices update errors ", ex);
                            }

                        });
                    });

        }
    }

    public void processOrders() {

        if (!biniConfig.isEnabled()) {
            LOG.info("BINI export is disabled. You can change this in application properties");
            return;
        }


        List<AggregatedProductDto> products = biniApiService.getAllProducts();
        String dateFrom = Utils.getMidnightDateString();
        dateFrom = "2022-03-29 00:00:00"; // Todo temp testing solution delete later

        String dateTo = Utils.getCurrentDateString();

        String filter = "{\"date_from\":\"" + dateFrom + "\", \"date_to\":\"" + dateTo + "\"}";
        List<Order> shopifyOrders = multiVendorApiService.getAllOrders(biniConfig.getMultivendorAccessToken(), filter);

        shopifyOrders.forEach(i -> {
            try {

                //Retrieving all orders
                String obj = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(i);
                org.shopify.integrator.db.entity.Order order = objectMapper.readValue(obj, org.shopify.integrator.db.entity.Order.class);

                //Updating item from existing in database
                order.setLineItems(order.getLineItems()
                        .stream()
                        .map(item -> {

                            item.setSeller(configPool.getSellerBySellerId(item.getSellerId()));
                            return item;
                        })
                        .map(item -> lineItemRepository.findById(item.getId()).orElse(item))
                        .collect(Collectors.toList()));

                //Persisting infromation
                order = orderJpaRepository.save(order);

                // If order is paid extracting all not sent order items to bini
                if ("1".equalsIgnoreCase(order.getIsPaid()) && "0".equalsIgnoreCase(order.getIsRefunded())) {

                    List<LineItem> notSentOrders = order.getLineItems().stream().filter(item -> !item.isOrderSentToProvider() && "BINI".equalsIgnoreCase(item.getSeller())).collect(Collectors.toList());

                    org.shopify.integrator.db.entity.Order orderEnt = order;
                    notSentOrders.stream().forEach(item -> {
                        try {

                            OrderMain orderMain = new OrderMain();
                            orderMain.setOrderId(item.getOrderId());
                            orderMain.setRetailer(item.getSeller());
                            BuyerInfo info = new BuyerInfo();

                            info.setName(orderEnt.getShippingAddressEntity().getName());
                            info.setSurname(orderEnt.getShippingAddressEntity().getLastName());
                            info.setAddress(orderEnt.getAddress1());
                            info.setZipCode(orderEnt.getZip());
                            info.setCity(orderEnt.getCity());
                            info.setPhoneNumber(orderEnt.getPhone());
                            info.setEmail(orderEnt.getCustomerEmail());
                            info.setISOcountry(orderEnt.getShippingAddressEntity().getCountryCode());
                            info.setTypeShipping("Direct");
                            info.setDestinationName(orderEnt.getShippingAddressEntity().getName());
                            info.setDestinationSurname(orderEnt.getShippingAddressEntity().getLastName());
                            info.setDestinationZipCode(orderEnt.getShippingAddressEntity().getZip());
                            info.setDestinationAddress(orderEnt.getShippingAddressEntity().getAddress1());
                            info.setDestinationCity(orderEnt.getShippingAddressEntity().getCity());
                            info.setDestinationISOcountry(orderEnt.getShippingAddressEntity().getCountryCode());
                            orderMain.setBuyerInfo(info);

                            GoodsList goodsList = new GoodsList();
                            goodsList.getGood().addAll(notSentOrders.stream().map(orderedItem -> {


                                ProductMultiVendorForRead shopifyProduct = multiVendorApiService.getProduct(orderedItem.getProductId(), biniConfig.getMultivendorAccessToken());

                                LOG.info(shopifyProduct.getHandle());

                                AggregatedProductDto productBini = products.stream().filter(product -> product.getStocks().stream().map(a -> a.getSku()).collect(Collectors.toList()).contains(orderedItem.getSku())).findFirst().get();
                                AggregatedProductDto.StocksAndPricing orderedStock = productBini.getStocks().stream().filter(stock -> stock.getSku().equals(orderedItem.getSku())).findFirst().get();

                                Good good = new Good();
                                good.setId(productBini.getId());
                                good.setSize(orderedStock.getSize());
                                good.setPrice(orderedItem.getProductPrice().replace(".", ","));
                                good.setCurrency("EUR");
                                good.setQty(orderedItem.getTotalQuantity());

                                return good;
                            }).collect(Collectors.toList()));

                            orderMain.setGoodsList(goodsList);
                            LOG.info("Posting new order to BINI -> " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderMain));
                            biniApiService.postOrder(orderMain);

                            item.setErrorMsg(null);
                            item.setOrderSentToProvider(true);
                            lineItemRepository.save(item);

                        } catch (Exception sellerEx) {
                            item.setErrorMsg(sellerEx.getMessage());
                            item.setOrderSentToProvider(false);
                            lineItemRepository.save(item);
                            LOG.error("Errors while trying to post order to seller " + item.getSeller(), sellerEx);
                        }

                    });
                }

            } catch (Exception ex) {
                LOG.error("Errors ", ex);
            }

        });

    }

}
