package org.shopify.integrator.beestore.service.config;


import org.shopify.integrator.utils.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.*;

@Configuration
@ConfigurationProperties(prefix = "beestore")
public class BeeStoreConfig {
    private String on;
    private boolean proxy;
    private String proxyHost;
    private String proxyUser;
    private String proxyPass;
    private String proxyPort;
    private String ftpHost;
    private String ftpUser;
    private String ftpPass;
    private String sellerId;
    private String locationId;
    private String imgProxyHost;
    private boolean deleteOld;
    private String multivendorAccessToken;
    private String multivendorRefreshToken;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public boolean isProxy() {
        return proxy;
    }

    public void setProxy(boolean proxy) {
        this.proxy = proxy;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyPass() {
        return proxyPass;
    }

    public void setProxyPass(String proxyPass) {
        this.proxyPass = proxyPass;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPass() {
        return ftpPass;
    }

    public void setFtpPass(String ftpPass) {
        this.ftpPass = ftpPass;
    }

    public int getFtpPort() {
        return 21;
    }

    public int getSshPort() {
        return 22;
    }

    public boolean isEnabled() {
        return "1".equalsIgnoreCase(on) || "true".equalsIgnoreCase(on);
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getImgProxyHost() {
        return Utils.prepareEndpointRoot(imgProxyHost);
    }

    public void setImgProxyHost(String imgProxyHost) {
        this.imgProxyHost = imgProxyHost;
    }

    public Proxy getProxyConfig() throws UnknownHostException {

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(getProxyUser(), getProxyPass().toCharArray()));
            }
        };

        Authenticator.setDefault(auth);
        SocketAddress proxyAddr = new InetSocketAddress(InetAddress.getByName(getProxyHost()), Integer.parseInt(getProxyPort()));
        return new Proxy(Proxy.Type.SOCKS, proxyAddr);
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

    public boolean isDeleteOld() {
        return deleteOld;
    }

    public void setDeleteOld(boolean deleteOld) {
        this.deleteOld = deleteOld;
    }

    @Override
    public String toString() {
        return "BeeStoreConfig{" +
                "enabled=" + on +
                ", proxy=" + proxy +
                ", proxyHost='" + proxyHost + '\'' +
                ", proxyUser='" + proxyUser + '\'' +
                ", proxyPass='**************'" +
                ", proxyPort='" + proxyPort + '\'' +
                ", ftpHost='" + ftpHost + '\'' +
                ", ftpUser='" + ftpUser + '\'' +
                ", ftpPass='**************'" +
                '}';
    }
}
