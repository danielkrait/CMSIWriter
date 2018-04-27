// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/config/ConfigurationProperties.java,v 1.4 2011/06/21 09:53:22 livernea Exp $ 
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
 *         $Log: ConfigurationProperties.java,v $
 *         Revision 1.4  2011/06/21 09:53:22  livernea
 *         GLI to manage a pool
 *
 *         Revision 1.3  2011/06/19 08:16:45  livernea
 *         GLI add new properties to init the size of the pool
 *
 *         Revision 1.2  2011/01/04 15:34:41  peltier
 *         Add:
 *         - Parameter 'cmsi.parent.request.id.activated' is a new configuration item
 *         Update:
 *         - insert() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - insertBatch() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - DAO closes correctly the preparedStatements
 *         - Clob is now displayed as a correct String
 *
 *         Revision 1.1  2010/08/17 09:58:25  peltier
 *         CMSI Writer:
 *         First commit
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.config;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * @version ConfigurationProperties.java
 * @version Created on 16 aout 2010, 18:36:45
 * @author tpeltier
 */
public class ConfigurationProperties 
{
	public static String CMSI_DB_URL = "cmsi.db.url";
	public static String CMSI_DB_USERNAME = "cmsi.db.username";
	public static String CMSI_DB_PASSWORD = "cmsi.db.password";
	public static String CMSI_DB_POOLSIZE = "cmsi.db.poolSize";
	
	private static String CMSI_PARENT_REQ_ID = "cmsi.parent.request.id.activated";
	
	private static ConfigurationProperties instance = null;
	
	private String DBURL;
    private String DBLogin;
    private String DBPassword;
    private int poolSize;
    
    // Default value is true
    private boolean parentReqIdActivated = true;
        
    /**
     * Constructor is private.
     * 
     * @param properties
     * @throws ConfigurationException
     */
    private ConfigurationProperties(Properties properties) throws ConfigurationException
    {
    	// Mandatory parameters
    	try {
	    	DBURL = properties.getProperty(CMSI_DB_URL);
	    	DBLogin = properties.getProperty(CMSI_DB_USERNAME);
	    	DBPassword = properties.getProperty(CMSI_DB_PASSWORD);
	    	
	    	if(properties.getProperty(CMSI_DB_POOLSIZE)!=null){
	    		poolSize = new Integer(properties.getProperty(CMSI_DB_POOLSIZE));
	    	}
    	} catch (Exception e) {
    		throw new ConfigurationException(e.getMessage());
    	}
    	
    	// Not mandatory parameters
    	String prop = properties.getProperty(CMSI_PARENT_REQ_ID);
    	if (prop != null) {
    		try {
    			parentReqIdActivated = Boolean.valueOf(prop).booleanValue();
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        throw new ConfigurationException(e.getMessage());
    	    }
    	}
    }
    
    /**
     * This method should be called at least ONCE before calling ConfigurationProperties.getInstance()
     * but can be called several times after this in order to re-load the configuration values
     * 
     * @param configFilename
     * @throws ConfigurationException
     */
    public static void init(Properties properties) throws ConfigurationException
    {
        instance = new ConfigurationProperties(properties);
        
        // Init log4j
        // We need to return a copy of all the properties to initialize the log4j
        PropertyConfigurator.configure((Properties)properties.clone());
    }
    
    /**
     * Get an instance of the singleton.
     * 
     * @return An instance of the singleton ConfigurationProperties
     */
    public static ConfigurationProperties getInstance()
    {
        if (instance == null) { throw new RuntimeException("Object has not been initialized"); }
        return instance;
    }
    
	/**
	 * @return the dBURL
	 */
	public String getDBURL() {
		return DBURL;
	}
	
	/**
	 * @return the dBLogin
	 */
	public String getDBLogin() {
		return DBLogin;
	}
	
	/**
	 * @return the dBPassword
	 */
	public String getDBPassword() {
		return DBPassword;
	}

	/**
	 * @return the parentReqIdActivated
	 */
	public boolean isParentReqIdActivated() {
		return parentReqIdActivated;
	}

	/**
	 * 
	 * @return poolSize
	 */
	public int getPoolSize() {
		return poolSize;
	}
	
}
