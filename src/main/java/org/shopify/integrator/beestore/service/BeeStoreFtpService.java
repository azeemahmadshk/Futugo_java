package org.shopify.integrator.beestore.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.shopify.integrator.beestore.service.config.BeeStoreConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class BeeStoreFtpService {

    private static final Logger LOG = LoggerFactory.getLogger(BeeStoreFtpService.class);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
    private final BeeStoreConfig beeStoreConfig;
    private final CsvMapper csvMapper;

    public BeeStoreFtpService(BeeStoreConfig beeStoreConfig, CsvMapper csvMapper) {
        this.beeStoreConfig = beeStoreConfig;
        this.csvMapper = csvMapper;
    }

    public List<BeeStoreFtpProduct> getLatestProducts() {
        List<BeeStoreFtpProduct> products = new ArrayList<>();

        LOG.info("BeeStore FTP client configuration:\n\r{}", beeStoreConfig);

        if (!beeStoreConfig.isEnabled()) {
            LOG.info("BeeStore integration is disabled. You can change this in application.properties");
            return products;
        }

        try {
            FTPClient ftpClient = new FTPClient();

            // If SOCKS5 proxy used setting it here
            if (beeStoreConfig.isProxy()) {
                LOG.info("Setting up SOCKS5 proxy for FTP connection via server");
                ftpClient.setProxy(beeStoreConfig.getProxyConfig());
            }

            ftpClient.connect(beeStoreConfig.getFtpHost(), beeStoreConfig.getFtpPort());

            int reply = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                LOG.error("FTP server refused connection.");
                return products;
            }

            if (ftpClient.login(beeStoreConfig.getFtpUser(), beeStoreConfig.getFtpPass())) {
                LOG.info("Connected and logged in to FTP server...");
                ftpClient.enterLocalPassiveMode();

                Optional<FileInFTP> latestFile = getLatestProductFile(ftpClient);
                if (latestFile.isPresent()) {
                    LOG.info("Latest products file in FTP: {} with dateTime: {}", latestFile.get().filename(), latestFile.get().date());
                    LOG.info("Downloading: {} ...", latestFile.get().filename());

                    InputStream stream = ftpClient.retrieveFileStream(latestFile.get().filename());
                    String content = IOUtils.toString(stream, StandardCharsets.UTF_8.name());

                    LOG.info("File downloaded, converting...");

                    CsvSchema schema = csvMapper.schemaFor(BeeStoreFtpProduct.class)
                            .withSkipFirstDataRow(true);

                    MappingIterator<BeeStoreFtpProduct> productsIterator = csvMapper.readerFor(BeeStoreFtpProduct.class).with(schema).readValues(content);
                    products = productsIterator.readAll();
                    LOG.info("Total products found in file {}", products.size());
                    LOG.info("File converted to POJO, closing FTP connection and releasing resources...");
                    stream.close();
                }

                ftpClient.logout();
                ftpClient.disconnect();
                LOG.info("FTP connection closed");
            } else {
                LOG.error("FTP login failed.");
            }


        } catch (Exception e) {
            LOG.error("Errors", e);
        }
        return products;
    }


    private Optional<FileInFTP> getLatestProductFile(FTPClient ftpClient) throws IOException {
        LOG.info("Listing all files in FTP server root directory...");

        return Arrays.stream(ftpClient.listNames())
                .peek(name -> LOG.info("File in FTP server: {}", name))
                .filter(name -> name.split("_").length == 6)
                .map(this::createFileInFTP)
                .sorted(Comparator.comparing(FileInFTP::date).reversed().thenComparing(FileInFTP::sequence).reversed())
                .findFirst();
    }

    private FileInFTP createFileInFTP(String name) {
        String[] parts = name.split("_");
        return new FileInFTP(parts[0], parts[1], parts[2],
                LocalDateTime.parse(parts[3] + " " + parts[4], DATE_FORMAT),
                Integer.parseInt(FilenameUtils.removeExtension(parts[5])), name);
    }

    private record FileInFTP(String company, String number, String code, LocalDateTime date, Integer sequence,
                             String filename) {
    }

}
