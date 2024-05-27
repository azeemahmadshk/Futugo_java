package org.shopify.integrator.bini.service.config.dto.subcategory;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.shopify.integrator.bini.service.config.dto.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "SubCategoryID",
        "SubCategoryName",
        "CategoryID",
        "CategoryName",
        "ParentID",
        "ParentName",
        "GenderID"
})
public class SubCategory implements Serializable
{

    @JsonProperty("SubCategoryID")
    private String subCategoryID;
    @JsonProperty("SubCategoryName")
    private Name subCategoryName;
    @JsonProperty("CategoryID")
    private String categoryID;
    @JsonProperty("CategoryName")
    private Name categoryName;
    @JsonProperty("ParentID")
    private String parentID;
    @JsonProperty("ParentName")
    private Name parentName;
    @JsonProperty("GenderID")
    private String genderID;
    private final static long serialVersionUID = -4205414107861936756L;

    /**
     * No args constructor for use in serialization
     *
     */
    public SubCategory() {
    }

    /**
     *
     * @param parentName
     * @param genderID
     * @param subCategoryID
     * @param categoryName
     * @param categoryID
     * @param parentID
     * @param subCategoryName
     */
    public SubCategory(String subCategoryID, Name subCategoryName, String categoryID, Name categoryName, String parentID, Name parentName, String genderID) {
        super();
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.parentID = parentID;
        this.parentName = parentName;
        this.genderID = genderID;
    }

    @JsonProperty("SubCategoryID")
    public String getSubCategoryID() {
        return subCategoryID;
    }

    @JsonProperty("SubCategoryID")
    public void setSubCategoryID(String subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    @JsonProperty("SubCategoryName")
    public Name getSubCategoryName() {
        return subCategoryName;
    }

    @JsonProperty("SubCategoryName")
    public void setSubCategoryName(Name subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @JsonProperty("CategoryID")
    public String getCategoryID() {
        return categoryID;
    }

    @JsonProperty("CategoryID")
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @JsonProperty("CategoryName")
    public Name getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(Name categoryName) {
        this.categoryName = categoryName;
    }

    @JsonProperty("ParentID")
    public String getParentID() {
        return parentID;
    }

    @JsonProperty("ParentID")
    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    @JsonProperty("ParentName")
    public Name getParentName() {
        return parentName;
    }

    @JsonProperty("ParentName")
    public void setParentName(Name parentName) {
        this.parentName = parentName;
    }

    @JsonProperty("GenderID")
    public String getGenderID() {
        return genderID;
    }

    @JsonProperty("GenderID")
    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SubCategory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subCategoryID");
        sb.append('=');
        sb.append(((this.subCategoryID == null)?"<null>":this.subCategoryID));
        sb.append(',');
        sb.append("subCategoryName");
        sb.append('=');
        sb.append(((this.subCategoryName == null)?"<null>":this.subCategoryName));
        sb.append(',');
        sb.append("categoryID");
        sb.append('=');
        sb.append(((this.categoryID == null)?"<null>":this.categoryID));
        sb.append(',');
        sb.append("categoryName");
        sb.append('=');
        sb.append(((this.categoryName == null)?"<null>":this.categoryName));
        sb.append(',');
        sb.append("parentID");
        sb.append('=');
        sb.append(((this.parentID == null)?"<null>":this.parentID));
        sb.append(',');
        sb.append("parentName");
        sb.append('=');
        sb.append(((this.parentName == null)?"<null>":this.parentName));
        sb.append(',');
        sb.append("genderID");
        sb.append('=');
        sb.append(((this.genderID == null)?"<null>":this.genderID));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
