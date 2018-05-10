//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.10 at 11:25:30 PM EEST 
//


package com.alu.cmsi.writer.beans.modifyMicrocell;

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
 *         &lt;element name="ACTION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HRCODE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="HRCODE_PUB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="microcell_members" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MM_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="DEST_CODE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="DEST_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="NUMBERING_PLAN" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "action",
    "hrcode",
    "hrcodepub",
    "microcellMembers"
})
@XmlRootElement(name = "microcell")
public class Microcell {

    @XmlElement(name = "ACTION", required = true)
    protected String action;
    @XmlElement(name = "HRCODE")
    protected long hrcode;
    @XmlElement(name = "HRCODE_PUB", required = true)
    protected String hrcodepub;
    @XmlElement(name = "microcell_members", required = true)
    protected List<Microcell.MicrocellMembers> microcellMembers;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTION() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTION(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the hrcode property.
     * 
     */
    public long getHRCODE() {
        return hrcode;
    }

    /**
     * Sets the value of the hrcode property.
     * 
     */
    public void setHRCODE(long value) {
        this.hrcode = value;
    }

    /**
     * Gets the value of the hrcodepub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHRCODEPUB() {
        return hrcodepub;
    }

    /**
     * Sets the value of the hrcodepub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHRCODEPUB(String value) {
        this.hrcodepub = value;
    }

    /**
     * Gets the value of the microcellMembers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the microcellMembers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMicrocellMembers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Microcell.MicrocellMembers }
     * 
     * 
     */
    public List<Microcell.MicrocellMembers> getMicrocellMembers() {
        if (microcellMembers == null) {
            microcellMembers = new ArrayList<Microcell.MicrocellMembers>();
        }
        return this.microcellMembers;
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
     *         &lt;element name="MM_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="DEST_CODE" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="DEST_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="NUMBERING_PLAN" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
        "mmid",
        "destcode",
        "destnumber",
        "numberingplan"
    })
    public static class MicrocellMembers {

        @XmlElement(name = "MM_ID")
        protected long mmid;
        @XmlElement(name = "DEST_CODE")
        protected long destcode;
        @XmlElement(name = "DEST_NUMBER", required = true)
        protected String destnumber;
        @XmlElement(name = "NUMBERING_PLAN")
        protected long numberingplan;

        /**
         * Gets the value of the mmid property.
         * 
         */
        public long getMMID() {
            return mmid;
        }

        /**
         * Sets the value of the mmid property.
         * 
         */
        public void setMMID(long value) {
            this.mmid = value;
        }

        /**
         * Gets the value of the destcode property.
         * 
         */
        public long getDESTCODE() {
            return destcode;
        }

        /**
         * Sets the value of the destcode property.
         * 
         */
        public void setDESTCODE(long value) {
            this.destcode = value;
        }

        /**
         * Gets the value of the destnumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESTNUMBER() {
            return destnumber;
        }

        /**
         * Sets the value of the destnumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESTNUMBER(String value) {
            this.destnumber = value;
        }

        /**
         * Gets the value of the numberingplan property.
         * 
         */
        public long getNUMBERINGPLAN() {
            return numberingplan;
        }

        /**
         * Sets the value of the numberingplan property.
         * 
         */
        public void setNUMBERINGPLAN(long value) {
            this.numberingplan = value;
        }

    }

}
