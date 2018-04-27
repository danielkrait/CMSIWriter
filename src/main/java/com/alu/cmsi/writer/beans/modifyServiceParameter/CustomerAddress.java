//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.13 at 01:01:43 PM IST 
//


package com.alu.cmsi.writer.beans.modifyServiceParameter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for customerAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roles">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="role" maxOccurs="unbounded">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="B"/>
 *                         &lt;enumeration value="C"/>
 *                         &lt;enumeration value="D"/>
 *                         &lt;enumeration value="E"/>
 *                         &lt;enumeration value="I"/>
 *                         &lt;enumeration value="P"/>
 *                         &lt;enumeration value="R"/>
 *                         &lt;enumeration value="S"/>
 *                         &lt;enumeration value="U"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="custtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="middle_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="full_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="sex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="M"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address_years" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="sms_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="job_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cctn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cctn_area" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cctn2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cctn2_area" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax_area" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="house_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zip_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="birth_date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="address_note_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address_note_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address_note_3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="id_type" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="passportno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="social_sec_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="drive_licence_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company_reg_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company_tax_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="is_employee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="marital_status" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerAddress", propOrder = {
    "roles",
    "custtype",
    "firstName",
    "middleName",
    "lastName",
    "fullName",
    "title",
    "sex",
    "email",
    "addressYears",
    "smsNo",
    "jobDesc",
    "cctn",
    "cctnArea",
    "cctn2",
    "cctn2Area",
    "fax",
    "faxArea",
    "remark",
    "street",
    "houseNo",
    "zipCode",
    "city",
    "state",
    "countryId",
    "language",
    "birthDate",
    "addressNote1",
    "addressNote2",
    "addressNote3",
    "nationality",
    "idType",
    "passportno",
    "socialSecNo",
    "driveLicenceNo",
    "companyRegNo",
    "companyTaxNo",
    "isEmployee",
    "maritalStatus"
})
public class CustomerAddress {

