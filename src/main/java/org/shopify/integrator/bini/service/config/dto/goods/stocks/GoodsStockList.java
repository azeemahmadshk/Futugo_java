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
        "Goods"
})
public class GoodsStockList implements Serializable
{

    @JsonProperty("Goods")
    private List<Good> goods = new ArrayList<Good>();
    private final static long serialVersionUID = 5015182891696888910L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsStockList() {
    }

    /**
     *
     * @param goods
     */
    public GoodsStockList(List<Good> goods) {
        super();
        this.goods = goods;
    }

    @JsonProperty("Goods")
    public List<Good> getGoods() {
        return goods;
    }

    @JsonProperty("Goods")
    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsStockList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("goods");
        sb.append('=');
        sb.append(((this.goods == null)?"<null>":this.goods));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
