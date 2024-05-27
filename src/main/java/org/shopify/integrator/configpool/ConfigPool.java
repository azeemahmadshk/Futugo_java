package org.shopify.integrator.configpool;

import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.beestore.service.config.BeeStoreConfig;
import org.shopify.integrator.bini.service.config.BiniBasedConfig;
import org.shopify.integrator.bini.service.config.BiniConfig;
import org.shopify.integrator.bonucci.service.config.BonucciConfig;
import org.springframework.stereotype.Service;

@Service
public class ConfigPool {

    private final BonucciConfig bonucciConfig;
    private final BiniBasedConfig biniBasedConfig;
    private final BiniConfig biniConfig;
    private final BeeStoreConfig beeStoreConfig;

    public ConfigPool(BonucciConfig bonucciConfig, BiniBasedConfig biniBasedConfig, BiniConfig biniConfig, BeeStoreConfig beeStoreConfig) {
        this.bonucciConfig = bonucciConfig;
        this.biniBasedConfig = biniBasedConfig;
        this.biniConfig = biniConfig;
        this.beeStoreConfig = beeStoreConfig;
    }

    public String getSellerBySellerId(String sellerId) {

        if (StringUtils.isEmpty(sellerId)) {
            return null;
        }

        if (bonucciConfig.getSellerId().equals(sellerId)) {
            return "BONUCCI";
        } else if (biniConfig.getSellerId().equals(sellerId)) {
            return "BINI";
        } else if (biniBasedConfig.getSellerId().equals(sellerId)) {
            return "BINI_BASED";
        } else if (beeStoreConfig.getSellerId().equals(sellerId)) {
            return "MAKONDA";
        }

        return null;
    }
}
