// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/xmlgen/XmlGFactory.java,v 1.2 2010/10/16 16:02:48 peltier Exp $ 
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
 *         $Log: XmlGFactory.java,v $
 *         Revision 1.2  2010/10/16 16:02:48  peltier
 *         Update:
 *         - Oracle DAO => Change the connection method to the database
 *
 *         Revision 1.1  2010/08/17 09:58:25  peltier
 *         CMSI Writer:
 *         First commit
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.xmlgen;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.alu.cmsi.writer.config.ConfigurationException;
import com.alu.cmsi.writer.dao.exception.DAOException;

/**
 * @version XmlGFactory.java
 * @version Created on 16 aout 2010, 18:46:07
 * @author tpeltier
 */
public class XmlGFactory 
{
	/** The logger. */
	private final static Logger _log = Logger.getLogger(XmlGFactory.class);

	/** The singleton instance of this class. */
	private static XmlGFactory _instance = null;
	
	/**
	 * This method constructs a new instance of this class. It is private to avoid direct
	 * instantiation.
	 */
	private XmlGFactory ()
	{
		_log.trace("=> XmlGFactory()");
		_log.trace("<= XmlGFactory()");
	}
	
	/**
	 * This method gets the singleton instance of this class.
	 * 
	 * @return The singleton XmlGFactory instance.
	 */
	public static XmlGFactory getInstance()
	{
		_log.trace("=> getInstance()");

		if (_instance == null)
		{
			_instance = new XmlGFactory();
		}

		_log.trace("<= getInstance()");
		return _instance;
	}
	
	/**
	 * This method gets the instance of the XmlGenerator client
	 * 
	 * @param properties 
	 * 		To initialize the client. 
	 * 		The mandatory properties are "cmsi.db.url", "cmsi.db.username", "cmsi.db.password".
	 * 		Important properties are: log4j appenders
	 * @return The initialized client.
	 * @throws DAOException 
	 * @throws ConfigurationException 
	 */
	public XmlGeneratorI createXmlGenerator(Properties properties) 
		throws ConfigurationException, DAOException
	{
		_log.trace("=> createXmlGenerator()");
		
		JaxbGenImpl client = new JaxbGenImpl();
		
		client.initialize(properties);
		
		_log.trace("<= createXmlGenerator()");
		return client;
	}
}