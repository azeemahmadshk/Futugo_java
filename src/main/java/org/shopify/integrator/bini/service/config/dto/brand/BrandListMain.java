package org.shopify.integrator.bini.service.config.dto.brand;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "BrandList"
})
public class BrandListMain implements Serializable {

    private final static long serialVersionUID = -6882946406848788662L;
    @JsonProperty("BrandList")
    private BrandList brandList = new BrandList();

    /**
     * No args constructor for use in serialization
     */
    public BrandListMain() {
    }

    /**
     * @param brandList
     */
    public BrandListMain(BrandList brandList) {
        super();
        this.brandList = brandList;
    }

    @JsonProperty("BrandList")
    public BrandList getBrandList() {
        return brandList;
    }

    @JsonProperty("BrandList")
    public void setBrandList(BrandList brandList) {
        this.brandList = brandList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BrandListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("brandList");
        sb.append('=');
        sb.append(((this.brandList == null) ? "<null>" : this.brandList));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
