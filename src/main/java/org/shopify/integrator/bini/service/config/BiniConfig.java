package org.shopify.integrator.bini.service.config;

import org.shopify.integrator.utils.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bini")
public class BiniConfig {

    public String on;
    private String username;
    private String pass;
    private String userMkt;
    private String pwdMkt;
    private String retailer;
    private String description;
    private String language;
    private String endpoint;
    private String sellerId;
    private String locationId;
    private boolean logReceivedData;
    private String multivendorAccessToken;
    private String multivendorRefreshToken;


    public BiniConfig() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserMkt() {
        return userMkt;
    }

    public void setUserMkt(String userMkt) {
        this.userMkt = userMkt;
    }

    public String getPwdMkt() {
        return pwdMkt;
    }

    public void setPwdMkt(String pwdMkt) {
        this.pwdMkt = pwdMkt;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
        return "1".equals(on) || "true".equals(on);
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

}
