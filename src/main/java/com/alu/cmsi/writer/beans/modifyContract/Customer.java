//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:43 PM IST 
//


package com.alu.cmsi.writer.beans.modifyContract;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *                   &lt;choice>
 *                     &lt;group ref="{}sp"/>
 *                     &lt;group ref="{}info"/>
 *                   &lt;/choice>
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
     *         &lt;choice>
     *           &lt;group ref="{}sp"/>
     *           &lt;group ref="{}info"/>
     *         &lt;/choice>
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
        "sourceServicePackageCode",
        "targetServicePackageCode",
        "additionalInfo",
        "coOpDir",
        "coSignedDate"
    })
    public static class Contract {

        @XmlElement(required = true)
        protected ContractIdType id;
        @XmlElement(name = "target_rateplan_code")
        protected Long targetRateplanCode;
        @XmlElement(name = "source_service_package_code")
        protected Long sourceServicePackageCode;
        @XmlElement(name = "target_service_package_code")
        protected Long targetServicePackageCode;
        @XmlElement(name = "additional_info", required = true)
        protected List<Customer.Contract.AdditionalInfo> additionalInfo;
        @XmlElement(name = "co_op_dir")
        protected Boolean coOpDir;
        @XmlElement(name = "co_signed_date")
        protected XMLGregorianCalendar coSignedDate;

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
         * Gets the value of the sourceServicePackageCode property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getSourceServicePackageCode() {
            return sourceServicePackageCode;
        }

        /**
         * Sets the value of the sourceServicePackageCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setSourceServicePackageCode(Long value) {
            this.sourceServicePackageCode = value;
        }

        /**
         * Gets the value of the targetServicePackageCode property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getTargetServicePackageCode() {
            return targetServicePackageCode;
        }

        /**
         * Sets the value of the targetServicePackageCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setTargetServicePackageCode(Long value) {
            this.targetServicePackageCode = value;
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
         * {@link Customer.Contract.AdditionalInfo }
         * 
         * 
         */
        public List<Customer.Contract.AdditionalInfo> getAdditionalInfo() {
            if (additionalInfo == null) {
                additionalInfo = new ArrayList<Customer.Contract.AdditionalInfo>();
            }
            return this.additionalInfo;
        }

        /**
         * Gets the value of the coOpDir property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCoOpDir() {
            return coOpDir;
        }

        /**
         * Sets the value of the coOpDir property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCoOpDir(Boolean value) {
            this.coOpDir = value;
        }

        /**
         * Gets the value of the coSignedDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCoSignedDate() {
            return coSignedDate;
        }

        /**
         * Sets the value of the coSignedDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCoSignedDate(XMLGregorianCalendar value) {
            this.coSignedDate = value;
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

    }

}