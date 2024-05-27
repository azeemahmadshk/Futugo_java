package org.shopify.integrator.bini.service.config.dto.goods.details;

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
        "Picture"
})

public class Pictures implements Serializable
{

    @JsonProperty("Picture")
    private List<Picture> picture = new ArrayList<Picture>();
    private final static long serialVersionUID = 2104103066031073705L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pictures() {
    }

    /**
     *
     * @param picture
     */
    public Pictures(List<Picture> picture) {
        super();
        this.picture = picture;
    }

    @JsonProperty("Picture")
    public List<Picture> getPicture() {
        return picture;
    }

    @JsonProperty("Picture")
    public void setPicture(List<Picture> picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pictures.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("picture");
        sb.append('=');
        sb.append(((this.picture == null)?"<null>":this.picture));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
