package org.shopify.integrator.bini.service.config.dto.category;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "CategoryList"
})
public class CategoryListMain implements Serializable {

    private final static long serialVersionUID = 2045960163671648902L;
    @JsonProperty("CategoryList")
    private CategoryList categoryList = new CategoryList();

    /**
     * No args constructor for use in serialization
     */
    public CategoryListMain() {
    }

    /**
     * @param categoryList
     */
    public CategoryListMain(CategoryList categoryList) {
        super();
        this.categoryList = categoryList;
    }

    @JsonProperty("CategoryList")
    public CategoryList getCategoryList() {
        return categoryList;
    }

    @JsonProperty("CategoryList")
    public void setCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CategoryListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("categoryList");
        sb.append('=');
        sb.append(((this.categoryList == null) ? "<null>" : this.categoryList));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
