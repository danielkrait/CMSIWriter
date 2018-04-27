// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/xmlgen/XmlGFactoryV2.java,v 1.2 2011/06/21 09:53:22 livernea Exp $ 
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
 *         $Log: XmlGFactoryV2.java,v $
 *         Revision 1.2  2011/06/21 09:53:22  livernea
 *         GLI to manage a pool
 *
 *         Revision 1.1  2011/06/19 08:14:32  livernea
 *         GLI add getter and setter on DAO attribut
 *
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
import com.alu.cmsi.writer.config.ConfigurationProperties;
import com.alu.cmsi.writer.dao.exception.DAOException;
import com.alu.cmsi.writer.xmlgen.pool.DaoPool;

/**
 * @version XmlGFactory.java
 * @version Created on 16 aout 2010, 18:46:07
 * @author tpeltier
 */
public class XmlGFactoryV2 
{
	/** The logger. */
	private final static Logger _log = Logger.getLogger(XmlGFactoryV2.class);

	
	DaoPool pool = null;
	
	private static XmlGFactoryV2 xmlGFactoryInstance = null;
	
	
	public XmlGFactoryV2 getInstance() throws Exception{
		if(xmlGFactoryInstance==null){
			throw new Exception("The object is not instancied");
		}
		return xmlGFactoryInstance;
	}
	/**
	 * This method constructs a new instance of this class. It is private to avoid direct
	 * instantiation.
	 * @throws ConfigurationException 
	 * @throws DAOException 
	 */
	public XmlGFactoryV2 (Properties properties) throws ConfigurationException, DAOException{
		_log.trace("=> XmlGFactory()");
		
		if(xmlGFactoryInstance!=null){
			throw new DAOException("The object is already instancied");
		}
		pool = new DaoPool(properties); 
		
		//ConfigurationProperties.init(properties);
		//ConfigurationProperties  confP = ConfigurationProperties.getInstance();
	    
		_log.trace("the pool will be init");
		for(int i=0;i<pool.getMaxActiveThreads();i++){
			pool.addNewInstanceToStack();
			_log.trace("Element ("+i+")is pool is added");
		}
		_log.trace("the pool will is init");
		_log.trace("<= XmlGFactory()");
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
	/*public XmlGeneratorI createXmlGenerator(Properties properties) 
		throws ConfigurationException, DAOException
	{
		_log.trace("=> createXmlGenerator()");
		
		XmlGeneratorI client = new JaxbGenImplV2(pool);
		
		//client.initialize(properties);
		
		_log.trace("<= createXmlGenerator()");
		return client;
	}*/
	
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
	public XmlGeneratorI getXmlGenerator() 
		throws ConfigurationException, DAOException
	{
		_log.trace("=> createXmlGenerator()");
		
		XmlGeneratorI client = new JaxbGenImplV2(pool);
		
		//client.initialize(properties);
		
		_log.trace("<= createXmlGenerator()");
		return client;
	}
	
}