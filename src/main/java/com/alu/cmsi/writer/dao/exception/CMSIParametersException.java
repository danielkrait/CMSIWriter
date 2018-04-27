// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/dao/exception/CMSIParametersException.java,v 1.1 2010/08/17 09:58:25 peltier Exp $ 
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
 *         $Log: CMSIParametersException.java,v $
 *         Revision 1.1  2010/08/17 09:58:25  peltier
 *         CMSI Writer:
 *         First commit
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.dao.exception;

/**
 * @version CMSIParametersException.java
 * @version Created on 16 aout 2010, 18:40:13
 * @author tpeltier
 */
public class CMSIParametersException extends Exception
{
	/** Id used for serialization */
	private static final long serialVersionUID = -564547718489900183L;

	/**
	 * Constructs a new exception with a detail message.
	 * 
	 * @param msg
	 *            The detail message.
	 */
	public CMSIParametersException(String msg)
    {
        super(msg);
    }
	
	/**
	 * Constructs a new exception with a cause.
	 * 
	 * @param cause
	 *            The cause.
	 */
	public CMSIParametersException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Constructs a new exception with a detail message and a cause.
	 * 
	 * @param msg
	 *            The detail message.
	 * @param cause
	 *            The cause.
	 */
	public CMSIParametersException(String msg, Throwable cause)
	{
		super(msg, cause);
	}
}