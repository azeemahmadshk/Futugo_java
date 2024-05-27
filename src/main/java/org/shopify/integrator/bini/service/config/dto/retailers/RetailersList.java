package org.shopify.integrator.bini.service.config.dto.retailers;

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
        "Retailer"
})

public class RetailersList implements Serializable
{

    @JsonProperty("Retailer")
    private List<Retailer> retailer = new ArrayList<Retailer>();
    private final static long serialVersionUID = -6721292495180442278L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RetailersList() {
    }

    /**
     *
     * @param retailer
     */
    public RetailersList(List<Retailer> retailer) {
        super();
        this.retailer = retailer;
    }

    @JsonProperty("Retailer")
    public List<Retailer> getRetailer() {
        return retailer;
    }

    @JsonProperty("Retailer")
    public void setRetailer(List<Retailer> retailer) {
        this.retailer = retailer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetailersList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("retailer");
        sb.append('=');
        sb.append(((this.retailer == null)?"<null>":this.retailer));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
