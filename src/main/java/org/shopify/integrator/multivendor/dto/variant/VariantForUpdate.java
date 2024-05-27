package org.shopify.integrator.multivendor.dto.variant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.shopify.integrator.multivendor.dto.InventoryLocation;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariantForUpdate {

    String id;
    @JsonProperty("sku")
    String sku;
    @JsonProperty("barcode")
    String barcode;
    @JsonProperty("weight")
    String weight;

    @JsonProperty("image_id")
    String imageId;

    @JsonProperty("option1")
    String option1;

    @JsonProperty("option2")
    String option2;

    @JsonProperty("option3")
    String option3;

    @JsonProperty("dimension")
    String dimension;
    @JsonProperty("price")
    String price;
    @JsonProperty("handling_charges")
    String handlingCharges;
    @JsonProperty("charge_taxes")
    int chargeTaxes = 0;
    @JsonProperty("require_shipping")
    String requireShipping;
    @JsonProperty("track_inventory")
    String trackInventory;
    @JsonProperty("quantity")
    String quantity;
    @JsonProperty("inventory_policy")
    String inventoryPolicy;
    @JsonProperty("inventory_locations")
    List<InventoryLocation> inventoryLocations  = new ArrayList<>();
    @JsonProperty("compare_at_price")
    String compareAtPrice = null;

    public VariantForUpdate clearCompareAtPrice(){
        this.setCompareAtPrice(null);
        return this;
    }


    public VariantForUpdate() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHandlingCharges() {
        return handlingCharges;
    }

    public void setHandlingCharges(String handlingCharges) {
        this.handlingCharges = handlingCharges;
    }

    public int getChargeTaxes() {
        return chargeTaxes;
    }

    public void setChargeTaxes(int chargeTaxes) {
        this.chargeTaxes = chargeTaxes;
    }

    public String getRequireShipping() {
        return requireShipping;
    }

    public void setRequireShipping(String requireShipping) {
        this.requireShipping = requireShipping;
    }

    public String getTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(String trackInventory) {
        this.trackInventory = trackInventory;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getInventoryPolicy() {
        return inventoryPolicy;
    }

    public void setInventoryPolicy(String inventoryPolicy) {
        this.inventoryPolicy = inventoryPolicy;
    }

    public List<InventoryLocation> getInventoryLocations() {
        return inventoryLocations;
    }

    public void setInventoryLocations(List<InventoryLocation> inventoryLocations) {
        this.inventoryLocations = inventoryLocations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(String compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    @Override
    public String toString() {
        return "VariantForUpdate{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", barcode='" + barcode + '\'' +
                ", weight='" + weight + '\'' +
                ", imageId='" + imageId + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", dimension='" + dimension + '\'' +
                ", price='" + price + '\'' +
                ", handlingCharges='" + handlingCharges + '\'' +
                ", chargeTaxes=" + chargeTaxes +
                ", requireShipping='" + requireShipping + '\'' +
                ", trackInventory='" + trackInventory + '\'' +
                ", quantity='" + quantity + '\'' +
                ", inventoryPolicy='" + inventoryPolicy + '\'' +
                ", inventoryLocations=" + inventoryLocations +
                ", compareAtPrice='" + compareAtPrice + '\'' +
                '}';
    }
}
