package org.shopify.integrator.bini.service.config.dto.category;

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
        "Name",
        "ParentID",
        "ParentName",
        "GenderID"
})
public class Category implements Serializable
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Name")
    private Name name;
    @JsonProperty("ParentID")
    private String parentID;
    @JsonProperty("ParentName")
    private Name parentName;
    @JsonProperty("GenderID")
    private String genderID;
    private final static long serialVersionUID = -3783755297258159067L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Category() {
    }

    /**
     *
     * @param parentName
     * @param name
     * @param genderID
     * @param iD
     * @param parentID
     */
    public Category(String iD, Name name, String parentID, Name parentName, String genderID) {
        super();
        this.iD = iD;
        this.name = name;
        this.parentID = parentID;
        this.parentName = parentName;
        this.genderID = genderID;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Name")
    public Name getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(Name name) {
        this.name = name;
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
        sb.append(Category.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iD");
        sb.append('=');
        sb.append(((this.iD == null)?"<null>":this.iD));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
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
