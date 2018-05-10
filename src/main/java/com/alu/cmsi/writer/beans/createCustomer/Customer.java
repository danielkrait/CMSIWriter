//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.10 at 11:25:29 PM EEST 
//


package com.alu.cmsi.writer.beans.createCustomer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="is_business_partner" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="is_payment_resp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="occ_rate_plan_code" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="price_group_code" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billing_account" type="{}billingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="family_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="external_customer_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="external_customer_set_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="cost_center" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="billing_cycle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custcat_code" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="trade_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credit_limit" type="{}moneyType" minOccurs="0"/>
 *         &lt;element name="cs_credit_remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cs_remark1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cs_remark2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealer_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="area_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="address" type="{}customerAddress" minOccurs="0"/>
 *         &lt;element name="payment_arrangement">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="payment_method_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="account_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="account_owner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bank_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bank_zip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bank_city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="swift" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="taxExemption" type="{}taxExemptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contract" type="{}contractType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="additional_info" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isBusinessPartner",
    "isPaymentResp",
    "occRatePlanCode",
    "priceGroupCode",
    "password",
    "billingAccount",
    "familyId",
    "externalCustomerId",
    "externalCustomerSetId",
    "costCenter",
    "billingCycle",
    "custcatCode",
    "tradeCode",
    "creditLimit",
    "csCreditRemark",
    "csRemark1",
    "csRemark2",
    "dealerId",
    "areaId",
    "currency",
    "address",
    "paymentArrangement",
    "taxExemption",
    "contract",
    "additionalInfo"
})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlElement(name = "is_business_partner")
    protected Boolean isBusinessPartner;
    @XmlElement(name = "is_payment_resp")
    protected Boolean isPaymentResp;
    @XmlElement(name = "occ_rate_plan_code")
    protected BigInteger occRatePlanCode;
    @XmlElement(name = "price_group_code")
    protected BigInteger priceGroupCode;
    protected String password;
    @XmlElement(name = "billing_account", required = true)
    protected List<BillingAccountType> billingAccount;
    @XmlElement(name = "family_id")
    protected BigInteger familyId;
    @XmlElement(name = "external_customer_id")
    protected BigInteger externalCustomerId;
    @XmlElement(name = "external_customer_set_id")
    protected BigInteger externalCustomerSetId;
    @XmlElement(name = "cost_center")
    protected BigInteger costCenter;
    @XmlElement(name = "billing_cycle")
    protected String billingCycle;
    @XmlElement(name = "custcat_code")
    protected BigInteger custcatCode;
    @XmlElement(name = "trade_code")
    protected String tradeCode;
    @XmlElement(name = "credit_limit")
    protected MoneyType creditLimit;
    @XmlElement(name = "cs_credit_remark")
    protected String csCreditRemark;
    @XmlElement(name = "cs_remark1")
    protected String csRemark1;
    @XmlElement(name = "cs_remark2")
    protected String csRemark2;
    @XmlElement(name = "dealer_id")
    protected Long dealerId;
    @XmlElement(name = "area_id")
    protected Long areaId;
    protected Long currency;
    protected CustomerAddress address;
    @XmlElement(name = "payment_arrangement", required = true)
    protected Customer.PaymentArrangement paymentArrangement;
    @XmlElement(required = true)
    protected List<TaxExemptionType> taxExemption;
    @XmlElement(required = true)
    protected List<ContractType> contract;
    @XmlElement(name = "additional_info", required = true)
    protected List<Customer.AdditionalInfo> additionalInfo;

    /**
     * Gets the value of the isBusinessPartner property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsBusinessPartner() {
        return isBusinessPartner;
    }

    /**
     * Sets the value of the isBusinessPartner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsBusinessPartner(Boolean value) {
        this.isBusinessPartner = value;
    }

    /**
     * Gets the value of the isPaymentResp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPaymentResp() {
        return isPaymentResp;
    }

    /**
     * Sets the value of the isPaymentResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPaymentResp(Boolean value) {
        this.isPaymentResp = value;
    }

    /**
     * Gets the value of the occRatePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOccRatePlanCode() {
        return occRatePlanCode;
    }

    /**
     * Sets the value of the occRatePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOccRatePlanCode(BigInteger value) {
        this.occRatePlanCode = value;
    }

    /**
     * Gets the value of the priceGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPriceGroupCode() {
        return priceGroupCode;
    }

    /**
     * Sets the value of the priceGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPriceGroupCode(BigInteger value) {
        this.priceGroupCode = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the billingAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingAccountType }
     * 
     * 
     */
    public List<BillingAccountType> getBillingAccount() {
        if (billingAccount == null) {
            billingAccount = new ArrayList<BillingAccountType>();
        }
        return this.billingAccount;
    }

    /**
     * Gets the value of the familyId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFamilyId() {
        return familyId;
    }

    /**
     * Sets the value of the familyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFamilyId(BigInteger value) {
        this.familyId = value;
    }

    /**
     * Gets the value of the externalCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExternalCustomerId() {
        return externalCustomerId;
    }

    /**
     * Sets the value of the externalCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExternalCustomerId(BigInteger value) {
        this.externalCustomerId = value;
    }

    /**
     * Gets the value of the externalCustomerSetId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExternalCustomerSetId() {
        return externalCustomerSetId;
    }

    /**
     * Sets the value of the externalCustomerSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExternalCustomerSetId(BigInteger value) {
        this.externalCustomerSetId = value;
    }

    /**
     * Gets the value of the costCenter property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCostCenter() {
        return costCenter;
    }

    /**
     * Sets the value of the costCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCostCenter(BigInteger value) {
        this.costCenter = value;
    }

    /**
     * Gets the value of the billingCycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingCycle() {
        return billingCycle;
    }

    /**
     * Sets the value of the billingCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingCycle(String value) {
        this.billingCycle = value;
    }

    /**
     * Gets the value of the custcatCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCustcatCode() {
        return custcatCode;
    }

    /**
     * Sets the value of the custcatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCustcatCode(BigInteger value) {
        this.custcatCode = value;
    }

    /**
     * Gets the value of the tradeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeCode() {
        return tradeCode;
    }

    /**
     * Sets the value of the tradeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeCode(String value) {
        this.tradeCode = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setCreditLimit(MoneyType value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the csCreditRemark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCreditRemark() {
        return csCreditRemark;
    }

    /**
     * Sets the value of the csCreditRemark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCreditRemark(String value) {
        this.csCreditRemark = value;
    }

    /**
     * Gets the value of the csRemark1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsRemark1() {
        return csRemark1;
    }

    /**
     * Sets the value of the csRemark1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsRemark1(String value) {
        this.csRemark1 = value;
    }

    /**
     * Gets the value of the csRemark2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsRemark2() {
        return csRemark2;
    }

    /**
     * Sets the value of the csRemark2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsRemark2(String value) {
        this.csRemark2 = value;
    }

    /**
     * Gets the value of the dealerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDealerId() {
        return dealerId;
    }

    /**
     * Sets the value of the dealerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDealerId(Long value) {
        this.dealerId = value;
    }

    /**
     * Gets the value of the areaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * Sets the value of the areaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAreaId(Long value) {
        this.areaId = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCurrency(Long value) {
        this.currency = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAddress }
     *     
     */
    public CustomerAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAddress }
     *     
     */
    public void setAddress(CustomerAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the paymentArrangement property.
     * 
     * @return
     *     possible object is
     *     {@link Customer.PaymentArrangement }
     *     
     */
    public Customer.PaymentArrangement getPaymentArrangement() {
        return paymentArrangement;
    }

    /**
     * Sets the value of the paymentArrangement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer.PaymentArrangement }
     *     
     */
    public void setPaymentArrangement(Customer.PaymentArrangement value) {
        this.paymentArrangement = value;
    }

    /**
     * Gets the value of the taxExemption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxExemption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxExemption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxExemptionType }
     * 
     * 
     */
    public List<TaxExemptionType> getTaxExemption() {
        if (taxExemption == null) {
            taxExemption = new ArrayList<TaxExemptionType>();
        }
        return this.taxExemption;
    }

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractType }
     * 
     * 
     */
    public List<ContractType> getContract() {
        if (contract == null) {
            contract = new ArrayList<ContractType>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Customer.AdditionalInfo }
     * 
     * 
     */
    public List<Customer.AdditionalInfo> getAdditionalInfo() {
        if (additionalInfo == null) {
            additionalInfo = new ArrayList<Customer.AdditionalInfo>();
        }
        return this.additionalInfo;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "value"
    })
    public static class AdditionalInfo {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String value;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="payment_method_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="account_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="account_owner" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="bank_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="bank_zip" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="bank_city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="swift" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paymentMethodId",
        "accountNo",
        "accountOwner",
        "bankName",
        "bankZip",
        "bankCity",
        "swift"
    })
    public static class PaymentArrangement {

        @XmlElement(name = "payment_method_id", required = true)
        protected BigInteger paymentMethodId;
        @XmlElement(name = "account_no", required = true)
        protected String accountNo;
        @XmlElement(name = "account_owner", required = true)
        protected String accountOwner;
        @XmlElement(name = "bank_name", required = true)
        protected String bankName;
        @XmlElement(name = "bank_zip", required = true)
        protected String bankZip;
        @XmlElement(name = "bank_city", required = true)
        protected String bankCity;
        @XmlElement(required = true)
        protected String swift;

        /**
         * Gets the value of the paymentMethodId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPaymentMethodId() {
            return paymentMethodId;
        }

        /**
         * Sets the value of the paymentMethodId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPaymentMethodId(BigInteger value) {
            this.paymentMethodId = value;
        }

        /**
         * Gets the value of the accountNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountNo() {
            return accountNo;
        }

        /**
         * Sets the value of the accountNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountNo(String value) {
            this.accountNo = value;
        }

        /**
         * Gets the value of the accountOwner property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountOwner() {
            return accountOwner;
        }

        /**
         * Sets the value of the accountOwner property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountOwner(String value) {
            this.accountOwner = value;
        }

        /**
         * Gets the value of the bankName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankName() {
            return bankName;
        }

        /**
         * Sets the value of the bankName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankName(String value) {
            this.bankName = value;
        }

        /**
         * Gets the value of the bankZip property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankZip() {
            return bankZip;
        }

        /**
         * Sets the value of the bankZip property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankZip(String value) {
            this.bankZip = value;
        }

        /**
         * Gets the value of the bankCity property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankCity() {
            return bankCity;
        }

        /**
         * Sets the value of the bankCity property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankCity(String value) {
            this.bankCity = value;
        }

        /**
         * Gets the value of the swift property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSwift() {
            return swift;
        }

        /**
         * Sets the value of the swift property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSwift(String value) {
            this.swift = value;
        }

    }

}
