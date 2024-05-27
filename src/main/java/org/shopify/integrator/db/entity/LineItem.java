package org.shopify.integrator.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "items")
public class LineItem
{

    @JsonProperty("id")
    @Id
    private String id;
    @JsonProperty("main_id_shop")
    @Column
    private String mainIdShop;
    @JsonProperty("seller_id")
    @Column
    private String sellerId;
    @JsonProperty("order_id")
    @Column
    private String orderId;
    @JsonProperty("shopify_order_id")
    @Column
    private String shopifyOrderId;
    @JsonProperty("order_product_id")
    @Column
    private String orderProductId;
    @JsonProperty("product_id")
    @Column
    private String productId;
    @JsonProperty("shopify_product_id")
    @Column
    private String shopifyProductId;
    @JsonProperty("shopify_variant_id")
    @Column
    private String shopifyVariantId;
    @JsonProperty("product_name")
    @Column
    private String productName;
    @JsonProperty("variant_title")
    @Column
    private String variantTitle;
    @JsonProperty("product_price")
    @Column
    private String productPrice;
    @JsonProperty("sku")
    @Column
    private String sku;
    @JsonProperty("note_attribute")
    @Column
    private String noteAttribute;
    @JsonProperty("line_discount")
    @Column
    private String lineDiscount;
    @JsonProperty("total_quantity")
    @Column
    private String totalQuantity;
    @JsonProperty("line_item_id")
    @Column
    private String lineItemId;
    @JsonProperty("tax_type")
    @Column
    private String taxType;
    @JsonProperty("tax_rate")
    @Column
    private String taxRate;
    @JsonProperty("tax_type2")
    @Column
    private String taxType2;
    @JsonProperty("tax_rate2")
    @Column
    private String taxRate2;
    @JsonProperty("actual_shipping")
    @Column
    private String actualShipping;
    @JsonProperty("actual_tax")
    @Column
    private String actualTax;
    @JsonProperty("unit_commission")
    @Column
    private String unitCommission;
    @JsonProperty("shipping_commission")
    @Column
    private String shippingCommission;
    @JsonProperty("tax_commission")
    @Column
    private String taxCommission;
    @JsonProperty("total_commission")
    @Column
    private String totalCommission;
    @JsonProperty("id_commission_basis")
    @Column
    private String idCommissionBasis;
    @JsonProperty("id_commission_type")
    @Column
    private String idCommissionType;
    @JsonProperty("commission_values")
    @Column
    private String commissionValues;
    @JsonProperty("status")
    @Column
    private String status;
    @JsonProperty("cancel_reason_id")
    @Column
    private String cancelReasonId;
    @JsonProperty("ndr_awb_number")
    @Column
    private String ndrAwbNumber;
    @JsonProperty("is_returned")
    @Column
    private String isReturned;
    @JsonProperty("penalty_type")
    @Column
    private String penaltyType;
    @JsonProperty("penalty_value")
    @Column
    private String penaltyValue;
    @JsonProperty("shipping_type")
    @Column
    private String shippingType;
    @JsonProperty("shipping_label_link")
    @Column
    private String shippingLabelLink;
    @JsonProperty("awb_created_as")
    @Column
    private String awbCreatedAs;
    @JsonProperty("shipping_tax")
    @Column
    private String shippingTax;
    @JsonProperty("fulfilled_shipping_method")
    @Column
    private String fulfilledShippingMethod;
    @JsonProperty("is_store_pickup")
    @Column
    private String isStorePickup;
    @JsonProperty("fulfillment_location_id")
    @Column
    private String fulfillmentLocationId;
    @JsonProperty("date_add")
    @Column
    private String dateAdd;
    @JsonProperty("date_upd")
    @Column
    private String dateUpd;
    @JsonProperty("refund_commission")
    @Column
    private String refundCommission;
    @JsonProperty("vat_type")
    @Column
    private String vatType;
    @JsonProperty("vat")
    @Column
    private String vat;
    @JsonProperty("tracking_url")
    @Column
    private String trackingUrl;
    @JsonProperty("total_actual_shipping")
    @Column
    private String totalActualShipping;

    @JsonProperty("order_sent_to_seller")
    @Column
    private boolean orderSentToProvider = false;

    @JsonProperty("seller")
    @Column
    private String seller;


