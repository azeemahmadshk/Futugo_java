package org.shopify.integrator.bini.service.config.dto.retailers;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "RetalersList"
})
public class RetailersListMain implements Serializable {

    private final static long serialVersionUID = 2257839351266670017L;
    @JsonProperty("RetalersList")
    private RetailersList retailersList = new RetailersList();

    /**
     * No args constructor for use in serialization
     */
    public RetailersListMain() {
    }

    /**
     * @param retailersList
     */
    public RetailersListMain(RetailersList retailersList) {
        super();
        this.retailersList = retailersList;
    }

    @JsonProperty("RetalersList")
    public RetailersList getRetailersList() {
        return retailersList;
    }

    @JsonProperty("RetalersList")
    public void setRetailersList(RetailersList retailersList) {
        this.retailersList = retailersList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetailersListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("retailersList");
        sb.append('=');
        sb.append(((this.retailersList == null) ? "<null>" : this.retailersList));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
