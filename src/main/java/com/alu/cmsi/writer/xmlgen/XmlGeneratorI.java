// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/xmlgen/XmlGeneratorI.java,v 1.9 2012/09/12 12:06:21 belbeze Exp $ 
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
 *         $Log: XmlGeneratorI.java,v $
 *         Revision 1.9  2012/09/12 12:06:21  belbeze
 *         Add OCC action for CMSIWriter
 *
 *         Revision 1.8  2012/08/03 08:13:06  belbeze
 *         Add ResourcesUpdate action for CMSIWriter
 *
 *         Revision 1.7  2012/02/16 13:42:44  lszabo
 *         CMSIWRiter 0.18: ContractTakeover operation.
 *
 *         Revision 1.6  2011/09/13 13:28:48  akker
 *         0.16 : add fonctions to insert a block of XMLs in cms_int for batch actions
 *
 *         Revision 1.5  2010/12/16 16:35:24  peltier
 *         Add:
 *         - Method to make payments
 *
 *         Revision 1.4  2010/11/24 01:15:05  akker
 *         v 0.9-TEST:
 *         - adding the function for insertion in the table CMS_INT using a jdbc batch (for performances purposes : use only one connection)
 *         - close the prepared statement after each use
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

import com.alu.cmsi.writer.common.CMSIParameters;
import com.alu.cmsi.writer.common.CmsStatus;
import com.alu.cmsi.writer.common.OutputArguments;
import com.alu.cmsi.writer.xmlgen.exception.XmlGenException;
import java.util.HashMap;

/**
 * @version XmlGeneratorI.java
 * @version Created on 16 aout 2010, 18:45:28
 * @author tpeltier
 */
public interface XmlGeneratorI {

    /**
     * Create customer and contracts by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void createCustomerAndContract(com.alu.cmsi.writer.beans.createCustomer.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * This method is used for performance manner => we use the JDBC batch to insert
     * the entries into CMS Interface in one shot for add service
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void addService(com.alu.cmsi.writer.beans.addServiceList.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void addServiceUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.addServiceList.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Remove a list of services from a contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void delService(com.alu.cmsi.writer.beans.delServiceList.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void delServiceUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.delServiceList.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Change the rateplan of a contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void changeRateplan(com.alu.cmsi.writer.beans.changeRateplan.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void changeRateplanUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeRateplan.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Create the contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void createContract(com.alu.cmsi.writer.beans.createContract.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void createContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createContract.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Activate the contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void activateContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void activateContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Suspend the contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void suspendContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void suspendContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Reactivate the contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void reactivateContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void reactivateContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Deactivate the contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void deactivateContract(com.alu.cmsi.writer.beans.changeContractStatus.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void deactivateContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.changeContractStatus.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Modify the service package
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void modifyContractServicePackage(com.alu.cmsi.writer.beans.modifyContract.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void modifyContractServicePackageUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyContract.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Modify the customer information by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void modifyCustomerInformation(com.alu.cmsi.writer.beans.modifyCustomer.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * Create the customer into a large account by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void createLargeAccount(com.alu.cmsi.writer.beans.createLargeAccount.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void createLargeAccountUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createLargeAccount.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Create a memo by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void createTickler(com.alu.cmsi.writer.beans.createTickler.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * Create a list of memos using CMSInterface
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void createTicklerUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createTickler.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Modify the or the additional information of the contract
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void modifyContractInformation(com.alu.cmsi.writer.beans.modifyContract.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void modifyContractInformationUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyContract.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void modifyCustomerInformationUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyCustomer.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Modify the access fee of a service
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void modifyServiceAccessFee(com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void modifyServiceAccessFeeUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.modifyServiceAccessFee.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Make a payment
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void makePayment(com.alu.cmsi.writer.beans.payment.Payment rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     * 
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void makePaymentUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.payment.Payment> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Suspend the contract by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void contractTakeover(com.alu.cmsi.writer.beans.contractTakeover.Customer rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void contractTakeoverUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.contractTakeover.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Call Resources update by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void resourceUpdate(com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void resourceUpdateUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Call OCC by using CMSInterface
     *
     * @param rootElement
     * @param params
     * @throws XmlGenException
     */
    void createOCC(com.alu.cmsi.writer.beans.occ.OccType rootElement, CMSIParameters params)
            throws XmlGenException;

    /**
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void createOCCUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.occ.OccType> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;

    /**
     * Gets the status of the given CMSI request identifier
     *
     * @param requestId
     * 			The request identifier in CMS Interface table
     * @return The status
     * @throws XmlGenException
     */
    CmsStatus getStatus(Long requestId) throws XmlGenException;

    /**
     * Gets the output arguments of the given CMSI request identifier
     *
     * @param requestId
     * 			The request identifier in CMS Interface table
     * @return The output arguments
     * @throws XmlGenException
     */
    OutputArguments getOutputArgs(Long requestId) throws XmlGenException;

    /**
     * Gets the next valid request id from the sequence
     *
     * @return The request identifier of CMS Interface table
     * @throws XmlGenException
     */
    Long getNextRequestId() throws XmlGenException;

    /**
     * This method is used for performance manner => we use the JDBC batch to insert
     * the entries into CMS Interface in one shot
     *
     * @param rootElements
     * @param params
     * @throws XmlGenException
     */
    void createCustomerAndContractUsingBatch(HashMap<Long, com.alu.cmsi.writer.beans.createCustomer.Customer> rootElements,
            HashMap<Long, CMSIParameters> params) throws XmlGenException;
}
