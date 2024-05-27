package org.shopify.integrator.bini.service.config.dto.seasons;

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
        "Season"
})

public class SeasonList implements Serializable {

    private final static long serialVersionUID = 8747503082805879138L;
    @JsonProperty("Season")
    private List<Season> season = new ArrayList<Season>();

    /**
     * No args constructor for use in serialization
     */
    public SeasonList() {
    }

    /**
     * @param season
     */
    public SeasonList(List<Season> season) {
        super();
        this.season = season;
    }

    @JsonProperty("Season")
    public List<Season> getSeason() {
        return season;
    }

    @JsonProperty("Season")
    public void setSeason(List<Season> season) {
        this.season = season;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SeasonList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("season");
        sb.append('=');
        sb.append(((this.season == null) ? "<null>" : this.season));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
