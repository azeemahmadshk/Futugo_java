package org.shopify.integrator.bini.service.config.dto.goods.price;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Retailer",
        "BrandReferencePrice",
        "BrandReferencePriceExVAT",
        "Discount",
        "NetPrice",
        "Currency",
        "PercentTax",
        "Country",
        "SizePrices"
})
public class Retailer implements Serializable
{

    @JsonProperty("Retailer")
    private String retailer;
    @JsonProperty("BrandReferencePrice")
    private String brandReferencePrice;
    @JsonProperty("BrandReferencePriceExVAT")
    private String brandReferencePriceExVAT;
    @JsonProperty("Discount")
    private String discount;
    @JsonProperty("NetPrice")
    private String netPrice;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("PercentTax")
    private String percentTax;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("SizePrices")
    private List<SizePrice> sizePrices = new ArrayList<SizePrice>();
    private final static long serialVersionUID = 1419669903233411774L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Retailer() {
    }

    /**
     *
     * @param country
     * @param sizePrices
     * @param retailer
     * @param brandReferencePrice
     * @param brandReferencePriceExVAT
     * @param discount
     * @param netPrice
     * @param currency
     * @param percentTax
     */
    public Retailer(String retailer, String brandReferencePrice, String brandReferencePriceExVAT, String discount, String netPrice, String currency, String percentTax, String country, List<SizePrice> sizePrices) {
        super();
        this.retailer = retailer;
        this.brandReferencePrice = brandReferencePrice;
        this.brandReferencePriceExVAT = brandReferencePriceExVAT;
        this.discount = discount;
        this.netPrice = netPrice;
        this.currency = currency;
        this.percentTax = percentTax;
        this.country = country;
        this.sizePrices = sizePrices;
    }

    @JsonProperty("Retailer")
    public String getRetailer() {
        return retailer;
    }

    @JsonProperty("Retailer")
    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    @JsonProperty("BrandReferencePrice")
    public String getBrandReferencePrice() {
        return brandReferencePrice;
    }

    @JsonProperty("BrandReferencePrice")
    public void setBrandReferencePrice(String brandReferencePrice) {
        this.brandReferencePrice = brandReferencePrice;
    }

    @JsonProperty("BrandReferencePriceExVAT")
    public String getBrandReferencePriceExVAT() {
        return brandReferencePriceExVAT;
    }

    @JsonProperty("BrandReferencePriceExVAT")
    public void setBrandReferencePriceExVAT(String brandReferencePriceExVAT) {
        this.brandReferencePriceExVAT = brandReferencePriceExVAT;
    }

    @JsonProperty("Discount")
    public String getDiscount() {
        return discount;
    }

    @JsonProperty("Discount")
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @JsonProperty("NetPrice")
    public String getNetPrice() {
        return netPrice;
    }

    @JsonProperty("NetPrice")
    public void setNetPrice(String netPrice) {
        this.netPrice = netPrice;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("PercentTax")
    public String getPercentTax() {
        return percentTax;
    }

    @JsonProperty("PercentTax")
    public void setPercentTax(String percentTax) {
        this.percentTax = percentTax;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("SizePrices")
    public List<SizePrice> getSizePrices() {
        return sizePrices;
    }

    @JsonProperty("SizePrices")
    public void setSizePrices(List<SizePrice> sizePrices) {
        this.sizePrices = sizePrices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Retailer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("retailer");
        sb.append('=');
        sb.append(((this.retailer == null)?"<null>":this.retailer));
        sb.append(',');
        sb.append("brandReferencePrice");
        sb.append('=');
        sb.append(((this.brandReferencePrice == null)?"<null>":this.brandReferencePrice));
        sb.append(',');
        sb.append("brandReferencePriceExVAT");
        sb.append('=');
        sb.append(((this.brandReferencePriceExVAT == null)?"<null>":this.brandReferencePriceExVAT));
        sb.append(',');
        sb.append("discount");
        sb.append('=');
        sb.append(((this.discount == null)?"<null>":this.discount));
        sb.append(',');
        sb.append("netPrice");
        sb.append('=');
        sb.append(((this.netPrice == null)?"<null>":this.netPrice));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("percentTax");
        sb.append('=');
        sb.append(((this.percentTax == null)?"<null>":this.percentTax));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("sizePrices");
        sb.append('=');
        sb.append(((this.sizePrices == null)?"<null>":this.sizePrices));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
