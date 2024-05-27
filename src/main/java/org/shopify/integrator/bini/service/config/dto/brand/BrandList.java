package org.shopify.integrator.bini.service.config.dto.brand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Brand"
})
public class BrandList implements Serializable
{

    @JsonProperty("Brand")
    private List<Brand> brand = new ArrayList<Brand>();
    private final static long serialVersionUID = 7526166353885714231L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BrandList() {
    }

    /**
     *
     * @param brand
     */
    public BrandList(List<Brand> brand) {
        super();
        this.brand = brand;
    }

    @JsonProperty("Brand")
    public List<Brand> getBrand() {
        return brand;
    }

    @JsonProperty("Brand")
    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BrandList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("brand");
        sb.append('=');
        sb.append(((this.brand == null)?"<null>":this.brand));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
