package org.shopify.integrator.bini.service.config.dto.goods.details;

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
        "Good"
})
public class GoodsDetailList implements Serializable
{

    @JsonProperty("Good")
    private List<Good> good = new ArrayList<Good>();
    private final static long serialVersionUID = -2470227429285862477L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsDetailList() {
    }

    /**
     *
     * @param good
     */
    public GoodsDetailList(List<Good> good) {
        super();
        this.good = good;
    }

    @JsonProperty("Good")
    public List<Good> getGood() {
        return good;
    }

    @JsonProperty("Good")
    public void setGood(List<Good> good) {
        this.good = good;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GoodsDetailList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("good");
        sb.append('=');
        sb.append(((this.good == null)?"<null>":this.good));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
