package org.shopify.integrator.multivendor.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.shopify.integrator.multivendor.dto.Image;
import org.shopify.integrator.multivendor.dto.options.OptionsForRead;
import org.shopify.integrator.multivendor.dto.variant.VariantForPost;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductMultiVendorForRead {
    String id;
    @JsonProperty("seller_id")
    String sellerId;
    @JsonProperty("handle")
    String handle;
    @JsonProperty("product_meta_info")
    String productMetaInfo;
    @JsonProperty("product_policy")
    String productPolicy;
    @JsonProperty("product_url")
    String productUrl;
    @JsonProperty("expiry_date")
    String expiryDate;
    @JsonProperty("shipping_id")
    String shippingId;
    @JsonProperty("variants")
    List<VariantForPost> variants = new ArrayList<>();
    @JsonProperty("images")
    List<Image> images = new ArrayList<>();
    @JsonProperty("options")
    List<OptionsForRead> options = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getProductMetaInfo() {
        return productMetaInfo;
    }

    public void setProductMetaInfo(String productMetaInfo) {
        this.productMetaInfo = productMetaInfo;
    }

    public String getProductPolicy() {
        return productPolicy;
    }

    public void setProductPolicy(String productPolicy) {
        this.productPolicy = productPolicy;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public List<VariantForPost> getVariants() {
        return variants;
    }

    public void setVariants(List<VariantForPost> variants) {
        this.variants = variants;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<OptionsForRead> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsForRead> options) {
        this.options = options;
    }

    public void clearCompareAtPrice(){
        if(this.getVariants() == null){
            return;
        }
        this.variants = this.getVariants().stream().map(v -> v.clearCompareAtPrice()).collect(Collectors.toList());
    }
}
