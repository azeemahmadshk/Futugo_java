package org.shopify.integrator.bini.service.config.dto.goods.price;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "GoodsPriceList"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsPriceListMain implements Serializable
{

    @JsonProperty("GoodsPriceList")
    private GoodsPriceList goodsPriceList = new GoodsPriceList();
    private final static long serialVersionUID = -2970147895167342460L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsPriceListMain() {
    }

    /**
     *
     * @param goodsPriceList
     */
    public GoodsPriceListMain(GoodsPriceList goodsPriceList) {
        super();
        this.goodsPriceList = goodsPriceList;
    }

    @JsonProperty("GoodsPriceList")
    public GoodsPriceList getGoodsPriceList() {
        return goodsPriceList;
    }

    @JsonProperty("GoodsPriceList")
    public void setGoodsPriceList(GoodsPriceList goodsPriceList) {
        this.goodsPriceList = goodsPriceList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsPriceListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("goodsPriceList");
        sb.append('=');
        sb.append(((this.goodsPriceList == null)?"<null>":this.goodsPriceList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
