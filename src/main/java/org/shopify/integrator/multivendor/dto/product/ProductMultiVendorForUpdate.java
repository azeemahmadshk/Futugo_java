package org.shopify.integrator.multivendor.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.shopify.integrator.multivendor.dto.Image;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductMultiVendorForUpdate {

    @JsonProperty("product_name")
    String productName;
    @JsonProperty("product_type")
    String productType;
    @JsonProperty("product_tag")
    String productTag;
    @JsonProperty("handle")
    String handle;
    @JsonProperty("product_description")
    String productDescription;
    @JsonProperty("images")
    List<Image> images = new ArrayList<>();;

    public ProductMultiVendorForUpdate() {
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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


}
