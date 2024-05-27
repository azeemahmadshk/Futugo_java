package org.shopify.integrator.bini.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.bini.service.BiniApiService;
import org.shopify.integrator.bini.service.BiniBasedApiService;
import org.shopify.integrator.bini.service.config.BiniBasedConfig;
import org.shopify.integrator.bini.service.config.BiniConfig;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BiniBasedShopImportService {

    private static final Logger LOG = LoggerFactory.getLogger(BiniBasedShopImportService.class);
    private static final Set<String> fakeCompareAtPrices = new HashSet<>();
    private final BiniBasedConfig biniBasedConfig;
    private final BiniBasedApiService biniBasedApiService;
    private final MultiVendorApiService multiVendorApiService;
    private final BiniDataMapper mapper;

    public BiniBasedShopImportService(BiniBasedConfig biniBasedConfig, BiniBasedApiService biniBasedApiService, MultiVendorApiService multiVendorApiService, BiniDataMapper mapper) {
        this.biniBasedConfig = biniBasedConfig;
        this.biniBasedApiService = biniBasedApiService;
        this.multiVendorApiService = multiVendorApiService;
        this.mapper = mapper;
    }


    public void updatePrices() throws JsonProcessingException {
        if (!biniBasedConfig.isEnabled()) {
            LOG.info("BINI based shop export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of BINI  based shop  updatePrices.");
        biniBasedApiService.initLists();


        if (biniBasedConfig.isLogReceivedData()) {
            LOG.info("All responses from BINI  based shop  API received:");
            biniBasedApiService.printFetchedLists();
        }


        LOG.info("Mapping products into single entity from various BINI  based shop  APIs, please wait...");
        List<AggregatedProductDto> products = biniBasedApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", biniBasedApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", biniBasedConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(biniBasedConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(biniBasedConfig.getSellerId())).toList();

        LOG.info("Updating prices ...");
        updatePrices(products, allMultiVendorProducts);

        LOG.info("Setting not available products stocks to 0 ...");
        //updateStocks(products, allMultiVendorProducts);

        LOG.info("Fake prices set for products: " + fakeCompareAtPrices.toString());

        LOG.info("End of BINI  based shop  updatePrices.");
    }

    public void startImport() throws JsonProcessingException {
        if (!biniBasedConfig.isEnabled()) {
            LOG.info("BINI  based shop  export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of BINI  based shop  products export.");


        if (biniBasedConfig.isLogReceivedData()) {
            LOG.info("All responses from BINI API received:");
            biniBasedApiService.printFetchedLists();
        }

        LOG.info("Mapping products into single entity from various BINI APIs, please wait...");
        List<AggregatedProductDto> products = biniBasedApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", biniBasedApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", biniBasedConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(biniBasedConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(biniBasedConfig.getSellerId())).toList();

        LOG.info("Setting not available products stocks to 0 ...");
        // updateStocks(products, allMultiVendorProducts);
        LOG.info("Importing products...");

        products.forEach(p -> {

            try {

                Optional<ProductMultiVendorForPost> savedProduct = mapper.mapProductMultiVendorByHandle(allMultiVendorProducts, p.getCode(), biniBasedConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = mapper.mapProduct(savedProduct, p, biniBasedConfig.getSellerId(), biniBasedConfig.getLocationId());

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model

                    productMultiVendor.clearCompareAtPrice();

                    String savedProductId = multiVendorApiService.post(productMultiVendor, biniBasedConfig.getMultivendorAccessToken()).getId();

                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProductId, biniBasedConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, biniBasedConfig.getSellerId());

                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, biniBasedConfig.getLocationId());
                            variantUpdate.clearCompareAtPrice();
                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, biniBasedConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(savedProductId, variantUpdate, biniBasedConfig.getMultivendorAccessToken());
                            }
                            LOG.info("Saved variant, SKU: {} -> {}", variant.getSku(), p.getName());
                        } catch (Exception variantException) {
                            LOG.info("Variant save errors: ", variantException);
                        }

                    });
                } else {
                    //Updating existing product, with images and options
                    ProductMultiVendorForUpdate productMultiVendorUpdate = MultiVendorObjectFactory.getProductMultiVendorForUpdateByProductMultiVendorForPost(productMultiVendor);
                    multiVendorApiService.updateProduct(productMultiVendorUpdate, savedProduct.get().getId(), biniBasedConfig.getMultivendorAccessToken());
                    //Retrieving saved product with newly generated props from shopify
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProduct.get().getId(), biniBasedConfig.getMultivendorAccessToken());
                    //Updating existing variants based on retrieved product
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, biniBasedConfig.getSellerId());
                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, biniBasedConfig.getLocationId());
                            variantUpdate.clearCompareAtPrice();
                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, biniBasedConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(finalSavedProduct.getId(), variantUpdate, biniBasedConfig.getMultivendorAccessToken());
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


        LOG.info("End of BINI  based shop  products export.");
    }

    public void importNewProducts() throws JsonProcessingException {
        if (!biniBasedConfig.isEnabled()) {
            LOG.info("BINI based export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Begin of BINI based new products export.");
        biniBasedApiService.initLists();

        if (biniBasedConfig.isLogReceivedData()) {
            LOG.info("All responses from BINI based API received:");
            biniBasedApiService.printFetchedLists();
        }

        LOG.info("Mapping products into single entity from various BINI based APIs, please wait...");
        List<AggregatedProductDto> products = biniBasedApiService.getAllProducts();
        LOG.info("Resulting JSON entity:{}", biniBasedApiService.getJson(products));
        LOG.info("Retrieving all products from shopify with sellerId {} ...", biniBasedConfig.getSellerId());
        final List<ProductMultiVendorForRead> allMultiVendorProducts = multiVendorApiService.getAllProducts(biniBasedConfig.getMultivendorAccessToken()).stream().filter(p -> p.getSellerId().equals(biniBasedConfig.getSellerId())).toList();
        LOG.info("Importing new products...");

        products.forEach(p -> {

            try {

                final List<String> skus = p.getStocks().stream().map(s -> s.getSku()).collect(Collectors.toList());
                if(skus.isEmpty()){
                    return;
                }

                Optional<ProductMultiVendorForPost> savedProduct = mapper.mapProductMultiVendorBySkus(allMultiVendorProducts, p.getStocks().stream().map(s -> s.getSku()).collect(Collectors.toList()), biniBasedConfig.getSellerId());
                ProductMultiVendorForPost productMultiVendor = mapper.mapProduct(savedProduct, p, biniBasedConfig.getSellerId(), biniBasedConfig.getLocationId());

                if (savedProduct.isEmpty()) {
                    //Saving new product along with options and image based on model
                    String savedProductId = multiVendorApiService.post(productMultiVendor, biniBasedConfig.getMultivendorAccessToken()).getId();
                    ProductMultiVendorForRead objRetrieved = multiVendorApiService.getProduct(savedProductId, biniBasedConfig.getMultivendorAccessToken());
                    //Saving all variants
                    ProductMultiVendorForPost finalSavedProduct = mapper.mapProductMultiVendorByProductMultiVendorGet(objRetrieved, biniBasedConfig.getSellerId());

                    p.getStocks().stream().forEach(variant -> {
                        try {
                            VariantForUpdate variantUpdate = mapper.mapVariantForUpdate(variant, finalSavedProduct, biniBasedConfig.getLocationId());

                            if (StringUtils.isNotEmpty(variantUpdate.getId())) {
                                //Updating existng main
                                multiVendorApiService.updateVariant(finalSavedProduct.getId(), variantUpdate.getId(), variantUpdate, biniBasedConfig.getMultivendorAccessToken());
                            } else {
                                // Adding other variants
                                multiVendorApiService.postVariant(savedProductId, variantUpdate, biniBasedConfig.getMultivendorAccessToken());
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


        LOG.info("End of BINI based new products export.");
    }

    public void updatePrices(List<AggregatedProductDto> prodcuts, List<ProductMultiVendorForRead> multiVendorProducts) {


        for (AggregatedProductDto biniProduct : prodcuts) {

            final Set<String> beeStoreProductIds = biniProduct.getStocks().stream().map(i -> i.getSku()).collect(Collectors.toSet());

            multiVendorProducts.stream()
                    .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                    .filter(p -> biniBasedConfig.getSellerId().equals(p.getSellerId()))
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
                                            update.setInventoryLocations(List.of(new InventoryLocation(biniBasedConfig.getLocationId(), stocks.get().getQuantity())));
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


                                update.clearCompareAtPrice();

                                LOG.info("Updating products " + p.getId() + " variant " + v.getId());
                                multiVendorApiService.updateVariant(p.getId(), v.getId(), update, biniBasedConfig.getMultivendorAccessToken());
                            } catch (Exception ex) {
                                LOG.error("Prices update errors ", ex);
                            }

                        });
                    });

        }
    }
}
