package org.shopify.integrator.bini.service.config.dto.color;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ColorList"
})
public class ColorListMain implements Serializable {

    private final static long serialVersionUID = 660602566202260235L;
    @JsonProperty("ColorList")
    private ColorList colorList = new ColorList();

    /**
     * No args constructor for use in serialization
     */
    public ColorListMain() {
    }

    /**
     * @param colorList
     */
    public ColorListMain(ColorList colorList) {
        super();
        this.colorList = colorList;
    }

    @JsonProperty("ColorList")
    public ColorList getColorList() {
        return colorList;
    }

    @JsonProperty("ColorList")
    public void setColorList(ColorList colorList) {
        this.colorList = colorList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ColorListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("colorList");
        sb.append('=');
        sb.append(((this.colorList == null) ? "<null>" : this.colorList));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
