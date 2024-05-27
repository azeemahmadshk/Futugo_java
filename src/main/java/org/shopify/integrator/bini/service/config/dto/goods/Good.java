package org.shopify.integrator.bini.service.config.dto.goods;

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
        "Model",
        "Variant",
        "Season",
        "Collection",
        "BrandID",
        "ParentCategoryID",
        "CategoryID",
        "GenderID",
        "Code",
        "GoodsName",
        "Description",
        "ShortDescription",
        "SpecialDescription",
        "InStock",
        "MainPicture",
        "CreatedTime",
        "ModifiedTime",
        "SubCategoryID"
})
public class Good implements Serializable
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("Variant")
    private String variant;
    @JsonProperty("Season")
    private String season;
    @JsonProperty("Collection")
    private String collection;
    @JsonProperty("BrandID")
    private String brandID;
    @JsonProperty("ParentCategoryID")
    private String parentCategoryID;
    @JsonProperty("CategoryID")
    private String categoryID;
    @JsonProperty("GenderID")
    private String genderID;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("GoodsName")
    private Name goodsName;
    @JsonProperty("Description")
    private Name description;
    @JsonProperty("ShortDescription")
    private Name shortDescription;
    @JsonProperty("SpecialDescription")
    private Name specialDescription;
    @JsonProperty("InStock")
    private String inStock;
    @JsonProperty("MainPicture")
    private String mainPicture;
    @JsonProperty("CreatedTime")
    private String createdTime;
    @JsonProperty("ModifiedTime")
    private String modifiedTime;
    @JsonProperty("SubCategoryID")
    private String subCategoryID;
    private final static long serialVersionUID = 1628622182774557953L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Good() {
    }

    /**
     *
     * @param modifiedTime
     * @param code
     * @param genderID
     * @param description
     * @param mainPicture
     * @param collection
     * @param shortDescription
     * @param subCategoryID
     * @param specialDescription
     * @param brandID
     * @param variant
     * @param season
     * @param createdTime
     * @param model
     * @param parentCategoryID
     * @param inStock
     * @param iD
     * @param goodsName
     * @param categoryID
     */
    public Good(String iD, String model, String variant, String season, String collection, String brandID, String parentCategoryID, String categoryID, String genderID, String code, Name goodsName, Name description, Name shortDescription, Name specialDescription, String inStock, String mainPicture, String createdTime, String modifiedTime, String subCategoryID) {
        super();
        this.iD = iD;
        this.model = model;
        this.variant = variant;
        this.season = season;
        this.collection = collection;
        this.brandID = brandID;
        this.parentCategoryID = parentCategoryID;
        this.categoryID = categoryID;
        this.genderID = genderID;
        this.code = code;
        this.goodsName = goodsName;
        this.description = description;
        this.shortDescription = shortDescription;
        this.specialDescription = specialDescription;
        this.inStock = inStock;
        this.mainPicture = mainPicture;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.subCategoryID = subCategoryID;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Model")
    public String getModel() {
        return model;
    }

    @JsonProperty("Model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("Variant")
    public String getVariant() {
        return variant;
    }

    @JsonProperty("Variant")
    public void setVariant(String variant) {
        this.variant = variant;
    }

    @JsonProperty("Season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("Season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonProperty("Collection")
    public String getCollection() {
        return collection;
    }

    @JsonProperty("Collection")
    public void setCollection(String collection) {
        this.collection = collection;
    }

    @JsonProperty("BrandID")
    public String getBrandID() {
        return brandID;
    }

    @JsonProperty("BrandID")
    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    @JsonProperty("ParentCategoryID")
    public String getParentCategoryID() {
        return parentCategoryID;
    }

    @JsonProperty("ParentCategoryID")
    public void setParentCategoryID(String parentCategoryID) {
        this.parentCategoryID = parentCategoryID;
    }

    @JsonProperty("CategoryID")
    public String getCategoryID() {
        return categoryID;
    }

    @JsonProperty("CategoryID")
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @JsonProperty("GenderID")
    public String getGenderID() {
        return genderID;
    }

    @JsonProperty("GenderID")
    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("GoodsName")
    public Name getGoodsName() {
        return goodsName;
    }

    @JsonProperty("GoodsName")
    public void setGoodsName(Name goodsName) {
        this.goodsName = goodsName;
    }

    @JsonProperty("Description")
    public Name getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(Name description) {
        this.description = description;
    }

    @JsonProperty("ShortDescription")
    public Name getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("ShortDescription")
    public void setShortDescription(Name shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("SpecialDescription")
    public Name getSpecialDescription() {
        return specialDescription;
    }

    @JsonProperty("SpecialDescription")
    public void setSpecialDescription(Name specialDescription) {
        this.specialDescription = specialDescription;
    }

    @JsonProperty("InStock")
    public String getInStock() {
        return inStock;
    }

    @JsonProperty("InStock")
    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    @JsonProperty("MainPicture")
    public String getMainPicture() {
        return mainPicture;
    }

    @JsonProperty("MainPicture")
    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
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

    @JsonProperty("SubCategoryID")
    public String getSubCategoryID() {
        return subCategoryID;
    }

    @JsonProperty("SubCategoryID")
    public void setSubCategoryID(String subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Good.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iD");
        sb.append('=');
        sb.append(((this.iD == null)?"<null>":this.iD));
        sb.append(',');
        sb.append("model");
        sb.append('=');
        sb.append(((this.model == null)?"<null>":this.model));
        sb.append(',');
        sb.append("variant");
        sb.append('=');
        sb.append(((this.variant == null)?"<null>":this.variant));
        sb.append(',');
        sb.append("season");
        sb.append('=');
        sb.append(((this.season == null)?"<null>":this.season));
        sb.append(',');
        sb.append("collection");
        sb.append('=');
        sb.append(((this.collection == null)?"<null>":this.collection));
        sb.append(',');
        sb.append("brandID");
        sb.append('=');
        sb.append(((this.brandID == null)?"<null>":this.brandID));
        sb.append(',');
        sb.append("parentCategoryID");
        sb.append('=');
        sb.append(((this.parentCategoryID == null)?"<null>":this.parentCategoryID));
        sb.append(',');
        sb.append("categoryID");
        sb.append('=');
        sb.append(((this.categoryID == null)?"<null>":this.categoryID));
        sb.append(',');
        sb.append("genderID");
        sb.append('=');
        sb.append(((this.genderID == null)?"<null>":this.genderID));
        sb.append(',');
        sb.append("code");
        sb.append('=');
        sb.append(((this.code == null)?"<null>":this.code));
        sb.append(',');
        sb.append("goodsName");
        sb.append('=');
        sb.append(((this.goodsName == null)?"<null>":this.goodsName));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("shortDescription");
        sb.append('=');
        sb.append(((this.shortDescription == null)?"<null>":this.shortDescription));
        sb.append(',');
        sb.append("specialDescription");
        sb.append('=');
        sb.append(((this.specialDescription == null)?"<null>":this.specialDescription));
        sb.append(',');
        sb.append("inStock");
        sb.append('=');
        sb.append(((this.inStock == null)?"<null>":this.inStock));
        sb.append(',');
        sb.append("mainPicture");
        sb.append('=');
        sb.append(((this.mainPicture == null)?"<null>":this.mainPicture));
        sb.append(',');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("modifiedTime");
        sb.append('=');
        sb.append(((this.modifiedTime == null)?"<null>":this.modifiedTime));
        sb.append(',');
        sb.append("subCategoryID");
        sb.append('=');
        sb.append(((this.subCategoryID == null)?"<null>":this.subCategoryID));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
