package org.shopify.integrator.bonucci.service.config.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "SKU_item",
        "Size",
        "Market_Price",
        "Supply_Price",
        "Stock"
})

public class StockItem implements Serializable {

    private final static long serialVersionUID = 479638689906233533L;
    @JsonProperty("SKU_item")
    private String sKUItem;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("Market_Price")
    private Double marketPrice;
    @JsonProperty("Supply_Price")
    private Double supplyPrice;
    @JsonProperty("Stock")
    private Integer stock;

    /**
     * No args constructor for use in serialization
     */
    public StockItem() {
    }

    /**
     * @param marketPrice
     * @param supplyPrice
     * @param size
     * @param sKUItem
     * @param stock
     */
    public StockItem(String sKUItem, String size, Double marketPrice, Double supplyPrice, Integer stock) {
        super();
        this.sKUItem = sKUItem;
        this.size = size;
        this.marketPrice = marketPrice;
        this.supplyPrice = supplyPrice;
        this.stock = stock;
    }

    @JsonProperty("SKU_item")
    public String getSKUItem() {
        return sKUItem;
    }

    @JsonProperty("SKU_item")
    public void setSKUItem(String sKUItem) {
        this.sKUItem = sKUItem;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("Market_Price")
    public Double getMarketPrice() {
        return marketPrice;
    }

    @JsonProperty("Market_Price")
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    @JsonProperty("Supply_Price")
    public Double getSupplyPrice() {
        return supplyPrice;
    }

    @JsonProperty("Supply_Price")
    public void setSupplyPrice(Double supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    @JsonProperty("Stock")
    public Integer getStock() {
        return stock;
    }

    @JsonProperty("Stock")
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return Objects.equals(sKUItem, stockItem.sKUItem) && Objects.equals(size, stockItem.size) && Objects.equals(marketPrice, stockItem.marketPrice) && Objects.equals(supplyPrice, stockItem.supplyPrice) && Objects.equals(stock, stockItem.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sKUItem, size, marketPrice, supplyPrice, stock);
    }
}
