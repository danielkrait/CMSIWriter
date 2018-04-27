// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/common/CMSIParameters.java,v 1.3 2011/11/21 14:55:32 jpbolatre Exp $ 
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
 *         $Log: CMSIParameters.java,v $
 *         Revision 1.3  2011/11/21 14:55:32  jpbolatre
 *         Update insert & insertBatch methods to insert the additionalInfo column
 *
 *         Revision 1.2  2010/10/12 12:16:03  peltier
 *         Add:
 *         - Oracle DAO => Function to get the next valid request id
 *         - Xml interface => Function to modify the access fee of a service
 *         Update:
 *         - Oracle DAO => Allows the caller to give the request id in CMSI parameters
 *
 *         Revision 1.1  2010/08/17 09:58:25  peltier
 *         CMSI Writer:
 *         First commit
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.common;

import java.util.Date;

import com.alu.cmsi.writer.dao.exception.CMSIParametersException;

/**
 * @version CMSIParameters.java
 * @version Created on 16 aout 2010, 18:30:10
 * @author tpeltier
 */
public class CMSIParameters 
{
	/** The different static values for priority. */
	public static Long LOW_PRIORITY = new Long(1);
	public static Long MEDIUM_PRIORITY = new Long(5);
	public static Long HIGH_PRIORITY = new Long(10);
	
	/**
	 * Not mandatory
	 * If not defined, the sequence will be used anyway.
	 */
	private Long requestId;
	
	/**
	 * Mandatory
	 * Defines the original application which wants to insert in CMSI
	 */
	private String origin;
	
	/**
	 * Not mandatory
	 * Defines the external id of the calling application
	 */
	private Long originalId;
	
	/**
	 * Not mandatory
	 * Defines the priority to be applied on the action.
	 * If not specified, the LOW_PRIORITY value will be applied.
	 */
	private Long priority;
	
	/**
	 * Not mandatory
	 * If not specified, the current date will be inserted.
	 * If specified, the action will not be processed by CMSI before this date is reached.
	 */
	private Date insertionDate;
	
	/**
	 * Not mandatory
	 * Defines the request that should be processed before this one.
	 * The CMS Interface should be configured accordingly.
	 */
	private Long parentRequestId;
	
	/**
	 * Not mandatory
	 */
	private String additionalInfo;
	
	/**
	 * Not mandatory
	 * If not defined, the sequence will be used anyway.
	 * @param requestId
	 */
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the request id
	 */
	public Long getRequestId() {
		return requestId;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Mandatory
	 * Defines the original application which wants to insert in CMSI
	 * @param origin The origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Get the external id of the calling application if specified.
	 * Get the null value if not specified.
	 * 
	 * @return the originalId
	 */
	public Long getOriginalId() {
		return originalId;
	}

	/**
	 * Not mandatory
	 * Defines the external id of the calling application
	 * 
	 * @param originalId The original id to set
	 */
	public void setOriginalId(Long originalId) {
		this.originalId = originalId;
	}

	/**
	 * Get the priority.
	 * Get the lowest priority if null.
	 * 
	 * @return the priority
	 */
	public Long getPriority() {
		if (priority == null) {
			return LOW_PRIORITY;
		} else {
			return priority;
		}
	}

	/**
	 * Not mandatory
	 * Defines the priority of the action.
	 * 
	 * @param priority The priority to set
	 */
	public void setPriority(Long priority) {
		this.priority = priority;
	}

	/**
	 * Get the insertion date if specified.
	 * Get the current date if null.
	 * 
	 * @return the insertionDate
	 */
	public Date getInsertionDate() {
		if (insertionDate == null) {
			return new Date();
		} else { 
			return insertionDate;
		}
	}

	/** 
	 * Not mandatory
	 * If not specified, the current date will be inserted.
	 * If specified, the action will not be processed by CMSI before this date is reached.
	 * 
	 * @param insertionDate The insertion date to set
	 */
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	/**
	 * Get the parent request identifier.
	 * 
	 * @return the parentRequestId
	 */
	public Long getParentRequestId() {
		return parentRequestId;
	}

	/**
	 * Not mandatory
	 * If specified, the action won't be processed until the parent request is. 
	 * The CMS Interface should be configured accordingly.
	 * 
	 * @param parentRequestId
	 */
	public void setParentRequestId(Long parentRequestId) {
		this.parentRequestId = parentRequestId;
	}
	
	/**
	 * @return the additionalInfo
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	/**
	 * Uses to check if parameters are well set.
	 * @return true if all parameters are correctly set
	 * @throws CMSIParametersException when a parameter is missing
	 */
	public boolean checkParameters() throws CMSIParametersException
	{
		if (this.origin == null)
		{
			throw new CMSIParametersException("Missing parameter: Origin");
		}
		return true;
	}
}