    @JsonProperty("error_msg")
    @Column(length = 4000)
    private String errorMsg;

    /**
     * No args constructor for use in serialization
     *
     */
    public LineItem() {
    }

    /**
     *
     * @param variantTitle
     * @param orderId
     * @param isStorePickup
     * @param totalCommission
     * @param productName
     * @param idCommissionBasis
     * @param sellerId
     * @param totalQuantity
     * @param taxCommission
     * @param cancelReasonId
     * @param dateAdd
     * @param id
     * @param sku
     * @param dateUpd
     * @param taxType
     * @param fulfilledShippingMethod
     * @param productId
     * @param unitCommission
     * @param lineDiscount
     * @param vat
     * @param commissionValues
     * @param orderProductId
     * @param taxType2
     * @param taxRate
     * @param vatType
     * @param actualTax
     * @param idCommissionType
     * @param shopifyVariantId
     * @param productPrice
     * @param status
     * @param trackingUrl
     * @param shippingCommission
     * @param penaltyType
     * @param shippingType
     * @param totalActualShipping
     * @param penaltyValue
     * @param shippingLabelLink
     * @param shippingTax
     * @param fulfillmentLocationId
     * @param taxRate2
     * @param actualShipping
     * @param shopifyProductId
     * @param lineItemId
     * @param shopifyOrderId
     * @param noteAttribute
     * @param ndrAwbNumber
     * @param isReturned
     * @param awbCreatedAs
     * @param refundCommission
     * @param mainIdShop
     */
    public LineItem(String id, String mainIdShop, String sellerId, String orderId, String shopifyOrderId, String orderProductId, String productId, String shopifyProductId, String shopifyVariantId, String productName, String variantTitle, String productPrice, String sku, String noteAttribute, String lineDiscount, String totalQuantity, String lineItemId, String taxType, String taxRate, String taxType2, String taxRate2, String actualShipping, String actualTax, String unitCommission, String shippingCommission, String taxCommission, String totalCommission, String idCommissionBasis, String idCommissionType, String commissionValues, String status, String cancelReasonId, String ndrAwbNumber, String isReturned, String penaltyType, String penaltyValue, String shippingType, String shippingLabelLink, String awbCreatedAs, String shippingTax, String fulfilledShippingMethod, String isStorePickup, String fulfillmentLocationId, String dateAdd, String dateUpd, String refundCommission, String vatType, String vat, String trackingUrl, String totalActualShipping) {
        super();
        this.id = id;
        this.mainIdShop = mainIdShop;
        this.sellerId = sellerId;
        this.orderId = orderId;
        this.shopifyOrderId = shopifyOrderId;
        this.orderProductId = orderProductId;
        this.productId = productId;
        this.shopifyProductId = shopifyProductId;
        this.shopifyVariantId = shopifyVariantId;
        this.productName = productName;
        this.variantTitle = variantTitle;
        this.productPrice = productPrice;
        this.sku = sku;
        this.noteAttribute = noteAttribute;
        this.lineDiscount = lineDiscount;
        this.totalQuantity = totalQuantity;
        this.lineItemId = lineItemId;
        this.taxType = taxType;
        this.taxRate = taxRate;
        this.taxType2 = taxType2;
        this.taxRate2 = taxRate2;
        this.actualShipping = actualShipping;
        this.actualTax = actualTax;
        this.unitCommission = unitCommission;
        this.shippingCommission = shippingCommission;
        this.taxCommission = taxCommission;
        this.totalCommission = totalCommission;
        this.idCommissionBasis = idCommissionBasis;
        this.idCommissionType = idCommissionType;
        this.commissionValues = commissionValues;
        this.status = status;
        this.cancelReasonId = cancelReasonId;
        this.ndrAwbNumber = ndrAwbNumber;
        this.isReturned = isReturned;
        this.penaltyType = penaltyType;
        this.penaltyValue = penaltyValue;
        this.shippingType = shippingType;
        this.shippingLabelLink = shippingLabelLink;
        this.awbCreatedAs = awbCreatedAs;
        this.shippingTax = shippingTax;
        this.fulfilledShippingMethod = fulfilledShippingMethod;
        this.isStorePickup = isStorePickup;
        this.fulfillmentLocationId = fulfillmentLocationId;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.refundCommission = refundCommission;
        this.vatType = vatType;
        this.vat = vat;
        this.trackingUrl = trackingUrl;
        this.totalActualShipping = totalActualShipping;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("main_id_shop")
    public String getMainIdShop() {
        return mainIdShop;
    }

    @JsonProperty("main_id_shop")
    public void setMainIdShop(String mainIdShop) {
        this.mainIdShop = mainIdShop;
    }

    @JsonProperty("seller_id")
    public String getSellerId() {
        return sellerId;
    }

    @JsonProperty("seller_id")
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("shopify_order_id")
    public String getShopifyOrderId() {
        return shopifyOrderId;
    }

    @JsonProperty("shopify_order_id")
    public void setShopifyOrderId(String shopifyOrderId) {
        this.shopifyOrderId = shopifyOrderId;
    }

    @JsonProperty("order_product_id")
    public String getOrderProductId() {
        return orderProductId;
    }

    @JsonProperty("order_product_id")
    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId;
    }

