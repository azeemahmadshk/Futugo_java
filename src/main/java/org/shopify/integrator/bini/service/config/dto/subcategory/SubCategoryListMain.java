package org.shopify.integrator.bini.service.config.dto.subcategory;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "SubCategoryList"
})
public class SubCategoryListMain implements Serializable
{

    @JsonProperty("SubCategoryList")
    private SubCategoryList subCategoryList = new SubCategoryList();
    private final static long serialVersionUID = 6643220057543767172L;

    /**
     * No args constructor for use in serialization
     *
     */
    public SubCategoryListMain() {
    }

    /**
     *
     * @param subCategoryList
     */
    public SubCategoryListMain(SubCategoryList subCategoryList) {
        super();
        this.subCategoryList = subCategoryList;
    }

    @JsonProperty("SubCategoryList")
    public SubCategoryList getSubCategoryList() {
        return subCategoryList;
    }

    @JsonProperty("SubCategoryList")
    public void setSubCategoryList(SubCategoryList subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SubCategoryListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subCategoryList");
        sb.append('=');
        sb.append(((this.subCategoryList == null)?"<null>":this.subCategoryList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
