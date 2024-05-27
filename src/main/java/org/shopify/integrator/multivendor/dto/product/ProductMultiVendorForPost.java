package org.shopify.integrator.multivendor.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.shopify.integrator.multivendor.dto.Image;
import org.shopify.integrator.multivendor.dto.options.Options;
import org.shopify.integrator.multivendor.dto.variant.VariantForPost;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductMultiVendorForPost {

    String id;
    @JsonProperty("seller_id")
    String sellerId;
    @JsonProperty("type")
    String type;
    @JsonProperty("product_name")
    String productName;
    @JsonProperty("product_type")
    String productType;
    @JsonProperty("product_tag")
    String productTag;
    @JsonProperty("product_description")
    String productDescription;
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
    List<VariantForPost> variants = new ArrayList<>();;
    @JsonProperty("options")
    List<Options> options = new ArrayList<>();;
    @JsonProperty("images")
    List<Image> images = new ArrayList<>();;
    @JsonProperty("collections")
    List<String> collections = new ArrayList<>();;


    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTag() {
        return productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<String> getCollections() {
        return collections;
    }

    public void setCollections(List<String> collections) {
        this.collections = collections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void clearCompareAtPrice(){
        if(this.getVariants() == null){
            return;
        }
        this.variants = this.getVariants().stream().map(v -> v.clearCompareAtPrice()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ProductMultivendor{" +
                "id='" + id + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", type='" + type + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productTag='" + productTag + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", handle='" + handle + '\'' +
                ", productMetaInfo='" + productMetaInfo + '\'' +
                ", productPolicy='" + productPolicy + '\'' +
                ", productUrl=" + productUrl +
                ", expiryDate=" + expiryDate +
                ", shippingId='" + shippingId + '\'' +
                ", variants=" + variants +
                ", options=" + options +
                ", images=" + images +
                ", collections=" + collections +
                '}';
    }
}
