//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:41 PM IST 
//


package com.alu.cmsi.writer.beans.changeContractStatus;

import java.math.BigInteger;
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
 *         &lt;element name="contract">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{}contractIdType"/>
 *                   &lt;element name="dn_retention_mode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="dev_retention_mode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    protected Customer.Contract contract;

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link Customer.Contract }
     *     
     */
    public Customer.Contract getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer.Contract }
     *     
     */
    public void setContract(Customer.Contract value) {
        this.contract = value;
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
     *         &lt;element name="dn_retention_mode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="dev_retention_mode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "dnRetentionMode",
        "devRetentionMode",
        "reason"
    })
    public static class Contract {

        @XmlElement(required = true)
        protected ContractIdType id;
        @XmlElement(name = "dn_retention_mode")
        protected BigInteger dnRetentionMode;
        @XmlElement(name = "dev_retention_mode")
        protected BigInteger devRetentionMode;
        protected BigInteger reason;

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
         * Gets the value of the dnRetentionMode property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDnRetentionMode() {
            return dnRetentionMode;
        }

        /**
         * Sets the value of the dnRetentionMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDnRetentionMode(BigInteger value) {
            this.dnRetentionMode = value;
        }

        /**
         * Gets the value of the devRetentionMode property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDevRetentionMode() {
            return devRetentionMode;
        }

        /**
         * Sets the value of the devRetentionMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDevRetentionMode(BigInteger value) {
            this.devRetentionMode = value;
        }

        /**
         * Gets the value of the reason property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getReason() {
            return reason;
        }

        /**
         * Sets the value of the reason property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setReason(BigInteger value) {
            this.reason = value;
        }

    }

}