    @XmlElement(required = true)
    protected CustomerAddress.Roles roles;
    @XmlElement(required = true)
    protected String custtype;
    @XmlElement(name = "first_name", required = true)
    protected String firstName;
    @XmlElement(name = "middle_name")
    protected String middleName;
    @XmlElement(name = "last_name", required = true)
    protected String lastName;
    @XmlElement(name = "full_name")
    protected String fullName;
    protected BigInteger title;
    protected String sex;
    protected String email;
    @XmlElement(name = "address_years")
    protected BigInteger addressYears;
    @XmlElement(name = "sms_no")
    protected String smsNo;
    @XmlElement(name = "job_desc")
    protected String jobDesc;
    protected String cctn;
    @XmlElement(name = "cctn_area")
    protected String cctnArea;
    protected String cctn2;
    @XmlElement(name = "cctn2_area")
    protected String cctn2Area;
    protected String fax;
    @XmlElement(name = "fax_area")
    protected String faxArea;
    protected String remark;
    @XmlElement(required = true)
    protected String street;
    @XmlElement(name = "house_no", required = true)
    protected String houseNo;
    @XmlElement(name = "zip_code", required = true)
    protected String zipCode;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected String state;
    @XmlElement(name = "country_id", required = true)
    protected BigInteger countryId;
    protected BigInteger language;
    @XmlElement(name = "birth_date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "address_note_1")
    protected String addressNote1;
    @XmlElement(name = "address_note_2")
    protected String addressNote2;
    @XmlElement(name = "address_note_3")
    protected String addressNote3;
    protected BigInteger nationality;
    @XmlElement(name = "id_type")
    protected BigInteger idType;
    protected String passportno;
    @XmlElement(name = "social_sec_no")
    protected String socialSecNo;
    @XmlElement(name = "drive_licence_no")
    protected String driveLicenceNo;
    @XmlElement(name = "company_reg_no")
    protected String companyRegNo;
    @XmlElement(name = "company_tax_no")
    protected String companyTaxNo;
    @XmlElement(name = "is_employee")
    protected Boolean isEmployee;
    @XmlElement(name = "marital_status")
    protected BigInteger maritalStatus;

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAddress.Roles }
     *     
     */
    public CustomerAddress.Roles getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAddress.Roles }
     *     
     */
    public void setRoles(CustomerAddress.Roles value) {
        this.roles = value;
    }

    /**
     * Gets the value of the custtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusttype() {
        return custtype;
    }

    /**
     * Sets the value of the custtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusttype(String value) {
        this.custtype = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTitle(BigInteger value) {
        this.title = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the addressYears property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddressYears() {
        return addressYears;
    }

    /**
     * Sets the value of the addressYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddressYears(BigInteger value) {
        this.addressYears = value;
    }

    /**
     * Gets the value of the smsNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsNo() {
        return smsNo;
    }

    /**
     * Sets the value of the smsNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsNo(String value) {
        this.smsNo = value;
    }

    /**
     * Gets the value of the jobDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * Sets the value of the jobDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobDesc(String value) {
        this.jobDesc = value;
    }

    /**
     * Gets the value of the cctn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCctn() {
        return cctn;
    }

    /**
     * Sets the value of the cctn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCctn(String value) {
        this.cctn = value;
    }

    /**
     * Gets the value of the cctnArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCctnArea() {
        return cctnArea;
    }

    /**
     * Sets the value of the cctnArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCctnArea(String value) {
        this.cctnArea = value;
    }

    /**
     * Gets the value of the cctn2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCctn2() {
        return cctn2;
    }

    /**
     * Sets the value of the cctn2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCctn2(String value) {
        this.cctn2 = value;
    }

    /**
     * Gets the value of the cctn2Area property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCctn2Area() {
        return cctn2Area;
    }

    /**
     * Sets the value of the cctn2Area property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCctn2Area(String value) {
        this.cctn2Area = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the faxArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxArea() {
        return faxArea;
    }

    /**
     * Sets the value of the faxArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxArea(String value) {
        this.faxArea = value;
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
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the houseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * Sets the value of the houseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseNo(String value) {
        this.houseNo = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the countryId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCountryId(BigInteger value) {
        this.countryId = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLanguage(BigInteger value) {
        this.language = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the addressNote1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressNote1() {
        return addressNote1;
    }

    /**
     * Sets the value of the addressNote1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressNote1(String value) {
        this.addressNote1 = value;
    }

    /**
     * Gets the value of the addressNote2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressNote2() {
        return addressNote2;
    }

    /**
     * Sets the value of the addressNote2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressNote2(String value) {
        this.addressNote2 = value;
    }

    /**
     * Gets the value of the addressNote3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressNote3() {
        return addressNote3;
    }

    /**
     * Sets the value of the addressNote3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressNote3(String value) {
        this.addressNote3 = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNationality(BigInteger value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the idType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdType(BigInteger value) {
        this.idType = value;
    }

    /**
     * Gets the value of the passportno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassportno() {
        return passportno;
    }

    /**
     * Sets the value of the passportno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassportno(String value) {
        this.passportno = value;
    }

    /**
     * Gets the value of the socialSecNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocialSecNo() {
        return socialSecNo;
    }

    /**
     * Sets the value of the socialSecNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocialSecNo(String value) {
        this.socialSecNo = value;
    }

    /**
     * Gets the value of the driveLicenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriveLicenceNo() {
        return driveLicenceNo;
    }

    /**
     * Sets the value of the driveLicenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriveLicenceNo(String value) {
        this.driveLicenceNo = value;
    }

    /**
     * Gets the value of the companyRegNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyRegNo() {
        return companyRegNo;
    }

    /**
     * Sets the value of the companyRegNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyRegNo(String value) {
        this.companyRegNo = value;
    }

    /**
     * Gets the value of the companyTaxNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyTaxNo() {
        return companyTaxNo;
    }

    /**
     * Sets the value of the companyTaxNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyTaxNo(String value) {
        this.companyTaxNo = value;
    }

    /**
     * Gets the value of the isEmployee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEmployee() {
        return isEmployee;
    }

    /**
     * Sets the value of the isEmployee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEmployee(Boolean value) {
        this.isEmployee = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaritalStatus(BigInteger value) {
        this.maritalStatus = value;
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
     *         &lt;element name="role" maxOccurs="unbounded">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="B"/>
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="D"/>
     *               &lt;enumeration value="E"/>
     *               &lt;enumeration value="I"/>
     *               &lt;enumeration value="P"/>
     *               &lt;enumeration value="R"/>
     *               &lt;enumeration value="S"/>
     *               &lt;enumeration value="U"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "role"
    })
    public static class Roles {

        @XmlElement(required = true)
        protected List<String> role;

        /**
         * Gets the value of the role property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the role property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRole().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRole() {
            if (role == null) {
                role = new ArrayList<String>();
            }
            return this.role;
        }

    }

}
