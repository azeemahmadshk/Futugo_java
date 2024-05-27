package org.shopify.integrator.bini.service.config.dto.goods.details;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "GoodsDetailList"
})
public class GoodsDetailListMain implements Serializable
{

    @JsonProperty("GoodsDetailList")
    private GoodsDetailList goodsDetailList = new GoodsDetailList();
    private final static long serialVersionUID = -4369521416276035448L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsDetailListMain() {
    }

    /**
     *
     * @param goodsDetailList
     */
    public GoodsDetailListMain(GoodsDetailList goodsDetailList) {
        super();
        this.goodsDetailList = goodsDetailList;
    }

    @JsonProperty("GoodsDetailList")
    public GoodsDetailList getGoodsDetailList() {
        return goodsDetailList;
    }

    @JsonProperty("GoodsDetailList")
    public void setGoodsDetailList(GoodsDetailList goodsDetailList) {
        this.goodsDetailList = goodsDetailList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsDetailListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("goodsDetailList");
        sb.append('=');
        sb.append(((this.goodsDetailList == null)?"<null>":this.goodsDetailList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
