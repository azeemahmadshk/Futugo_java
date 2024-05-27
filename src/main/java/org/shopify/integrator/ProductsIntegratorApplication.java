package org.shopify.integrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ThreadUtils;
import org.shopify.integrator.beestore.importer.BeeStoreImportService;
import org.shopify.integrator.beestore.service.config.BeeStoreConfig;
import org.shopify.integrator.bini.importer.BiniBasedShopImportService;
import org.shopify.integrator.bini.importer.BiniImportService;
import org.shopify.integrator.bini.service.config.BiniBasedConfig;
import org.shopify.integrator.bini.service.config.BiniConfig;
import org.shopify.integrator.bonucci.importer.BonucciImportService;
import org.shopify.integrator.bonucci.service.config.BonucciConfig;
import org.shopify.integrator.multivendor.config.MultiVendorConfig;
import org.shopify.integrator.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan(basePackages = {"org.shopify.integrator*"})
@EntityScan
@EnableConfigurationProperties({BiniConfig.class, MultiVendorConfig.class, BeeStoreConfig.class, BiniBasedConfig.class, BonucciConfig.class})
@EnableScheduling
public class ProductsIntegratorApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory
            .getLogger(ProductsIntegratorApplication.class);

    private final BeeStoreImportService beeStoreImportService;
    private final BiniImportService biniImportService;
    private final BiniBasedShopImportService biniBasedShopImportService;
    private final BonucciImportService bonucciImportService;

    @Value("${mode:prices}")
    private String exportMode;

    @Value("${cron.prices}")
    private String pricesUpdateCron;

    @Value("${cron.orders}")
    private String ordersUpdateCron;

    @Value("${cron.products}")
    private String productsUpdateCron;

    @Autowired
    public ProductsIntegratorApplication(@Lazy BeeStoreImportService beeStoreImportService,
                                         @Lazy BiniImportService biniImportService,
                                         @Lazy BiniBasedShopImportService biniBasedShopImportService,
                                         @Lazy BonucciImportService bonucciImportService) {
        this.beeStoreImportService = beeStoreImportService;
        this.biniImportService = biniImportService;
        this.biniBasedShopImportService = biniBasedShopImportService;
        this.bonucciImportService = bonucciImportService;
    }

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(ProductsIntegratorApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    CsvMapper csvMapper() {


        CsvMapper csvMapper = new CsvMapper();
        csvMapper.enable(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS);
        csvMapper.enable(CsvGenerator.Feature.ALWAYS_QUOTE_EMPTY_STRINGS);
        csvMapper.enable(CsvGenerator.Feature.STRICT_CHECK_FOR_QUOTING);
        return csvMapper;
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        try {

            LOG.info("Application mode is " + exportMode);

            if (StringUtils.isNotEmpty(exportMode) && exportMode.equalsIgnoreCase("full")) {
                bonucciImportService.startImport();
                biniBasedShopImportService.startImport();
                biniImportService.startImport();
                beeStoreImportService.startImport();
            }if (StringUtils.isNotEmpty(exportMode) && exportMode.equalsIgnoreCase("jar")) {
                //build jar and do nothing
            }
            else{
                while(true){
                    Utils.sleep(10000);
                }
            }
        } catch (Exception ex) {
            LOG.error("Errors occurred in application", ex);
        }


    }

    @Scheduled(cron = "${cron.products}")
    public void updatePrices() {

        LOG.info("Updating prices and stocks information...");

        try {
            bonucciImportService.updatePrices();
            biniBasedShopImportService.updatePrices();
            biniImportService.updatePrices();
            beeStoreImportService.updatePrices();
        } catch (Exception ex) {
            LOG.error("Errors occurred in application while updating prices", ex);
        }
    }

    @Scheduled(cron = "${cron.prices}")
    public void updateProducts() {

        LOG.info("Updating products information...");

        try {
            biniImportService.importNewProducts();
            beeStoreImportService.importNewProducts();
            bonucciImportService.importNewProducts();
            biniBasedShopImportService.importNewProducts();
        } catch (Exception ex) {
            LOG.error("Errors occurred in application while updating products", ex);
        }
    }

    @Scheduled(cron = "${cron.orders}")
    public void updateOrders() {

        LOG.info("Updating orders information...");

        try {
            biniImportService.processOrders();
        } catch (Exception ex) {
            LOG.error("Errors occurred in application while updating prices", ex);
        }
    }


}
