package org.shopify.integrator.bini.service.config.dto.subcategory;

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
        "SubCategory"
})

public class SubCategoryList implements Serializable {

    private final static long serialVersionUID = 8655674823572677550L;
    @JsonProperty("SubCategory")
    private List<SubCategory> subCategory = new ArrayList<SubCategory>();

    /**
     * No args constructor for use in serialization
     */
    public SubCategoryList() {
    }

    /**
     * @param subCategory
     */
    public SubCategoryList(List<SubCategory> subCategory) {
        super();
        this.subCategory = subCategory;
    }

    @JsonProperty("SubCategory")
    public List<SubCategory> getSubCategory() {
        return subCategory;
    }

    @JsonProperty("SubCategory")
    public void setSubCategory(List<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SubCategoryList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subCategory");
        sb.append('=');
        sb.append(((this.subCategory == null) ? "<null>" : this.subCategory));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
