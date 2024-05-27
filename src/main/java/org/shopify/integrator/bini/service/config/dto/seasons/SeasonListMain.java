package org.shopify.integrator.bini.service.config.dto.seasons;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "SeasonList"
})
public class SeasonListMain implements Serializable {

    private final static long serialVersionUID = -2429039568332993502L;
    @JsonProperty("SeasonList")
    private SeasonList seasonList = new SeasonList();

    /**
     * No args constructor for use in serialization
     */
    public SeasonListMain() {
    }

    /**
     * @param seasonList
     */
    public SeasonListMain(SeasonList seasonList) {
        super();
        this.seasonList = seasonList;
    }

    @JsonProperty("SeasonList")
    public SeasonList getSeasonList() {
        return seasonList;
    }

    @JsonProperty("SeasonList")
    public void setSeasonList(SeasonList seasonList) {
        this.seasonList = seasonList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SeasonListMain.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("seasonList");
        sb.append('=');
        sb.append(((this.seasonList == null) ? "<null>" : this.seasonList));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
