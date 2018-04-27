// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/common/OutputArguments.java,v 1.2 2011/01/04 15:34:41 peltier Exp $ 
 *------------------------------------------------------------------------------
 *   ALCATEL-LUCENT/France                           
 *------------------------------------------------------------------------------
 *   Copyright (c) 2010 ALCATEL-LUCENT - All rights reserved
 *------------------------------------------------------------------------------
 *   CREATION DATE: 18 aout 2010                          Author: tpeltier
 *------------------------------------------------------------------------------
 *
 *  HISTORY:
 *
 *         $Log: OutputArguments.java,v $
 *         Revision 1.2  2011/01/04 15:34:41  peltier
 *         Add:
 *         - Parameter 'cmsi.parent.request.id.activated' is a new configuration item
 *         Update:
 *         - insert() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - insertBatch() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - DAO closes correctly the preparedStatements
 *         - Clob is now displayed as a correct String
 *
 *         Revision 1.1  2010/08/18 16:04:28  peltier
 *         Add:
 *         - getStatus feature => A procedure of XmlGeneratorI that allows to get the status of a given request id
 *         - getOutputArgs feature => A procedure of XmlGeneratorI that allows to get the status of a given request id
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @version Output.java
 * @version Created on 18 aout 2010, 15:57:14
 * @author tpeltier
 */
public class OutputArguments implements Serializable 
{
	/** Id used for serialization. */
	private static final long serialVersionUID = 447766728024236249L;
	
	private Long requestId;
	private CmsStatus status;
	
	/** The insertion date of the request. */
	private Date insertionDate;
	
	/** The last update date of the request. */
	private Date lastUpdateDate;
	
	/** 
	 * The error message.
	 * Set only if status is failure.
	 */
	private String errorMessage;
	
	/** 
	 * The output data.
	 * Set only if status is success.
	 */
	private String outputData;

	/**
	 * Retrieves the identifier of the request in CMS Interface.
	 * 
	 * @return the request identifier
	 */
	public Long getRequestId() {
		return requestId;
	}

	/**
	 * Sets the request identifier.
	 * 
	 * @param requestId the request id to set
	 */
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	/**
	 * Retrieves the status of the request.
	 * 
	 * @return the status
	 */
	public CmsStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(CmsStatus status) {
		this.status = status;
	}
	
	/**
	 * Sets the status.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = CmsStatus.getCmsStatus(status);
	}

	/**
	 * Retrieves the date of insertion in CMS Interface.
	 * 
	 * @return the insertionDate
	 */
	public Date getInsertionDate() {
		return insertionDate;
	}

	/**
	 * Sets the date of insertion.
	 * 
	 * @param insertionDate the insertion date to set
	 */
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	/**
	 * Retrieves the date of last modification of the request in CMS Interface.
	 *  
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * Sets the last modification date.
	 * 
	 * @param lastUpdateDate the last update date to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * Retrieves the error message when an error has occurred 
	 * while processing the request in CMS Interface.
	 * This field is empty if status is not PROCESS_NOK.
	 * 
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 * 
	 * @param errorMessage the error message to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Retrieves the output information if no error occurred while
	 * processing the request in CMS Interface.
	 * This field is empty if status is not PROCESS_OK.
	 * 
	 * @return the outputData
	 */
	public String getOutputData() {
		return outputData;
	}

	/**
	 * Sets the output information.
	 * 
	 * @param outputData the output data to set
	 */
	public void setOutputData(String outputData) {
		this.outputData = outputData;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result = result.append("\nRequest Id: " + requestId);
		result = result.append("\nStatus: " + status.toString());
		result = result.append("\nInsertion Date: " + insertionDate.toString());
		result = result.append("\nLast Update Date: " + lastUpdateDate.toString());
		if (errorMessage != null) result = result.append("\nError Message: " + errorMessage);
		if (outputData != null) result = result.append("\nOutput Data: " + outputData);
		return result.toString();
	}
}