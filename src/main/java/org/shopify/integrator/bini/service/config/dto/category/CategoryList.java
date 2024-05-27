package org.shopify.integrator.bini.service.config.dto.category;

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
        "Category"
})

public class CategoryList implements Serializable
{

    @JsonProperty("Category")
    private List<Category> category = new ArrayList<Category>();
    private final static long serialVersionUID = 1229581857351594809L;

    /**
     * No args constructor for use in serialization
     *
     */
    public CategoryList() {
    }

    /**
     *
     * @param category
     */
    public CategoryList(List<Category> category) {
        super();
        this.category = category;
    }

    @JsonProperty("Category")
    public List<Category> getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CategoryList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
