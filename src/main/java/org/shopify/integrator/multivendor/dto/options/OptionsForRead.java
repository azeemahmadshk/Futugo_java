package org.shopify.integrator.multivendor.dto.options;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsForRead {

    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("values")
    List<OptionsForReadValue> values = new ArrayList<>();

    public OptionsForRead() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OptionsForReadValue> getValues() {
        return values;
    }

    public void setValues(List<OptionsForReadValue> values) {
        this.values = values;
    }
}
