//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:43 PM IST 
//


package com.alu.cmsi.writer.beans.modifyCustomer;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for billingAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="billingAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="billing_medium" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="termcode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="individualtax_from_ind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "billingAccountType", propOrder = {
    "id",
    "billingMedium",
    "termcode",
    "individualtaxFromInd"
})
public class BillingAccountType {

    protected long id;
    @XmlElement(name = "billing_medium")
    protected Long billingMedium;
    protected BigInteger termcode;
    @XmlElement(name = "individualtax_from_ind")
    protected String individualtaxFromInd;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
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
     * Gets the value of the termcode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTermcode() {
        return termcode;
    }

    /**
     * Sets the value of the termcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTermcode(BigInteger value) {
        this.termcode = value;
    }

    /**
     * Gets the value of the individualtaxFromInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndividualtaxFromInd() {
        return individualtaxFromInd;
    }

    /**
     * Sets the value of the individualtaxFromInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndividualtaxFromInd(String value) {
        this.individualtaxFromInd = value;
    }

}
