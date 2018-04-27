// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/xmlgen/JaxbGenImplV2.java,v 1.3 2012/09/12 12:06:21 belbeze Exp $ 
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
 *         $Log: JaxbGenImplV2.java,v $
 *         Revision 1.3  2012/09/12 12:06:21  belbeze
 *         Add OCC action for CMSIWriter
 *
 *         Revision 1.2  2012/08/03 08:13:06  belbeze
 *         Add ResourcesUpdate action for CMSIWriter
 *
 *         Revision 1.1  2011/06/19 08:14:32  livernea
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
import com.alu.cmsi.writer.xmlgen.pool.DaoPool;



import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @version JaxbGenImpl.java
 * @version Created on 16 aout 2010, 18:44:45
 * @author tpeltier
 */
public class JaxbGenImplV2 extends JaxbGenImpl implements XmlGeneratorI {

    /** The logger. */
    private final static Logger _log = Logger.getLogger(JaxbGenImplV2.class);
    
    private DaoPool daoPool;

	

    /**
     * This method initializes the client.
     *
     * @param properties
     *            The mandatory properties are "cmsi.db.url", "cmsi.db.username", "cmsi.db.password".
     * 			  Important properties are: log4j appenders
     * @throws ConfigurationException
     * @throws DAOException
     */
    public JaxbGenImplV2(DaoPool pool)
            throws ConfigurationException, DAOException {
    	this.daoPool=pool;
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
        DAO dao = null;
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.createCustomerAndContract(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= createCustomerAndContract()");
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
        DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.addService(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }
        _log.trace("<= addService()");
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
        DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.delService(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= delService()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.changeRateplan(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= changeRateplan()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.activateContract(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= activateContract()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.reactivateContract(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= reactivateContract()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.suspendContract(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= suspendContract()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.deactivateContract(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= deactivateContract()");
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
        DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.createContract(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= createContract()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.createLargeAccount(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= createLargeAccount()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.createTickler(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= createTickler()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.modifyContractInformation(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= modifyContractInformation()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.modifyContractServicePackage(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= modifyContractServicePackage()");
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
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.modifyCustomerInformation(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= modifyCustomerInformation()");
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#modifyServiceAccessFee(com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer, com.alu.cmsi.writer.common.CMSIParameters)
     */
    public void modifyServiceAccessFee(Customer rootElement,
            CMSIParameters params) throws XmlGenException {
        _log.trace("=> modifyServiceAccessFee()");
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.modifyServiceAccessFee(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }


        _log.trace("<= modifyServiceAccessFee()");
    }
    
    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#makePayment(com.alu.cmsi.writer.beans.payment.Payment, com.alu.cmsi.writer.common.CMSIParameters)
     */
    public void makePayment(com.alu.cmsi.writer.beans.payment.Payment rootElement, 
    		CMSIParameters params) throws XmlGenException {
    	_log.trace("=> makePayment()");
DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.makePayment(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

    	_log.trace("<= makePayment()");
	}

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.xmlgen.XmlGeneratorI#getStatus(java.lang.Long)
     */
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
        DAO dao = null;
        
        try {
        	dao = daoPool.popInstanceFromStack();
        	super.setDao(dao);
        	OutputArguments outputArguments = super.getOutputArgs(requestId);
        } catch (Exception e) {
            throw new XmlGenException(e);
        }finally{
        	daoPool.pushInstanceToStack(dao);
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
        DAO dao = null;
        
        try {
        	dao = daoPool.popInstanceFromStack();
        	super.setDao(dao);
            id = super.getNextRequestId();
        } catch (Exception e) {
        	_log.trace(e);
            throw new XmlGenException(e);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= getNextRequestId()");
        return id;
    }


    public void createCustomerAndContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createCustomer.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {

        HashMap<Long, String> inputDatas = new HashMap<Long, String>();
        
        for (Entry<Long, com.alu.cmsi.writer.beans.createCustomer.Customer> entry : rootElements.entrySet()) {
            
            com.alu.cmsi.writer.beans.createCustomer.Customer rootElement = entry.getValue();
            Long loopId = entry.getKey();

            try {
                // Check given parameters
                CMSIParameters param = params.get(loopId);
                param.checkParameters();

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
                inputDatas.put(loopId, baos.toString("UTF-8"));
                
            } catch (UnsupportedEncodingException ex) {
                java.util.logging.Logger.getLogger(JaxbGenImplV2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CMSIParametersException cpe) {
                throw new XmlGenException(cpe.getMessage());
            } catch (JAXBException je) {
                throw new XmlGenException(je.getMessage());
            }

        }
        
        DAO dao = null;
        
        try {
            dao.insertBatch(params, Action.CREATE_CUSTOMER_AND_CONTRACT_ACTION, inputDatas);
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        } catch (CMSIParametersException ex) {
            throw new XmlGenException(ex.getMessage());
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }
    }

    
    public void resourceUpdate(com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE rootElement, CMSIParameters params) throws XmlGenException {
        _log.trace("=> v2:resourceUpdate()");

        DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.resourceUpdate(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= v2:resourceUpdate()");
    }

    
    @SuppressWarnings("unchecked")
    public void resourceUpdateUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> v2:resourceUpdateUsingBatch()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        DAO dao = null;

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
	
        	dao = daoPool.popInstanceFromStack();
        	super.setDao(dao);
        	dao.insertBatch(params, Action.RESOURCE_UPDATE_ACTION, inputDatas);
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= v2:resourceUpdateUsingBatch()");
    }

    
    public void createOCC(com.alu.cmsi.writer.beans.occ.OccType rootElement, CMSIParameters params) throws XmlGenException {
        _log.trace("=> v2:createOCC()");

        DAO dao = null;
        
        try {
            // Insert in database
            dao = daoPool.popInstanceFromStack();
            super.setDao(dao);
            super.createOCC(rootElement,params);
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= v2:createOCC()");
    }

    
    @SuppressWarnings("unchecked")
    public void createOCCUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.occ.OccType> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException {
        _log.trace("=> v2:createOCC()");
        HashMap<Long, String> inputDatas = new HashMap<Long, String>();

        DAO dao = null;

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
	
        	dao = daoPool.popInstanceFromStack();
        	super.setDao(dao);
        	dao.insertBatch(params, Action.OCC_ACTION, inputDatas);
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(JaxbGenImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CMSIParametersException cpe) {
            throw new XmlGenException(cpe.getMessage());
        } catch (JAXBException je) {
            throw new XmlGenException(je.getMessage());
        } catch (DAOException ex) {
            throw new XmlGenException(ex.getMessage());
        }finally{
        	daoPool.pushInstanceToStack(dao);
        }

        _log.trace("<= v2:createOCC()");
    }

    
    /*synchronized public void setClose(boolean b) {
		_log.trace("=> close");
		close = true;
		_log.trace("<= close");
	}*/
    
    /*public void close() throws DAOException{
    	_log.trace("close");
    	dao.close();
    }*/

	private void shutdown()
	{
		/*xmlGeneratorPool.removeInstanceToStack(this);
		//_log.trace("ClientJaxbGenImpl-"+this.getId()+" closing");
		_log.trace("ClientJaxbGenImpl- closing");*/
		
	}

	
}
