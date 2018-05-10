//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.10 at 05:55:29 PM EEST 
//


package com.alu.cmsi.writer.beans.modifyServiceAccessFee;

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
 *         &lt;element name="contract" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{}contractIdType"/>
 *                   &lt;element name="service" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="sncode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="accessFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="accessFeeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="accessFeePrd" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "contract"
})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlElement(required = true)
    protected List<Customer.Contract> contract;

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
     *         &lt;element name="service" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="sncode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="accessFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *                   &lt;element name="accessFeeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="accessFeePrd" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
        "id",
        "service"
    })
    public static class Contract {

        @XmlElement(required = true)
        protected ContractIdType id;
        @XmlElement(required = true)
        protected List<Customer.Contract.Service> service;

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
         * {@link Customer.Contract.Service }
         * 
         * 
         */
        public List<Customer.Contract.Service> getService() {
            if (service == null) {
                service = new ArrayList<Customer.Contract.Service>();
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
         *         &lt;element name="sncode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="accessFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
         *         &lt;element name="accessFeeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="accessFeePrd" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
            "sncode",
            "accessFee",
            "accessFeeType",
            "accessFeePrd"
        })
        public static class Service {

            @XmlElement(required = true)
            protected BigInteger sncode;
            protected double accessFee;
            @XmlElement(required = true)
            protected String accessFeeType;
            @XmlElement(required = true)
            protected BigInteger accessFeePrd;

            /**
             * Gets the value of the sncode property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSncode() {
                return sncode;
            }

            /**
             * Sets the value of the sncode property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSncode(BigInteger value) {
                this.sncode = value;
            }

            /**
             * Gets the value of the accessFee property.
             * 
             */
            public double getAccessFee() {
                return accessFee;
            }

            /**
             * Sets the value of the accessFee property.
             * 
             */
            public void setAccessFee(double value) {
                this.accessFee = value;
            }

            /**
             * Gets the value of the accessFeeType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccessFeeType() {
                return accessFeeType;
            }

            /**
             * Sets the value of the accessFeeType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccessFeeType(String value) {
                this.accessFeeType = value;
            }

            /**
             * Gets the value of the accessFeePrd property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getAccessFeePrd() {
                return accessFeePrd;
            }

            /**
             * Sets the value of the accessFeePrd property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setAccessFeePrd(BigInteger value) {
                this.accessFeePrd = value;
            }

        }

    }

}
