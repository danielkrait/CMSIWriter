//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:43 PM IST 
//


package com.alu.cmsi.writer.beans.createTickler;

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
 *         &lt;element name="id" type="{}custIdType" minOccurs="0"/>
 *         &lt;element name="contract" type="{}contractIdType" minOccurs="0"/>
 *         &lt;element name="tickler" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="follow_up_user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="tickler_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tickler_status" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="NOTE"/>
 *                         &lt;enumeration value="OPEN"/>
 *                         &lt;enumeration value="CLOSED"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tickler_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="tickler_shdes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="tickler_priority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    "contract",
    "tickler"
})
@XmlRootElement(name = "customer")
public class Customer {

    protected CustIdType id;
    protected ContractIdType contract;
    @XmlElement(required = true)
    protected List<Customer.Tickler> tickler;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link CustIdType }
     *     
     */
    public CustIdType getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustIdType }
     *     
     */
    public void setId(CustIdType value) {
        this.id = value;
    }

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link ContractIdType }
     *     
     */
    public ContractIdType getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractIdType }
     *     
     */
    public void setContract(ContractIdType value) {
        this.contract = value;
    }

    /**
     * Gets the value of the tickler property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tickler property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTickler().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Customer.Tickler }
     * 
     * 
     */
    public List<Customer.Tickler> getTickler() {
        if (tickler == null) {
            tickler = new ArrayList<Customer.Tickler>();
        }
        return this.tickler;
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
     *         &lt;element name="follow_up_user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="tickler_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tickler_status" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="NOTE"/>
     *               &lt;enumeration value="OPEN"/>
     *               &lt;enumeration value="CLOSED"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="tickler_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="tickler_shdes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="tickler_priority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "followUpUser",
        "ticklerCode",
        "ticklerStatus",
        "ticklerDesc",
        "ticklerShdes",
        "ticklerPriority"
    })
    public static class Tickler {

        @XmlElement(name = "follow_up_user")
        protected String followUpUser;
        @XmlElement(name = "tickler_code", required = true)
        protected String ticklerCode;
        @XmlElement(name = "tickler_status")
        protected String ticklerStatus;
        @XmlElement(name = "tickler_desc")
        protected String ticklerDesc;
        @XmlElement(name = "tickler_shdes")
        protected String ticklerShdes;
        @XmlElement(name = "tickler_priority")
        protected BigInteger ticklerPriority;

        /**
         * Gets the value of the followUpUser property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFollowUpUser() {
            return followUpUser;
        }

        /**
         * Sets the value of the followUpUser property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFollowUpUser(String value) {
            this.followUpUser = value;
        }

        /**
         * Gets the value of the ticklerCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTicklerCode() {
            return ticklerCode;
        }

        /**
         * Sets the value of the ticklerCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTicklerCode(String value) {
            this.ticklerCode = value;
        }

        /**
         * Gets the value of the ticklerStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTicklerStatus() {
            return ticklerStatus;
        }

        /**
         * Sets the value of the ticklerStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTicklerStatus(String value) {
            this.ticklerStatus = value;
        }

        /**
         * Gets the value of the ticklerDesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTicklerDesc() {
            return ticklerDesc;
        }

        /**
         * Sets the value of the ticklerDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTicklerDesc(String value) {
            this.ticklerDesc = value;
        }

        /**
         * Gets the value of the ticklerShdes property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTicklerShdes() {
            return ticklerShdes;
        }

        /**
         * Sets the value of the ticklerShdes property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTicklerShdes(String value) {
            this.ticklerShdes = value;
        }

        /**
         * Gets the value of the ticklerPriority property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTicklerPriority() {
            return ticklerPriority;
        }

        /**
         * Sets the value of the ticklerPriority property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTicklerPriority(BigInteger value) {
            this.ticklerPriority = value;
        }

    }

}
