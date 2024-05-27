package org.shopify.integrator.multivendor.dto.order;

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
        "id",
        "main_id_order",
        "main_id_shop",
        "id_shop",
        "total_price",
        "payment_status",
        "customer",
        "gateway",
        "order_name",
        "fulfillment",
        "mp_shipping",
        "customer_email",
        "address1",
        "address2",
        "company",
        "city",
        "zip",
        "province",
        "country",
        "phone",
        "billing_address",
        "shipping_address",
        "date_add",
        "date_upd",
        "is_mail_sent",
        "capture_payment_mail",
        "order_placed_mail",
        "is_deleted",
        "order_note",
        "delivery_method",
        "is_nav_synced",
        "transaction_id",
        "order_prepare_status",
        "main_transaction_id",
        "ref_order_id",
        "token",
        "checkout_token",
        "is_paid",
        "tax_inclusive",
        "tax_shipping_comm_type",
        "is_cachable",
        "fulfillment_service_name",
        "discount_code",
        "discount_details",
        "discount_bear_by",
        "commission_calculated_on",
        "discount_difference",
        "order_status_url",
        "fulfillment_earning_cost",
        "is_refunded",
        "gateway_processed",
        "presentment_currency",
        "payment_flow",
        "restrict_view_order",
        "seller_global_fixed_commission",
        "refunded_seller_global_fixed_comm",
        "expected_delivery_date",
        "risk_recommendation",
        "risk_response",
        "tip_distribution",
        "tip_amount",
        "fixed_transaction_amount",
        "percent_transaction_amount",
        "transaction_fixed_charge_rule",
        "transaction_bear_by",
        "payment_gateway_fee",
        "fee_bear_by",
        "seller_earning_added",
        "total_shipping_charges",
        "line_items"
})
public class Order implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("main_id_order")
    private String mainIdOrder;
    @JsonProperty("main_id_shop")
    private String mainIdShop;
    @JsonProperty("id_shop")
    private String idShop;
    @JsonProperty("total_price")
    private String totalPrice;
    @JsonProperty("payment_status")
    private String paymentStatus;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("gateway")
    private String gateway;
    @JsonProperty("order_name")
    private String orderName;
    @JsonProperty("fulfillment")
    private String fulfillment;
    @JsonProperty("mp_shipping")
    private String mpShipping;
    @JsonProperty("customer_email")
    private String customerEmail;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("company")
    private String company;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("province")
    private String province;
    @JsonProperty("country")
    private String country;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("billing_address")
    private String billingAddress;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("date_add")
    private String dateAdd;
    @JsonProperty("date_upd")
    private String dateUpd;
    @JsonProperty("is_mail_sent")
    private String isMailSent;
    @JsonProperty("capture_payment_mail")
    private String capturePaymentMail;
    @JsonProperty("order_placed_mail")
    private String orderPlacedMail;
    @JsonProperty("is_deleted")
    private String isDeleted;
    @JsonProperty("order_note")
    private String orderNote;
    @JsonProperty("delivery_method")
    private String deliveryMethod;
    @JsonProperty("is_nav_synced")
    private String isNavSynced;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("order_prepare_status")
    private String orderPrepareStatus;
    @JsonProperty("main_transaction_id")
    private String mainTransactionId;
    @JsonProperty("ref_order_id")
    private String refOrderId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("checkout_token")
    private String checkoutToken;
    @JsonProperty("is_paid")
    private String isPaid;
    @JsonProperty("tax_inclusive")
    private String taxInclusive;
    @JsonProperty("tax_shipping_comm_type")
    private String taxShippingCommType;
    @JsonProperty("is_cachable")
    private String isCachable;
    @JsonProperty("fulfillment_service_name")
    private String fulfillmentServiceName;
    @JsonProperty("discount_code")
    private String discountCode;
    @JsonProperty("discount_details")
    private String discountDetails;
    @JsonProperty("discount_bear_by")
    private String discountBearBy;
    @JsonProperty("commission_calculated_on")
    private String commissionCalculatedOn;
    @JsonProperty("discount_difference")
    private String discountDifference;
    @JsonProperty("order_status_url")
    private String orderStatusUrl;
    @JsonProperty("fulfillment_earning_cost")
    private String fulfillmentEarningCost;
    @JsonProperty("is_refunded")
    private String isRefunded;
    @JsonProperty("gateway_processed")
    private String gatewayProcessed;
    @JsonProperty("presentment_currency")
    private String presentmentCurrency;
    @JsonProperty("payment_flow")
    private String paymentFlow;
    @JsonProperty("restrict_view_order")
    private String restrictViewOrder;
    @JsonProperty("seller_global_fixed_commission")
    private String sellerGlobalFixedCommission;
    @JsonProperty("refunded_seller_global_fixed_comm")
    private String refundedSellerGlobalFixedComm;
    @JsonProperty("expected_delivery_date")
    private String expectedDeliveryDate;
    @JsonProperty("risk_recommendation")
    private String riskRecommendation;
    @JsonProperty("risk_response")
    private String riskResponse;
    @JsonProperty("tip_distribution")
    private String tipDistribution;
    @JsonProperty("tip_amount")
    private String tipAmount;
    @JsonProperty("fixed_transaction_amount")
    private String fixedTransactionAmount;
    @JsonProperty("percent_transaction_amount")
    private String percentTransactionAmount;
    @JsonProperty("transaction_fixed_charge_rule")
    private String transactionFixedChargeRule;
    @JsonProperty("transaction_bear_by")
    private String transactionBearBy;
    @JsonProperty("payment_gateway_fee")
    private String paymentGatewayFee;
    @JsonProperty("fee_bear_by")
    private String feeBearBy;
    @JsonProperty("seller_earning_added")
    private String sellerEarningAdded;
    @JsonProperty("total_shipping_charges")
    private String totalShippingCharges;
    @JsonProperty("line_items")
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private final static long serialVersionUID = 3075697630355359225L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Order() {
    }

    /**
     *
     * @param country
     * @param fulfillmentEarningCost
     * @param orderStatusUrl
     * @param lineItems
     * @param commissionCalculatedOn
     * @param totalShippingCharges
     * @param province
     * @param presentmentCurrency
     * @param dateAdd
     * @param transactionBearBy
     * @param customerEmail
     * @param mainIdOrder
     * @param id
     * @param dateUpd
     * @param feeBearBy
     * @param fixedTransactionAmount
     * @param zip
     * @param riskResponse
     * @param transactionFixedChargeRule
     * @param isMailSent
     * @param taxShippingCommType
     * @param orderPlacedMail
     * @param transactionId
     * @param isPaid
     * @param restrictViewOrder
     * @param fulfillmentServiceName
     * @param phone
     * @param discountDetails
     * @param isCachable
     * @param mpShipping
     * @param discountDifference
     * @param riskRecommendation
     * @param sellerEarningAdded
     * @param totalPrice
     * @param city
     * @param deliveryMethod
     * @param orderNote
     * @param refOrderId
     * @param gatewayProcessed
     * @param capturePaymentMail
     * @param taxInclusive
     * @param isDeleted
     * @param company
     * @param mainTransactionId
     * @param paymentStatus
     * @param orderName
     * @param checkoutToken
     * @param refundedSellerGlobalFixedComm
     * @param discountBearBy
     * @param paymentGatewayFee
     * @param idShop
     * @param isRefunded
     * @param address2
     * @param tipAmount
     * @param address1
     * @param isNavSynced
     * @param expectedDeliveryDate
     * @param sellerGlobalFixedCommission
     * @param token
     * @param orderPrepareStatus
     * @param discountCode
     * @param tipDistribution
     * @param percentTransactionAmount
     * @param shippingAddress
     * @param fulfillment
     * @param billingAddress
     * @param mainIdShop
     * @param paymentFlow
     * @param gateway
     * @param customer
     */
    public Order(String id, String mainIdOrder, String mainIdShop, String idShop, String totalPrice, String paymentStatus, String customer, String gateway, String orderName, String fulfillment, String mpShipping, String customerEmail, String address1, String address2, String company, String city, String zip, String province, String country, String phone, String billingAddress, String shippingAddress, String dateAdd, String dateUpd, String isMailSent, String capturePaymentMail, String orderPlacedMail, String isDeleted, String orderNote, String deliveryMethod, String isNavSynced, String transactionId, String orderPrepareStatus, String mainTransactionId, String refOrderId, String token, String checkoutToken, String isPaid, String taxInclusive, String taxShippingCommType, String isCachable, String fulfillmentServiceName, String discountCode, String discountDetails, String discountBearBy, String commissionCalculatedOn, String discountDifference, String orderStatusUrl, String fulfillmentEarningCost, String isRefunded, String gatewayProcessed, String presentmentCurrency, String paymentFlow, String restrictViewOrder, String sellerGlobalFixedCommission, String refundedSellerGlobalFixedComm, String expectedDeliveryDate, String riskRecommendation, String riskResponse, String tipDistribution, String tipAmount, String fixedTransactionAmount, String percentTransactionAmount, String transactionFixedChargeRule, String transactionBearBy, String paymentGatewayFee, String feeBearBy, String sellerEarningAdded, String totalShippingCharges, List<LineItem> lineItems) {
        super();
        this.id = id;
        this.mainIdOrder = mainIdOrder;
        this.mainIdShop = mainIdShop;
        this.idShop = idShop;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.customer = customer;
        this.gateway = gateway;
        this.orderName = orderName;
        this.fulfillment = fulfillment;
        this.mpShipping = mpShipping;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.company = company;
        this.city = city;
        this.zip = zip;
        this.province = province;
        this.country = country;
        this.phone = phone;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.isMailSent = isMailSent;
        this.capturePaymentMail = capturePaymentMail;
        this.orderPlacedMail = orderPlacedMail;
        this.isDeleted = isDeleted;
        this.orderNote = orderNote;
        this.deliveryMethod = deliveryMethod;
        this.isNavSynced = isNavSynced;
        this.transactionId = transactionId;
        this.orderPrepareStatus = orderPrepareStatus;
        this.mainTransactionId = mainTransactionId;
        this.refOrderId = refOrderId;
        this.token = token;
        this.checkoutToken = checkoutToken;
        this.isPaid = isPaid;
        this.taxInclusive = taxInclusive;
        this.taxShippingCommType = taxShippingCommType;
        this.isCachable = isCachable;
        this.fulfillmentServiceName = fulfillmentServiceName;
        this.discountCode = discountCode;
        this.discountDetails = discountDetails;
        this.discountBearBy = discountBearBy;
        this.commissionCalculatedOn = commissionCalculatedOn;
        this.discountDifference = discountDifference;
        this.orderStatusUrl = orderStatusUrl;
        this.fulfillmentEarningCost = fulfillmentEarningCost;
        this.isRefunded = isRefunded;
        this.gatewayProcessed = gatewayProcessed;
        this.presentmentCurrency = presentmentCurrency;
        this.paymentFlow = paymentFlow;
        this.restrictViewOrder = restrictViewOrder;
        this.sellerGlobalFixedCommission = sellerGlobalFixedCommission;
        this.refundedSellerGlobalFixedComm = refundedSellerGlobalFixedComm;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.riskRecommendation = riskRecommendation;
        this.riskResponse = riskResponse;
        this.tipDistribution = tipDistribution;
        this.tipAmount = tipAmount;
        this.fixedTransactionAmount = fixedTransactionAmount;
        this.percentTransactionAmount = percentTransactionAmount;
        this.transactionFixedChargeRule = transactionFixedChargeRule;
        this.transactionBearBy = transactionBearBy;
        this.paymentGatewayFee = paymentGatewayFee;
        this.feeBearBy = feeBearBy;
        this.sellerEarningAdded = sellerEarningAdded;
        this.totalShippingCharges = totalShippingCharges;
        this.lineItems = lineItems;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("main_id_order")
    public String getMainIdOrder() {
        return mainIdOrder;
    }

    @JsonProperty("main_id_order")
    public void setMainIdOrder(String mainIdOrder) {
        this.mainIdOrder = mainIdOrder;
    }

    @JsonProperty("main_id_shop")
    public String getMainIdShop() {
        return mainIdShop;
    }

    @JsonProperty("main_id_shop")
    public void setMainIdShop(String mainIdShop) {
        this.mainIdShop = mainIdShop;
    }

    @JsonProperty("id_shop")
    public String getIdShop() {
        return idShop;
    }

    @JsonProperty("id_shop")
    public void setIdShop(String idShop) {
        this.idShop = idShop;
    }

    @JsonProperty("total_price")
    public String getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("total_price")
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("payment_status")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    @JsonProperty("payment_status")
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @JsonProperty("customer")
    public String getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("order_name")
    public String getOrderName() {
        return orderName;
    }

    @JsonProperty("order_name")
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @JsonProperty("fulfillment")
    public String getFulfillment() {
        return fulfillment;
    }

    @JsonProperty("fulfillment")
    public void setFulfillment(String fulfillment) {
        this.fulfillment = fulfillment;
    }

    @JsonProperty("mp_shipping")
    public String getMpShipping() {
        return mpShipping;
    }

    @JsonProperty("mp_shipping")
    public void setMpShipping(String mpShipping) {
        this.mpShipping = mpShipping;
    }

    @JsonProperty("customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    @JsonProperty("customer_email")
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("billing_address")
    public String getBillingAddress() {
        return billingAddress;
    }

    @JsonProperty("billing_address")
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @JsonProperty("shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shipping_address")
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
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

    @JsonProperty("is_mail_sent")
    public String getIsMailSent() {
        return isMailSent;
    }

    @JsonProperty("is_mail_sent")
    public void setIsMailSent(String isMailSent) {
        this.isMailSent = isMailSent;
    }

    @JsonProperty("capture_payment_mail")
    public String getCapturePaymentMail() {
        return capturePaymentMail;
    }

    @JsonProperty("capture_payment_mail")
    public void setCapturePaymentMail(String capturePaymentMail) {
        this.capturePaymentMail = capturePaymentMail;
    }

    @JsonProperty("order_placed_mail")
    public String getOrderPlacedMail() {
        return orderPlacedMail;
    }

    @JsonProperty("order_placed_mail")
    public void setOrderPlacedMail(String orderPlacedMail) {
        this.orderPlacedMail = orderPlacedMail;
    }

    @JsonProperty("is_deleted")
    public String getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("is_deleted")
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("order_note")
    public String getOrderNote() {
        return orderNote;
    }

    @JsonProperty("order_note")
    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    @JsonProperty("delivery_method")
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    @JsonProperty("delivery_method")
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @JsonProperty("is_nav_synced")
    public String getIsNavSynced() {
        return isNavSynced;
    }

    @JsonProperty("is_nav_synced")
    public void setIsNavSynced(String isNavSynced) {
        this.isNavSynced = isNavSynced;
    }

    @JsonProperty("transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("order_prepare_status")
    public String getOrderPrepareStatus() {
        return orderPrepareStatus;
    }

    @JsonProperty("order_prepare_status")
    public void setOrderPrepareStatus(String orderPrepareStatus) {
        this.orderPrepareStatus = orderPrepareStatus;
    }

    @JsonProperty("main_transaction_id")
    public String getMainTransactionId() {
        return mainTransactionId;
    }

    @JsonProperty("main_transaction_id")
    public void setMainTransactionId(String mainTransactionId) {
        this.mainTransactionId = mainTransactionId;
    }

    @JsonProperty("ref_order_id")
    public String getRefOrderId() {
        return refOrderId;
    }

    @JsonProperty("ref_order_id")
    public void setRefOrderId(String refOrderId) {
        this.refOrderId = refOrderId;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("checkout_token")
    public String getCheckoutToken() {
        return checkoutToken;
    }

    @JsonProperty("checkout_token")
    public void setCheckoutToken(String checkoutToken) {
        this.checkoutToken = checkoutToken;
    }

    @JsonProperty("is_paid")
    public String getIsPaid() {
        return isPaid;
    }

    @JsonProperty("is_paid")
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    @JsonProperty("tax_inclusive")
    public String getTaxInclusive() {
        return taxInclusive;
    }

    @JsonProperty("tax_inclusive")
    public void setTaxInclusive(String taxInclusive) {
        this.taxInclusive = taxInclusive;
    }

    @JsonProperty("tax_shipping_comm_type")
    public String getTaxShippingCommType() {
        return taxShippingCommType;
    }

    @JsonProperty("tax_shipping_comm_type")
    public void setTaxShippingCommType(String taxShippingCommType) {
        this.taxShippingCommType = taxShippingCommType;
    }

    @JsonProperty("is_cachable")
    public String getIsCachable() {
        return isCachable;
    }

    @JsonProperty("is_cachable")
    public void setIsCachable(String isCachable) {
        this.isCachable = isCachable;
    }

    @JsonProperty("fulfillment_service_name")
    public String getFulfillmentServiceName() {
        return fulfillmentServiceName;
    }

    @JsonProperty("fulfillment_service_name")
    public void setFulfillmentServiceName(String fulfillmentServiceName) {
        this.fulfillmentServiceName = fulfillmentServiceName;
    }

    @JsonProperty("discount_code")
    public String getDiscountCode() {
        return discountCode;
    }

    @JsonProperty("discount_code")
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @JsonProperty("discount_details")
    public String getDiscountDetails() {
        return discountDetails;
    }

    @JsonProperty("discount_details")
    public void setDiscountDetails(String discountDetails) {
        this.discountDetails = discountDetails;
    }

    @JsonProperty("discount_bear_by")
    public String getDiscountBearBy() {
        return discountBearBy;
    }

    @JsonProperty("discount_bear_by")
    public void setDiscountBearBy(String discountBearBy) {
        this.discountBearBy = discountBearBy;
    }

    @JsonProperty("commission_calculated_on")
    public String getCommissionCalculatedOn() {
        return commissionCalculatedOn;
    }

    @JsonProperty("commission_calculated_on")
    public void setCommissionCalculatedOn(String commissionCalculatedOn) {
        this.commissionCalculatedOn = commissionCalculatedOn;
    }

    @JsonProperty("discount_difference")
    public String getDiscountDifference() {
        return discountDifference;
    }

    @JsonProperty("discount_difference")
    public void setDiscountDifference(String discountDifference) {
        this.discountDifference = discountDifference;
    }

    @JsonProperty("order_status_url")
    public String getOrderStatusUrl() {
        return orderStatusUrl;
    }

    @JsonProperty("order_status_url")
    public void setOrderStatusUrl(String orderStatusUrl) {
        this.orderStatusUrl = orderStatusUrl;
    }

    @JsonProperty("fulfillment_earning_cost")
    public String getFulfillmentEarningCost() {
        return fulfillmentEarningCost;
    }

    @JsonProperty("fulfillment_earning_cost")
    public void setFulfillmentEarningCost(String fulfillmentEarningCost) {
        this.fulfillmentEarningCost = fulfillmentEarningCost;
    }

    @JsonProperty("is_refunded")
    public String getIsRefunded() {
        return isRefunded;
    }

    @JsonProperty("is_refunded")
    public void setIsRefunded(String isRefunded) {
        this.isRefunded = isRefunded;
    }

    @JsonProperty("gateway_processed")
    public String getGatewayProcessed() {
        return gatewayProcessed;
    }

    @JsonProperty("gateway_processed")
    public void setGatewayProcessed(String gatewayProcessed) {
        this.gatewayProcessed = gatewayProcessed;
    }

    @JsonProperty("presentment_currency")
    public String getPresentmentCurrency() {
        return presentmentCurrency;
    }

    @JsonProperty("presentment_currency")
    public void setPresentmentCurrency(String presentmentCurrency) {
        this.presentmentCurrency = presentmentCurrency;
    }

    @JsonProperty("payment_flow")
    public String getPaymentFlow() {
        return paymentFlow;
    }

    @JsonProperty("payment_flow")
    public void setPaymentFlow(String paymentFlow) {
        this.paymentFlow = paymentFlow;
    }

    @JsonProperty("restrict_view_order")
    public String getRestrictViewOrder() {
        return restrictViewOrder;
    }

    @JsonProperty("restrict_view_order")
    public void setRestrictViewOrder(String restrictViewOrder) {
        this.restrictViewOrder = restrictViewOrder;
    }

    @JsonProperty("seller_global_fixed_commission")
    public String getSellerGlobalFixedCommission() {
        return sellerGlobalFixedCommission;
    }

    @JsonProperty("seller_global_fixed_commission")
    public void setSellerGlobalFixedCommission(String sellerGlobalFixedCommission) {
        this.sellerGlobalFixedCommission = sellerGlobalFixedCommission;
    }

    @JsonProperty("refunded_seller_global_fixed_comm")
    public String getRefundedSellerGlobalFixedComm() {
        return refundedSellerGlobalFixedComm;
    }

    @JsonProperty("refunded_seller_global_fixed_comm")
    public void setRefundedSellerGlobalFixedComm(String refundedSellerGlobalFixedComm) {
        this.refundedSellerGlobalFixedComm = refundedSellerGlobalFixedComm;
    }

    @JsonProperty("expected_delivery_date")
    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    @JsonProperty("expected_delivery_date")
    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    @JsonProperty("risk_recommendation")
    public String getRiskRecommendation() {
        return riskRecommendation;
    }

    @JsonProperty("risk_recommendation")
    public void setRiskRecommendation(String riskRecommendation) {
        this.riskRecommendation = riskRecommendation;
    }

    @JsonProperty("risk_response")
    public String getRiskResponse() {
        return riskResponse;
    }

    @JsonProperty("risk_response")
    public void setRiskResponse(String riskResponse) {
        this.riskResponse = riskResponse;
    }

    @JsonProperty("tip_distribution")
    public String getTipDistribution() {
        return tipDistribution;
    }

    @JsonProperty("tip_distribution")
    public void setTipDistribution(String tipDistribution) {
        this.tipDistribution = tipDistribution;
    }

    @JsonProperty("tip_amount")
    public String getTipAmount() {
        return tipAmount;
    }

    @JsonProperty("tip_amount")
    public void setTipAmount(String tipAmount) {
        this.tipAmount = tipAmount;
    }

    @JsonProperty("fixed_transaction_amount")
    public String getFixedTransactionAmount() {
        return fixedTransactionAmount;
    }

    @JsonProperty("fixed_transaction_amount")
    public void setFixedTransactionAmount(String fixedTransactionAmount) {
        this.fixedTransactionAmount = fixedTransactionAmount;
    }

    @JsonProperty("percent_transaction_amount")
    public String getPercentTransactionAmount() {
        return percentTransactionAmount;
    }

    @JsonProperty("percent_transaction_amount")
    public void setPercentTransactionAmount(String percentTransactionAmount) {
        this.percentTransactionAmount = percentTransactionAmount;
    }

    @JsonProperty("transaction_fixed_charge_rule")
    public String getTransactionFixedChargeRule() {
        return transactionFixedChargeRule;
    }

    @JsonProperty("transaction_fixed_charge_rule")
    public void setTransactionFixedChargeRule(String transactionFixedChargeRule) {
        this.transactionFixedChargeRule = transactionFixedChargeRule;
    }

    @JsonProperty("transaction_bear_by")
    public String getTransactionBearBy() {
        return transactionBearBy;
    }

    @JsonProperty("transaction_bear_by")
    public void setTransactionBearBy(String transactionBearBy) {
        this.transactionBearBy = transactionBearBy;
    }

    @JsonProperty("payment_gateway_fee")
    public String getPaymentGatewayFee() {
        return paymentGatewayFee;
    }

    @JsonProperty("payment_gateway_fee")
    public void setPaymentGatewayFee(String paymentGatewayFee) {
        this.paymentGatewayFee = paymentGatewayFee;
    }

    @JsonProperty("fee_bear_by")
    public String getFeeBearBy() {
        return feeBearBy;
    }

    @JsonProperty("fee_bear_by")
    public void setFeeBearBy(String feeBearBy) {
        this.feeBearBy = feeBearBy;
    }

    @JsonProperty("seller_earning_added")
    public String getSellerEarningAdded() {
        return sellerEarningAdded;
    }

    @JsonProperty("seller_earning_added")
    public void setSellerEarningAdded(String sellerEarningAdded) {
        this.sellerEarningAdded = sellerEarningAdded;
    }

    @JsonProperty("total_shipping_charges")
    public String getTotalShippingCharges() {
        return totalShippingCharges;
    }

    @JsonProperty("total_shipping_charges")
    public void setTotalShippingCharges(String totalShippingCharges) {
        this.totalShippingCharges = totalShippingCharges;
    }

    @JsonProperty("line_items")
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    @JsonProperty("line_items")
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", mainIdOrder='" + mainIdOrder + '\'' +
                ", mainIdShop='" + mainIdShop + '\'' +
                ", idShop='" + idShop + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", customer='" + customer + '\'' +
                ", gateway='" + gateway + '\'' +
                ", orderName='" + orderName + '\'' +
                ", fulfillment='" + fulfillment + '\'' +
                ", mpShipping='" + mpShipping + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", dateAdd='" + dateAdd + '\'' +
                ", dateUpd='" + dateUpd + '\'' +
                ", isMailSent='" + isMailSent + '\'' +
                ", capturePaymentMail='" + capturePaymentMail + '\'' +
                ", orderPlacedMail='" + orderPlacedMail + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                ", orderNote='" + orderNote + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", isNavSynced='" + isNavSynced + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", orderPrepareStatus='" + orderPrepareStatus + '\'' +
                ", mainTransactionId='" + mainTransactionId + '\'' +
                ", refOrderId='" + refOrderId + '\'' +
                ", token='" + token + '\'' +
                ", checkoutToken='" + checkoutToken + '\'' +
                ", isPaid='" + isPaid + '\'' +
                ", taxInclusive='" + taxInclusive + '\'' +
                ", taxShippingCommType='" + taxShippingCommType + '\'' +
                ", isCachable='" + isCachable + '\'' +
                ", fulfillmentServiceName='" + fulfillmentServiceName + '\'' +
                ", discountCode='" + discountCode + '\'' +
                ", discountDetails='" + discountDetails + '\'' +
                ", discountBearBy='" + discountBearBy + '\'' +
                ", commissionCalculatedOn='" + commissionCalculatedOn + '\'' +
                ", discountDifference='" + discountDifference + '\'' +
                ", orderStatusUrl='" + orderStatusUrl + '\'' +
                ", fulfillmentEarningCost='" + fulfillmentEarningCost + '\'' +
                ", isRefunded='" + isRefunded + '\'' +
                ", gatewayProcessed='" + gatewayProcessed + '\'' +
                ", presentmentCurrency='" + presentmentCurrency + '\'' +
                ", paymentFlow='" + paymentFlow + '\'' +
                ", restrictViewOrder='" + restrictViewOrder + '\'' +
                ", sellerGlobalFixedCommission='" + sellerGlobalFixedCommission + '\'' +
                ", refundedSellerGlobalFixedComm='" + refundedSellerGlobalFixedComm + '\'' +
                ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
                ", riskRecommendation='" + riskRecommendation + '\'' +
                ", riskResponse='" + riskResponse + '\'' +
                ", tipDistribution='" + tipDistribution + '\'' +
                ", tipAmount='" + tipAmount + '\'' +
                ", fixedTransactionAmount='" + fixedTransactionAmount + '\'' +
                ", percentTransactionAmount='" + percentTransactionAmount + '\'' +
                ", transactionFixedChargeRule='" + transactionFixedChargeRule + '\'' +
                ", transactionBearBy='" + transactionBearBy + '\'' +
                ", paymentGatewayFee='" + paymentGatewayFee + '\'' +
                ", feeBearBy='" + feeBearBy + '\'' +
                ", sellerEarningAdded='" + sellerEarningAdded + '\'' +
                ", totalShippingCharges='" + totalShippingCharges + '\'' +
                ", lineItems=" + lineItems +
                '}';
    }
}
