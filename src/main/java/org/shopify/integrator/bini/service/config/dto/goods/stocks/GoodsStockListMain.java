package org.shopify.integrator.bini.service.config.dto.goods.stocks;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "GoodsStockList"
})

public class GoodsStockListMain implements Serializable
{

    @JsonProperty("GoodsStockList")
    private GoodsStockList goodsStockList = new GoodsStockList();
    private final static long serialVersionUID = -8975094391648193743L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsStockListMain() {
    }

    /**
     *
     * @param goodsStockList
     */
    public GoodsStockListMain(GoodsStockList goodsStockList) {
        super();
        this.goodsStockList = goodsStockList;
    }

    @JsonProperty("GoodsStockList")
    public GoodsStockList getGoodsStockList() {
        return goodsStockList;
    }

    @JsonProperty("GoodsStockList")
    public void setGoodsStockList(GoodsStockList goodsStockList) {
        this.goodsStockList = goodsStockList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsStockListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("goodsStockList");
        sb.append('=');
        sb.append(((this.goodsStockList == null)?"<null>":this.goodsStockList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
