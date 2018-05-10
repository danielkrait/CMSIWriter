//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.1-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.10 at 11:25:31 PM EEST 
//


package com.alu.cmsi.writer.beans.occ;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.alu.cmsi.writer.beans.occ package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Occ_QNAME = new QName("", "occ");
    private final static QName _ParameterTypeDes_QNAME = new QName("", "des");
    private final static QName _ParameterTypeValue_QNAME = new QName("", "value");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.alu.cmsi.writer.beans.occ
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MoneyType }
     * 
     */
    public MoneyType createMoneyType() {
        return new MoneyType();
    }

    /**
     * Create an instance of {@link OccType }
     * 
     */
    public OccType createOccType() {
        return new OccType();
    }

    /**
     * Create an instance of {@link CustomerAddressForModification }
     * 
     */
    public CustomerAddressForModification createCustomerAddressForModification() {
        return new CustomerAddressForModification();
    }

    /**
     * Create an instance of {@link ContractType.InstallationAddress }
     * 
     */
    public ContractType.InstallationAddress createContractTypeInstallationAddress() {
        return new ContractType.InstallationAddress();
    }

    /**
     * Create an instance of {@link BsgType }
     * 
     */
    public BsgType createBsgType() {
        return new BsgType();
    }

    /**
     * Create an instance of {@link ParameterType }
     * 
     */
    public ParameterType createParameterType() {
        return new ParameterType();
    }

    /**
     * Create an instance of {@link TaxExemptionType }
     * 
     */
    public TaxExemptionType createTaxExemptionType() {
        return new TaxExemptionType();
    }

    /**
     * Create an instance of {@link ContractType }
     * 
     */
    public ContractType createContractType() {
        return new ContractType();
    }

    /**
     * Create an instance of {@link CustomerAddress }
     * 
     */
    public CustomerAddress createCustomerAddress() {
        return new CustomerAddress();
    }

    /**
     * Create an instance of {@link ServiceType }
     * 
     */
    public ServiceType createServiceType() {
        return new ServiceType();
    }

    /**
     * Create an instance of {@link PortType }
     * 
     */
    public PortType createPortType() {
        return new PortType();
    }

    /**
     * Create an instance of {@link ServiceType.DirectoryNumber }
     * 
     */
    public ServiceType.DirectoryNumber createServiceTypeDirectoryNumber() {
        return new ServiceType.DirectoryNumber();
    }

    /**
     * Create an instance of {@link ContractIdType }
     * 
     */
    public ContractIdType createContractIdType() {
        return new ContractIdType();
    }

    /**
     * Create an instance of {@link CustIdType }
     * 
     */
    public CustIdType createCustIdType() {
        return new CustIdType();
    }

    /**
     * Create an instance of {@link CustomerAddress.Roles }
     * 
     */
    public CustomerAddress.Roles createCustomerAddressRoles() {
        return new CustomerAddress.Roles();
    }

    /**
     * Create an instance of {@link BillingAccountType }
     * 
     */
    public BillingAccountType createBillingAccountType() {
        return new BillingAccountType();
    }

    /**
     * Create an instance of {@link CugType }
     * 
     */
    public CugType createCugType() {
        return new CugType();
    }

    /**
     * Create an instance of {@link ContractType.AdditionalInfo }
     * 
     */
    public ContractType.AdditionalInfo createContractTypeAdditionalInfo() {
        return new ContractType.AdditionalInfo();
    }

    /**
     * Create an instance of {@link CugElementType }
     * 
     */
    public CugElementType createCugElementType() {
        return new CugElementType();
    }

    /**
     * Create an instance of {@link CustomerAddressForModification.Roles }
     * 
     */
    public CustomerAddressForModification.Roles createCustomerAddressForModificationRoles() {
        return new CustomerAddressForModification.Roles();
    }

    /**
     * Create an instance of {@link ContractType.Device }
     * 
     */
    public ContractType.Device createContractTypeDevice() {
        return new ContractType.Device();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OccType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "occ")
    public JAXBElement<OccType> createOcc(OccType value) {
        return new JAXBElement<OccType>(_Occ_QNAME, OccType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "des", scope = ParameterType.class)
    public JAXBElement<String> createParameterTypeDes(String value) {
        return new JAXBElement<String>(_ParameterTypeDes_QNAME, String.class, ParameterType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "value", scope = ParameterType.class)
    public JAXBElement<String> createParameterTypeValue(String value) {
        return new JAXBElement<String>(_ParameterTypeValue_QNAME, String.class, ParameterType.class, value);
    }

}
