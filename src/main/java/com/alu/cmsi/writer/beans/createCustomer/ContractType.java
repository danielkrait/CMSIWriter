//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:42 PM IST 
//


package com.alu.cmsi.writer.beans.createCustomer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for contractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="billing_account_assignment" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="device" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="storage_medium_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="port_number" type="{}portType"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="rate_plan_code" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="network_code" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="market_code" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="submarket_code" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="valid_from" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dealer_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;group ref="{}cd" minOccurs="0"/>
 *         &lt;element name="installation_address" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="house_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="zip_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="country_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="address_note_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="address_note_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="address_note_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element name="service" type="{}serviceType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contractType", propOrder = {
    "status",
    "billingAccountAssignment",
    "device",
    "ratePlanCode",
    "networkCode",
    "marketCode",
    "submarketCode",
    "validFrom",
    "dealerId",
    "callDetail",
    "billingMedium",
    "installationAddress",
    "additionalInfo",
    "service"
})
public class ContractType {

    protected Integer status;
    @XmlElement(name = "billing_account_assignment")
    protected Long billingAccountAssignment;
    protected ContractType.Device device;
    @XmlElement(name = "rate_plan_code", required = true)
    protected BigInteger ratePlanCode;
    @XmlElement(name = "network_code", required = true)
    protected BigInteger networkCode;
    @XmlElement(name = "market_code", required = true)
    protected BigInteger marketCode;
    @XmlElement(name = "submarket_code", required = true)
    protected BigInteger submarketCode;
    @XmlElement(name = "valid_from")
    protected XMLGregorianCalendar validFrom;
    @XmlElement(name = "dealer_id")
    protected Long dealerId;
    @XmlElement(name = "call_detail")
    protected String callDetail;
    @XmlElement(name = "billing_medium")
    protected Long billingMedium;
    @XmlElement(name = "installation_address")
    protected ContractType.InstallationAddress installationAddress;
    @XmlElement(name = "additional_info", required = true)
    protected List<ContractType.AdditionalInfo> additionalInfo;
    @XmlElement(required = true)
    protected List<ServiceType> service;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the billingAccountAssignment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillingAccountAssignment() {
        return billingAccountAssignment;
    }

