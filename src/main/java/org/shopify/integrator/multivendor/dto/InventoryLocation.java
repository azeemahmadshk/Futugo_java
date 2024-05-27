package org.shopify.integrator.multivendor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryLocation {

    String id;
    @JsonProperty("location_id")
    String locationId;
    @JsonProperty("variant_quantity")
    String variantQuantity;

    public InventoryLocation() {
    }

    public InventoryLocation(String locationId, String variantQuantity) {
        this.locationId = locationId;
        this.variantQuantity = variantQuantity;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getVariantQuantity() {
        return variantQuantity;
    }

    public void setVariantQuantity(String variantQuantity) {
        this.variantQuantity = variantQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InventoryLocations{" +
                "id='" + id + '\'' +
                ", locationId='" + locationId + '\'' +
                ", variantQuantity='" + variantQuantity + '\'' +
                '}';
    }
}
