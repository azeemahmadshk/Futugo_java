package org.shopify.integrator.bonucci.service.config.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "SKU",
        "ProductID",
        "Product_Name",
        "Season_Code",
        "CarryOver",
        "Description",
        "Category",
        "CategoryID",
        "Product_Brand",
        "Product_BrandID",
        "Product_Detail",
        "Product_Material",
        "Product_MADEin",
        "Gender",
        "Url",
        "Color",
        "Market_Price",
        "Supply_Price",
        "SizeInfo",
        "Picture",
        "Stock_Item"
})
public class Article implements Serializable {

    private final static long serialVersionUID = -5622628516177663697L;
    @JsonProperty("SKU")
    private String sku;
    @JsonProperty("ProductID")
    private String productID;
    @JsonProperty("Product_Name")
    private String productName;
    @JsonProperty("Season_Code")
    private String seasonCode;
    @JsonProperty("CarryOver")
    private Boolean carryOver;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("CategoryID")
    private Integer categoryID;
    @JsonProperty("Product_Brand")
    private String productBrand;
    @JsonProperty("Product_BrandID")
    private Integer productBrandID;
    @JsonProperty("Product_Detail")
    private String productDetail;
    @JsonProperty("Product_Material")
    private String productMaterial;
    @JsonProperty("Product_MADEin")
    private String productMADEin;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Url")
    private String url;
    @JsonProperty("Color")
    private String color;
    @JsonProperty("Market_Price")
    private Double marketPrice;
    @JsonProperty("Supply_Price")
    private Double supplyPrice;
    @JsonProperty("SizeInfo")
    private String sizeInfo;
    @JsonProperty("Picture")
    private List<String> picture = new ArrayList<String>();
    @JsonProperty("Stock_Item")
    private List<StockItem> stockItem = new ArrayList<StockItem>();

    /**
     * No args constructor for use in serialization
     */
    public Article() {
    }

    /**
     * @param marketPrice
     * @param supplyPrice
     * @param productID
     * @param seasonCode
     * @param gender
     * @param color
     * @param productDetail
     * @param productMaterial
     * @param productMADEin
     * @param productBrand
     * @param productBrandID
     * @param carryOver
     * @param description
     * @param productName
     * @param url
     * @param picture
     * @param sizeInfo
     * @param stockItem
     * @param sku
     * @param category
     * @param categoryID
     */
    public Article(String sku, String productID, String productName, String seasonCode, Boolean carryOver, String description, String category, Integer categoryID, String productBrand, Integer productBrandID, String productDetail, String productMaterial, String productMADEin, String gender, String url, String color, Double marketPrice, Double supplyPrice, String sizeInfo, List<String> picture, List<StockItem> stockItem) {
        super();
        this.sku = sku;
        this.productID = productID;
        this.productName = productName;
        this.seasonCode = seasonCode;
        this.carryOver = carryOver;
        this.description = description;
        this.category = category;
        this.categoryID = categoryID;
        this.productBrand = productBrand;
        this.productBrandID = productBrandID;
        this.productDetail = productDetail;
        this.productMaterial = productMaterial;
        this.productMADEin = productMADEin;
        this.gender = gender;
        this.url = url;
        this.color = color;
        this.marketPrice = marketPrice;
        this.supplyPrice = supplyPrice;
        this.sizeInfo = sizeInfo;
        this.picture = picture;
        this.stockItem = stockItem;
    }

    @JsonProperty("SKU")
    public String getSku() {
        return sku;
    }

    @JsonProperty("SKU")
    public void setSku(String sku) {
        this.sku = sku;
    }

    @JsonProperty("ProductID")
    public String getProductID() {
        return productID;
    }

    @JsonProperty("ProductID")
    public void setProductID(String productID) {
        this.productID = productID;
    }

    @JsonProperty("Product_Name")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("Product_Name")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("Season_Code")
    public String getSeasonCode() {
        return seasonCode;
    }

    @JsonProperty("Season_Code")
    public void setSeasonCode(String seasonCode) {
        this.seasonCode = seasonCode;
    }

    @JsonProperty("CarryOver")
    public Boolean getCarryOver() {
        return carryOver;
    }

    @JsonProperty("CarryOver")
    public void setCarryOver(Boolean carryOver) {
        this.carryOver = carryOver;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("CategoryID")
    public Integer getCategoryID() {
        return categoryID;
    }

    @JsonProperty("CategoryID")
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    @JsonProperty("Product_Brand")
    public String getProductBrand() {
        return productBrand;
    }

    @JsonProperty("Product_Brand")
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    @JsonProperty("Product_BrandID")
    public Integer getProductBrandID() {
        return productBrandID;
    }

    @JsonProperty("Product_BrandID")
    public void setProductBrandID(Integer productBrandID) {
        this.productBrandID = productBrandID;
    }

    @JsonProperty("Product_Detail")
    public String getProductDetail() {
        return productDetail;
    }

    @JsonProperty("Product_Detail")
    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @JsonProperty("Product_Material")
    public String getProductMaterial() {
        return productMaterial;
    }

    @JsonProperty("Product_Material")
    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    @JsonProperty("Product_MADEin")
    public String getProductMADEin() {
        return productMADEin;
    }

    @JsonProperty("Product_MADEin")
    public void setProductMADEin(String productMADEin) {
        this.productMADEin = productMADEin;
    }

    @JsonProperty("Gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("Url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("Color")
    public String getColor() {
        return color;
    }

    @JsonProperty("Color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("Market_Price")
    public Double getMarketPrice() {
        return marketPrice;
    }

    @JsonProperty("Market_Price")
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    @JsonProperty("Supply_Price")
    public Double getSupplyPrice() {
        return supplyPrice;
    }

    @JsonProperty("Supply_Price")
    public void setSupplyPrice(Double supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    @JsonProperty("SizeInfo")
    public String getSizeInfo() {
        return sizeInfo;
    }

    @JsonProperty("SizeInfo")
    public void setSizeInfo(String sizeInfo) {
        this.sizeInfo = sizeInfo;
    }

    @JsonProperty("Picture")
    public List<String> getPicture() {
        return picture;
    }

    @JsonProperty("Picture")
    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    @JsonProperty("Stock_Item")
    public List<StockItem> getStockItem() {
        return stockItem;
    }

    @JsonProperty("Stock_Item")
    public void setStockItem(List<StockItem> stockItem) {
        this.stockItem = stockItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(sku, article.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}
