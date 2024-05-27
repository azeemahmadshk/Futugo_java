package org.shopify.integrator.bini.service.config.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.shopify.integrator.multivendor.dto.InventoryLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AggregatedProductDto {

    private String id;
    private String name;
    private String description;
    private String variant;
    private String code;
    private String model;
    private String category;
    private String parentCategory;
    private String subCategory;
    private String gender;
    private String brand;
    private String season;
    private String collection;
    private String color;
    private String composition;
    private String sizeAndFit;
    private String madeIn;
    private String fabric;
    private List<String> images = new ArrayList<>();
    private List<StocksAndPricing> stocks = new ArrayList<>();

    public AggregatedProductDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getSizeAndFit() {
        return sizeAndFit;
    }

    public void setSizeAndFit(String sizeAndFit) {
        this.sizeAndFit = sizeAndFit;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<StocksAndPricing> getStocks() {
        return stocks;
    }

    public void setStocks(List<StocksAndPricing> stocks) {
        this.stocks = stocks;
    }

    public static class StocksAndPricing {

        private String sku;
        private String barcode;
        private String weight;
        private String color;
        private String brand;
        private String size;
        private String dimension;
        private String price;
        private String compareAtPrice;
        private String quantity;
        private boolean fakeCompareAtPrice = false;


        public StocksAndPricing() {
        }

        public boolean isValid() {
            return StringUtils.isNotEmpty(sku) &&
                    StringUtils.isNotEmpty(barcode) &&
                    StringUtils.isNotEmpty(color) &&
                    StringUtils.isNotEmpty(brand) &&
                    StringUtils.isNotEmpty(size) &&
                    StringUtils.isNotEmpty(price) &&
                    StringUtils.isNotEmpty(compareAtPrice) &&
                    StringUtils.isNotEmpty(quantity);
        }


        public boolean isValidBonucci() {
            return StringUtils.isNotEmpty(sku) &&
                    StringUtils.isNotEmpty(barcode) &&
                    StringUtils.isNotEmpty(color) &&
                    StringUtils.isNotEmpty(brand) &&
                    StringUtils.isNotEmpty(size) &&
                    StringUtils.isNotEmpty(price) &&
                    StringUtils.isNotEmpty(quantity);
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getDimension() {
            return dimension;
        }

        public void setDimension(String dimension) {
            this.dimension = dimension;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCompareAtPrice() {
            return compareAtPrice;
        }

        public void setCompareAtPrice(String compareAtPrice) {
            this.compareAtPrice = compareAtPrice;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StocksAndPricing that = (StocksAndPricing) o;
            return Objects.equals(sku, that.sku) && Objects.equals(barcode, that.barcode) && Objects.equals(weight, that.weight) && Objects.equals(color, that.color) && Objects.equals(brand, that.brand) && Objects.equals(size, that.size) && Objects.equals(dimension, that.dimension) && Objects.equals(price, that.price) && Objects.equals(compareAtPrice, that.compareAtPrice) && Objects.equals(quantity, that.quantity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sku, barcode, weight, color, brand, size, dimension, price, compareAtPrice, quantity);
        }

        public boolean isFakeCompareAtPrice() {
            return fakeCompareAtPrice;
        }

        public void setFakeCompareAtPrice(boolean fakeCompareAtPrice) {
            this.fakeCompareAtPrice = fakeCompareAtPrice;
        }
    }
}
