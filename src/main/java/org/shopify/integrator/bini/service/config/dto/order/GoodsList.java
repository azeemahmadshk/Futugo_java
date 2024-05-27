package org.shopify.integrator.bini.service.config.dto.order;

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
        "Good"
})

public class GoodsList implements Serializable
{

    @JsonProperty("Good")
    private List<Good> good = new ArrayList<Good>();
    private final static long serialVersionUID = -5369434182977952519L;

    /**
     * No args constructor for use in serialization
     *
     */
    public GoodsList() {
    }

    /**
     *
     * @param good
     */
    public GoodsList(List<Good> good) {
        super();
        this.good = good;
    }

    @JsonProperty("Good")
    public List<Good> getGood() {
        return good;
    }

    @JsonProperty("Good")
    public void setGood(List<Good> good) {
        this.good = good;
    }

}