    @JsonProperty("product_id")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("shopify_product_id")
    public String getShopifyProductId() {
        return shopifyProductId;
    }

    @JsonProperty("shopify_product_id")
    public void setShopifyProductId(String shopifyProductId) {
        this.shopifyProductId = shopifyProductId;
    }

    @JsonProperty("shopify_variant_id")
    public String getShopifyVariantId() {
        return shopifyVariantId;
    }

    @JsonProperty("shopify_variant_id")
    public void setShopifyVariantId(String shopifyVariantId) {
        this.shopifyVariantId = shopifyVariantId;
    }

    @JsonProperty("product_name")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("product_name")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("variant_title")
    public String getVariantTitle() {
        return variantTitle;
    }

    @JsonProperty("variant_title")
    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    @JsonProperty("product_price")
    public String getProductPrice() {
        return productPrice;
    }

    @JsonProperty("product_price")
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    @JsonProperty("note_attribute")
    public String getNoteAttribute() {
        return noteAttribute;
    }

    @JsonProperty("note_attribute")
    public void setNoteAttribute(String noteAttribute) {
        this.noteAttribute = noteAttribute;
    }

    @JsonProperty("line_discount")
    public String getLineDiscount() {
        return lineDiscount;
    }

    @JsonProperty("line_discount")
    public void setLineDiscount(String lineDiscount) {
        this.lineDiscount = lineDiscount;
    }

    @JsonProperty("total_quantity")
    public String getTotalQuantity() {
        return totalQuantity;
    }

    @JsonProperty("total_quantity")
    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @JsonProperty("line_item_id")
    public String getLineItemId() {
        return lineItemId;
    }

    @JsonProperty("line_item_id")
    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    @JsonProperty("tax_type")
    public String getTaxType() {
        return taxType;
    }

    @JsonProperty("tax_type")
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    @JsonProperty("tax_rate")
    public String getTaxRate() {
        return taxRate;
    }

    @JsonProperty("tax_rate")
    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    @JsonProperty("tax_type2")
    public String getTaxType2() {
        return taxType2;
    }

    @JsonProperty("tax_type2")
    public void setTaxType2(String taxType2) {
        this.taxType2 = taxType2;
    }

    @JsonProperty("tax_rate2")
    public String getTaxRate2() {
        return taxRate2;
    }

    @JsonProperty("tax_rate2")
    public void setTaxRate2(String taxRate2) {
        this.taxRate2 = taxRate2;
    }

    @JsonProperty("actual_shipping")
    public String getActualShipping() {
        return actualShipping;
    }

    @JsonProperty("actual_shipping")
    public void setActualShipping(String actualShipping) {
        this.actualShipping = actualShipping;
    }

    @JsonProperty("actual_tax")
    public String getActualTax() {
        return actualTax;
    }

    @JsonProperty("actual_tax")
    public void setActualTax(String actualTax) {
        this.actualTax = actualTax;
    }

    @JsonProperty("unit_commission")
    public String getUnitCommission() {
        return unitCommission;
    }

    @JsonProperty("unit_commission")
    public void setUnitCommission(String unitCommission) {
        this.unitCommission = unitCommission;
    }

    @JsonProperty("shipping_commission")
    public String getShippingCommission() {
        return shippingCommission;
    }

    @JsonProperty("shipping_commission")
    public void setShippingCommission(String shippingCommission) {
        this.shippingCommission = shippingCommission;
    }

