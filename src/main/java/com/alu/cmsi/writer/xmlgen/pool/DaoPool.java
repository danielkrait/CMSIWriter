// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/xmlgen/pool/DaoPool.java,v 1.3 2011/11/21 14:22:14 jpbolatre Exp $ 
 *------------------------------------------------------------------------------
 *   ALCATEL-LUCENT/France                           
 *------------------------------------------------------------------------------
 *   Copyright (c) 2011 ALCATEL-LUCENT - All rights reserved
 *------------------------------------------------------------------------------
 *   CREATION DATE: 9 mars 2011                          Author: flepault
 *------------------------------------------------------------------------------
 *
 *  HISTORY:
 *
 *         $Log: DaoPool.java,v $
 *         Revision 1.3  2011/11/21 14:22:14  jpbolatre
 *         Organize imports
 *
 *         Revision 1.2  2011/06/21 09:53:29  livernea
 *         GLI to manage a pool
 *
 *         Revision 1.1  2011/06/19 08:14:20  livernea
 *         GLI add getter and setter on DAO attribut
 *
 *         Revision 1.1  2011/06/12 15:32:29  livernea
 *         GLI OJO add parameter for the multithread dunning
 *
 *         Revision 1.1  2011/04/29 15:43:20  peltier
 *         refactoring
 *
 *         Revision 1.4  2011/03/17 18:08:44  peltier
 *         Scoring implementation
 *
 *         Revision 1.3  2011/03/16 11:07:04  lepault
 *         *** empty log message ***
 *
 *         Revision 1.2  2011/03/16 08:43:23  lepault
 *         *** empty log message ***
 *
 *         Revision 1.1  2011/03/14 09:01:44  lepault
 *         *** empty log message ***
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.xmlgen.pool;

import java.util.Properties;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.alu.cmsi.writer.config.ConfigurationException;
import com.alu.cmsi.writer.config.ConfigurationProperties;
import com.alu.cmsi.writer.dao.DAO;
import com.alu.cmsi.writer.dao.OracleDAOImpl;
import com.alu.cmsi.writer.dao.exception.DAOException;



/**
 * @version InsertDunnningPool.java
 * @version Created on 9 mars 2011, 11:40:23
 * @author gliverne
 */

public class DaoPool extends Thread{


    /** The Logger. */
    private static Logger _log = Logger.getLogger(DaoPool.class);

	volatile private Integer openInstance = 0;
	
	volatile private Stack<DAO> pool;
	private Integer maxActiveThreads;

	
	private Properties properties = null;
	
	private ConfigurationProperties confP = null; 

	public Properties getProperties() {
		return properties;
	}

    public void run() {

		_log.trace("=> run");

		while(true){

			try{
				//wait 1 minute
				try { Thread.sleep(60000); }
				catch (InterruptedException e) {}				
			
				
				/*if(dao.isValid()==false){
					_log.error("the connection with the database is down, lunch a reconnection");
					dao.reconnection();
					
				}*/
			}catch(Exception e){
				
			}
		}
	}



	public DaoPool(Properties properties) throws ConfigurationException {
		this.properties=properties;
		this.pool = new Stack<DAO>();
		
		ConfigurationProperties.init(properties);
		ConfigurationProperties  confP = ConfigurationProperties.getInstance();
		
		this.maxActiveThreads = confP.getPoolSize();//default
		
		if(this.maxActiveThreads==0){
			_log.trace("the key "+confP.CMSI_DB_POOLSIZE+" to defined the number of pool is not found, the default number of pool is 10");
			this.maxActiveThreads=10;
		}
		
		
		ConfigurationProperties.init(properties);
        confP = ConfigurationProperties.getInstance();
       
	
	}
	
	
	
	synchronized public DAO popInstanceFromStack() {
		_log.debug("=> popInstanceFromStack");
		if (pool.isEmpty()){
			return null;
		}
		_log.debug("<= popInstanceFromStack");
		return pool.pop(); 
	}
	
	synchronized public void addNewInstanceToStack() throws ConfigurationException, DAOException{	
		_log.debug("=> addNewInstanceToStack");
		DAO t = new OracleDAOImpl(properties);
		pool.push(t);	
		openInstance++;	
		_log.debug("<= addNewInstanceToStack");
	}
	
	synchronized public void removeInstanceToStack(DAO t){
		_log.debug("=> removeInstanceToStack");
		pool.remove(t);
		openInstance--;
		_log.debug("<= removeInstanceToStack");
	}

	synchronized public void pushInstanceToStack(DAO t) {
		_log.debug("=> pushInstanceToStack");
		try{
			//t.close();
			pool.push(t);
		}catch(Exception e){
			_log.error("remove this instance DAO due to:",e);
			removeInstanceToStack(t);
		}
		_log.debug("<= pushInstanceToStack");
	}

	synchronized public boolean isInstanceStackEmpty() {
		return pool.isEmpty();
	}

	synchronized public boolean isOpenInstanceFull() {
		return openInstance >= maxActiveThreads;
	}
	
	synchronized public boolean isPoolUnavailable() {
		return isInstanceStackEmpty() && isOpenInstanceFull();
	}
	
	synchronized public Integer instanceStackAvailable(){
		return pool.size();
	}
	
	synchronized public Integer openInstanceAvailable(){
		return openInstance;
	}
	
	synchronized public void close() throws DAOException {
		_log.debug("=> close");
		for(int i=0;i<pool.size();i++){
			((DAO)pool.get(i)).close();
		}
		_log.debug("<= close");
	}

	public Integer getMaxActiveThreads() {
		return maxActiveThreads;
	}
}
