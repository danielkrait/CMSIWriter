//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:42 PM IST 
//


package com.alu.cmsi.writer.beans.changeRateplan;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for portType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="portType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="portnum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hlcode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="npcode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portType", propOrder = {
    "portnum",
    "hlcode",
    "npcode"
})
public class PortType {

    @XmlElement(required = true)
    protected String portnum;
    @XmlElement(required = true)
    protected BigInteger hlcode;
    @XmlElement(required = true)
    protected BigInteger npcode;

    /**
     * Gets the value of the portnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortnum() {
        return portnum;
    }

    /**
     * Sets the value of the portnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortnum(String value) {
        this.portnum = value;
    }

    /**
     * Gets the value of the hlcode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHlcode() {
        return hlcode;
    }

    /**
     * Sets the value of the hlcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHlcode(BigInteger value) {
        this.hlcode = value;
    }

    /**
     * Gets the value of the npcode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNpcode() {
        return npcode;
    }

    /**
     * Sets the value of the npcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNpcode(BigInteger value) {
        this.npcode = value;
    }

}
