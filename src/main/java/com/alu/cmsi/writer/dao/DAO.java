// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/dao/DAO.java,v 1.6 2011/06/19 08:15:07 livernea Exp $ 
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
 *         $Log: DAO.java,v $
 *         Revision 1.6  2011/06/19 08:15:07  livernea
 *         GLI add api
 *
 *         Revision 1.5  2011/01/04 15:34:41  peltier
 *         Add:
 *         - Parameter 'cmsi.parent.request.id.activated' is a new configuration item
 *         Update:
 *         - insert() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - insertBatch() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - DAO closes correctly the preparedStatements
 *         - Clob is now displayed as a correct String
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
package com.alu.cmsi.writer.dao;

import java.util.HashMap;

import com.alu.cmsi.writer.common.CMSIParameters;
import com.alu.cmsi.writer.common.OutputArguments;
import com.alu.cmsi.writer.dao.exception.CMSIParametersException;
import com.alu.cmsi.writer.dao.exception.DAOException;

/**
 * @version DAO.java
 * @version Created on 16 aout 2010, 18:37:58
 * @author tpeltier
 */
public interface DAO {

    /**
     * Makes a new record in CMS_INT table.
     *
     * @param params
     * 			The parameters of the new record
     * @param actionId
     * 			The action id to be inserted
     * @param inputData
     * 			The XML data
     * @return 1 if success, 0 if failure
     * @throws DAOException
     * 			In case of database access exception
     * @throws CMSIParametersException
     * 			In case of incorrect parameters
     */
    int insert(CMSIParameters params, Long actionId, String inputData)
            throws DAOException, CMSIParametersException;

    /**
     * Gets the output arguments of a record in CMS_INT table
     *
     * @param requestId
     * 			The record to be checked
     * @return The output arguments of the given record
     * @throws DAOException
     * 			In case of database access exception
     */
    OutputArguments getOutputArgs(Long requestId)
            throws DAOException;

    /**
     * Returns the next valid request id from the sequence of CMS_INT table
     *
     * @return The request id
     * @throws DAOException
     * 			In case of database access exception
     */
    Long getNextRequestId()
            throws DAOException;

    /**
     * Makes new records in CMS_INT table.
     * 
     * @param params
     * 			The parameters of the new records
     * @param actionId
     * 			The action id to be inserted
     * @param inputDatas
     * 			The XML data
     * @return 1 if success, 0 if failure
     * @throws DAOException
     * 			In case of database access exception
     * @throws CMSIParametersException
     * 			In case of incorrect parameters
     */
    public int [] insertBatch(HashMap<Long, CMSIParameters> params, Long actionId,
            HashMap<Long, String> inputDatas) throws DAOException, CMSIParametersException;
    
    public void close() throws DAOException ;
    
    public void reconnection() throws DAOException;
    
    
    public boolean isValid();
        
}
