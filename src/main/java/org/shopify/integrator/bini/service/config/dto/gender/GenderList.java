package org.shopify.integrator.bini.service.config.dto.gender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Gender"
})
public class GenderList implements Serializable
{

    @JsonProperty("Gender")
    private List<Gender> gender = new ArrayList<Gender>();
    private final static long serialVersionUID = 4855801396007134678L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GenderList() {
    }

    /**
     *
     * @param gender
     */
    public GenderList(List<Gender> gender) {
        super();
        this.gender = gender;
    }

    @JsonProperty("Gender")
    public List<Gender> getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(List<Gender> gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GenderList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null)?"<null>":this.gender));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
