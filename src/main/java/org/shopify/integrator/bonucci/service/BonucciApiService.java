package org.shopify.integrator.bonucci.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
import org.shopify.integrator.bonucci.service.config.BonucciConfig;
import org.shopify.integrator.bonucci.service.config.dto.Article;
import org.shopify.integrator.bonucci.service.config.dto.ArticleMain;
import org.shopify.integrator.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BonucciApiService {

    private static final Logger LOG = LoggerFactory.getLogger(BonucciApiService.class);
    private static final Set<Article> articlesList = new HashSet<>();
    private static Set<String> seasonsList = new HashSet<>();
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final BonucciConfig bonucciConfig;

    public BonucciApiService(RestTemplate restTemplate, ObjectMapper objectMapper, BonucciConfig bonucciConfig) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.bonucciConfig = bonucciConfig;
    }

    public List<AggregatedProductDto> getAllProducts() {

        return articlesList.stream().map(g -> {


            String season = g.getSeasonCode();
            String gender = g.getGender();
            String brand = g.getProductBrand();
            String category = g.getCategory();
            String parentCategory = g.getCategory();
            String subCategory = g.getCategory();
            String color = g.getColor();
            String composition = g.getProductMaterial();
            String sizeAndFit = g.getSizeInfo();
            String madeIn = g.getProductMADEin();
            String fabric = g.getProductMaterial();
            List<String> images = g.getPicture();

            //Main prodcut
            AggregatedProductDto product = new AggregatedProductDto();
            product.setId(g.getProductID());
            product.setName(g.getProductName().split("\r\n")[0].trim());
            product.setDescription(g.getDescription());
            product.setCode(g.getSku());
            product.setModel(g.getSku());
            product.setBrand(brand);
            product.setGender(gender);
            product.setCategory(category);
            product.setSubCategory(subCategory);
            product.setParentCategory(parentCategory);
            product.setColor(color);
            product.setComposition(composition);
            product.setSizeAndFit(sizeAndFit);
            product.setMadeIn(madeIn);
            product.setFabric(fabric);
            product.setSeason(season);
            product.setImages(images);
            //pricing and stocks
            List<AggregatedProductDto.StocksAndPricing> stocksAndpricings = new ArrayList<>();

            g.getStockItem().forEach(stock -> {
                AggregatedProductDto.StocksAndPricing stocksAndPricing = new AggregatedProductDto.StocksAndPricing();

                stocksAndPricing.setBarcode(stock.getSKUItem());
                stocksAndPricing.setSku(stock.getSKUItem());
                stocksAndPricing.setQuantity(String.valueOf(stock.getStock()));
                stocksAndPricing.setSize(stock.getSize());
                stocksAndPricing.setBrand(brand);
                stocksAndPricing.setColor(color);
                stocksAndPricing.setDimension(sizeAndFit);

                String netPrice = String.valueOf(stock.getMarketPrice());
                stocksAndPricing.setPrice(Utils.getDecimalFormatter("0.00").format(new BigDecimal(netPrice)));


                stocksAndpricings.add(stocksAndPricing);

            });

            List<AggregatedProductDto.StocksAndPricing> filteredList = stocksAndpricings.stream().filter(i -> i.isValidBonucci()).collect(Collectors.toList());
            Collections.sort(filteredList, (AggregatedProductDto.StocksAndPricing s1, AggregatedProductDto.StocksAndPricing s2) -> s1.getSize().compareToIgnoreCase(s2.getSize()));
            product.setStocks(filteredList);


            return product;


        }).filter(i -> !CollectionUtils.isEmpty(i.getImages())).toList();


    }

    public void printFetchedLists() throws JsonProcessingException {
        if (bonucciConfig.isLogReceivedData()) {
            LOG.info("articlesList:{}", getJson(articlesList));
            LOG.info("seasonsList:{}", getJson(seasonsList));
        }
    }


    @PostConstruct
    public void initLists() throws JsonProcessingException {

        if (!bonucciConfig.isEnabled()) {
            LOG.info("Bonucci export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Fetching lists from Bonucci...");
        seasonsList = getAllSeasons();
//                .stream()
//                .sorted().limit(2)
//                .collect(Collectors.toCollection(LinkedHashSet::new));

        if (!CollectionUtils.isEmpty(seasonsList)) {
            for (String season : seasonsList) {

                ArticleMain main = getArticlesBySeason(season);
                if (main.getSuccess()) {
                    if (bonucciConfig.isLogReceivedData()) {
                        LOG.info("listReceived:{}", getJson(main.getArticle()));
                    }
                    articlesList.addAll(main.getArticle());
                }
            }
        }

        LOG.info("All lists fetched.");
    }

    private Set<String> getAllSeasons() {

        LOG.info("Fetching season list with url: {}", bonucciConfig.getEndpoint() + "/GetSeason");


        String url = bonucciConfig.getEndpoint() + "/GetSeason";
        HttpMethod method = HttpMethod.GET;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders()), String.class);
            return objectMapper.readValue(response.getBody(), Set.class);

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }
        throw new RuntimeException("Response contains no body");
    }


    private ArticleMain getArticlesBySeason(final String season) {


        String url = bonucciConfig.getEndpoint() + "/Get?Cod=" + bonucciConfig.getCod() + "&Season=" + season;
        LOG.info("Fetching article list with url: {}", url);
        HttpMethod method = HttpMethod.GET;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders()), String.class);
            return objectMapper.readValue(response.getBody(), ArticleMain.class);

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }
        throw new RuntimeException("Response contains no body");

    }

    private HttpHeaders createHttpHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public String getJson(Object obj) throws JsonProcessingException {
        if (obj == null) {
            return "\r\n\r\n\r\n";
        }
        return "\r\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj) + "\r\n\r\n";
    }
}

