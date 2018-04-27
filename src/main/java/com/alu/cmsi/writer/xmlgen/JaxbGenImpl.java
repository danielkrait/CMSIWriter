// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/xmlgen/JaxbGenImpl.java,v 1.13 2012/09/12 12:06:21 belbeze Exp $ 
 *------------------------------------------------------------------------------
 *   ALCATEL-LUCENT/France                           
 *------------------------------------------------------------------------------
 *   Copyright (c) 2010 ALCATEL-LUCENT - All rights reserved
 *------------------------------------------------------------------------------
 *   CREATION DATE: 16 aout 2010                          Author: tpeltier
 *------------------------------------------------------------------------------
 *
 *  HISTORY:
 *
 *         $Log: JaxbGenImpl.java,v $
 *         Revision 1.13  2012/09/12 12:06:21  belbeze
 *         Add OCC action for CMSIWriter
 *
 *         Revision 1.12  2012/08/03 08:13:06  belbeze
 *         Add ResourcesUpdate action for CMSIWriter
 *
 *         Revision 1.11  2012/02/16 13:42:44  lszabo
 *         CMSIWRiter 0.18: ContractTakeover operation.
 *
 *         Revision 1.10  2011/09/13 13:28:48  akker
 *         0.16 : add fonctions to insert a block of XMLs in cms_int for batch actions
 *
 *         Revision 1.9  2011/06/19 08:14:08  livernea
 *         GLI add getter and setter on DAO attribut
 *
 *         Revision 1.8  2010/12/16 16:35:24  peltier
 *         Add:
 *         - Method to make payments
 *
 *         Revision 1.7  2010/12/06 18:28:30  peltier
 *         Add:
 *         - Write in DB with UTF-8 mode
 *
 *         Revision 1.6  2010/12/06 17:15:42  aragrag
 *         update : force xml to UTF-8 encoding to support arabic language (for customer data update and create large account only)
 *
 *         Revision 1.5  2010/11/24 01:15:05  akker
 *         v 0.9-TEST:
 *         - adding the function for insertion in the table CMS_INT using a jdbc batch (for performances purposes : use only one connection)
 *         - close the prepared statement after each use
 *
 *         Revision 1.4  2010/10/16 16:02:48  peltier
 *         Update:
 *         - Oracle DAO => Change the connection method to the database
 *
 *         Revision 1.3  2010/10/12 12:16:03  peltier
 *         Add:
 *         - Oracle DAO => Function to get the next valid request id
 *         - Xml interface => Function to modify the access fee of a service
 *         Update:
 *         - Oracle DAO => Allows the caller to give the request id in CMSI parameters
 *
 *         Revision 1.2  2010/08/18 16:04:28  peltier
 *         Add:
 *         - getStatus feature => A procedure of XmlGeneratorI that allows to get the status of a given request id
 *         - getOutputArgs feature => A procedure of XmlGeneratorI that allows to get the status of a given request id
 *
 *         Revision 1.1  2010/08/17 09:58:25  peltier
 *         CMSI Writer:
 *         First commit
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.xmlgen;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer;
import com.alu.cmsi.writer.common.Action;
import com.alu.cmsi.writer.common.CMSIParameters;
import com.alu.cmsi.writer.common.CmsStatus;
import com.alu.cmsi.writer.common.OutputArguments;
import com.alu.cmsi.writer.config.ConfigurationException;
import com.alu.cmsi.writer.config.ConfigurationProperties;
import com.alu.cmsi.writer.dao.DAO;
import com.alu.cmsi.writer.dao.OracleDAOImpl;
import com.alu.cmsi.writer.dao.exception.CMSIParametersException;
import com.alu.cmsi.writer.dao.exception.DAOException;
import com.alu.cmsi.writer.xmlgen.exception.XmlGenException;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @version JaxbGenImpl.java
 * @version Created on 16 aout 2010, 18:44:45
 * @author tpeltier
 */
public class JaxbGenImpl implements XmlGeneratorI {

