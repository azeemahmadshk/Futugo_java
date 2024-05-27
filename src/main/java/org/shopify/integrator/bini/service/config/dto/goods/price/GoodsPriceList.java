package org.shopify.integrator.bini.service.config.dto.goods.price;

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
        "Price"
})
public class GoodsPriceList implements Serializable
{

    @JsonProperty("Price")
    private List<Price> price = new ArrayList<Price>();
    private final static long serialVersionUID = -5175489608931060257L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsPriceList() {
    }

    /**
     *
     * @param price
     */
    public GoodsPriceList(List<Price> price) {
        super();
        this.price = price;
    }

    @JsonProperty("Price")
    public List<Price> getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(List<Price> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsPriceList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
