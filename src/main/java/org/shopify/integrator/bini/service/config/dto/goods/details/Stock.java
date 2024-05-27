package org.shopify.integrator.bini.service.config.dto.goods.details;

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
        "Item"
})

public class Stock implements Serializable {

    private final static long serialVersionUID = 7780395849804901031L;
    @JsonProperty("Item")
    private List<Item> item = new ArrayList<Item>();

    /**
     * No args constructor for use in serialization
     */
    public Stock() {
    }

    /**
     * @param item
     */
    public Stock(List<Item> item) {
        super();
        this.item = item;
    }

    @JsonProperty("Item")
    public List<Item> getItem() {
        return item;
    }

    @JsonProperty("Item")
    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stock.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("item");
        sb.append('=');
        sb.append(((this.item == null) ? "<null>" : this.item));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
