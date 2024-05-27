package org.shopify.integrator.bini.service.config.dto.goods.price;

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
        "ID",
        "Retailers"
})
public class Price implements Serializable
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Retailers")
    private List<Retailer> retailers = new ArrayList<Retailer>();
    private final static long serialVersionUID = 3232851975508446094L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Price() {
    }

    /**
     *
     * @param retailers
     * @param iD
     */
    public Price(String iD, List<Retailer> retailers) {
        super();
        this.iD = iD;
        this.retailers = retailers;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Retailers")
    public List<Retailer> getRetailers() {
        return retailers;
    }

    @JsonProperty("Retailers")
    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Price.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iD");
        sb.append('=');
        sb.append(((this.iD == null)?"<null>":this.iD));
        sb.append(',');
        sb.append("retailers");
        sb.append('=');
        sb.append(((this.retailers == null)?"<null>":this.retailers));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
