package org.shopify.integrator.bonucci.service.config;

import org.shopify.integrator.utils.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bonucci")
public class BonucciConfig {
    private String cod;
    private String endpoint;
    private String sellerId;
    private String locationId;
    private String on;
    private boolean logReceivedData;
    private String multivendorAccessToken;
    private String multivendorRefreshToken;


    public BonucciConfig() {
    }



    public String getEndpoint() {
        return Utils.prepareEndpointRoot(endpoint);
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public boolean isEnabled() {
        return "1".equalsIgnoreCase(on) || "true".equalsIgnoreCase(on);
    }

    public void setOn(String on) {
        this.on = on;
    }

    public boolean isLogReceivedData() {
        return logReceivedData;
    }

    public void setLogReceivedData(boolean logReceivedData) {
        this.logReceivedData = logReceivedData;
    }

    public String getMultivendorAccessToken() {
        return multivendorAccessToken;
    }

    public void setMultivendorAccessToken(String multivendorAccessToken) {
        this.multivendorAccessToken = multivendorAccessToken;
    }

    public String getMultivendorRefreshToken() {
        return multivendorRefreshToken;
    }

    public void setMultivendorRefreshToken(String multivendorRefreshToken) {
        this.multivendorRefreshToken = multivendorRefreshToken;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
