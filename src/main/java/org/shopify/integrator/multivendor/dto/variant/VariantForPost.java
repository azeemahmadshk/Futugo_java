package org.shopify.integrator.multivendor.dto.variant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.shopify.integrator.multivendor.dto.Combination;
import org.shopify.integrator.multivendor.dto.InventoryLocation;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantForPost {

    String id;
    @JsonProperty("sku")
    String sku;
    @JsonProperty("barcode")
    String barcode;
    @JsonProperty("weight")
    String weight;
    @JsonProperty("dimension")
    String dimension;
    @JsonProperty("price")
    String price;
    @JsonProperty("compare_at_price")
    String compareAtPrice = null;
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
    List<InventoryLocation> inventoryLocations = new ArrayList<>();
    @JsonProperty("image_id")
    String imageId;
    @JsonProperty("combinations")
    List<Combination> combinations = new ArrayList<>();

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

    public String getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(String compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public List<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(List<Combination> combinations) {
        this.combinations = combinations;
    }

    public VariantForPost clearCompareAtPrice(){
        this.setCompareAtPrice(null);
        return this;
    }

    @Override
    public String toString() {
        return "Variants{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", barcode='" + barcode + '\'' +
                ", weight='" + weight + '\'' +
                ", dimension='" + dimension + '\'' +
                ", price='" + price + '\'' +
                ", handlingCharges='" + handlingCharges + '\'' +
                ", chargeTaxes=" + chargeTaxes +
                ", requireShipping='" + requireShipping + '\'' +
                ", trackInventory='" + trackInventory + '\'' +
                ", quantity='" + quantity + '\'' +
                ", inventoryPolicy='" + inventoryPolicy + '\'' +
                ", inventoryLocations=" + inventoryLocations +
                '}';
    }

}
