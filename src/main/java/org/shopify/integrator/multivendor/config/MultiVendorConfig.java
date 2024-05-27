package org.shopify.integrator.multivendor.config;


import org.shopify.integrator.utils.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "multivendor")
public class MultiVendorConfig {

    private Integer delay;
    private String endpoint;
    private boolean logRequests;


    public String getEndpoint() {
        return Utils.prepareEndpointRoot(endpoint);
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public boolean isLogRequests() {
        return logRequests;
    }

    public void setLogRequests(boolean logRequests) {
        this.logRequests = logRequests;
    }

}
