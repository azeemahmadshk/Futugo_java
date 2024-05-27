package org.shopify.integrator.bini.service.config.dto.color;

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
        "Color"
})

public class ColorList implements Serializable
{

    @JsonProperty("Color")
    private List<Color> color = new ArrayList<Color>();
    private final static long serialVersionUID = 3499298867222250862L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ColorList() {
    }

    /**
     *
     * @param color
     */
    public ColorList(List<Color> color) {
        super();
        this.color = color;
    }

    @JsonProperty("Color")
    public List<Color> getColor() {
        return color;
    }

    @JsonProperty("Color")
    public void setColor(List<Color> color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ColorList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null)?"<null>":this.color));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
