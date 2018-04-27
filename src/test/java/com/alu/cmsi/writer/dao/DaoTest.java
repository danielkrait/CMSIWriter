// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/test/java/com/alu/cmsi/writer/dao/DaoTest.java,v 1.10 2012/08/03 08:13:06 belbeze Exp $ 
 *------------------------------------------------------------------------------
 *   ALCATEL-LUCENT/France                           
 *------------------------------------------------------------------------------
 *   Copyright (c) 2010 ALCATEL-LUCENT - All rights reserved
 *------------------------------------------------------------------------------
 *   CREATION DATE: 17 aout 2010                          Author: tpeltier
 *------------------------------------------------------------------------------
 *
 *  HISTORY:
 *
 *         $Log: DaoTest.java,v $
 *         Revision 1.10  2012/08/03 08:13:06  belbeze
 *         Add ResourcesUpdate action for CMSIWriter
 *
 *         Revision 1.9  2011/11/21 14:55:32  jpbolatre
 *         Update insert & insertBatch methods to insert the additionalInfo column
 *
 *         Revision 1.8  2011/01/04 15:34:51  peltier
 *         Add:
 *         - Parameter 'cmsi.parent.request.id.activated' is a new configuration item
 *         Update:
 *         - insert() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - insertBatch() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - DAO closes correctly the preparedStatements
 *         - Clob is now displayed as a correct String
 *
 *         Revision 1.7  2010/12/16 16:35:24  peltier
 *         Add:
 *         - Method to make payments
 *
 *         Revision 1.6  2010/12/01 09:13:37  peltier
 *         Update:
 *         - adding the function for insertion in the table CMS_INT using a jdbc batch (for performances purposes : use only one connection)
 *         - close the prepared statement after each use
 *         - modify service access fee object update => add access fee period
 *
 *         Revision 1.5  2010/11/24 01:15:05  akker
 *         v 0.9-TEST:
 *         - adding the function for insertion in the table CMS_INT using a jdbc batch (for performances purposes : use only one connection)
 *         - close the prepared statement after each use
 *
 *         Revision 1.4  2010/10/16 16:02:48  peltier
 *         Update:
 *         - Oracle DAO => Change the connection method to the database
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.alu.cmsi.writer.common.Action;
import com.alu.cmsi.writer.common.CMSIParameters;
import com.alu.cmsi.writer.common.OutputArguments;
import com.alu.cmsi.writer.config.ConfigurationProperties;
import com.alu.cmsi.writer.dao.exception.CMSIParametersException;
import com.alu.cmsi.writer.dao.exception.DAOException;

/**
 * @version DaoTest.java
 * @version Created on 17 aout 2010, 11:46:12
 * @author tpeltier
 */
public class DaoTest
{
	/** The Logger. */
	private static Logger _log = Logger.getLogger(DaoTest.class);
	
	private DAO dao;
	
	@BeforeClass
	public static void setUp() throws Exception {
		Properties logProperties = new Properties();
	    logProperties.put("log4j.rootLogger", "DEBUG, CONSOLE");
	    logProperties.put("log4j.logger.com.alu.product","DEBUG");
	    logProperties.put("log4j.logger.java.sql","DEBUG");
	    logProperties.put("log4j.appender.CONSOLE","org.apache.log4j.ConsoleAppender");
	    logProperties.put("log4j.appender.CONSOLE.layout","org.apache.log4j.PatternLayout");
	    logProperties.put("log4j.appender.CONSOLE.layout.ConversionPattern","%d [%t] %-5.5p (%C{1}:%L) - %m%n");
		PropertyConfigurator.configure(logProperties);
		_log.info("=> setUp");
		_log.info("<= setUp");
	}

	@Before
	public void daoCreationTest() {
		_log.info("=> daoCreationTest");	
		try {
			Properties props = new Properties();
			props.put("cmsi.db.url", "jdbc:oracle:thin:@172.201.33.148:1521:JTG9DEV");
			props.put("cmsi.db.username", "alcatel");
			props.put("cmsi.db.password", "sysadm");
			props.put("cmsi.parent.request.id.activated","false");
			ConfigurationProperties.init(props);
			dao = new OracleDAOImpl(ConfigurationProperties.getInstance().getDBURL(),
					ConfigurationProperties.getInstance().getDBLogin(),
					ConfigurationProperties.getInstance().getDBPassword());
			assertNotNull(dao);
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= daoCreationTest");
		}
	}
	
