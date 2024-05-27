package org.shopify.integrator.bini.service.config.dto.goods.details;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "No",
        "PictureUrl",
        "PictureThumbUrl"
})
public class Picture implements Serializable
{

    @JsonProperty("No")
    private String no;
    @JsonProperty("PictureUrl")
    private String pictureUrl;
    @JsonProperty("PictureThumbUrl")
    private String pictureThumbUrl;
    private final static long serialVersionUID = -8250389461830814963L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Picture() {
    }

    /**
     *
     * @param no
     * @param pictureUrl
     * @param pictureThumbUrl
     */
    public Picture(String no, String pictureUrl, String pictureThumbUrl) {
        super();
        this.no = no;
        this.pictureUrl = pictureUrl;
        this.pictureThumbUrl = pictureThumbUrl;
    }

    @JsonProperty("No")
    public String getNo() {
        return no;
    }

    @JsonProperty("No")
    public void setNo(String no) {
        this.no = no;
    }

    @JsonProperty("PictureUrl")
    public String getPictureUrl() {
        return pictureUrl;
    }

    @JsonProperty("PictureUrl")
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @JsonProperty("PictureThumbUrl")
    public String getPictureThumbUrl() {
        return pictureThumbUrl;
    }

    @JsonProperty("PictureThumbUrl")
    public void setPictureThumbUrl(String pictureThumbUrl) {
        this.pictureThumbUrl = pictureThumbUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Picture.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("no");
        sb.append('=');
        sb.append(((this.no == null)?"<null>":this.no));
        sb.append(',');
        sb.append("pictureUrl");
        sb.append('=');
        sb.append(((this.pictureUrl == null)?"<null>":this.pictureUrl));
        sb.append(',');
        sb.append("pictureThumbUrl");
        sb.append('=');
        sb.append(((this.pictureThumbUrl == null)?"<null>":this.pictureThumbUrl));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
