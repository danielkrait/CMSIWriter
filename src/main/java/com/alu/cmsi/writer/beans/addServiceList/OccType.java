//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:41 PM IST 
//


package com.alu.cmsi.writer.beans.addServiceList;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for occType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="occType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}custIdType"/>
 *         &lt;element name="action_code">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="D"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fee_type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fee_class">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="seqno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="num_periods" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="invoice_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="co_id" type="{}contractIdType" minOccurs="0"/>
 *         &lt;element name="rate_plan_code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="rate_plan_version" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="service_package_code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sncode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="record_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="record_sub_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="base_part_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="charge_part_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="event_code" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fee_amount" type="{}moneyType" minOccurs="0"/>
 *         &lt;element name="fu_pack_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="num_fu" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="fu_ver" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="fu_pkver" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="fu_pkelsq" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="glcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="glcodedisc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="glcodemin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servcat_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serv_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serv_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valid_from" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "occType", propOrder = {
    "id",
    "actionCode",
    "feeType",
    "feeClass",
    "seqno",
    "numPeriods",
    "invoiceId",
    "coId",
    "ratePlanCode",
    "ratePlanVersion",
    "servicePackageCode",
    "sncode",
    "recordId",
    "recordSubId",
    "basePartId",
    "chargePartId",
    "eventCode",
    "feeAmount",
    "fuPackId",
    "numFu",
    "fuVer",
    "fuPkver",
    "fuPkelsq",
    "glcode",
    "glcodedisc",
    "glcodemin",
    "servcatCode",
    "servCode",
    "servType",
    "remark",
    "validFrom"
})
public class OccType {

    @XmlElement(required = true)
    protected CustIdType id;
    @XmlElement(name = "action_code", required = true)
    protected String actionCode;
    @XmlElement(name = "fee_type", required = true)
    protected String feeType;
    @XmlElement(name = "fee_class", required = true)
    protected BigInteger feeClass;
    protected Long seqno;
    @XmlElement(name = "num_periods")
    protected BigInteger numPeriods;
    @XmlElement(name = "invoice_id")
    protected Long invoiceId;
    @XmlElement(name = "co_id")
    protected ContractIdType coId;
    @XmlElement(name = "rate_plan_code")
    protected Long ratePlanCode;
    @XmlElement(name = "rate_plan_version")
    protected Long ratePlanVersion;
    @XmlElement(name = "service_package_code")
    protected Long servicePackageCode;
    protected Long sncode;
    @XmlElement(name = "record_id")
    protected BigInteger recordId;
    @XmlElement(name = "record_sub_id")
    protected BigInteger recordSubId;
    @XmlElement(name = "base_part_id")
    protected BigInteger basePartId;
    @XmlElement(name = "charge_part_id")
    protected BigInteger chargePartId;
    @XmlElement(name = "event_code")
    protected Long eventCode;
    @XmlElement(name = "fee_amount")
    protected MoneyType feeAmount;
    @XmlElement(name = "fu_pack_id")
    protected BigInteger fuPackId;
    @XmlElement(name = "num_fu")
    protected Float numFu;
    @XmlElement(name = "fu_ver")
    protected BigInteger fuVer;
    @XmlElement(name = "fu_pkver")
    protected BigInteger fuPkver;
    @XmlElement(name = "fu_pkelsq")
    protected BigInteger fuPkelsq;
    protected String glcode;
    protected String glcodedisc;
    protected String glcodemin;
    @XmlElement(name = "servcat_code")
    protected String servcatCode;
    @XmlElement(name = "serv_code")
    protected String servCode;
    @XmlElement(name = "serv_type")
    protected String servType;
    protected String remark;
    @XmlElement(name = "valid_from")
    protected XMLGregorianCalendar validFrom;

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
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the feeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * Sets the value of the feeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeType(String value) {
        this.feeType = value;
    }

    /**
     * Gets the value of the feeClass property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFeeClass() {
        return feeClass;
    }

    /**
     * Sets the value of the feeClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFeeClass(BigInteger value) {
        this.feeClass = value;
    }

    /**
     * Gets the value of the seqno property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSeqno() {
        return seqno;
    }

    /**
     * Sets the value of the seqno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSeqno(Long value) {
        this.seqno = value;
    }

    /**
     * Gets the value of the numPeriods property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumPeriods() {
        return numPeriods;
    }

    /**
     * Sets the value of the numPeriods property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumPeriods(BigInteger value) {
        this.numPeriods = value;
    }

    /**
     * Gets the value of the invoiceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the value of the invoiceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvoiceId(Long value) {
        this.invoiceId = value;
    }

    /**
     * Gets the value of the coId property.
     * 
     * @return
     *     possible object is
     *     {@link ContractIdType }
     *     
     */
    public ContractIdType getCoId() {
        return coId;
    }

