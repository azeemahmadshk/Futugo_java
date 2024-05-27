package org.shopify.integrator.beestore.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.beestore.service.BeeStoreFtpFileValuesExtractor;
import org.shopify.integrator.beestore.service.BeeStoreFtpProduct;
import org.shopify.integrator.beestore.service.BeeStoreFtpService;
import org.shopify.integrator.beestore.service.config.BeeStoreConfig;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
import org.shopify.integrator.multivendor.dto.InventoryLocation;
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
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BeeStoreImportService {

    private static final Logger LOG = LoggerFactory.getLogger(BeeStoreImportService.class);
    private final BeeStoreConfig beeStoreConfig;
    private final BeeStoreFtpService beeStoreFtpService;
    private final MultiVendorApiService multivendorApiService;
    private final BeeStoreDataMapper beeStoreDateMapper;

    public BeeStoreImportService(BeeStoreConfig beeStoreConfig, BeeStoreFtpService beeStoreFtpService, MultiVendorApiService multivendorApiService, BeeStoreDataMapper beeStoreDateMapper) {
        this.beeStoreConfig = beeStoreConfig;
        this.beeStoreFtpService = beeStoreFtpService;
        this.multivendorApiService = multivendorApiService;
        this.beeStoreDateMapper = beeStoreDateMapper;
    }

    private static List<String> fakeCompareAtPrices = new ArrayList<>();
    public void updatePrices() throws JsonProcessingException {

        if (!beeStoreConfig.isEnabled()) {
            LOG.info("BeeStore prices export is disabled.");
            return;
        }
        LOG.info("Begin of BeeStore prices update.");

        final List<BeeStoreFtpProduct> beeStoreProducts = beeStoreFtpService.getLatestProducts().stream().filter(i -> StringUtils.isNotEmpty(i.getURLImg1())).toList();

        if (beeStoreProducts.isEmpty()) {
            LOG.error("No products downloaded via FTP. Maybe file in FT not exists, aborting ...");
            return;
        }

        LOG.info("Retrieving all products from shopify with sellerId {} ...", beeStoreConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multivendorApiService.getAllProducts(beeStoreConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(beeStoreConfig.getSellerId())).toList();
        //Setting stock quantity to 0 for missing products in beeStore
        LOG.info("Updating prices ...");
        updatePrices(beeStoreProducts, allMultiVendorProducts);
        LOG.info("Setting not available products stocks to 0 ...");
        updateStocks(beeStoreProducts, allMultiVendorProducts);
        LOG.info("End of BeeStore updatePrices.");
    }

    public void startImport() {

        if (!beeStoreConfig.isEnabled()) {
            LOG.info("BeeStore products export is disabled.");
            return;
        }
        LOG.info("Begin of BeeStore products export.");

        final List<BeeStoreFtpProduct> beeStoreProducts = beeStoreFtpService.getLatestProducts().stream().filter(i -> StringUtils.isNotEmpty(i.getURLImg1())).toList();

        if (beeStoreProducts.isEmpty()) {
            LOG.error("No products downloaded via FTP. Maybe file in FT not exists, aborting ...");
            return;
        }

        LOG.info("Retrieving all products from shopify with sellerId {} ...", beeStoreConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multivendorApiService.getAllProducts(beeStoreConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(beeStoreConfig.getSellerId())).toList();
        final Map<String, List<BeeStoreFtpProduct>> beeStoreProductsGroupedByModel = beeStoreProducts.stream().collect(Collectors.groupingBy(i -> i.getModello()));

        //Setting stock quantity to 0 for missing products in beeStore

        LOG.info("Setting not available products stocks to 0 ...");
        updateStocks(beeStoreProducts, allMultiVendorProducts);
        LOG.info("Importing products...");

        beeStoreProductsGroupedByModel.forEach((model, productVariants) -> {

            try {
                BeeStoreFtpProduct mainVariant = productVariants.get(0);
                Optional<ProductMultiVendorForPost> savedProduct = beeStoreDateMapper.mapProductMultiVendorByHandle(allMultiVendorProducts, model);
                ProductMultiVendorForPost productMultiVendor = beeStoreDateMapper.mapProduct(savedProduct, mainVariant);

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model
                    String savedProductId = multivendorApiService.post(productMultiVendor, beeStoreConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multivendorApiService.getProduct(savedProductId, beeStoreConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = beeStoreDateMapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved);
                    productVariants.stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = beeStoreDateMapper.mapVariantForUpdate(variant, finalSavedProduct);

                            if (variant.equals(mainVariant)) {
                                //Updating existng main
                                multivendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, beeStoreConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multivendorApiService.postVariant(savedProductId, variantUpdate, beeStoreConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getCodArticolo(), variant.getDSArticolo());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }

                    });
                } else {
                    //Updating existing product, with images and options
                    ProductMultiVendorForUpdate productMultiVendorUpdate = MultiVendorObjectFactory.getProductMultiVendorForUpdateByProductMultiVendorForPost(productMultiVendor);
                    multivendorApiService.updateProduct(productMultiVendorUpdate, savedProduct.get().getId(), beeStoreConfig.getMultivendorAccessToken());
                    //Retrieving saved product with newly generated props from shopify
                    ProductMultiVendorForRead objRetrieved = multivendorApiService.getProduct(savedProduct.get().getId(), beeStoreConfig.getMultivendorAccessToken());
                    //Updating existing variants based on retrieved product
                    ProductMultiVendorForPost finalSavedProduct = beeStoreDateMapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved);
                    productVariants.stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = beeStoreDateMapper.mapVariantForUpdate(variant, finalSavedProduct);

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multivendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, beeStoreConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multivendorApiService.postVariant(finalSavedProduct.getId(), variantUpdate, beeStoreConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getCodArticolo(), variant.getDSArticolo());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }
                    });
                }
            } catch (Exception ex) {
                LOG.error("Errors while saving product via multiVendor API", ex);
            }
        });

        LOG.info("End of BeeStore products export.");
    }


    public void importNewProducts() {

        if (!beeStoreConfig.isEnabled()) {
            LOG.info("BeeStore new  products export is disabled.");
            return;
        }
        LOG.info("Begin of BeeStore products export.");

        final List<BeeStoreFtpProduct> beeStoreProducts = beeStoreFtpService.getLatestProducts().stream().filter(i -> StringUtils.isNotEmpty(i.getURLImg1())).toList();

        if (beeStoreProducts.isEmpty()) {
            LOG.error("No products downloaded via FTP. Maybe file in FT not exists, aborting ...");
            return;
        }

        LOG.info("Retrieving all products from shopify with sellerId {} ...", beeStoreConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multivendorApiService.getAllProducts(beeStoreConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(beeStoreConfig.getSellerId())).toList();
        final Map<String, List<BeeStoreFtpProduct>> beeStoreProductsGroupedByModel = beeStoreProducts.stream().collect(Collectors.groupingBy(i -> i.getModello()));

        //Setting stock quantity to 0 for missing products in beeStore

        LOG.info("Setting not available products stocks to 0 ...");
       // updateStocks(beeStoreProducts, allMultiVendorProducts);
        LOG.info("Importing products...");

        beeStoreProductsGroupedByModel.forEach((model, productVariants) -> {

            try {
                BeeStoreFtpProduct mainVariant = productVariants.get(0);


                final List<String> skus = productVariants.stream().map(i -> i.getCodArticolo()).collect(Collectors.toList());
                if(skus.isEmpty()){
                    return;
                }

                Optional<ProductMultiVendorForPost> savedProduct = beeStoreDateMapper.mapProductMultiVendorBySkus(allMultiVendorProducts, skus,  beeStoreConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = beeStoreDateMapper.mapProduct(savedProduct, mainVariant);

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model
                    String savedProductId = multivendorApiService.post(productMultiVendor, beeStoreConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multivendorApiService.getProduct(savedProductId, beeStoreConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = beeStoreDateMapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved);
                    productVariants.stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = beeStoreDateMapper.mapVariantForUpdate(variant, finalSavedProduct);

                            if (variant.equals(mainVariant)) {
                                //Updating existng main
                                multivendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, beeStoreConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multivendorApiService.postVariant(savedProductId, variantUpdate, beeStoreConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getCodArticolo(), variant.getDSArticolo());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }

                    });
                }
            } catch (Exception ex) {
                LOG.error("Errors while saving product via multiVendor API", ex);
            }
        });

        LOG.info("End of BeeStore new products export.");
    }

    // Filters all products not in BeeStore but saved in Shopify and sets their quantities to 0
    public void updateStocks(List<BeeStoreFtpProduct> beeStoreProducts, List<ProductMultiVendorForRead> multiVendorProducts) {

        final Set<String> beeStoreProductIds = BeeStoreFtpFileValuesExtractor.getAllDistinctValuesByProperty(beeStoreProducts, "CodArticolo");

        multiVendorProducts.stream()
                .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                .filter(p -> beeStoreConfig.getSellerId().equals(p.getSellerId()))
                .forEach(p -> {
                    List<VariantForPost> noLongerPresentVariants = p.getVariants().stream().filter(v -> !beeStoreProductIds.contains(v.getSku())).toList();
                    noLongerPresentVariants.forEach(v -> {
                        try {
                            VariantForUpdate update = MultiVendorObjectFactory.getVariantForUpdateForVariantForPost(v);
                            update.setQuantity("0");

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


                            if (CollectionUtils.isEmpty(v.getInventoryLocations())) {
                                update.setInventoryLocations(List.of(new InventoryLocation(beeStoreConfig.getLocationId(), "0")));
                            } else {
                                update.setInventoryLocations(v.getInventoryLocations().stream().map(l -> {
                                    l.setVariantQuantity("0");
                                    return l;
                                }).toList());
                            }
                            multivendorApiService.updateVariant(p.getId(), v.getId(), update, beeStoreConfig.getMultivendorAccessToken());
                        } catch (Exception ex) {
                            LOG.error("Stocks update errors ", ex);
                        }

                    });
                });

    }


    public void updatePrices(List<BeeStoreFtpProduct> beeStoreProducts, List<ProductMultiVendorForRead> multiVendorProducts) {

        final Set<String> beeStoreProductIds = BeeStoreFtpFileValuesExtractor.getAllDistinctValuesByProperty(beeStoreProducts, "CodArticolo");

        multiVendorProducts.stream()
                .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                .filter(p -> beeStoreConfig.getSellerId().equals(p.getSellerId()))
                .forEach(p -> {
                    List<VariantForPost> noLongerPresentVariants = p.getVariants().stream().filter(v -> !beeStoreProductIds.contains(v.getSku())).toList();
                    noLongerPresentVariants.forEach(v -> {
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


                            Optional<BeeStoreFtpProduct> beeStoreProduct = beeStoreProducts.stream().filter(i -> i.getBarCode().equalsIgnoreCase(v.getSku())).findFirst();

                            if (beeStoreProduct.isPresent()) {

                                if (StringUtils.isNotEmpty(beeStoreProduct.get().getPrezzoIvato())) {
                                    BigDecimal price = new BigDecimal(beeStoreProduct.get().getPrezzoIvato());
                                    update.setPrice(Utils.getDecimalFormatter("0.00").format(price));
                                    update.setCompareAtPrice(Utils.getDecimalFormatter("0.00").format(price.multiply(new BigDecimal("1.001"))));
                                    update.setQuantity(StringUtils.defaultString(beeStoreProduct.get().getDisponibilita()));

                                }

                                if (CollectionUtils.isEmpty(v.getInventoryLocations())) {
                                    update.setInventoryLocations(List.of(new InventoryLocation(beeStoreConfig.getLocationId(), beeStoreProduct.get().getDisponibilita())));
                                } else {
                                    update.setInventoryLocations(v.getInventoryLocations().stream().map(l -> {
                                        l.setVariantQuantity(beeStoreProduct.get().getDisponibilita());
                                        return l;
                                    }).toList());
                                }


                            }


                            multivendorApiService.updateVariant(p.getId(), v.getId(), update, beeStoreConfig.getMultivendorAccessToken());
                        } catch (Exception ex) {
                            LOG.error("Stocks update errors ", ex);
                        }

                    });
                });

    }
