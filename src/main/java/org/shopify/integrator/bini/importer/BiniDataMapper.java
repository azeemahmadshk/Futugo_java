package org.shopify.integrator.bini.importer;

import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.bini.service.config.BiniConfig;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
import org.shopify.integrator.multivendor.dto.Image;
import org.shopify.integrator.multivendor.dto.InventoryLocation;
import org.shopify.integrator.multivendor.dto.options.Options;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForPost;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForRead;
import org.shopify.integrator.multivendor.dto.variant.VariantForPost;
import org.shopify.integrator.multivendor.dto.variant.VariantForUpdate;
import org.shopify.integrator.multivendor.service.MultiVendorObjectFactory;
import org.shopify.integrator.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BiniDataMapper {

    private static final Logger LOG = LoggerFactory.getLogger(BiniDataMapper.class);

    public BiniDataMapper() {
    }

    //------------------------------ For Create ------------------------
    public ProductMultiVendorForPost mapProduct(Optional<ProductMultiVendorForPost> oldProduct, AggregatedProductDto product, String sellerId, String locationId) throws Exception {

        ProductMultiVendorForPost productMultivendor = oldProduct.orElseGet(() -> MultiVendorObjectFactory.getDefaultProductMultiVendor(sellerId));

        productMultivendor.setProductName(StringUtils.defaultIfEmpty(product.getName(), productMultivendor.getProductName()));
        productMultivendor.setProductType(StringUtils.defaultIfEmpty(product.getCategory(), product.getSubCategory()));
        productMultivendor.setHandle(StringUtils.defaultIfEmpty(product.getCode(), productMultivendor.getHandle()));
        productMultivendor.setProductDescription(StringUtils.defaultIfEmpty(product.getDescription(), productMultivendor.getProductDescription()));
        productMultivendor.setProductTag(StringUtils.defaultIfEmpty(product.getBrand(), productMultivendor.getProductTag()));

        AggregatedProductDto.StocksAndPricing stock = product.getStocks().stream().findFirst().orElse(new AggregatedProductDto.StocksAndPricing());
        productMultivendor.setVariants(List.of(mapVariant(productMultivendor.getVariants(), stock, locationId)));
        productMultivendor.setOptions(mapOptions(stock));
        productMultivendor.setImages(mapImages(product));

        return productMultivendor;
    }


    public List<Image> mapImages(AggregatedProductDto product) throws Exception {
        //--------------------Images--------------
        List<Image> images = new ArrayList<>();

        for (int i = 0; i < product.getImages().size(); i++) {
            images.add(new Image(product.getImages().get(i), product.getImages().get(i), String.valueOf(i + 1)));
        }

        return images;
    }

    public List<Options> mapOptions(AggregatedProductDto.StocksAndPricing stock) {


        List<Options> options = Stream.of(
                        createOption("Size", stock.getSize()),
                        createOption("Color", stock.getColor()),
                        createOption("Brand", stock.getBrand())
                )
                .filter(Objects::nonNull)
                .toList();

        return options;
    }

    public VariantForPost mapVariant(List<VariantForPost> oldVariants, AggregatedProductDto.StocksAndPricing stock, String locationId) {
        VariantForPost variant = oldVariants.stream().filter(p -> stock.getSku().equals(p.getSku())).findFirst().orElseGet(() -> MultiVendorObjectFactory.getVariantForPost());

        variant.setQuantity(StringUtils.defaultString(stock.getQuantity()));
        variant.setBarcode(StringUtils.defaultString(stock.getBarcode()));
        variant.setSku(StringUtils.defaultString(stock.getSku()));
        variant.setWeight("0");


        if (StringUtils.isNotEmpty(stock.getPrice())) {
            BigDecimal price = new BigDecimal(stock.getPrice().replace(",", "."));
            BigDecimal compareAtPrice = new BigDecimal(stock.getCompareAtPrice().replace(",", "."));

            if (compareAtPrice.compareTo(price) == -1) {
                compareAtPrice = price.multiply(new BigDecimal("1.10"));
            }

            variant.setPrice(Utils.getDecimalFormatter("0.00").format(price));
            variant.setCompareAtPrice(Utils.getDecimalFormatter("0.00").format(compareAtPrice));
        }

        //Inventory locations set from environment for new object. Quantity updated for both - new and old objects
        if (CollectionUtils.isEmpty(variant.getInventoryLocations())) {
            variant.setInventoryLocations(List.of(new InventoryLocation(locationId, stock.getQuantity())));
        } else {
            variant.setInventoryLocations(variant.getInventoryLocations().stream().map(l -> {
                l.setVariantQuantity(stock.getQuantity());
                return l;
            }).toList());
        }
        return variant;
    }

    //------------------------------ For Update ------------------------
    public ProductMultiVendorForPost mapProductMultiVendorByProductMultiVendorGet(ProductMultiVendorForRead product, final String sellerId) {
        return MultiVendorObjectFactory.getProductMultiVendorByProductMultiVendorForRead(sellerId, product);
    }

    public Optional<ProductMultiVendorForPost> mapProductMultiVendorBySku(List<ProductMultiVendorForRead> multiVendorProducts, String sku, final String sellerId) {
        return multiVendorProducts.stream()
                .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                .filter(p -> sku.equals(p.getVariants().get(0).getSku()) && sellerId.equals(p.getSellerId()))
                .findFirst()
                .map(found -> mapProductMultiVendorByProductMultiVendorGet(found, sellerId));
    }

    public Optional<ProductMultiVendorForPost> mapProductMultiVendorByHandle(List<ProductMultiVendorForRead> multiVendorProducts, String handle, final String sellerId) {
        return multiVendorProducts.stream()
                .filter(p -> StringUtils.isNotEmpty(p.getHandle()))
                .filter(p -> handle.equals(p.getHandle()) && sellerId.equals(p.getSellerId()))
                .findFirst()
                .map(found -> mapProductMultiVendorByProductMultiVendorGet(found, sellerId));
    }


    public Optional<ProductMultiVendorForPost> mapProductMultiVendorBySkus(List<ProductMultiVendorForRead> multiVendorProducts, final List<String> skus, final String sellerId) {
        return multiVendorProducts.stream()
                .filter(p -> p.getVariants() != null)
                .filter(p -> CollectionUtils.containsAny(p.getVariants().stream().map(i -> i.getSku()).collect(Collectors.toList()),skus) && sellerId.equals(p.getSellerId()))
                .findFirst()
                .map(found -> mapProductMultiVendorByProductMultiVendorGet(found, sellerId));
    }

    public VariantForUpdate mapVariantForUpdate(AggregatedProductDto.StocksAndPricing stock, ProductMultiVendorForPost old, String locationId) {
        VariantForPost variantForPost = mapVariant(old.getVariants(), stock, locationId);
        VariantForUpdate variantForUpdate = MultiVendorObjectFactory.getVariantForUpdateForVariantForPost(variantForPost);
        List<Options> options = mapOptions(stock);

        //Shitty multiVendor API needs three hardcoded options: option1 option2 option3. Even if they are present in options part. Why the fuck should I duplicate?
        for (int i = 0; i < options.size(); i++) {
            switch (i) {
                case 0 -> variantForUpdate.setOption1(options.get(i).getValues());
                case 1 -> variantForUpdate.setOption2(options.get(i).getValues());
                case 2 -> variantForUpdate.setOption3(options.get(i).getValues());
            }
        }

        //Shitty multiVendor API sets 0 to variant image_id and not accepts it backs -> needed to retrieve image id form product images;
        Optional<Image> firstImage = old.getImages().stream().findFirst();
        if (firstImage.isPresent()) {
            variantForUpdate.setImageId(firstImage.get().getId());
        }

        return variantForUpdate;

    }

    // MISC
    private Options createOption(String name, String value) {
        return StringUtils.isNotEmpty(value) ? new Options(name, value) : null;
    }

}
