package org.shopify.integrator.bini.service.config.dto.goods.price;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Size",
        "Barcode",
        "SizeBrandReferencePrice",
        "SizeBrandReferencePriceExVAT",
        "SizeDiscount",
        "SizeNetPrice"
})
public class SizePrice implements Serializable
{

    @JsonProperty("Size")
    private String size;
    @JsonProperty("Barcode")
    private String barcode;
    @JsonProperty("SizeBrandReferencePrice")
    private String sizeBrandReferencePrice;
    @JsonProperty("SizeBrandReferencePriceExVAT")
    private String sizeBrandReferencePriceExVAT;
    @JsonProperty("SizeDiscount")
    private String sizeDiscount;
    @JsonProperty("SizeNetPrice")
    private String sizeNetPrice;
    private final static long serialVersionUID = 7120986035388913545L;

    /**
     * No args constructor for use in serialization
     *
     */
    public SizePrice() {
    }

    /**
     *
     * @param sizeBrandReferencePrice
     * @param size
     * @param sizeNetPrice
     * @param sizeBrandReferencePriceExVAT
     * @param barcode
     * @param sizeDiscount
     */
    public SizePrice(String size, String barcode, String sizeBrandReferencePrice, String sizeBrandReferencePriceExVAT, String sizeDiscount, String sizeNetPrice) {
        super();
        this.size = size;
        this.barcode = barcode;
        this.sizeBrandReferencePrice = sizeBrandReferencePrice;
        this.sizeBrandReferencePriceExVAT = sizeBrandReferencePriceExVAT;
        this.sizeDiscount = sizeDiscount;
        this.sizeNetPrice = sizeNetPrice;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("Barcode")
    public String getBarcode() {
        return barcode;
    }

    @JsonProperty("Barcode")
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @JsonProperty("SizeBrandReferencePrice")
    public String getSizeBrandReferencePrice() {
        return sizeBrandReferencePrice;
    }

    @JsonProperty("SizeBrandReferencePrice")
    public void setSizeBrandReferencePrice(String sizeBrandReferencePrice) {
        this.sizeBrandReferencePrice = sizeBrandReferencePrice;
    }

    @JsonProperty("SizeBrandReferencePriceExVAT")
    public String getSizeBrandReferencePriceExVAT() {
        return sizeBrandReferencePriceExVAT;
    }

    @JsonProperty("SizeBrandReferencePriceExVAT")
    public void setSizeBrandReferencePriceExVAT(String sizeBrandReferencePriceExVAT) {
        this.sizeBrandReferencePriceExVAT = sizeBrandReferencePriceExVAT;
    }

    @JsonProperty("SizeDiscount")
    public String getSizeDiscount() {
        return sizeDiscount;
    }

    @JsonProperty("SizeDiscount")
    public void setSizeDiscount(String sizeDiscount) {
        this.sizeDiscount = sizeDiscount;
    }

    @JsonProperty("SizeNetPrice")
    public String getSizeNetPrice() {
        return sizeNetPrice;
    }

    @JsonProperty("SizeNetPrice")
    public void setSizeNetPrice(String sizeNetPrice) {
        this.sizeNetPrice = sizeNetPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SizePrice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("barcode");
        sb.append('=');
        sb.append(((this.barcode == null)?"<null>":this.barcode));
        sb.append(',');
        sb.append("sizeBrandReferencePrice");
        sb.append('=');
        sb.append(((this.sizeBrandReferencePrice == null)?"<null>":this.sizeBrandReferencePrice));
        sb.append(',');
        sb.append("sizeBrandReferencePriceExVAT");
        sb.append('=');
        sb.append(((this.sizeBrandReferencePriceExVAT == null)?"<null>":this.sizeBrandReferencePriceExVAT));
        sb.append(',');
        sb.append("sizeDiscount");
        sb.append('=');
        sb.append(((this.sizeDiscount == null)?"<null>":this.sizeDiscount));
        sb.append(',');
        sb.append("sizeNetPrice");
        sb.append('=');
        sb.append(((this.sizeNetPrice == null)?"<null>":this.sizeNetPrice));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
