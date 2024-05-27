package org.shopify.integrator.bini.service.config.dto.goods.stocks;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ID",
        "Retailer",
        "Stocks"
})
public class Good implements Serializable
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Retailer")
    private String retailer;
    @JsonProperty("Stocks")
    private Stocks stocks;
    private final static long serialVersionUID = -4242447538975265575L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Good() {
    }

    /**
     *
     * @param retailer
     * @param iD
     * @param stocks
     */
    public Good(String iD, String retailer, Stocks stocks) {
        super();
        this.iD = iD;
        this.retailer = retailer;
        this.stocks = stocks;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Retailer")
    public String getRetailer() {
        return retailer;
    }

    @JsonProperty("Retailer")
    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    @JsonProperty("Stocks")
    public Stocks getStocks() {
        return stocks;
    }

    @JsonProperty("Stocks")
    public void setStocks(Stocks stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Good.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iD");
        sb.append('=');
        sb.append(((this.iD == null)?"<null>":this.iD));
        sb.append(',');
        sb.append("retailer");
        sb.append('=');
        sb.append(((this.retailer == null)?"<null>":this.retailer));
        sb.append(',');
        sb.append("stocks");
        sb.append('=');
        sb.append(((this.stocks == null)?"<null>":this.stocks));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
