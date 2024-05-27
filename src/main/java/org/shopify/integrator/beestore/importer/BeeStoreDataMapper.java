package org.shopify.integrator.beestore.importer;


import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.beestore.service.BeeStoreFtpProduct;
import org.shopify.integrator.beestore.service.config.BeeStoreConfig;
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

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BeeStoreDataMapper {

    private static final Logger LOG = LoggerFactory.getLogger(BeeStoreDataMapper.class);
    private final BeeStoreConfig beeStoreConfig;


    public BeeStoreDataMapper(BeeStoreConfig beeStoreConfig) {
        this.beeStoreConfig = beeStoreConfig;
    }

    //------------------------------ For Create ------------------------
    public ProductMultiVendorForPost mapProduct(Optional<ProductMultiVendorForPost> oldProduct, BeeStoreFtpProduct product) throws Exception {

        ProductMultiVendorForPost productMultivendor = oldProduct.orElseGet(() -> MultiVendorObjectFactory.getDefaultProductMultiVendor(beeStoreConfig.getSellerId()));

        productMultivendor.setProductName(StringUtils.defaultIfEmpty(product.getDSArticolo(), productMultivendor.getProductName()));
        productMultivendor.setProductType(StringUtils.defaultIfEmpty(product.getDSTipoEtichetta(), product.getDSCategoriaMerceologica()));
        productMultivendor.setHandle(StringUtils.defaultIfEmpty(product.getModello(), productMultivendor.getHandle()));
        productMultivendor.setProductDescription(StringUtils.defaultIfEmpty(product.getNota(), productMultivendor.getProductDescription()));
        productMultivendor.setProductTag(StringUtils.defaultIfEmpty(product.getDSLinea(), productMultivendor.getProductTag()));
        productMultivendor.setVariants(List.of(mapVariant(productMultivendor.getVariants(), product)));
        productMultivendor.setOptions(mapOptions(product));
        productMultivendor.setImages(mapImages(product));

        return productMultivendor;
    }


    public List<Image> mapImages(BeeStoreFtpProduct product) throws Exception {
        //--------------------Images--------------
        List<Image> images = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Field field = product.getClass().getDeclaredField("URLImg" + i);
            field.setAccessible(true);
            String url = (String) field.get(product);
            if (StringUtils.isNotEmpty(url)) {

                URI uri = new URI(url);
                url = beeStoreConfig.getImgProxyHost() + uri.getPath();
                if (StringUtils.isNotEmpty(uri.getQuery())) {
                    url += ("?" + uri.getQuery());
                }

                images.add(new Image(url, url, String.valueOf(i)));
            }
        }

        return images;
    }

    public Optional<ProductMultiVendorForPost> mapProductMultiVendorBySkus(List<ProductMultiVendorForRead> multiVendorProducts, final List<String> skus, final String sellerId) {
        return multiVendorProducts.stream()
                .filter(p -> p.getVariants() != null)
                .filter(p -> CollectionUtils.containsAny(p.getVariants().stream().map(i -> i.getSku()).collect(Collectors.toList()),skus) && sellerId.equals(p.getSellerId()))
                .findFirst()
                .map(found -> mapProductMultiVendorByProductMultiVendorGet(found));
    }

    public List<Options> mapOptions(BeeStoreFtpProduct product) {
        List<Options> options = Stream.of(
                        createOption("Size", product.getTaglia()),
                        createOption("Color", product.getDSColore()),
                        createOption("Brand", product.getRaggruppamentoLinea())
                )
                .filter(Objects::nonNull)
                .toList();

        return options;
    }

    public VariantForPost mapVariant(List<VariantForPost> oldVariants, BeeStoreFtpProduct product) {
        VariantForPost variant = oldVariants.stream().filter(p -> product.getCodArticolo().equals(p.getSku())).findFirst().orElseGet(() -> MultiVendorObjectFactory.getVariantForPost());

        variant.setQuantity(StringUtils.defaultString(product.getDisponibilita()));
        variant.setBarcode(StringUtils.defaultString(product.getBarCode()));
        variant.setSku(StringUtils.defaultString(product.getCodArticolo()));
        variant.setWeight(StringUtils.defaultString(product.getPeso(), null));

        if (StringUtils.isNotEmpty(product.getPrezzoIvato())) {
            BigDecimal price = new BigDecimal(product.getPrezzoIvato());
            variant.setPrice(Utils.getDecimalFormatter("0.00").format(price));
            variant.setCompareAtPrice(Utils.getDecimalFormatter("0.00").format(price.multiply(new BigDecimal("1.10"))));
        }

        //Inventory locations set from environment for new object. Quantity updated for both - new and old objects
        if (CollectionUtils.isEmpty(variant.getInventoryLocations())) {
            variant.setInventoryLocations(List.of(new InventoryLocation(beeStoreConfig.getLocationId(), product.getDisponibilita())));
        } else {
            variant.setInventoryLocations(variant.getInventoryLocations().stream().map(l -> {
                l.setVariantQuantity(product.getDisponibilita());
                return l;
            }).toList());
        }
        return variant;
    }

    //------------------------------ For Update ------------------------
    public ProductMultiVendorForPost mapProductMultiVendorByProductMultiVendorGet(ProductMultiVendorForRead product) {
        return MultiVendorObjectFactory.getProductMultiVendorByProductMultiVendorForRead(beeStoreConfig.getSellerId(), product);
    }

    public Optional<ProductMultiVendorForPost> mapProductMultiVendorBySku(List<ProductMultiVendorForRead> multiVendorProducts, String sku) {
        return multiVendorProducts.stream()
                .filter(p -> !CollectionUtils.isEmpty(p.getVariants()))
                .filter(p -> sku.equals(p.getVariants().get(0).getSku()) && beeStoreConfig.getSellerId().equals(p.getSellerId()))
                .findFirst()
                .map(found -> mapProductMultiVendorByProductMultiVendorGet(found));
    }

    public Optional<ProductMultiVendorForPost> mapProductMultiVendorByHandle(List<ProductMultiVendorForRead> multiVendorProducts, String handle) {
        return multiVendorProducts.stream()
                .filter(p -> StringUtils.isNotEmpty(p.getHandle()))
                .filter(p -> handle.equals(p.getHandle()) && beeStoreConfig.getSellerId().equals(p.getSellerId()))
                .findFirst()
                .map(found -> mapProductMultiVendorByProductMultiVendorGet(found));
    }

    public VariantForUpdate mapVariantForUpdate(BeeStoreFtpProduct product, ProductMultiVendorForPost old) {
        VariantForPost variantForPost = mapVariant(old.getVariants(), product);
        VariantForUpdate variantForUpdate = MultiVendorObjectFactory.getVariantForUpdateForVariantForPost(variantForPost);
        List<Options> options = mapOptions(product);

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