    @JsonProperty("tax_commission")
    public String getTaxCommission() {
        return taxCommission;
    }

    @JsonProperty("tax_commission")
    public void setTaxCommission(String taxCommission) {
        this.taxCommission = taxCommission;
    }

    @JsonProperty("total_commission")
    public String getTotalCommission() {
        return totalCommission;
    }

    @JsonProperty("total_commission")
    public void setTotalCommission(String totalCommission) {
        this.totalCommission = totalCommission;
    }

    @JsonProperty("id_commission_basis")
    public String getIdCommissionBasis() {
        return idCommissionBasis;
    }

    @JsonProperty("id_commission_basis")
    public void setIdCommissionBasis(String idCommissionBasis) {
        this.idCommissionBasis = idCommissionBasis;
    }

    @JsonProperty("id_commission_type")
    public String getIdCommissionType() {
        return idCommissionType;
    }

    @JsonProperty("id_commission_type")
    public void setIdCommissionType(String idCommissionType) {
        this.idCommissionType = idCommissionType;
    }

    @JsonProperty("commission_values")
    public String getCommissionValues() {
        return commissionValues;
    }

    @JsonProperty("commission_values")
    public void setCommissionValues(String commissionValues) {
        this.commissionValues = commissionValues;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("cancel_reason_id")
    public String getCancelReasonId() {
        return cancelReasonId;
    }

    @JsonProperty("cancel_reason_id")
    public void setCancelReasonId(String cancelReasonId) {
        this.cancelReasonId = cancelReasonId;
    }

    @JsonProperty("ndr_awb_number")
    public String getNdrAwbNumber() {
        return ndrAwbNumber;
    }

    @JsonProperty("ndr_awb_number")
    public void setNdrAwbNumber(String ndrAwbNumber) {
        this.ndrAwbNumber = ndrAwbNumber;
    }

    @JsonProperty("is_returned")
    public String getIsReturned() {
        return isReturned;
    }

    @JsonProperty("is_returned")
    public void setIsReturned(String isReturned) {
        this.isReturned = isReturned;
    }

    @JsonProperty("penalty_type")
    public String getPenaltyType() {
        return penaltyType;
    }

    @JsonProperty("penalty_type")
    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    @JsonProperty("penalty_value")
    public String getPenaltyValue() {
        return penaltyValue;
    }

    @JsonProperty("penalty_value")
    public void setPenaltyValue(String penaltyValue) {
        this.penaltyValue = penaltyValue;
    }

    @JsonProperty("shipping_type")
    public String getShippingType() {
        return shippingType;
    }

    @JsonProperty("shipping_type")
    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    @JsonProperty("shipping_label_link")
    public String getShippingLabelLink() {
        return shippingLabelLink;
    }

    @JsonProperty("shipping_label_link")
    public void setShippingLabelLink(String shippingLabelLink) {
        this.shippingLabelLink = shippingLabelLink;
    }

    @JsonProperty("awb_created_as")
    public String getAwbCreatedAs() {
        return awbCreatedAs;
    }

    @JsonProperty("awb_created_as")
    public void setAwbCreatedAs(String awbCreatedAs) {
        this.awbCreatedAs = awbCreatedAs;
    }

    @JsonProperty("shipping_tax")
    public String getShippingTax() {
        return shippingTax;
    }

    @JsonProperty("shipping_tax")
    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    @JsonProperty("fulfilled_shipping_method")
    public String getFulfilledShippingMethod() {
        return fulfilledShippingMethod;
    }

    @JsonProperty("fulfilled_shipping_method")
    public void setFulfilledShippingMethod(String fulfilledShippingMethod) {
        this.fulfilledShippingMethod = fulfilledShippingMethod;
    }

    @JsonProperty("is_store_pickup")
    public String getIsStorePickup() {
        return isStorePickup;
    }

    @JsonProperty("is_store_pickup")
    public void setIsStorePickup(String isStorePickup) {
        this.isStorePickup = isStorePickup;
    }

    @JsonProperty("fulfillment_location_id")
    public String getFulfillmentLocationId() {
        return fulfillmentLocationId;
    }

    @JsonProperty("fulfillment_location_id")
    public void setFulfillmentLocationId(String fulfillmentLocationId) {
        this.fulfillmentLocationId = fulfillmentLocationId;
    }

    @JsonProperty("date_add")
    public String getDateAdd() {
        return dateAdd;
    }

    @JsonProperty("date_add")
    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    @JsonProperty("date_upd")
    public String getDateUpd() {
        return dateUpd;
    }

    @JsonProperty("date_upd")
    public void setDateUpd(String dateUpd) {
        this.dateUpd = dateUpd;
    }

    @JsonProperty("refund_commission")
    public String getRefundCommission() {
        return refundCommission;
    }

    @JsonProperty("refund_commission")
    public void setRefundCommission(String refundCommission) {
        this.refundCommission = refundCommission;
    }

    @JsonProperty("vat_type")
    public String getVatType() {
        return vatType;
    }

    @JsonProperty("vat_type")
    public void setVatType(String vatType) {
        this.vatType = vatType;
    }

    @JsonProperty("vat")
    public String getVat() {
        return vat;
    }

    @JsonProperty("vat")
    public void setVat(String vat) {
        this.vat = vat;
    }

    @JsonProperty("tracking_url")
    public String getTrackingUrl() {
        return trackingUrl;
    }

    @JsonProperty("tracking_url")
    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    @JsonProperty("total_actual_shipping")
    public String getTotalActualShipping() {
        return totalActualShipping;
    }

    @JsonProperty("total_actual_shipping")
    public void setTotalActualShipping(String totalActualShipping) {
        this.totalActualShipping = totalActualShipping;
    }

    public boolean isOrderSentToProvider() {
        return orderSentToProvider;
    }

    public void setOrderSentToProvider(boolean orderSentToProvider) {
        this.orderSentToProvider = orderSentToProvider;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id='" + id + '\'' +
                ", mainIdShop='" + mainIdShop + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", shopifyOrderId='" + shopifyOrderId + '\'' +
                ", orderProductId='" + orderProductId + '\'' +
                ", productId='" + productId + '\'' +
                ", shopifyProductId='" + shopifyProductId + '\'' +
                ", shopifyVariantId='" + shopifyVariantId + '\'' +
                ", productName='" + productName + '\'' +
                ", variantTitle='" + variantTitle + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", sku='" + sku + '\'' +
                ", noteAttribute='" + noteAttribute + '\'' +
                ", lineDiscount='" + lineDiscount + '\'' +
                ", totalQuantity='" + totalQuantity + '\'' +
                ", lineItemId='" + lineItemId + '\'' +
                ", taxType='" + taxType + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", taxType2='" + taxType2 + '\'' +
                ", taxRate2='" + taxRate2 + '\'' +
                ", actualShipping='" + actualShipping + '\'' +
                ", actualTax='" + actualTax + '\'' +
                ", unitCommission='" + unitCommission + '\'' +
                ", shippingCommission='" + shippingCommission + '\'' +
                ", taxCommission='" + taxCommission + '\'' +
                ", totalCommission='" + totalCommission + '\'' +
                ", idCommissionBasis='" + idCommissionBasis + '\'' +
                ", idCommissionType='" + idCommissionType + '\'' +
                ", commissionValues='" + commissionValues + '\'' +
                ", status='" + status + '\'' +
                ", cancelReasonId='" + cancelReasonId + '\'' +
                ", ndrAwbNumber='" + ndrAwbNumber + '\'' +
                ", isReturned='" + isReturned + '\'' +
                ", penaltyType='" + penaltyType + '\'' +
                ", penaltyValue='" + penaltyValue + '\'' +
                ", shippingType='" + shippingType + '\'' +
                ", shippingLabelLink='" + shippingLabelLink + '\'' +
                ", awbCreatedAs='" + awbCreatedAs + '\'' +
                ", shippingTax='" + shippingTax + '\'' +
                ", fulfilledShippingMethod='" + fulfilledShippingMethod + '\'' +
                ", isStorePickup='" + isStorePickup + '\'' +
                ", fulfillmentLocationId='" + fulfillmentLocationId + '\'' +
                ", dateAdd='" + dateAdd + '\'' +
                ", dateUpd='" + dateUpd + '\'' +
                ", refundCommission='" + refundCommission + '\'' +
                ", vatType='" + vatType + '\'' +
                ", vat='" + vat + '\'' +
                ", trackingUrl='" + trackingUrl + '\'' +
                ", totalActualShipping='" + totalActualShipping + '\'' +
                '}';
    }


}
