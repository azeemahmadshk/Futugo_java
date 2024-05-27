package org.shopify.integrator.multivendor.service;

import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForPost;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForRead;
import org.shopify.integrator.multivendor.dto.product.ProductMultiVendorForUpdate;
import org.shopify.integrator.multivendor.dto.variant.VariantForPost;
import org.shopify.integrator.multivendor.dto.variant.VariantForUpdate;

import java.util.ArrayList;

// Factory methods for creating default values for MultiVendor Pojos
public class MultiVendorObjectFactory {

    public static ProductMultiVendorForPost getDefaultProductMultiVendor(String sellerId) {

        ProductMultiVendorForPost product = new ProductMultiVendorForPost();
        product.setSellerId(sellerId);
        product.setType("1");
        product.setProductMetaInfo("meta_info");
        product.setProductPolicy("product_policy");
        product.setExpiryDate("2040/08/15");
        product.setShippingId("1");
        product.setVariants(new ArrayList<>());
        product.setOptions(new ArrayList<>());
        product.setImages(new ArrayList<>());

        return product;
    }

    public static ProductMultiVendorForUpdate getProductMultiVendorForUpdateByProductMultiVendorForPost(ProductMultiVendorForPost saved) {
        ProductMultiVendorForUpdate product = new ProductMultiVendorForUpdate();
        product.setProductName(saved.getProductName());
        product.setProductType(saved.getProductType());
        product.setHandle(saved.getHandle());
        product.setProductTag(saved.getProductTag());
        product.setProductDescription(saved.getProductDescription());
        product.setImages(saved.getImages());

        return product;
    }

    public static ProductMultiVendorForPost getProductMultiVendorByProductMultiVendorForRead(String sellerId, ProductMultiVendorForRead saved) {
        ProductMultiVendorForPost product = getDefaultProductMultiVendor(sellerId);
        product.setProductPolicy(saved.getProductPolicy());
        product.setId(saved.getId());
        product.setProductMetaInfo(saved.getProductMetaInfo());
        product.setProductUrl(saved.getProductUrl());
        product.setSellerId(saved.getSellerId());
        product.setHandle(saved.getHandle());
        product.setExpiryDate(saved.getExpiryDate());
        product.setShippingId(saved.getShippingId());
        product.setVariants(saved.getVariants());
        product.setImages(saved.getImages());

        return product;
    }

    public static VariantForPost getVariantForPost() {

        VariantForPost variant = new VariantForPost();
        variant.setDimension("{\"length\":\"1\", \"width\":\"1\", \"height\":\"1\", \"girth\":\"1\"}");
        variant.setHandlingCharges("0.00");
        variant.setChargeTaxes(0);
        variant.setRequireShipping("1");
        variant.setTrackInventory("1");
        variant.setInventoryPolicy("0");

        return variant;
    }

    public static VariantForUpdate getVariantForUpdateForVariantForPost(VariantForPost v) {

        VariantForUpdate variant = new VariantForUpdate();
        variant.setId(v.getId());
        variant.setSku(v.getSku());
        variant.setBarcode(v.getBarcode());
        variant.setWeight(v.getWeight());
        variant.setDimension(StringUtils.defaultIfEmpty(v.getDimension(), "{\"length\":\"1\", \"width\":\"1\", \"height\":\"1\", \"girth\":\"1\"}" ));
        variant.setPrice(v.getPrice());
        variant.setCompareAtPrice(v.getCompareAtPrice());
        variant.setHandlingCharges(StringUtils.defaultIfEmpty(v.getHandlingCharges(),"0.00" ));
        variant.setChargeTaxes(v.getChargeTaxes());
        variant.setRequireShipping(StringUtils.defaultIfEmpty(v.getRequireShipping(), "1"));
        variant.setTrackInventory(StringUtils.defaultIfEmpty(v.getTrackInventory(), "1"));
        variant.setQuantity(v.getQuantity());
        variant.setInventoryPolicy(StringUtils.defaultIfEmpty(v.getInventoryPolicy() , "0"));
        variant.setInventoryLocations(v.getInventoryLocations());
        variant.setImageId(v.getImageId());

        return variant;
    }
}