    /** The logger. */
    private final static Logger _log = Logger.getLogger(JaxbGenImpl.class);
    /** The DAO */
    private DAO dao = null;

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    /**
     * This method initializes the client.
     *
     * @param properties
     *            The mandatory properties are "cmsi.db.url", "cmsi.db.username", "cmsi.db.password".
     * 			  Important properties are: log4j appenders
     * @throws ConfigurationException
     * @throws DAOException
     */
    protected void initialize(Properties properties)
            throws ConfigurationException, DAOException {
        // Initialize the properties
        ConfigurationProperties.init(properties);
        ConfigurationProperties confP = ConfigurationProperties.getInstance();
        // Initiate the JDBC link
        dao = new OracleDAOImpl(confP.getDBURL(), confP.getDBLogin(), confP.getDBPassword());
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#createCustomerAndContract()
     */
    @SuppressWarnings("unchecked")
    public void createCustomerAndContract(
            com.alu.cmsi.writer.beans.createCustomer.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> createCustomerAndContract()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.customer.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.CREATE_CUSTOMER_AND_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= createCustomerAndContract()");
    }

    @SuppressWarnings("unchecked")
    public void createCustomerAndContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createCustomer.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> createCustomerAndContractUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();
        try {
            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.createCustomer.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.customer.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.createCustomer.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.createCustomer.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.CREATE_CUSTOMER_AND_CONTRACT_ACTION, inputDatas);
            _log.trace("<= createCustomerAndContractUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#addService(com.alu.cmsi.writer.beans.addServiceList.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void addService(
            com.alu.cmsi.writer.beans.addServiceList.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> addService()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../add.service.list.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.ADD_SERVICE_LIST_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= addService()");
    }

    @SuppressWarnings("unchecked")
    public void addServiceUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.addServiceList.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> addServiceUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.addServiceList.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../add.service.list.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.addServiceList.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.addServiceList.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.ADD_SERVICE_LIST_ACTION, inputDatas);
            _log.trace("<= addServiceUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#delService(com.alu.cmsi.writer.beans.delServiceList.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void delService(
            com.alu.cmsi.writer.beans.delServiceList.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> delService()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../del.service.list.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.DEL_SERVICE_LIST_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= delService()");
    }

