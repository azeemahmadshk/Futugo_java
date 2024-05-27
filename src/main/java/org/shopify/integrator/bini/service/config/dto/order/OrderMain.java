package org.shopify.integrator.bini.service.config.dto.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "OrderId",
        "Retailer",
        "StockPointId",
        "BuyerInfo",
        "GoodsList"
})
public class OrderMain implements Serializable {

    @JsonProperty("OrderId")
    private String orderId;
    @JsonProperty("Retailer")
    private String retailer;
    @JsonProperty("StockPointId")
    private String stockPointId;
    @JsonProperty("BuyerInfo")
    private BuyerInfo buyerInfo;
    @JsonProperty("GoodsList")
    private GoodsList goodsList;
    private final static long serialVersionUID = 1478547432089651789L;

    /**
     * No args constructor for use in serialization
     */
    public OrderMain() {
    }

    /**
     * @param buyerInfo
     * @param orderId
     * @param retailer
     * @param stockPointId
     * @param goodsList
     */
    public OrderMain(String orderId, String retailer, String stockPointId, BuyerInfo buyerInfo, GoodsList goodsList) {
        super();
        this.orderId = orderId;
        this.retailer = retailer;
        this.stockPointId = stockPointId;
        this.buyerInfo = buyerInfo;
        this.goodsList = goodsList;
    }

    @JsonProperty("OrderId")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("OrderId")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("Retailer")
    public String getRetailer() {
        return retailer;
    }

    @JsonProperty("Retailer")
    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    @JsonProperty("StockPointId")
    public String getStockPointId() {
        return stockPointId;
    }

    @JsonProperty("StockPointId")
    public void setStockPointId(String stockPointId) {
        this.stockPointId = stockPointId;
    }

    @JsonProperty("BuyerInfo")
    public BuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    @JsonProperty("BuyerInfo")
    public void setBuyerInfo(BuyerInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
    }

    @JsonProperty("GoodsList")
    public GoodsList getGoodsList() {
        return goodsList;
    }

    @JsonProperty("GoodsList")
    public void setGoodsList(GoodsList goodsList) {
        this.goodsList = goodsList;
    }
}
