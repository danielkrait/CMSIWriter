// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/test/java/com/alu/cmsi/writer/dao/XmlGeneratorTest.java,v 1.4 2012/09/12 12:06:21 belbeze Exp $ 
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
 *         $Log: XmlGeneratorTest.java,v $
 *         Revision 1.4  2012/09/12 12:06:21  belbeze
 *         Add OCC action for CMSIWriter
 *
 *         Revision 1.3  2012/08/03 08:13:06  belbeze
 *         Add ResourcesUpdate action for CMSIWriter
 *
 *         Revision 1.2  2011/06/21 10:05:40  livernea
 *         GLI to manage a pool
 *
 *         Revision 1.1  2011/06/19 08:17:14  livernea
 *         GLI add new test for the new api
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

import java.math.BigDecimal;
import java.math.BigInteger;
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

import com.alu.cmsi.writer.beans.addServiceList.ContractIdType;
import com.alu.cmsi.writer.beans.addServiceList.Customer;
import com.alu.cmsi.writer.beans.addServiceList.ObjectFactory;
import com.alu.cmsi.writer.beans.addServiceList.ServiceType;
import com.alu.cmsi.writer.beans.occ.CustIdType;
import com.alu.cmsi.writer.beans.occ.MoneyType;
import com.alu.cmsi.writer.common.Action;
import com.alu.cmsi.writer.common.CMSIParameters;
import com.alu.cmsi.writer.common.CmsStatus;
import com.alu.cmsi.writer.common.OutputArguments;
import com.alu.cmsi.writer.config.ConfigurationException;
import com.alu.cmsi.writer.config.ConfigurationProperties;
import com.alu.cmsi.writer.dao.exception.CMSIParametersException;
import com.alu.cmsi.writer.dao.exception.DAOException;

import com.alu.cmsi.writer.xmlgen.XmlGFactoryV2;
import com.alu.cmsi.writer.xmlgen.XmlGeneratorI;


/**
 * @version DaoTest.java
 * @version Created on 17 aout 2010, 11:46:12
 * @author tpeltier
 */
public class XmlGeneratorTest
{
	/** The Logger. */
	private static Logger _log = Logger.getLogger(XmlGeneratorTest.class);
	