    @SuppressWarnings("unchecked")
    public void delServiceUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.delServiceList.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> delServiceUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.delServiceList.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../del.service.list.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.delServiceList.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.delServiceList.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.DEL_SERVICE_LIST_ACTION, inputDatas);
            _log.trace("<= delServiceUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#changeRateplan(com.alu.cmsi.writer.beans.changeRateplan.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void changeRateplan(
            com.alu.cmsi.writer.beans.changeRateplan.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> changeRateplan()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.rateplan.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.MODIFY_CONTRACT_RATEPLAN_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= changeRateplan()");
    }

    @SuppressWarnings("unchecked")
    public void changeRateplanUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeRateplan.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> changeRateplanUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.changeRateplan.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.rateplan.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.changeRateplan.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.changeRateplan.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.MODIFY_CONTRACT_RATEPLAN_ACTION, inputDatas);
            _log.trace("<= changeRateplanUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }


    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#activateContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void activateContract(
            com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> activateContract()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.ACTIVATE_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= activateContract()");
    }

    @SuppressWarnings("unchecked")
    public void activateContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> activateContractUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.changeContractStatus.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");
            _log.trace(" Map rootElements.size() ==> "+rootElements.size());
            for (Entry<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            _log.trace("calling insertBatch() methods");
            dao.insertBatch(params, Action.ACTIVATE_CONTRACT_ACTION, inputDatas);
            _log.trace("<= activateContractUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#reactivateContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void reactivateContract(
            com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> reactivateContract()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.REACTIVATE_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= reactivateContract()");
    }

    @SuppressWarnings("unchecked")
    public void reactivateContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> reactivateContractUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.changeContractStatus.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.REACTIVATE_CONTRACT_ACTION, inputDatas);
            _log.trace("<= reactivateContractUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#suspendContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void suspendContract(
            com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> suspendContract()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.SUSPEND_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= suspendContract()");
    }

    @SuppressWarnings("unchecked")
    public void suspendContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> suspendContractUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.changeContractStatus.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.SUSPEND_CONTRACT_ACTION, inputDatas);
            _log.trace("<= suspendContractUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#deactivateContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void deactivateContract(
            com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> deactivateContract()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.DEACTIVATE_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= deactivateContract()");
    }

    @SuppressWarnings("unchecked")
    public void deactivateContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> deactivateContractUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.changeContractStatus.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../change.contract.status.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.DEACTIVATE_CONTRACT_ACTION, inputDatas);
            _log.trace("<= deactivateContractUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#createContract(com.alu.cmsi.writer.beans.createContract.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void createContract(
            com.alu.cmsi.writer.beans.createContract.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> createContract()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.contract.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.CREATE_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= createContract()");
    }

    @SuppressWarnings("unchecked")
    public void createContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createContract.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> createContractUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.createContract.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.contract.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.createContract.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.createContract.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.CREATE_CONTRACT_ACTION, inputDatas);
            _log.trace("<= createContractUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }


    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#createLargeAccount(com.alu.cmsi.writer.beans.createLargeAccount.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void createLargeAccount(
            com.alu.cmsi.writer.beans.createLargeAccount.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> createLargeAccount()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.large.account.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.CREATE_LARGE_ACCOUNT_AND_CONTRACT, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= createLargeAccount()");
    }

    @SuppressWarnings("unchecked")
    public void createLargeAccountUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createLargeAccount.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> createLargeAccountUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.createLargeAccount.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.large.account.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.createLargeAccount.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.createLargeAccount.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.CREATE_LARGE_ACCOUNT_AND_CONTRACT, inputDatas);
            _log.trace("<= createLargeAccountUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#createTickler(com.alu.cmsi.writer.beans.createTickler.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void createTickler(
            com.alu.cmsi.writer.beans.createTickler.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> createTickler()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.tickler.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.CREATE_TICKLER, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= createTickler()");
    }

    @SuppressWarnings("unchecked")
    public void createTicklerUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createTickler.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> createTicklerUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.createTickler.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../create.tickler.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.createTickler.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.createTickler.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.CREATE_TICKLER, inputDatas);
            _log.trace("<= createTicklerUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#modifyContractInformation(com.alu.cmsi.writer.beans.modifyContract.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void modifyContractInformation(
            com.alu.cmsi.writer.beans.modifyContract.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> modifyContractInformation()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.contract.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.MODIFY_CONTRACT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= modifyContractInformation()");
    }

    @SuppressWarnings("unchecked")
    public void modifyContractInformationUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyContract.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> modifyContractInformationUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.modifyContract.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.contract.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.modifyContract.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.modifyContract.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.MODIFY_CONTRACT_ACTION, inputDatas);
            _log.trace("<= modifyContractInformationUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#modifyContractServicePackage(com.alu.cmsi.writer.beans.modifyContract.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void modifyContractServicePackage(
            com.alu.cmsi.writer.beans.modifyContract.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> modifyContractServicePackage()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.contract.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.MODIFY_CONTRACT_PRODUCT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= modifyContractServicePackage()");
    }

    @SuppressWarnings("unchecked")
    public void modifyContractServicePackageUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyContract.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> modifyContractServicePackageUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.modifyContract.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.contract.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.modifyContract.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.modifyContract.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.MODIFY_CONTRACT_PRODUCT_ACTION, inputDatas);
            _log.trace("<= modifyContractServicePackageUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#modifyCustomerInformation(com.alu.cmsi.writer.beans.modifyCustomer.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void modifyCustomerInformation(
            com.alu.cmsi.writer.beans.modifyCustomer.Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> modifyCustomerInformation()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.customer.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.MODIFY_CUSTOMER_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= modifyCustomerInformation()");
    }

    @SuppressWarnings("unchecked")
    public void modifyCustomerInformationUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyCustomer.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> modifyContractServicePackageUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.modifyCustomer.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.customer.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.modifyCustomer.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.modifyCustomer.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.MODIFY_CUSTOMER_ACTION, inputDatas);
            _log.trace("<= modifyContractServicePackageUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#modifyServiceAccessFee(com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void modifyServiceAccessFee(Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> modifyServiceAccessFee()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.service.access.fee.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.MODIFY_SERVICE_ACCESS_FEE_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= modifyServiceAccessFee()");
    }

    @SuppressWarnings("unchecked")
    public void modifyServiceAccessFeeUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> modifyServiceAccessFeeUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../modify.service.access.fee.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.MODIFY_SERVICE_ACCESS_FEE_ACTION, inputDatas);
            _log.trace("<= modifyServiceAccessFeeUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#makePayment(com.alu.cmsi.writer.beans.payment.Payment, com.alu.cmsi.writer.common.CMSIParameters)
     */
    @SuppressWarnings("unchecked")
    public void makePayment(com.alu.cmsi.writer.beans.payment.Payment rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> makePayment()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../payment.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("payment"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.PAYMENT_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }
        _log.trace("<= makePayment()");
    }

    @SuppressWarnings("unchecked")
    public void makePaymentUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.payment.Payment> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> modifyServiceAccessFeeUsingBatch()");

        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.payment.Payment().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../payment.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.payment.Payment> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.payment.Payment rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("payment"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));
            }

            dao.insertBatch(params, Action.PAYMENT_ACTION, inputDatas);
            _log.trace("<= modifyServiceAccessFeeUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#getStatus(java.lang.Long)
     */
    @SuppressWarnings("unchecked")
    public CmsStatus getStatus(Long requestId) throws XmlGenException {
        _log.trace("=> getStatus()");

        CmsStatus status = null;
        OutputArguments out = this.getOutputArgs(requestId);
        if (out != null) {
            status = out.getStatus();
        }

        _log.trace("<= getStatus()");
        return status;
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#getOutputArgs(java.lang.Long)
     */
    public OutputArguments getOutputArgs(Long requestId) throws XmlGenException {
        _log.trace("=> getOutputArgs()");

        OutputArguments out = null;
        try {
            out = dao.getOutputArgs(requestId);
        } catch (DAOException e) {
            throw new XmlGenException(e);
        }

        _log.trace("<= getOutputArgs()");
        return out;
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#getNextRequestId()
     */
    public Long getNextRequestId() throws XmlGenException {
        _log.trace("=> getNextRequestId()");

        Long id = null;
        try {
            id = dao.getNextRequestId();
        } catch (DAOException e) {
            throw new XmlGenException(e);
        }

        _log.trace("<= getNextRequestId()");
        return id;
    }

    public void close() {
        try {
            _log.trace("=>close");
            dao.close();
        } catch (Exception ex) {
            _log.error(ex);
        }
        _log.trace("<=close");
    }

    public void contractTakeover(com.alu.cmsi.writer.beans.contractTakeover.Customer rootElement, CMSIParameters params) throws XmlGenException {
        _log.trace("=> contractTakeover()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../contract.takeover.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("customer"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.CONTRACT_TAKEOVER_ACTION, baos.toString("UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= contractTakeover()");

    }

    public void contractTakeoverUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.contractTakeover.Customer> rootElements, HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> contractTakeoverUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.contractTakeover.Customer().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../contract.takeover.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.contractTakeover.Customer> entry : rootElements.entrySet()) {

                com.alu.cmsi.writer.beans.contractTakeover.Customer rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("customer"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            dao.insertBatch(params, Action.CONTRACT_TAKEOVER_ACTION, inputDatas);
            _log.trace("<= contractTakeoverUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }

    }

    
    /**
     * Call Resources update by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    @SuppressWarnings("unchecked")
    public void resourceUpdate(com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE rootElement, CMSIParameters params) throws XmlGenException {
        _log.trace("=> resourceUpdate()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../resource.update.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("RESOURCES_UPDATE"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.RESOURCE_UPDATE_ACTION, baos.toString("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= resourceUpdate()");
    }

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    @SuppressWarnings("unchecked")
    public void resourceUpdateUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE> rootElements, HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> resourceUpdateUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {
            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../resource.update.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE> entry : rootElements.entrySet()) {
                com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("RESOURCES_UPDATE"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            if( dao != null ){
            	dao.insertBatch(params, Action.RESOURCE_UPDATE_ACTION, inputDatas);
            }else{
    			throw new DAOException("dao is null");
            }
            _log.trace("<= resourceUpdateUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
    }

    /**
     * Call OCC by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    @SuppressWarnings("unchecked")
    public void createOCC(com.alu.cmsi.writer.beans.occ.OccType rootElement, CMSIParameters params) throws XmlGenException {
        _log.trace("=> createOCC()");

        try {
            // Check given parameters
            params.checkParameters();

            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(rootElement.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../occ.xsd");

            // Create the tree element
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JAXBElement element = new JAXBElement(new QName("occ"),
                    rootElement.getClass(), null, rootElement);
            marshaller.marshal(element, baos);

            // Insert in database
            dao.insert(params, Action.OCC_ACTION, baos.toString("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException de) {
            throw new XmlGenException(de.getMessage());
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        }

        _log.trace("<= createOCC()");
    }

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    @SuppressWarnings("unchecked")
    public void createOCCUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.occ.OccType> rootElements, HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> createOCCUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        try {
            // Instantiate the marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(new com.alu.cmsi.writer.beans.occ.OccType().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "../occ.xsd");

            for (Entry<Long, com.alu.cmsi.writer.beans.occ.OccType> entry : rootElements.entrySet()) {
                com.alu.cmsi.writer.beans.occ.OccType rootElement = entry.getValue();
                Long loopId = entry.getKey();

                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

                // Create the tree element
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JAXBElement element = new JAXBElement(new QName("occ"), rootElement.getClass(), null, rootElement);
                marshaller.marshal(element, baos);
                inputDatas.put(loopId, baos.toString("UTF-8"));

            }
            if( dao != null ){
            	dao.insertBatch(params, Action.OCC_ACTION, inputDatas);
            }else{
    			throw new DAOException("dao is null");
            }
            _log.trace("<= createOCCUsingBatch()");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }
   }

}
