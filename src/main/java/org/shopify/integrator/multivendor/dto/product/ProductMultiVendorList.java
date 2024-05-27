package org.shopify.integrator.multivendor.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductMultiVendorList {

    List<ProductMultiVendorForRead> products = new ArrayList<>();;

    public List<ProductMultiVendorForRead> getProducts() {
        return products;
    }

    public void setProducts(List<ProductMultiVendorForRead> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "products=" + products +
                '}';
    }
}