    /**
     * Sets the value of the billingAccountAssignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillingAccountAssignment(Long value) {
        this.billingAccountAssignment = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType.Device }
     *     
     */
    public ContractType.Device getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType.Device }
     *     
     */
    public void setDevice(ContractType.Device value) {
        this.device = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRatePlanCode(BigInteger value) {
        this.ratePlanCode = value;
    }

    /**
     * Gets the value of the networkCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNetworkCode() {
        return networkCode;
    }

    /**
     * Sets the value of the networkCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNetworkCode(BigInteger value) {
        this.networkCode = value;
    }

    /**
     * Gets the value of the marketCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMarketCode() {
        return marketCode;
    }

    /**
     * Sets the value of the marketCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMarketCode(BigInteger value) {
        this.marketCode = value;
    }

    /**
     * Gets the value of the submarketCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSubmarketCode() {
        return submarketCode;
    }

    /**
     * Sets the value of the submarketCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSubmarketCode(BigInteger value) {
        this.submarketCode = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
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
     * Gets the value of the callDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallDetail() {
        return callDetail;
    }

    /**
     * Sets the value of the callDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallDetail(String value) {
        this.callDetail = value;
    }

    /**
     * Gets the value of the billingMedium property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillingMedium() {
        return billingMedium;
    }

    /**
     * Sets the value of the billingMedium property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillingMedium(Long value) {
        this.billingMedium = value;
    }

    /**
     * Gets the value of the installationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType.InstallationAddress }
     *     
     */
    public ContractType.InstallationAddress getInstallationAddress() {
        return installationAddress;
    }

    /**
     * Sets the value of the installationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType.InstallationAddress }
     *     
     */
    public void setInstallationAddress(ContractType.InstallationAddress value) {
        this.installationAddress = value;
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
     * {@link ContractType.AdditionalInfo }
     * 
     * 
     */
    public List<ContractType.AdditionalInfo> getAdditionalInfo() {
        if (additionalInfo == null) {
            additionalInfo = new ArrayList<ContractType.AdditionalInfo>();
        }
        return this.additionalInfo;
    }

    /**
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceType }
     * 
     * 
     */
    public List<ServiceType> getService() {
        if (service == null) {
            service = new ArrayList<ServiceType>();
        }
        return this.service;
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
     *       &lt;choice>
     *         &lt;element name="storage_medium_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="port_number" type="{}portType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "storageMediumNumber",
        "portNumber"
    })
    public static class Device {

        @XmlElement(name = "storage_medium_number")
        protected String storageMediumNumber;
        @XmlElement(name = "port_number")
        protected PortType portNumber;

        /**
         * Gets the value of the storageMediumNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStorageMediumNumber() {
            return storageMediumNumber;
        }

        /**
         * Sets the value of the storageMediumNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStorageMediumNumber(String value) {
            this.storageMediumNumber = value;
        }

        /**
         * Gets the value of the portNumber property.
         * 
         * @return
         *     possible object is
         *     {@link PortType }
         *     
         */
        public PortType getPortNumber() {
            return portNumber;
        }

        /**
         * Sets the value of the portNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link PortType }
         *     
         */
        public void setPortNumber(PortType value) {
            this.portNumber = value;
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
     *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="house_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="zip_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="country_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="address_note_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="address_note_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="address_note_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "firstName",
        "lastName",
        "street",
        "houseNo",
        "zipCode",
        "city",
        "state",
        "countryId",
        "addressNote1",
        "addressNote2",
        "addressNote3",
        "email",
        "remark"
    })
    public static class InstallationAddress {

        @XmlElement(name = "first_name")
        protected String firstName;
        @XmlElement(name = "last_name")
        protected String lastName;
        @XmlElement(required = true)
        protected String street;
        @XmlElement(name = "house_no", required = true)
        protected String houseNo;
        @XmlElement(name = "zip_code", required = true)
        protected String zipCode;
        @XmlElement(required = true)
        protected String city;
        @XmlElement(required = true)
        protected String state;
        @XmlElement(name = "country_id", required = true)
        protected BigInteger countryId;
        @XmlElement(name = "address_note_1", required = true)
        protected String addressNote1;
        @XmlElement(name = "address_note_2", required = true)
        protected String addressNote2;
        @XmlElement(name = "address_note_3", required = true)
        protected String addressNote3;
        protected String email;
        protected String remark;

        /**
         * Gets the value of the firstName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Sets the value of the firstName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Gets the value of the lastName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Sets the value of the lastName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastName(String value) {
            this.lastName = value;
        }

        /**
         * Gets the value of the street property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStreet() {
            return street;
        }

        /**
         * Sets the value of the street property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStreet(String value) {
            this.street = value;
        }

        /**
         * Gets the value of the houseNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHouseNo() {
            return houseNo;
        }

        /**
         * Sets the value of the houseNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHouseNo(String value) {
            this.houseNo = value;
        }

        /**
         * Gets the value of the zipCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZipCode() {
            return zipCode;
        }

        /**
         * Sets the value of the zipCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZipCode(String value) {
            this.zipCode = value;
        }

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCity() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCity(String value) {
            this.city = value;
        }

        /**
         * Gets the value of the state property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setState(String value) {
            this.state = value;
        }

        /**
         * Gets the value of the countryId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCountryId() {
            return countryId;
        }

        /**
         * Sets the value of the countryId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCountryId(BigInteger value) {
            this.countryId = value;
        }

        /**
         * Gets the value of the addressNote1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressNote1() {
            return addressNote1;
        }

        /**
         * Sets the value of the addressNote1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressNote1(String value) {
            this.addressNote1 = value;
        }

        /**
         * Gets the value of the addressNote2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressNote2() {
            return addressNote2;
        }

        /**
         * Sets the value of the addressNote2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressNote2(String value) {
            this.addressNote2 = value;
        }

        /**
         * Gets the value of the addressNote3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressNote3() {
            return addressNote3;
        }

        /**
         * Sets the value of the addressNote3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressNote3(String value) {
            this.addressNote3 = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
        }

        /**
         * Gets the value of the remark property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemark() {
            return remark;
        }

        /**
         * Sets the value of the remark property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemark(String value) {
            this.remark = value;
        }

    }

}