//this method
    //  public void processOrders() {

    //     if (!beeStoreConfig.isEnabled()) {
    //         LOG.info("BeeStore export is disabled. You can change this in application properties");
    //         return;
    //     }


    //     List<AggregatedProductDto> products = biniApiService.getAllProducts();
    //     String dateFrom = Utils.getMidnightDateString();
    //     dateFrom = "2022-03-29 00:00:00"; // Todo temp testing solution delete later

    //     String dateTo = Utils.getCurrentDateString();

    //     String filter = "{\"date_from\":\"" + dateFrom + "\", \"date_to\":\"" + dateTo + "\"}";
    //     List<Order> shopifyOrders = multiVendorApiService.getAllOrders(biniConfig.getMultivendorAccessToken(), filter);

    //     shopifyOrders.forEach(i -> {
    //         try {

    //             //Retrieving all orders
    //             String obj = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(i);
    //             org.shopify.integrator.db.entity.Order order = objectMapper.readValue(obj, org.shopify.integrator.db.entity.Order.class);

    //             //Updating item from existing in database
    //             order.setLineItems(order.getLineItems()
    //                     .stream()
    //                     .map(item -> {

    //                         item.setSeller(configPool.getSellerBySellerId(item.getSellerId()));
    //                         return item;
    //                     })
    //                     .map(item -> lineItemRepository.findById(item.getId()).orElse(item))
    //                     .collect(Collectors.toList()));

    //             //Persisting infromation
    //             order = orderJpaRepository.save(order);

    //             // If order is paid extracting all not sent order items to bini
    //             if ("1".equalsIgnoreCase(order.getIsPaid()) && "0".equalsIgnoreCase(order.getIsRefunded())) {

    //                 List<LineItem> notSentOrders = order.getLineItems().stream().filter(item -> !item.isOrderSentToProvider() && "BINI".equalsIgnoreCase(item.getSeller())).collect(Collectors.toList());

    //                 org.shopify.integrator.db.entity.Order orderEnt = order;
    //                 notSentOrders.stream().forEach(item -> {
    //                     try {

    //                         OrderMain orderMain = new OrderMain();
    //                         orderMain.setOrderId(item.getOrderId());
    //                         orderMain.setRetailer(item.getSeller());
    //                         BuyerInfo info = new BuyerInfo();

    //                         info.setName(orderEnt.getShippingAddressEntity().getName());
    //                         info.setSurname(orderEnt.getShippingAddressEntity().getLastName());
    //                         info.setAddress(orderEnt.getAddress1());
    //                         info.setZipCode(orderEnt.getZip());
    //                         info.setCity(orderEnt.getCity());
    //                         info.setPhoneNumber(orderEnt.getPhone());
    //                         info.setEmail(orderEnt.getCustomerEmail());
    //                         info.setISOcountry(orderEnt.getShippingAddressEntity().getCountryCode());
    //                         info.setTypeShipping("Direct");
    //                         info.setDestinationName(orderEnt.getShippingAddressEntity().getName());
    //                         info.setDestinationSurname(orderEnt.getShippingAddressEntity().getLastName());
    //                         info.setDestinationZipCode(orderEnt.getShippingAddressEntity().getZip());
    //                         info.setDestinationAddress(orderEnt.getShippingAddressEntity().getAddress1());
    //                         info.setDestinationCity(orderEnt.getShippingAddressEntity().getCity());
    //                         info.setDestinationISOcountry(orderEnt.getShippingAddressEntity().getCountryCode());
    //                         orderMain.setBuyerInfo(info);

    //                         GoodsList goodsList = new GoodsList();
    //                         goodsList.getGood().addAll(notSentOrders.stream().map(orderedItem -> {


    //                             ProductMultiVendorForRead shopifyProduct = multiVendorApiService.getProduct(orderedItem.getProductId(), biniConfig.getMultivendorAccessToken());

    //                             LOG.info(shopifyProduct.getHandle());

    //                             AggregatedProductDto productBini = products.stream().filter(product -> product.getStocks().stream().map(a -> a.getSku()).collect(Collectors.toList()).contains(orderedItem.getSku())).findFirst().get();
    //                             AggregatedProductDto.StocksAndPricing orderedStock = productBini.getStocks().stream().filter(stock -> stock.getSku().equals(orderedItem.getSku())).findFirst().get();

    //                             Good good = new Good();
    //                             good.setId(productBini.getId());
    //                             good.setSize(orderedStock.getSize());
    //                             good.setPrice(orderedItem.getProductPrice().replace(".", ","));
    //                             good.setCurrency("EUR");
    //                             good.setQty(orderedItem.getTotalQuantity());

    //                             return good;
    //                         }).collect(Collectors.toList()));

    //                         orderMain.setGoodsList(goodsList);
    //                         LOG.info("Posting new order to BINI -> " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderMain));
    //                         biniApiService.postOrder(orderMain);

    //                         item.setErrorMsg(null);
    //                         item.setOrderSentToProvider(true);
    //                         lineItemRepository.save(item);

    //                     } catch (Exception sellerEx) {
    //                         item.setErrorMsg(sellerEx.getMessage());
    //                         item.setOrderSentToProvider(false);
    //                         lineItemRepository.save(item);
    //                         LOG.error("Errors while trying to post order to seller " + item.getSeller(), sellerEx);
    //                     }

    //                 });
    //             }

    //         } catch (Exception ex) {
    //             LOG.error("Errors ", ex);
    //         }

    //     });

    // }

}
