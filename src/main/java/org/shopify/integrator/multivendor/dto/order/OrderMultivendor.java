package org.shopify.integrator.multivendor.dto.order;

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
        "orders"
})

public class OrderMultivendor implements Serializable {

    @JsonProperty("orders")
    private List<Order> orders = new ArrayList<Order>();
    private final static long serialVersionUID = 5625702961014615338L;

    /**
     * No args constructor for use in serialization
     */
    public OrderMultivendor() {
    }

    /**
     * @param orders
     */
    public OrderMultivendor(List<Order> orders) {
        super();
        this.orders = orders;
    }

    @JsonProperty("orders")
    public List<Order> getOrders() {
        return orders;
    }

    @JsonProperty("orders")
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
