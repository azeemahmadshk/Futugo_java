package org.shopify.integrator.bini.service.config.dto.goods.details;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Barcode",
        "Size",
        "Qty"
})
public class Item implements Serializable
{

    @JsonProperty("Barcode")
    private String barcode;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("Qty")
    private String qty;
    private final static long serialVersionUID = -4246728837537866602L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Item() {
    }

    /**
     *
     * @param size
     * @param qty
     * @param barcode
     */
    public Item(String barcode, String size, String qty) {
        super();
        this.barcode = barcode;
        this.size = size;
        this.qty = qty;
    }

    @JsonProperty("Barcode")
    public String getBarcode() {
        return barcode;
    }

    @JsonProperty("Barcode")
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("Qty")
    public String getQty() {
        return qty;
    }

    @JsonProperty("Qty")
    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Item.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("barcode");
        sb.append('=');
        sb.append(((this.barcode == null)?"<null>":this.barcode));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("qty");
        sb.append('=');
        sb.append(((this.qty == null)?"<null>":this.qty));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
