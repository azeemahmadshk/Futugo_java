package org.shopify.integrator.bini.service.config.dto.gender;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.shopify.integrator.bini.service.config.dto.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ID",
        "Name"
})
public class Gender implements Serializable
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Name")
    private Name name;
    private final static long serialVersionUID = 417344927717087336L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Gender() {
    }

    /**
     *
     * @param name
     * @param iD
     */
    public Gender(String iD, Name name) {
        super();
        this.iD = iD;
        this.name = name;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Name")
    public Name getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Gender.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iD");
        sb.append('=');
        sb.append(((this.iD == null)?"<null>":this.iD));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