    /**
     * Sets the value of the coId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractIdType }
     *     
     */
    public void setCoId(ContractIdType value) {
        this.coId = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRatePlanCode(Long value) {
        this.ratePlanCode = value;
    }

    /**
     * Gets the value of the ratePlanVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRatePlanVersion() {
        return ratePlanVersion;
    }

    /**
     * Sets the value of the ratePlanVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRatePlanVersion(Long value) {
        this.ratePlanVersion = value;
    }

    /**
     * Gets the value of the servicePackageCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getServicePackageCode() {
        return servicePackageCode;
    }

    /**
     * Sets the value of the servicePackageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setServicePackageCode(Long value) {
        this.servicePackageCode = value;
    }

    /**
     * Gets the value of the sncode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSncode() {
        return sncode;
    }

    /**
     * Sets the value of the sncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSncode(Long value) {
        this.sncode = value;
    }

    /**
     * Gets the value of the recordId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRecordId() {
        return recordId;
    }

    /**
     * Sets the value of the recordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRecordId(BigInteger value) {
        this.recordId = value;
    }

    /**
     * Gets the value of the recordSubId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRecordSubId() {
        return recordSubId;
    }

    /**
     * Sets the value of the recordSubId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRecordSubId(BigInteger value) {
        this.recordSubId = value;
    }

    /**
     * Gets the value of the basePartId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBasePartId() {
        return basePartId;
    }

    /**
     * Sets the value of the basePartId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBasePartId(BigInteger value) {
        this.basePartId = value;
    }

    /**
     * Gets the value of the chargePartId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getChargePartId() {
        return chargePartId;
    }

    /**
     * Sets the value of the chargePartId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setChargePartId(BigInteger value) {
        this.chargePartId = value;
    }

    /**
     * Gets the value of the eventCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEventCode() {
        return eventCode;
    }

    /**
     * Sets the value of the eventCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEventCode(Long value) {
        this.eventCode = value;
    }

    /**
     * Gets the value of the feeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setFeeAmount(MoneyType value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the fuPackId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFuPackId() {
        return fuPackId;
    }

    /**
     * Sets the value of the fuPackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFuPackId(BigInteger value) {
        this.fuPackId = value;
    }

    /**
     * Gets the value of the numFu property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNumFu() {
        return numFu;
    }

    /**
     * Sets the value of the numFu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNumFu(Float value) {
        this.numFu = value;
    }

    /**
     * Gets the value of the fuVer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFuVer() {
        return fuVer;
    }

    /**
     * Sets the value of the fuVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFuVer(BigInteger value) {
        this.fuVer = value;
    }

    /**
     * Gets the value of the fuPkver property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFuPkver() {
        return fuPkver;
    }

    /**
     * Sets the value of the fuPkver property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFuPkver(BigInteger value) {
        this.fuPkver = value;
    }

    /**
     * Gets the value of the fuPkelsq property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFuPkelsq() {
        return fuPkelsq;
    }

    /**
     * Sets the value of the fuPkelsq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFuPkelsq(BigInteger value) {
        this.fuPkelsq = value;
    }

    /**
     * Gets the value of the glcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlcode() {
        return glcode;
    }

    /**
     * Sets the value of the glcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlcode(String value) {
        this.glcode = value;
    }

    /**
     * Gets the value of the glcodedisc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlcodedisc() {
        return glcodedisc;
    }

    /**
     * Sets the value of the glcodedisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlcodedisc(String value) {
        this.glcodedisc = value;
    }

    /**
     * Gets the value of the glcodemin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlcodemin() {
        return glcodemin;
    }

    /**
     * Sets the value of the glcodemin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlcodemin(String value) {
        this.glcodemin = value;
    }

    /**
     * Gets the value of the servcatCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServcatCode() {
        return servcatCode;
    }

    /**
     * Sets the value of the servcatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServcatCode(String value) {
        this.servcatCode = value;
    }

    /**
     * Gets the value of the servCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServCode() {
        return servCode;
    }

    /**
     * Sets the value of the servCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServCode(String value) {
        this.servCode = value;
    }

    /**
     * Gets the value of the servType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServType() {
        return servType;
    }

    /**
     * Sets the value of the servType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServType(String value) {
        this.servType = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

}
