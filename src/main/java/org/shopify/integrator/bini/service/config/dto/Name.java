package org.shopify.integrator.bini.service.config.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "it",
        "en"
})
public class Name implements Serializable {

    private final static long serialVersionUID = 417344927717087336L;
    @JsonProperty("it")
    private String it;
    @JsonProperty("en")
    private String en;

    /**
     * No args constructor for use in serialization
     */
    public Name() {
    }


    public Name(String it, String en) {
        this.it = it;
        this.en = en;
    }


    public String getIt() {
        return it;
    }

    public String getEn() {
        return StringUtils.defaultIfEmpty(en, it);
    }

    @Override
    public String toString() {
        return "Name{" +
                "it='" + it + '\'' +
                ", en='" + en + '\'' +
                '}';
    }
}
