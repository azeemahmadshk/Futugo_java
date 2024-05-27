package org.shopify.integrator.bini.service.config.dto.gender;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "GenderList"
})
public class GenderListMain implements Serializable
{

    @JsonProperty("GenderList")
    private GenderList genderList = new GenderList();
    private final static long serialVersionUID = -2572170231065156437L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GenderListMain() {
    }

    /**
     *
     * @param genderList
     */
    public GenderListMain(GenderList genderList) {
        super();
        this.genderList = genderList;
    }

    @JsonProperty("GenderList")
    public GenderList getGenderList() {
        return genderList;
    }

    @JsonProperty("GenderList")
    public void setGenderList(GenderList genderList) {
        this.genderList = genderList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GenderListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("genderList");
        sb.append('=');
        sb.append(((this.genderList == null)?"<null>":this.genderList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
