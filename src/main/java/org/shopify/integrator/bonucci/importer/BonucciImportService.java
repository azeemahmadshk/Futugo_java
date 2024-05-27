package org.shopify.integrator.bonucci.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
import org.shopify.integrator.bonucci.service.BonucciApiService;
import org.shopify.integrator.bonucci.service.config.BonucciConfig;
import org.shopify.integrator.multivendor.dto.InventoryLocation;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForPost;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForRead;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForUpdate;
import org.shopify.integrator.multivendor.dto.variant.VariantForPost;
import org.shopify.integrator.multivendor.dto.variant.VariantForUpdate;
import org.shopify.integrator.multivendor.service.MultiVendorApiService;
import org.shopify.integrator.multivendor.service.MultiVendorObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class BonucciImportService {

    private static final Logger LOG = LoggerFactory.getLogger(BonucciImportService.class);
    private final BonucciConfig bonucciConfig;
    private final BonucciApiService bonucciApiService;
    private final MultiVendorApiService multiVendorApiService;
    private final BonucciDataMapper mapper;

    public BonucciImportService(BonucciConfig bonucciConfig, BonucciApiService bonucciApiService, MultiVendorApiService multiVendorApiService, BonucciDataMapper mapper) {
        this.bonucciConfig = bonucciConfig;
        this.bonucciApiService = bonucciApiService;
        this.multiVendorApiService = multiVendorApiService;
        this.mapper = mapper;
    }


    public void updatePrices() throws JsonProcessingException {
        if (!bonucciConfig.isEnabled()) {
            LOG.info("Bonucci export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of Bonucci updatePrices.");
        bonucciApiService.initLists();


        if (bonucciConfig.isLogReceivedData()) {
            LOG.info("All responses from Bonucci API received:");
            bonucciApiService.printFetchedLists();
        }


        LOG.info("Mapping products into single entity from various BINI APIs, please wait...");
        List<AggregatedProductDto> products = bonucciApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", bonucciApiService.getJson(products));
        LOG.info("Total Bonucci products to import:{}", products.size());
        final long total = products.size();

        LOG.info("Retrieving all products from shopify with sellerId {} ...", bonucciConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(bonucciConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(bonucciConfig.getSellerId())).toList();

        LOG.info("Updating prices ...");
        updatePrices(products, allMultiVendorProducts);
        LOG.info("End of Bonucci updatePrices.");
    }

    public void startImport() throws JsonProcessingException {
        if (!bonucciConfig.isEnabled()) {
            LOG.info("Bonucci export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of Bonucci products export.");


        if (bonucciConfig.isLogReceivedData()) {
            LOG.info("All responses from Bonucci API received:");
            bonucciApiService.printFetchedLists();
        }

        LOG.info("Mapping products into single entity from various BINI APIs, please wait...");
        List<AggregatedProductDto> products = bonucciApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", bonucciApiService.getJson(products));

        LOG.info("Total Bonucci products to import:{}", products.size());
        final long total = products.size();


        LOG.info("Retrieving all products from shopify with sellerId {} ...", bonucciConfig.getSellerId());

        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(bonucciConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(bonucciConfig.getSellerId())).toList();
        LOG.info("Importing products...");

        AtomicLong processed = new AtomicLong(0);
        products.forEach(p -> {

            try {

                Optional<ProductMultiVendorForPost> savedProduct = mapper.mapProductMultiVendorByHandle(allMultiVendorProducts, p.getCode(), bonucciConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = mapper.mapProduct(savedProduct, p, bonucciConfig.getSellerId(), bonucciConfig.getLocationId());

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model
                    String savedProductId = multiVendorApiService.post(productMultiVendor, bonucciConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProductId, bonucciConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, bonucciConfig.getSellerId());

                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, bonucciConfig.getLocationId());

                            variantUpdate.setCompareAtPrice(null);

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, bonucciConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(savedProductId, variantUpdate, bonucciConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getSku(), p.getName());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }

                    });
                } else {
                    //Updating existing product, with images and options
                    ProductMultiVendorForUpdate productMultiVendorUpdate = MultiVendorObjectFactory.getProductMultiVendorForUpdateByProductMultiVendorForPost(productMultiVendor);
                    multiVendorApiService.updateProduct(productMultiVendorUpdate, savedProduct.get().getId(), bonucciConfig.getMultivendorAccessToken());
                    //Retrieving saved product with newly generated props from shopify
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProduct.get().getId(), bonucciConfig.getMultivendorAccessToken());
                    //Updating existing variants based on retrieved product
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, bonucciConfig.getSellerId());
                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, bonucciConfig.getLocationId());
                            variantUpdate.setCompareAtPrice(null);
                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, bonucciConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(finalSavedProduct.getId(), variantUpdate, bonucciConfig.getMultivendorAccessToken());
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

            LOG.info("Processed Bonucci objects {} of {}", processed.incrementAndGet(), total);
        });


        LOG.info("Updating stocks and variants");
        updatePrices(products, allMultiVendorProducts);

        LOG.info("End of Bonucci products export.");
    }


    public void importNewProducts() throws JsonProcessingException {
        if (!bonucciConfig.isEnabled()) {
            LOG.info("Bonucci based export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of Bonucci based new products export.");

        bonucciApiService.initLists();
        if (bonucciConfig.isLogReceivedData()) {
            LOG.info("All responses from Bonucci based API received:");
            bonucciApiService.printFetchedLists();
        }

        LOG.info("Mapping products into single entity from various BINI based APIs, please wait...");
        List<AggregatedProductDto> products = bonucciApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", bonucciApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", bonucciConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(bonucciConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(bonucciConfig.getSellerId())).toList();
        LOG.info("Importing new products...");

        products.forEach(p -> {

            try {

                final List<String> skus = p.getStocks().stream().map(s -> s.getSku()).collect(Collectors.toList());
                if(skus.isEmpty()){
                    return;
                }

                Optional<ProductMultiVendorForPost> savedProduct = mapper.mapProductMultiVendorBySkus(allMultiVendorProducts, p.getStocks().stream().map(s -> s.getSku()).collect(Collectors.toList()), bonucciConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = mapper.mapProduct(savedProduct, p, bonucciConfig.getSellerId(), bonucciConfig.getLocationId());

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model
                    String savedProductId = multiVendorApiService.post(productMultiVendor, bonucciConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProductId, bonucciConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, bonucciConfig.getSellerId());

                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, bonucciConfig.getLocationId());

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, bonucciConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(savedProductId, variantUpdate, bonucciConfig.getMultivendorAccessToken());
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


        LOG.info("End of Bonucci based new products export.");
    }


    public void updatePrices(List<AggregatedProductDto> prodcuts, List<ProductMultiVendorForRead> multiVendorProducts) {


        for (AggregatedProductDto biniProduct : prodcuts) {

            final Set<String> beeStoreProductIds = biniProduct.getStocks().stream().map(i -> i.getSku()).collect(Collectors.toSet());

            multiVendorProducts.stream()
                    .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                    .filter(p -> bonucciConfig.getSellerId().equals(p.getSellerId()))
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
                                        update.setPrice(stocks.get().getPrice().replace(",", "."));
                                        update.setQuantity(stocks.get().getQuantity());

                                        if (CollectionUtils.isEmpty(v.getInventoryLocations())) {
                                            update.setInventoryLocations(List.of(new InventoryLocation(bonucciConfig.getLocationId(), stocks.get().getQuantity())));
                                        } else {
                                            update.setInventoryLocations(v.getInventoryLocations().stream().map(l -> {
                                                l.setVariantQuantity(stocks.get().getQuantity());
                                                return l;
                                            }).toList());
                                        }
                                    }
                                }

                                update.setCompareAtPrice(null);
                                LOG.info("Updating products " + p.getId() + " variant " + v.getId());
                                multiVendorApiService.updateVariant(p.getId(), v.getId(), update, bonucciConfig.getMultivendorAccessToken());
                            } catch (Exception ex) {
                                LOG.error("Prices update errors ", ex);
                            }

                        });
                    });

        }
    }


}