	XmlGFactoryV2 factory = null;
	
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
			props.put("cmsi.db.poolSize","2");
			ConfigurationProperties.init(props);
			
			
			this.factory = new XmlGFactoryV2(props);
			assertNotNull(factory);
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
	public void statusTest() {
		_log.info("=> statusTest");
		try {
			XmlGeneratorI xmlGeneratorI = factory.getXmlGenerator();
			long idRequest = 0;
			CmsStatus status = xmlGeneratorI.getStatus(idRequest);
			
			_log.debug("Query status: " + status);
			//assertEquals(new Double(1), new Double(result));
		} catch (DAOException e) {
			_log.error("error occured while getting a connection.");
			fail("error occured while getting a connection.");
		} catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= statusTest");
		}
	}
	

	
	//@Test
	@Ignore
	public void addService() throws ConfigurationException, DAOException {
		_log.info("=> insertTestWithId");
		
		//retrieve an element into a pool
		XmlGeneratorI xmlGeneratorI = factory.getXmlGenerator();
		int nbRequest = 10;
		try {
			
			long begin = System.currentTimeMillis();
			for(int i =0;i<nbRequest;i++){
				Long requestId = xmlGeneratorI.getNextRequestId();
	
				CMSIParameters params = new CMSIParameters();
				
				CMSIParameters cmsiP = new CMSIParameters();
				cmsiP.setOrigin("TEST_CMSI");
				cmsiP.setInsertionDate(new java.util.Date());
				cmsiP.setRequestId(requestId);
				
				//create customer
				ObjectFactory objFactory = new ObjectFactory();
				Customer customer = objFactory.createCustomer();
	
				ContractIdType contractId = new ContractIdType();
				contractId.setType("co_id");
				BigInteger coId = new BigInteger("12345");
				contractId.setValue(coId);
	
				ServiceType service = new ServiceType();
				BigInteger spCode = new BigInteger("22");
				service.setServicePackageCode(spCode );
				BigInteger snCode = new BigInteger("11");
				service.setSncode(snCode);
	
				com.alu.cmsi.writer.beans.addServiceList.Customer.Contract contract = new com.alu.cmsi.writer.beans.addServiceList.Customer.Contract();
				contract.setId(contractId);
				contract.getService().add(service);
				customer.getContract().add(contract);
				
				xmlGeneratorI.addService(customer , cmsiP);
				//check if the request is inserted into CMS_INT
				CmsStatus status = xmlGeneratorI.getStatus(requestId);
				
				
				_log.debug("Query status: " + status);
				//assertNotNull(status);
				
			}
			long end = System.currentTimeMillis();
			
			long timeToProcess = end-begin;
			_log.error("timeToProcess:"+nbRequest+" is "+timeToProcess);
			
		}  catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= insertTestWithId");
		}
	}
	
	/*public void insertBatchTest() {
		_log.info("=> insertBatchTest");
		try {
			HashMap<Long, CMSIParameters> params = new HashMap<Long, CMSIParameters>();
			HashMap<Long, String> inputDatas = new HashMap<Long, String>();
			
			CMSIParameters p1 = new CMSIParameters();
			p1.setOrigin("TEST");
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
			
			assertEquals(new Double(1), new Double(result[0]));
			assertEquals(new Double(1), new Double(result[1]));
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
	}*/

	
	//@Test
	@Ignore
	public void doResourceUpdate() throws ConfigurationException, DAOException {
		_log.info("=> doResourceUpdate");

		//retrieve an element into a pool
		XmlGeneratorI xmlGeneratorI = factory.getXmlGenerator();
		try {
			long begin = System.currentTimeMillis();
			Long requestId = xmlGeneratorI.getNextRequestId();

			CMSIParameters cmsiP = new CMSIParameters();
			cmsiP.setOrigin("TEST_CMSI");
			cmsiP.setInsertionDate(new java.util.Date());
			cmsiP.setRequestId(requestId);
			cmsiP.setOriginalId(new Long(2));

			//create customer and all infos
			com.alu.cmsi.writer.beans.resourceUpdate.ObjectFactory objFactory = new com.alu.cmsi.writer.beans.resourceUpdate.ObjectFactory();
			com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE resource = objFactory.createRESOURCESUPDATE();

            resource.setDNNUM("1234567890");
            resource.setPORTNUM("Port1");
            resource.setSMSERIALNUM("SM12345");
			xmlGeneratorI.resourceUpdate(resource , cmsiP);

			//check if the request is inserted into CMS_INT
			CmsStatus status = xmlGeneratorI.getStatus(requestId);
			_log.debug("Query status: " + status);

			long end = System.currentTimeMillis();

			long timeToProcess = end-begin;
			_log.error("timeToProcess is : "+timeToProcess);
		}  catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= doResourceUpdate");
		}
	}
	

	//@Test
	@Ignore
	public void doResourceUpdateUsingBatch() throws ConfigurationException, DAOException {
		_log.info("=> doResourceUpdateUsingBatch");
		HashMap<Long, com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE> rootElements = new HashMap<Long, com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE>();
		HashMap<Long, CMSIParameters> cmsiParams = new HashMap<Long, CMSIParameters>();

		//retrieve an element into a pool
		XmlGeneratorI xmlGeneratorI = factory.getXmlGenerator();
		try {
			long begin = System.currentTimeMillis();

			//create resource and all infos
			com.alu.cmsi.writer.beans.resourceUpdate.ObjectFactory objFactory = new com.alu.cmsi.writer.beans.resourceUpdate.ObjectFactory();

			for(int index=1 ; index < 5 ; index++){
				CMSIParameters p = new CMSIParameters();
				p.setOrigin("TEST_CMSI");
				p.setInsertionDate(new java.util.Date());
				p.setOriginalId(new Long(index));
				cmsiParams.put(new Long(index), p);

				com.alu.cmsi.writer.beans.resourceUpdate.RESOURCESUPDATE resource = objFactory.createRESOURCESUPDATE();
	            resource.setDNNUM("1234567890-"+index);
	            resource.setPORTNUM("Port"+index);
	            resource.setSMSERIALNUM("SM12345-"+index);

				rootElements.put(new Long(index), resource);
			}

			// Do the insertion in batch
			xmlGeneratorI.resourceUpdateUsingBatch(rootElements , cmsiParams);

			long end = System.currentTimeMillis();

			long timeToProcess = end-begin;
			_log.error("timeToProcess is : "+timeToProcess);
		}  catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= doResourceUpdateUsingBatch");
		}
	}

	@Test
	//@Ignore
	public void doCreateOCC() throws ConfigurationException, DAOException {
		_log.info("=> doCreateOCC");

		//retrieve an element into a pool
		XmlGeneratorI xmlGeneratorI = factory.getXmlGenerator();
		try {
			long begin = System.currentTimeMillis();
			Long requestId = xmlGeneratorI.getNextRequestId();

			CMSIParameters cmsiP = new CMSIParameters();
			cmsiP.setOrigin("TEST_CMSI");
			cmsiP.setInsertionDate(new java.util.Date());
			cmsiP.setRequestId(requestId);
			cmsiP.setOriginalId(new Long(2));

			//create customer and all infos
			com.alu.cmsi.writer.beans.occ.ObjectFactory objFactory = new com.alu.cmsi.writer.beans.occ.ObjectFactory();
			com.alu.cmsi.writer.beans.occ.OccType occType = objFactory.createOccType();

			CustIdType csId = new CustIdType( );
			csId.setType("cs_id");
			csId.setValue(BigInteger.valueOf(344));
			occType.setId(csId);
			occType.setActionCode("I");
			occType.setFeeType("N");
//			occType.setFeeClass(BigInteger.valueOf(1));
//			occType.setInvoiceId(new Long(1000));
			occType.setFeeClass(BigInteger.valueOf(2));
//			occType.setFeeClass(BigInteger.valueOf(3));
//			occType.setFeeClass(BigInteger.valueOf(5));
			com.alu.cmsi.writer.beans.occ.ContractIdType coId = new com.alu.cmsi.writer.beans.occ.ContractIdType();;
			coId.setType("co_id");
			coId.setValue(BigInteger.valueOf(213));
			occType.setCoId(coId);
			occType.setRatePlanCode(new Long(19));
			occType.setRatePlanVersion(new Long(25));
			occType.setServicePackageCode(new Long(21));
			occType.setSncode(new Long(99));
			occType.setRecordId(BigInteger.valueOf(1));
			occType.setRecordSubId(BigInteger.valueOf(1));
			occType.setBasePartId(BigInteger.valueOf(1));
			occType.setChargePartId(BigInteger.valueOf(1));
//			occType.setEventCode(new Long(226));
			MoneyType moneyType = new MoneyType();
			moneyType.setAmount(120.00);
			moneyType.setCurrency("EUR");
			occType.setFeeAmount(moneyType);
//			occType.setFuPackId(BigInteger.valueOf(107));
//			occType.setNumFu(new Float(12.00));
//			occType.setFuVer(BigInteger.valueOf(1));
//			occType.setFuPkver(BigInteger.valueOf(1));
//			occType.setFuPkelsq(BigInteger.valueOf(1));
			
			xmlGeneratorI.createOCC(occType , cmsiP);

			//check if the request is inserted into CMS_INT
			CmsStatus status = xmlGeneratorI.getStatus(requestId);
			_log.debug("Query status: " + status);

			long end = System.currentTimeMillis();

			long timeToProcess = end-begin;
			_log.error("timeToProcess is : "+timeToProcess);
		}  catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= doCreateOCC");
		}
	}
	
	//@Test
	@Ignore
	public void doCreateOCCUsingBatch() throws ConfigurationException, DAOException {
		_log.info("=> doCreateOCCUsingBatch");
		HashMap<Long, com.alu.cmsi.writer.beans.occ.OccType> rootElements = new HashMap<Long, com.alu.cmsi.writer.beans.occ.OccType>();
		HashMap<Long, CMSIParameters> cmsiParams = new HashMap<Long, CMSIParameters>();

		//retrieve an element into a pool
		XmlGeneratorI xmlGeneratorI = factory.getXmlGenerator();
		try {
			long begin = System.currentTimeMillis();

			//create resource and all infos
			com.alu.cmsi.writer.beans.occ.ObjectFactory objFactory = new com.alu.cmsi.writer.beans.occ.ObjectFactory();

			for(int index=1 ; index < 5 ; index++){
				CMSIParameters p = new CMSIParameters();
				p.setOrigin("TEST_CMSI");
				p.setInsertionDate(new java.util.Date());
				p.setOriginalId(new Long(index));
				cmsiParams.put(new Long(index), p);

				com.alu.cmsi.writer.beans.occ.OccType occType = objFactory.createOccType();
				CustIdType csId = new CustIdType( );
				csId.setType("cs_id");
				csId.setValue(BigInteger.valueOf(344+index));
				occType.setId(csId);
				occType.setActionCode("I");
				occType.setFeeType("N");
				occType.setFeeClass(BigInteger.valueOf(1));
				occType.setInvoiceId(new Long(1000+index));

				rootElements.put(new Long(index), occType);
			}

			// Do the insertion in batch
			xmlGeneratorI.createOCCUsingBatch(rootElements , cmsiParams);

			long end = System.currentTimeMillis();

			long timeToProcess = end-begin;
			_log.error("timeToProcess is : "+timeToProcess);
		}  catch (Exception e) {
			_log.error("error occured");
			e.printStackTrace();
			fail("error occured");
		} finally {
			_log.info("<= doCreateOCCUsingBatch");
		}
	}



	
	
	
}