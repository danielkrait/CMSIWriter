//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:42 PM IST 
//


package com.alu.cmsi.writer.beans.convertToFlat;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cugType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cugType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cugElement" type="{}cugElementType" maxOccurs="unbounded"/>
 *         &lt;element name="bsg" type="{}bsgType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cugType", propOrder = {
    "cugElement",
    "bsg"
})
public class CugType {

    @XmlElement(required = true)
    protected List<CugElementType> cugElement;
    @XmlElement(required = true)
    protected List<BsgType> bsg;

    /**
     * Gets the value of the cugElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cugElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCugElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CugElementType }
     * 
     * 
     */
    public List<CugElementType> getCugElement() {
        if (cugElement == null) {
            cugElement = new ArrayList<CugElementType>();
        }
        return this.cugElement;
    }

    /**
     * Gets the value of the bsg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bsg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBsg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BsgType }
     * 
     * 
     */
    public List<BsgType> getBsg() {
        if (bsg == null) {
            bsg = new ArrayList<BsgType>();
        }
        return this.bsg;
    }

}
