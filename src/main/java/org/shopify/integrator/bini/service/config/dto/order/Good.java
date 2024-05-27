package org.shopify.integrator.bini.service.config.dto.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ID",
        "Size",
        "Qty",
        "Price",
        "Currency",
        "ReferencePrice"
})
public class Good implements Serializable
{

    @JsonProperty("ID")
    private String id;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("Qty")
    private String qty;
    @JsonProperty("Price")
    private String price;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("ReferencePrice")
    private String referencePrice;
    private final static long serialVersionUID = 2749727598313367482L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Good() {
    }

    /**
     *
     * @param referencePrice
     * @param size
     * @param price
     * @param qty
     * @param currency
     * @param id
     */
    public Good(String id, String size, String qty, String price, String currency, String referencePrice) {
        super();
        this.id = id;
        this.size = size;
        this.qty = qty;
        this.price = price;
        this.currency = currency;
        this.referencePrice = referencePrice;
    }

    @JsonProperty("ID")
    public String getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("Qty")
    public String getQty() {
        return qty;
    }

    @JsonProperty("Qty")
    public void setQty(String qty) {
        this.qty = qty;
    }

    @JsonProperty("Price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("ReferencePrice")
    public String getReferencePrice() {
        return referencePrice;
    }

    @JsonProperty("ReferencePrice")
    public void setReferencePrice(String referencePrice) {
        this.referencePrice = referencePrice;
    }

}
