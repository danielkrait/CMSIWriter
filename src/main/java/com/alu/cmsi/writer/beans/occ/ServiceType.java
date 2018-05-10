//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.10 at 11:25:31 PM EEST 
//


package com.alu.cmsi.writer.beans.occ;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for serviceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sncode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="service_package_code" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="directory_number" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="create_if_unexisting" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="main" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="npcode" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cug" type="{}cugType" minOccurs="0"/>
 *         &lt;element name="parameter" type="{}parameterType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceType", propOrder = {
    "sncode",
    "servicePackageCode",
    "directoryNumber",
    "cug",
    "parameter"
})
public class ServiceType {

    @XmlElement(required = true)
    protected BigInteger sncode;
    @XmlElement(name = "service_package_code", required = true)
    protected BigInteger servicePackageCode;
    @XmlElement(name = "directory_number")
    protected ServiceType.DirectoryNumber directoryNumber;
    protected CugType cug;
    @XmlElement(required = true)
    protected List<ParameterType> parameter;

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
     * Gets the value of the servicePackageCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServicePackageCode() {
        return servicePackageCode;
    }

    /**
     * Sets the value of the servicePackageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServicePackageCode(BigInteger value) {
        this.servicePackageCode = value;
    }

    /**
     * Gets the value of the directoryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType.DirectoryNumber }
     *     
     */
    public ServiceType.DirectoryNumber getDirectoryNumber() {
        return directoryNumber;
    }

    /**
     * Sets the value of the directoryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType.DirectoryNumber }
     *     
     */
    public void setDirectoryNumber(ServiceType.DirectoryNumber value) {
        this.directoryNumber = value;
    }

    /**
     * Gets the value of the cug property.
     * 
     * @return
     *     possible object is
     *     {@link CugType }
     *     
     */
    public CugType getCug() {
        return cug;
    }

    /**
     * Sets the value of the cug property.
     * 
     * @param value
     *     allowed object is
     *     {@link CugType }
     *     
     */
    public void setCug(CugType value) {
        this.cug = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterType }
     * 
     * 
     */
    public List<ParameterType> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<ParameterType>();
        }
        return this.parameter;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="create_if_unexisting" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="main" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="npcode" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class DirectoryNumber {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "create_if_unexisting", required = true)
        protected boolean createIfUnexisting;
        @XmlAttribute(required = true)
        protected boolean main;
        @XmlAttribute(required = true)
        protected BigInteger npcode;

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

        /**
         * Gets the value of the createIfUnexisting property.
         * 
         */
        public boolean isCreateIfUnexisting() {
            return createIfUnexisting;
        }

        /**
         * Sets the value of the createIfUnexisting property.
         * 
         */
        public void setCreateIfUnexisting(boolean value) {
            this.createIfUnexisting = value;
        }

        /**
         * Gets the value of the main property.
         * 
         */
        public boolean isMain() {
            return main;
        }

        /**
         * Sets the value of the main property.
         * 
         */
        public void setMain(boolean value) {
            this.main = value;
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

}
