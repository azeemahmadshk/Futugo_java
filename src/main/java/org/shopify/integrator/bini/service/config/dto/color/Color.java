package org.shopify.integrator.bini.service.config.dto.color;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.shopify.integrator.bini.service.config.dto.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "SuperColor",
        "ColorName"
})
public class Color implements Serializable
{

    @JsonProperty("SuperColor")
    private Name superColor;
    @JsonProperty("ColorName")
    private Name colorName;
    private final static long serialVersionUID = 8080837950706465157L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Color() {
    }

    /**
     *
     * @param colorName
     * @param superColor
     */
    public Color(Name superColor, Name colorName) {
        super();
        this.superColor = superColor;
        this.colorName = colorName;
    }

    @JsonProperty("SuperColor")
    public Name getSuperColor() {
        return superColor;
    }

    @JsonProperty("SuperColor")
    public void setSuperColor(Name superColor) {
        this.superColor = superColor;
    }

    @JsonProperty("ColorName")
    public Name getColorName() {
        return colorName;
    }

    @JsonProperty("ColorName")
    public void setColorName(Name colorName) {
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Color.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("superColor");
        sb.append('=');
        sb.append(((this.superColor == null)?"<null>":this.superColor));
        sb.append(',');
        sb.append("colorName");
        sb.append('=');
        sb.append(((this.colorName == null)?"<null>":this.colorName));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
