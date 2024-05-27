package org.shopify.integrator.multivendor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    String id;
    @JsonProperty("image_url")
    String imageUrl;
    @JsonProperty("image_alt")
    String imageAlt;
    @JsonProperty("position")
    String position;
    @JsonProperty("image_attachment")
    String imageAttachment;

    public Image(String imageUrl, String imageAlt, String position) {
        this.imageUrl = imageUrl;
        this.position = position;
        this.imageAlt = imageAlt;
    }

    public Image() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImageAttachment() {
        return imageAttachment;
    }

    public void setImageAttachment(String imageAttachment) {
        this.imageAttachment = imageAttachment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageAlt='" + imageAlt + '\'' +
                ", position='" + position + '\'' +
                ", imageAttachment='" + imageAttachment + '\'' +
                '}';
    }
}
