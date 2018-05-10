//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.10 at 05:55:27 PM EEST 
//


package com.alu.cmsi.writer.beans.addServiceList;

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
 *         &lt;element name="contract" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{}contractIdType"/>
 *                   &lt;element name="target_rateplan_code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="service" type="{}serviceType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="occ" type="{}occType" minOccurs="0"/>
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
    "contract",
    "occ"
})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlElement(required = true)
    protected List<Customer.Contract> contract;
    protected OccType occ;

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
     * {@link Customer.Contract }
     * 
     * 
     */
    public List<Customer.Contract> getContract() {
        if (contract == null) {
            contract = new ArrayList<Customer.Contract>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the occ property.
     * 
     * @return
     *     possible object is
     *     {@link OccType }
     *     
     */
    public OccType getOcc() {
        return occ;
    }

    /**
     * Sets the value of the occ property.
     * 
     * @param value
     *     allowed object is
     *     {@link OccType }
     *     
     */
    public void setOcc(OccType value) {
        this.occ = value;
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
     *         &lt;element name="id" type="{}contractIdType"/>
     *         &lt;element name="target_rateplan_code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="service" type="{}serviceType" maxOccurs="unbounded" minOccurs="0"/>
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
        "id",
        "targetRateplanCode",
        "service"
    })
    public static class Contract {

        @XmlElement(required = true)
        protected ContractIdType id;
        @XmlElement(name = "target_rateplan_code")
        protected Long targetRateplanCode;
        @XmlElement(required = true)
        protected List<ServiceType> service;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link ContractIdType }
         *     
         */
        public ContractIdType getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link ContractIdType }
         *     
         */
        public void setId(ContractIdType value) {
            this.id = value;
        }

        /**
         * Gets the value of the targetRateplanCode property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getTargetRateplanCode() {
            return targetRateplanCode;
        }

        /**
         * Sets the value of the targetRateplanCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setTargetRateplanCode(Long value) {
            this.targetRateplanCode = value;
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

    }

}
