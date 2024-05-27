package org.shopify.integrator.bini.service.config.dto.goods.details;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.shopify.integrator.bini.service.config.dto.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ID",
        "SuperColor",
        "Color",
        "Fabric",
        "Composition",
        "SizeAndFit",
        "MadeIn",
        "SizeCountry",
        "SizeType",
        "Stock",
        "Pictures",
        "CreatedTime",
        "ModifiedTime"
})

public class Good implements Serializable
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("SuperColor")
    private Name superColor;
    @JsonProperty("Color")
    private Name color;
    @JsonProperty("Fabric")
    private Name fabric;
    @JsonProperty("Composition")
    private Name composition;
    @JsonProperty("SizeAndFit")
    private Name sizeAndFit;
    @JsonProperty("MadeIn")
    private String madeIn;
    @JsonProperty("SizeCountry")
    private String sizeCountry;
    @JsonProperty("SizeType")
    private String sizeType;
    @JsonProperty("Stock")
    private Stock stock;
    @JsonProperty("Pictures")
    private Pictures pictures;
    @JsonProperty("CreatedTime")
    private String createdTime;
    @JsonProperty("ModifiedTime")
    private String modifiedTime;
    private final static long serialVersionUID = -3451442191372053374L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Good() {
    }

    /**
     *
     * @param sizeAndFit
     * @param sizeType
     * @param modifiedTime
     * @param superColor
     * @param color
     * @param sizeCountry
     * @param pictures
     * @param composition
     * @param fabric
     * @param createdTime
     * @param iD
     * @param madeIn
     * @param stock
     */
    public Good(String iD, Name superColor, Name color, Name fabric, Name composition, Name sizeAndFit, String madeIn, String sizeCountry, String sizeType, Stock stock, Pictures pictures, String createdTime, String modifiedTime) {
        super();
        this.iD = iD;
        this.superColor = superColor;
        this.color = color;
        this.fabric = fabric;
        this.composition = composition;
        this.sizeAndFit = sizeAndFit;
        this.madeIn = madeIn;
        this.sizeCountry = sizeCountry;
        this.sizeType = sizeType;
        this.stock = stock;
        this.pictures = pictures;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("SuperColor")
    public Name getSuperColor() {
        return superColor;
    }

    @JsonProperty("SuperColor")
    public void setSuperColor(Name superColor) {
        this.superColor = superColor;
    }

    @JsonProperty("Color")
    public Name getColor() {
        return color;
    }

    @JsonProperty("Color")
    public void setColor(Name color) {
        this.color = color;
    }

    @JsonProperty("Fabric")
    public Name getFabric() {
        return fabric;
    }

    @JsonProperty("Fabric")
    public void setFabric(Name fabric) {
        this.fabric = fabric;
    }

    @JsonProperty("Composition")
    public Name getComposition() {
        return composition;
    }

    @JsonProperty("Composition")
    public void setComposition(Name composition) {
        this.composition = composition;
    }

    @JsonProperty("SizeAndFit")
    public Name getSizeAndFit() {
        return sizeAndFit;
    }

    @JsonProperty("SizeAndFit")
    public void setSizeAndFit(Name sizeAndFit) {
        this.sizeAndFit = sizeAndFit;
    }

    @JsonProperty("MadeIn")
    public String getMadeIn() {
        return madeIn;
    }

    @JsonProperty("MadeIn")
    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @JsonProperty("SizeCountry")
    public String getSizeCountry() {
        return sizeCountry;
    }

    @JsonProperty("SizeCountry")
    public void setSizeCountry(String sizeCountry) {
        this.sizeCountry = sizeCountry;
    }

    @JsonProperty("SizeType")
    public String getSizeType() {
        return sizeType;
    }

    @JsonProperty("SizeType")
    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    @JsonProperty("Stock")
    public Stock getStock() {
        return stock;
    }

    @JsonProperty("Stock")
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @JsonProperty("Pictures")
    public Pictures getPictures() {
        return pictures;
    }

    @JsonProperty("Pictures")
    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("CreatedTime")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("CreatedTime")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("ModifiedTime")
    public String getModifiedTime() {
        return modifiedTime;
    }

    @JsonProperty("ModifiedTime")
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Good.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iD");
        sb.append('=');
        sb.append(((this.iD == null)?"<null>":this.iD));
        sb.append(',');
        sb.append("superColor");
        sb.append('=');
        sb.append(((this.superColor == null)?"<null>":this.superColor));
        sb.append(',');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null)?"<null>":this.color));
        sb.append(',');
        sb.append("fabric");
        sb.append('=');
        sb.append(((this.fabric == null)?"<null>":this.fabric));
        sb.append(',');
        sb.append("composition");
        sb.append('=');
        sb.append(((this.composition == null)?"<null>":this.composition));
        sb.append(',');
        sb.append("sizeAndFit");
        sb.append('=');
        sb.append(((this.sizeAndFit == null)?"<null>":this.sizeAndFit));
        sb.append(',');
        sb.append("madeIn");
        sb.append('=');
        sb.append(((this.madeIn == null)?"<null>":this.madeIn));
        sb.append(',');
        sb.append("sizeCountry");
        sb.append('=');
        sb.append(((this.sizeCountry == null)?"<null>":this.sizeCountry));
        sb.append(',');
        sb.append("sizeType");
        sb.append('=');
        sb.append(((this.sizeType == null)?"<null>":this.sizeType));
        sb.append(',');
        sb.append("stock");
        sb.append('=');
        sb.append(((this.stock == null)?"<null>":this.stock));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("modifiedTime");
        sb.append('=');
        sb.append(((this.modifiedTime == null)?"<null>":this.modifiedTime));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
