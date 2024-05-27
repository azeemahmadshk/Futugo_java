package org.shopify.integrator.bini.service.config.dto.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Name",
        "Surname",
        "Address",
        "ZipCode",
        "City",
        "PhoneNumber",
        "Email",
        "VatNumber",
        "FiscalCode",
        "ISOcountry",
        "Courier",
        "Notes",
        "TypeShipping",
        "Identification1",
        "Identification2",
        "DestinationName",
        "DestinationSurname",
        "DestinationAddress",
        "DestinationZipCode",
        "DestinationCity",
        "DestinationISOcountry",
        "ShippingCosts",
        "CustomsCosts",
        "OtherCosts"
})
public class BuyerInfo implements Serializable
{

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Surname")
    private String surname;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("ZipCode")
    private String zipCode;
    @JsonProperty("City")
    private String city;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("VatNumber")
    private String vatNumber;
    @JsonProperty("FiscalCode")
    private String fiscalCode;
    @JsonProperty("ISOcountry")
    private String iSOcountry;
    @JsonProperty("Courier")
    private String courier;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("TypeShipping")
    private String typeShipping;
    @JsonProperty("Identification1")
    private String identification1;
    @JsonProperty("Identification2")
    private String identification2;
    @JsonProperty("DestinationName")
    private String destinationName;
    @JsonProperty("DestinationSurname")
    private String destinationSurname;
    @JsonProperty("DestinationAddress")
    private String destinationAddress;
    @JsonProperty("DestinationZipCode")
    private String destinationZipCode;
    @JsonProperty("DestinationCity")
    private String destinationCity;
    @JsonProperty("DestinationISOcountry")
    private String destinationISOcountry;
    @JsonProperty("ShippingCosts")
    private String shippingCosts;
    @JsonProperty("CustomsCosts")
    private String customsCosts;
    @JsonProperty("OtherCosts")
    private String otherCosts;
    private final static long serialVersionUID = -7956378588224975914L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BuyerInfo() {
    }

    /**
     *
     * @param customsCosts
     * @param otherCosts
     * @param zipCode
     * @param address
     * @param notes
     * @param destinationAddress
     * @param city
     * @param typeShipping
     * @param destinationISOcountry
     * @param identification1
     * @param shippingCosts
     * @param identification2
     * @param destinationCity
     * @param iSOcountry
     * @param phoneNumber
     * @param courier
     * @param surname
     * @param destinationSurname
     * @param fiscalCode
     * @param destinationName
     * @param name
     * @param destinationZipCode
     * @param email
     * @param vatNumber
     */
    public BuyerInfo(String name, String surname, String address, String zipCode, String city, String phoneNumber, String email, String vatNumber, String fiscalCode, String iSOcountry, String courier, String notes, String typeShipping, String identification1, String identification2, String destinationName, String destinationSurname, String destinationAddress, String destinationZipCode, String destinationCity, String destinationISOcountry, String shippingCosts, String customsCosts, String otherCosts) {
        super();
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatNumber = vatNumber;
        this.fiscalCode = fiscalCode;
        this.iSOcountry = iSOcountry;
        this.courier = courier;
        this.notes = notes;
        this.typeShipping = typeShipping;
        this.identification1 = identification1;
        this.identification2 = identification2;
        this.destinationName = destinationName;
        this.destinationSurname = destinationSurname;
        this.destinationAddress = destinationAddress;
        this.destinationZipCode = destinationZipCode;
        this.destinationCity = destinationCity;
        this.destinationISOcountry = destinationISOcountry;
        this.shippingCosts = shippingCosts;
        this.customsCosts = customsCosts;
        this.otherCosts = otherCosts;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("Surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("ZipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("PhoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("VatNumber")
    public String getVatNumber() {
        return vatNumber;
    }

    @JsonProperty("VatNumber")
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @JsonProperty("FiscalCode")
    public String getFiscalCode() {
        return fiscalCode;
    }

    @JsonProperty("FiscalCode")
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    @JsonProperty("ISOcountry")
    public String getISOcountry() {
        return iSOcountry;
    }

    @JsonProperty("ISOcountry")
    public void setISOcountry(String iSOcountry) {
        this.iSOcountry = iSOcountry;
    }

    @JsonProperty("Courier")
    public String getCourier() {
        return courier;
    }

    @JsonProperty("Courier")
    public void setCourier(String courier) {
        this.courier = courier;
    }

    @JsonProperty("Notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("Notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("TypeShipping")
    public String getTypeShipping() {
        return typeShipping;
    }

    @JsonProperty("TypeShipping")
    public void setTypeShipping(String typeShipping) {
        this.typeShipping = typeShipping;
    }

    @JsonProperty("Identification1")
    public String getIdentification1() {
        return identification1;
    }

    @JsonProperty("Identification1")
    public void setIdentification1(String identification1) {
        this.identification1 = identification1;
    }

    @JsonProperty("Identification2")
    public String getIdentification2() {
        return identification2;
    }

    @JsonProperty("Identification2")
    public void setIdentification2(String identification2) {
        this.identification2 = identification2;
    }

    @JsonProperty("DestinationName")
    public String getDestinationName() {
        return destinationName;
    }

    @JsonProperty("DestinationName")
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @JsonProperty("DestinationSurname")
    public String getDestinationSurname() {
        return destinationSurname;
    }

    @JsonProperty("DestinationSurname")
    public void setDestinationSurname(String destinationSurname) {
        this.destinationSurname = destinationSurname;
    }

    @JsonProperty("DestinationAddress")
    public String getDestinationAddress() {
        return destinationAddress;
    }

    @JsonProperty("DestinationAddress")
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @JsonProperty("DestinationZipCode")
    public String getDestinationZipCode() {
        return destinationZipCode;
    }

    @JsonProperty("DestinationZipCode")
    public void setDestinationZipCode(String destinationZipCode) {
        this.destinationZipCode = destinationZipCode;
    }

    @JsonProperty("DestinationCity")
    public String getDestinationCity() {
        return destinationCity;
    }

    @JsonProperty("DestinationCity")
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @JsonProperty("DestinationISOcountry")
    public String getDestinationISOcountry() {
        return destinationISOcountry;
    }

    @JsonProperty("DestinationISOcountry")
    public void setDestinationISOcountry(String destinationISOcountry) {
        this.destinationISOcountry = destinationISOcountry;
    }

    @JsonProperty("ShippingCosts")
    public String getShippingCosts() {
        return shippingCosts;
    }

    @JsonProperty("ShippingCosts")
    public void setShippingCosts(String shippingCosts) {
        this.shippingCosts = shippingCosts;
    }

    @JsonProperty("CustomsCosts")
    public String getCustomsCosts() {
        return customsCosts;
    }

    @JsonProperty("CustomsCosts")
    public void setCustomsCosts(String customsCosts) {
        this.customsCosts = customsCosts;
    }

    @JsonProperty("OtherCosts")
    public String getOtherCosts() {
        return otherCosts;
    }

    @JsonProperty("OtherCosts")
    public void setOtherCosts(String otherCosts) {
        this.otherCosts = otherCosts;
    }

}
