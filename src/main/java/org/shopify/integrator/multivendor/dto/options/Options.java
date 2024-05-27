package org.shopify.integrator.multivendor.dto.options;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {

    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("values")
    String values;

    public Options(String name, String values) {
        this.name = name;
        this.values = values;
    }

    public Options() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", values='" + values + '\'' +
                '}';
    }
}
