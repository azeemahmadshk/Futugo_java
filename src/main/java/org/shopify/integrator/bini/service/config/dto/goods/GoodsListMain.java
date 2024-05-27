package org.shopify.integrator.bini.service.config.dto.goods;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "GoodsList"
})

public class GoodsListMain implements Serializable
{

    @JsonProperty("GoodsList")
    private GoodsList goodsList = new GoodsList();
    private final static long serialVersionUID = -2494744233637980935L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsListMain() {
    }

    /**
     *
     * @param goodsList
     */
    public GoodsListMain(GoodsList goodsList) {
        super();
        this.goodsList = goodsList;
    }

    @JsonProperty("GoodsList")
    public GoodsList getGoodsList() {
        return goodsList;
    }

    @JsonProperty("GoodsList")
    public void setGoodsList(GoodsList goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("goodsList");
        sb.append('=');
        sb.append(((this.goodsList == null)?"<null>":this.goodsList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
