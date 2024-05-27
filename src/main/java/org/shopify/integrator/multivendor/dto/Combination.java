package org.shopify.integrator.multivendor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Combination {

    @JsonProperty("id")
    String id;
    @JsonProperty("variant_id")
    String variantId;
    @JsonProperty("option_value")
    String optionValue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    @Override
    public String toString() {
        return "Combination{" +
                "id='" + id + '\'' +
                ", variantId='" + variantId + '\'' +
                ", optionValue='" + optionValue + '\'' +
                '}';
    }
}
