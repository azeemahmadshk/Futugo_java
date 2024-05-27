package org.shopify.integrator.bini.service.config.dto.goods.stocks;

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
        "Stock"
})
public class Stocks implements Serializable
{

    @JsonProperty("Stock")
    private List<Stock> stock = new ArrayList<Stock>();
    private final static long serialVersionUID = -6527636688384517924L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Stocks() {
    }

    /**
     *
     * @param stock
     */
    public Stocks(List<Stock> stock) {
        super();
        this.stock = stock;
    }

    @JsonProperty("Stock")
    public List<Stock> getStock() {
        return stock;
    }

    @JsonProperty("Stock")
    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stocks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("stock");
        sb.append('=');
        sb.append(((this.stock == null)?"<null>":this.stock));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
