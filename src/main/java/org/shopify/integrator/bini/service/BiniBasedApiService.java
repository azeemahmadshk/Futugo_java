package org.shopify.integrator.bini.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.bini.service.config.BiniBasedConfig;
import org.shopify.integrator.bini.service.config.BiniConfig;
import org.shopify.integrator.bini.service.config.dto.AggregatedProductDto;
import org.shopify.integrator.bini.service.config.dto.brand.Brand;
import org.shopify.integrator.bini.service.config.dto.brand.BrandListMain;
import org.shopify.integrator.bini.service.config.dto.category.Category;
import org.shopify.integrator.bini.service.config.dto.category.CategoryListMain;
import org.shopify.integrator.bini.service.config.dto.color.Color;
import org.shopify.integrator.bini.service.config.dto.color.ColorListMain;
import org.shopify.integrator.bini.service.config.dto.gender.Gender;
import org.shopify.integrator.bini.service.config.dto.gender.GenderListMain;
import org.shopify.integrator.bini.service.config.dto.goods.GoodsListMain;
import org.shopify.integrator.bini.service.config.dto.goods.details.Good;
import org.shopify.integrator.bini.service.config.dto.goods.details.GoodsDetailListMain;
import org.shopify.integrator.bini.service.config.dto.goods.price.GoodsPriceListMain;
import org.shopify.integrator.bini.service.config.dto.goods.price.Price;
import org.shopify.integrator.bini.service.config.dto.goods.stocks.GoodsStockListMain;
import org.shopify.integrator.bini.service.config.dto.order.OrderMain;
import org.shopify.integrator.bini.service.config.dto.retailers.Retailer;
import org.shopify.integrator.bini.service.config.dto.retailers.RetailersListMain;
import org.shopify.integrator.bini.service.config.dto.seasons.Season;
import org.shopify.integrator.bini.service.config.dto.seasons.SeasonListMain;
import org.shopify.integrator.bini.service.config.dto.subcategory.SubCategory;
import org.shopify.integrator.bini.service.config.dto.subcategory.SubCategoryListMain;
import org.shopify.integrator.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BiniBasedApiService {

    private static final Logger LOG = LoggerFactory.getLogger(BiniBasedApiService.class);
    private static CategoryListMain categoryListMain = null;
    private static SubCategoryListMain subCategoryListMain = null;
    private static BrandListMain brandListMain = null;
    private static ColorListMain colorListMain = null;
    private static GenderListMain genderListMain = null;
    private static RetailersListMain retailersListMain = null;
    private static SeasonListMain seasonListMain = null;
    private static GoodsListMain goodsListMain = null;
    private static GoodsDetailListMain goodsDetailsListMain = null;
    private static GoodsStockListMain goodsStockListMain = null;
    private static GoodsPriceListMain goodsPriceListMain = null;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final BiniBasedConfig biniBasedConfig;

    public BiniBasedApiService(RestTemplate restTemplate, ObjectMapper objectMapper, BiniBasedConfig biniBasedConfig) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.biniBasedConfig = biniBasedConfig;
    }

    public List<AggregatedProductDto> getAllProducts() {

        return goodsListMain.getGoodsList().getGood().stream().map(g -> {

            Optional<Good> goodDetails = getGoodDetailsById(g.getID());
            Optional<Price> prices = getGoodPricesById(g.getID());


            Optional<org.shopify.integrator.bini.service.config.dto.goods.stocks.Good> stocks = getGoodStocksById(g.getID());

            String season = getSeasonById(g.getSeason()).map(i -> i.getName()).orElse(g.getSeason());
            String gender = getGenderById(g.getGenderID()).map(i -> i.getName().getEn()).orElse(null);
            String brand = getBrandById(g.getBrandID()).map(i -> i.getName()).orElse(null);
            String category = getCategoryById(g.getCategoryID()).map(i -> i.getName().getEn()).orElse(null);
            String parentCategory = getCategoryById(g.getParentCategoryID()).map(i -> i.getName().getEn()).orElse(null);
            String subCategory = getSubCategoryById(g.getSubCategoryID()).map(i -> i.getSubCategoryName().getEn()).orElse(null);
            String color = goodDetails.map(i -> i.getColor().getEn()).orElse(goodDetails.map(i -> i.getSuperColor().getEn()).orElse(null));
            String composition = goodDetails.map(i -> i.getComposition().getEn()).orElse(null);
            String sizeAndFit = goodDetails.map(i -> i.getSizeAndFit().getEn()).orElse(null);
            String madeIn = goodDetails.map(i -> i.getMadeIn()).orElse(null);
            String fabric = goodDetails.map(i -> i.getFabric().getEn()).orElse(null);
            List<String> images = goodDetails.map(i -> i.getPictures().getPicture().stream().map(p -> p.getPictureUrl()).toList()).orElse(new ArrayList<>());

            //Main prodcut
            AggregatedProductDto product = new AggregatedProductDto();
            product.setId(g.getID());
            product.setName(g.getGoodsName().getEn().split("\r\n")[0].trim());
            product.setDescription(g.getGoodsName().getEn());
            product.setVariant(g.getVariant());
            product.setCode(g.getCode());
            product.setModel(g.getModel());
            product.setCollection(g.getCollection());
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

            stocks.map(i -> i.getStocks().getStock()).orElse(new ArrayList<>()).forEach(stock -> {
                AggregatedProductDto.StocksAndPricing stocksAndPricing = new AggregatedProductDto.StocksAndPricing();

                stocksAndPricing.setBarcode(stock.getBarcode());
                stocksAndPricing.setSku(stock.getBarcode());
                stocksAndPricing.setQuantity(stock.getQty());
                stocksAndPricing.setSize(stock.getSize());
                stocksAndPricing.setBrand(brand);
                stocksAndPricing.setColor(color);
                stocksAndPricing.setDimension(sizeAndFit);

                if(prices.isPresent()){

                    String compareAt = prices.get().getRetailers().get(0).getBrandReferencePrice();
                    String netPrice = prices.get().getRetailers().get(0).getNetPrice();

                    if (StringUtils.isNotEmpty(compareAt)) {
                        BigDecimal ntPrice = new BigDecimal(netPrice.replace(",","."));
                        BigDecimal cmpPrice = new BigDecimal(compareAt.replace(",","."));

                        if(cmpPrice.compareTo(ntPrice) == 1){
                            stocksAndPricing.setFakeCompareAtPrice(false);
                            stocksAndPricing.setCompareAtPrice(compareAt);
                        }else{
                            stocksAndPricing.setFakeCompareAtPrice(true);
                            stocksAndPricing.setCompareAtPrice((Utils.getDecimalFormatter("0.00").format(ntPrice.multiply(new BigDecimal("1.10")))).replace(".",","));
                        }
                    }
                    stocksAndPricing.setPrice(netPrice);
                }

                stocksAndpricings.add(stocksAndPricing);

            });

            List<AggregatedProductDto.StocksAndPricing> filteredList = stocksAndpricings.stream().filter( i -> i.isValid()).collect(Collectors.toList());
            Collections.sort(filteredList, (AggregatedProductDto.StocksAndPricing s1, AggregatedProductDto.StocksAndPricing s2) -> s1.getSize().compareToIgnoreCase(s2.getSize()));
            product.setStocks(filteredList);


            return product;


        }).toList();


    }

    public void printFetchedLists() throws JsonProcessingException {
        if (biniBasedConfig.isLogReceivedData()) {
            LOG.info("categoryList:{}", getJson(categoryListMain));
            LOG.info("subCategoryList:{}", getJson(subCategoryListMain));
            LOG.info("brandList:{}", getJson(brandListMain));
            LOG.info("colorList:{}", getJson(colorListMain));
            LOG.info("genderList:{}", getJson(genderListMain));
            LOG.info("retailersList:{}", getJson(retailersListMain));
            LOG.info("seasonList:{}", getJson(seasonListMain));
            LOG.info("goodsList:{}", getJson(goodsListMain));
            LOG.info("goodsDetailsList:{}", getJson(goodsDetailsListMain));
            LOG.info("goodsStockList:{}", getJson(goodsStockListMain));
            LOG.info("goodsPriceListMain:{}", getJson(goodsPriceListMain));
        }
    }


    @PostConstruct
    public void initLists() throws JsonProcessingException {

        if (!biniBasedConfig.isEnabled()) {
            LOG.info("BINI based shop export is disabled. You can change this in application properties");
            return;
        }

        LOG.info("Fetching lists from BINI based shop ...");

        categoryListMain = objectMapper.readValue(getClsListByEndpoint("CategoryList"), CategoryListMain.class);
        subCategoryListMain = objectMapper.readValue(getClsListByEndpoint("SubCategoryList"), SubCategoryListMain.class);
        brandListMain = objectMapper.readValue(getClsListByEndpoint("BrandList"), BrandListMain.class);
        colorListMain = objectMapper.readValue(getClsListByEndpoint("ColorList"), ColorListMain.class);
        genderListMain = objectMapper.readValue(getClsListByEndpoint("GenderList"), GenderListMain.class);
        retailersListMain = objectMapper.readValue(getClsListByEndpoint("RetailersList"), RetailersListMain.class);
        seasonListMain = objectMapper.readValue(getClsListByEndpoint("SeasonList"), SeasonListMain.class);
        goodsListMain = objectMapper.readValue(getClsListByEndpoint("GoodsList?retailer=" + biniBasedConfig.getRetailer()), GoodsListMain.class);
        goodsDetailsListMain = objectMapper.readValue(getClsListByEndpoint("GoodsDetailList?retailer=" + biniBasedConfig.getRetailer()), GoodsDetailListMain.class);
        goodsStockListMain = objectMapper.readValue(getClsListByEndpoint("GoodsStockRetailerList?retailer=" + biniBasedConfig.getRetailer()), GoodsStockListMain.class);
        goodsPriceListMain = objectMapper.readValue(getClsListByEndpoint("GoodsPriceList?retailer=" + biniBasedConfig.getRetailer()), GoodsPriceListMain.class);

        LOG.info("All lists fetched.");
    }

    private Optional<Category> getCategoryById(final String id) {

        if (categoryListMain == null) {
            return Optional.empty();
        }
        return categoryListMain.getCategoryList().getCategory().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<SubCategory> getSubCategoryById(final String id) {

        if (subCategoryListMain == null) {
            return Optional.empty();
        }
        return subCategoryListMain.getSubCategoryList().getSubCategory().stream().filter(i -> i.getCategoryID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<Brand> getBrandById(final String id) {

        if (brandListMain == null) {
            return Optional.empty();
        }
        return brandListMain.getBrandList().getBrand().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private List<Color> getColors() {

        if (colorListMain == null) {
            return new ArrayList<>();
        }

        return colorListMain.getColorList().getColor();
    }

    private Optional<Gender> getGenderById(final String id) {

        if (genderListMain == null) {
            return Optional.empty();
        }
        return genderListMain.getGenderList().getGender().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<Retailer> getRetailerById(final String id) {

        if (retailersListMain == null) {
            return Optional.empty();
        }
        return retailersListMain.getRetailersList().getRetailer().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<Season> getSeasonById(final String id) {

        if (seasonListMain == null) {
            return Optional.empty();
        }
        return seasonListMain.getSeasonList().getSeason().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<Good> getGoodDetailsById(final String id) {

        if (goodsDetailsListMain == null) {
            return Optional.empty();
        }
        return goodsDetailsListMain.getGoodsDetailList().getGood().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<org.shopify.integrator.bini.service.config.dto.goods.stocks.Good> getGoodStocksById(final String id) {

        if (goodsStockListMain == null) {
            return Optional.empty();
        }
        return goodsStockListMain.getGoodsStockList().getGoods().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private Optional<Price> getGoodPricesById(final String id) {

        if (goodsPriceListMain == null) {
            return Optional.empty();
        }
        return goodsPriceListMain.getGoodsPriceList().getPrice().stream().filter(i -> i.getID().equalsIgnoreCase(id)).findFirst();
    }

    private String getClsListByEndpoint(String endpoint) {

        LOG.info("Fetching list of type: {}", endpoint);

        String url = biniBasedConfig.getEndpoint() + "/" + endpoint;
        HttpMethod method = HttpMethod.GET;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(createHttpHeaders()), String.class);
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
        }
        throw new RuntimeException("Response contains no body");

    }

    public String postOrder(OrderMain orderMain) {

        if (orderMain == null) {
            return null;
        }

        final String orderSaveEndpoint = "CreateNewOrder";

        LOG.info("Fetching list of type: {}", orderSaveEndpoint);

        String url = biniBasedConfig.getEndpoint() + "/" + orderSaveEndpoint;
        HttpMethod method = HttpMethod.POST;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(orderMain, createHttpHeaders()), String.class);
            return response.getBody();

        } catch (Exception eek) {
            LOG.error("Error for " + method.name() + " " + url + " endpoint, Response: " + eek.getMessage());
            throw new RuntimeException(eek.getMessage());
        }

    }

    private HttpHeaders createHttpHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString((biniBasedConfig.getUsername() + ":" + biniBasedConfig.getPass()).getBytes()));
        headers.add("USER_MKT", biniBasedConfig.getUserMkt());
        headers.add("PWD_MKT", biniBasedConfig.getPwdMkt());
        headers.add("DESCRIPTION", biniBasedConfig.getDescription());
        headers.add("LANGUAGE", biniBasedConfig.getLanguage());

        return headers;
    }

    public String getJson(Object obj) throws JsonProcessingException {
        if (obj == null) {
            return "\r\n\r\n\r\n";
        }
        return "\r\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj) + "\r\n\r\n";
    }
}

