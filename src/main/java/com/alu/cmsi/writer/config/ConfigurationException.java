// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/config/ConfigurationException.java,v 1.1 2010/08/17 09:58:25 peltier Exp $ 
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
 *         $Log: ConfigurationException.java,v $
 *         Revision 1.1  2010/08/17 09:58:25  peltier
 *         CMSI Writer:
 *         First commit
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.config;

/**
 * @version ConfigurationException.java
 * @version Created on 16 aout 2010, 18:31:36
 * @author tpeltier
 */
public class ConfigurationException extends Exception
{
	/** Id used for serialization */
	private static final long serialVersionUID = -3127581963926571313L;

	/**
	 * Constructs a new exception with a detail message.
	 * 
	 * @param msg
	 *            The detail message.
	 */
	public ConfigurationException(String msg)
    {
        super(msg);
    }
	
	/**
	 * Constructs a new exception with a cause.
	 * 
	 * @param cause
	 *            The cause.
	 */
	public ConfigurationException(Throwable cause)
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
	public ConfigurationException(String msg, Throwable cause)
	{
		super(msg, cause);
	}
}