	//@Test
	@Ignore
	public void insertTest() {
		_log.info("=> insertTest");
		try {
			CMSIParameters params = new CMSIParameters();
			params.setOrigin("TEST");
			params.setAdditionalInfo("additionalInfo");
			String inputData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
					"<customer xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"../change.contract.status.xsd\">" +
					" <contract>" +
					"  <contractIdType>" +
					"   <type>co_id</type>" +
					"   <value>123456</value>" +
					"  </contractIdType>" +
					"  <reason>1</reason>" +
					" </contract>" +
					"</customer>";
			int result = dao.insert(params, Action.SUSPEND_CONTRACT_ACTION, inputData);
			_log.debug("Query result: " + result);
			assertEquals(new Double(1), new Double(result));
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (CMSIParametersException e) {
			_log.error("error occured in the parameters checking.");
			fail("error occured in the parameters checking.");
		} catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= insertTest");
		}
	}
	
	//@Test
	@Ignore
	public void insertTestWithId() {
		_log.info("=> insertTestWithId");
		try {
			CMSIParameters params = new CMSIParameters();
			params.setRequestId(dao.getNextRequestId());
			params.setOrigin("TEST");
			String inputData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
					"<customer xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"../change.contract.status.xsd\">" +
					" <contract>" +
					"  <contractIdType>" +
					"   <type>co_id</type>" +
					"   <value>123456</value>" +
					"  </contractIdType>" +
					"  <reason>1</reason>" +
					" </contract>" +
					"</customer>";
			int result = dao.insert(params, Action.SUSPEND_CONTRACT_ACTION, inputData);
			_log.debug("Query result: " + result);
			assertEquals(new Double(1), new Double(result));
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (CMSIParametersException e) {
			_log.error("error occured in the parameters checking.");
			fail("error occured in the parameters checking.");
		} catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= insertTestWithId");
		}
	}
	
	//@Test
	@Ignore
	public void insertBatchTest() {
		_log.info("=> insertBatchTest");
		try {
			HashMap<Long, CMSIParameters> params = new HashMap<Long, CMSIParameters>();
			HashMap<Long, String> inputDatas = new HashMap<Long, String>();
			
			CMSIParameters p1 = new CMSIParameters();
			p1.setOrigin("TEST");
			p1.setAdditionalInfo("p1");
			String i1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
			"<customer xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"../change.contract.status.xsd\">" +
			" <contract>" +
			"  <contractIdType>" +
			"   <type>co_id</type>" +
			"   <value>123456</value>" +
			"  </contractIdType>" +
			"  <reason>1</reason>" +
			" </contract>" +
			"</customer>";
			params.put(new Long(1), p1);
			inputDatas.put(new Long(1), i1);
			
			CMSIParameters p2 = new CMSIParameters();
			p2.setOrigin("TEST");
			p2.setAdditionalInfo("p2");
			String i2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
			"<customer xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"../change.contract.status.xsd\">" +
			" <contract>" +
			"  <contractIdType>" +
			"   <type>co_id</type>" +
			"   <value>123456</value>" +
			"  </contractIdType>" +
			"  <reason>1</reason>" +
			" </contract>" +
			"</customer>";
			params.put(new Long(2), p2);
			inputDatas.put(new Long(2), i2);
			
			int[] result = dao.insertBatch(params, Action.SUSPEND_CONTRACT_ACTION, inputDatas);

			_log.debug("Query result 1: " + result[0]);
			_log.debug("Query result 2: " + result[1]);
			
			assertEquals(new Double(PreparedStatement.SUCCESS_NO_INFO), new Double(result[0]));
			assertEquals(new Double(PreparedStatement.SUCCESS_NO_INFO), new Double(result[1]));
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (CMSIParametersException e) {
			_log.error("error occured in the parameters checking.");
			fail("error occured in the parameters checking.");
		} catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= insertBatchTest");
		}
	}
	
	@Test
	//@Ignore
	public void getOutputArgsTest() {
		_log.info("=> getOutputArgsTest");
		try {
			OutputArguments result = dao.getOutputArgs(new Long(246440));
			_log.debug("Query result: " + result.toString());
			assertNotNull(result);
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= getOutputArgsTest");
		}
	}
	
	//@Test
	@Ignore
	public void getNextRequestIdTest() {
		_log.info("=> getNextRequestIdTest");
		try {
			Long id1 = dao.getNextRequestId();
			Long id2 = dao.getNextRequestId();
			_log.debug("Query result 1: " + id1);
			_log.debug("Query result 2: " + id2);
			assertEquals(id1.longValue()+1, id2.longValue());
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= getNextRequestIdTest");
		}
	}
	
	@After
	public void daoFree() {
		_log.info("=> daoFree");
		dao = null;
		_log.info("<= daoFree");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		_log.info("=> tearDown <=");		
	}
}