package org.shopify.integrator.multivendor.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductMultiVendorReadById {
    ProductMultiVendorForRead product;

    public ProductMultiVendorForRead getProduct() {
        return product;
    }

    public void setProduct(ProductMultiVendorForRead product) {
        this.product = product;
    }
}
