// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/dao/OracleDAOImpl.java,v 1.15 2011/12/20 16:13:01 lszabo Exp $ 
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
 *         $Log: OracleDAOImpl.java,v $
 *         Revision 1.15  2011/12/20 16:13:01  lszabo
 *         CMSIWriter_0_17:Change data type for CMS_INT.INSERTION_DATE to timestamp.
 *
 *         Revision 1.14  2011/11/21 14:55:32  jpbolatre
 *         Update insert & insertBatch methods to insert the additionalInfo column
 *
 *         Revision 1.13  2011/09/13 13:28:34  akker
 *         0.16 : add fonctions to insert a block of XMLs in cms_int for batch actions
 *
 *         Revision 1.12  2011/06/21 09:53:22  livernea
 *         GLI to manage a pool
 *
 *         Revision 1.11  2011/06/19 08:16:12  livernea
 *         GLI add new constructor
 *
 *         Revision 1.10  2011/01/04 15:34:41  peltier
 *         Add:
 *         - Parameter 'cmsi.parent.request.id.activated' is a new configuration item
 *         Update:
 *         - insert() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - insertBatch() in the DAO can now performed insertion without PARENT_REQUEST_ID in the request
 *         - DAO closes correctly the preparedStatements
 *         - Clob is now displayed as a correct String
 *
 *         Revision 1.9  2010/12/20 09:50:12  peltier
 *         Update:
 *         - customer types bean
 *         - payment bean
 *         - getOutputArgs() in the DAO can now performed action upon historised requests
 *
 *         Revision 1.8  2010/12/01 09:13:28  peltier
 *         Update:
 *         - adding the function for insertion in the table CMS_INT using a jdbc batch (for performances purposes : use only one connection)
 *         - close the prepared statement after each use
 *         - modify service access fee object update => add access fee period
 *
 *         Revision 1.7  2010/11/24 01:15:05  akker
 *         v 0.9-TEST:
 *         - adding the function for insertion in the table CMS_INT using a jdbc batch (for performances purposes : use only one connection)
 *         - close the prepared statement after each use
 *
 *         Revision 1.6  2010/10/16 16:02:48  peltier
 *         Update:
 *         - Oracle DAO => Change the connection method to the database
 *
 *         Revision 1.5  2010/10/14 20:01:25  atik
 *         new solution applied for dao connection
 *
 *         Revision 1.4  2010/10/12 12:16:03  peltier
 *         Add:
 *         - Oracle DAO => Function to get the next valid request id
 *         - Xml interface => Function to modify the access fee of a service
 *         Update:
 *         - Oracle DAO => Allows the caller to give the request id in CMSI parameters
 *
 *         Revision 1.3  2010/10/01 12:05:32  peltier
 *         CMSIW
 *         Update:
 *         - Oracle DAO => Connections were not released after process, aiming to a reach of maximum opened cursors.
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

import java.io.StringReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.alu.cmsi.writer.common.CMSIParameters;
import com.alu.cmsi.writer.common.CmsStatus;
import com.alu.cmsi.writer.common.OutputArguments;
import com.alu.cmsi.writer.config.ConfigurationException;
import com.alu.cmsi.writer.config.ConfigurationProperties;
import com.alu.cmsi.writer.dao.exception.CMSIParametersException;
import com.alu.cmsi.writer.dao.exception.DAOException;

/**
 * @version OracleDAOImpl.java
 * @version Created on 16 aout 2010, 18:39:19
 * @author tpeltier
 */
public class OracleDAOImpl implements DAO {

    /** The logger. */
    private final static Logger _log = Logger.getLogger(OracleDAOImpl.class);
    /** The data source. */
    private Connection _cnx = null;
    private String url;
    private String username;
    private String password;
    private ConfigurationProperties confP = null;

    /**
     * Constructor
     * Initializes the data source with given parameters.
     *
     * @param url The link to the database.
     * @param username The user name to connect to the database.
     * @param password The password to connect to the database.
     * @throws DaoException In case of error while initializing the object.
     */
    public OracleDAOImpl(String url, String username, String password) throws DAOException {
        super();
        _log.trace("=> OracleDAO()");
        this.url = url;
        this.username = username;
        this.password = password;

        _log.trace("url:" + url);
        _log.trace("username:" + username);
        _log.trace("password:" + password);

        _cnx = this.dbConnect(url, username, password);
        _log.trace("<= OracleDAO()");
    }

    /**
     * Constructor
     * Initializes the data source with given parameters.
     *
     * @param url The link to the database.
     * @param username The user name to connect to the database.
     * @param password The password to connect to the database.
     * @throws ConfigurationException 
     * @throws DaoException In case of error while initializing the object.
     */
    public OracleDAOImpl(Properties properties) throws DAOException, ConfigurationException {
        super();
        _log.trace("=> OracleDAO()");

        _log.trace("=> Load properties");
        ConfigurationProperties.init(properties);
        confP = ConfigurationProperties.getInstance();

        _log.trace("=> retrieve data from properties");
        this.url = confP.getDBURL();
        this.username = confP.getDBLogin();
        this.password = confP.getDBPassword();


        _log.trace("key url:" + confP.CMSI_DB_URL + " value url:" + url);
        _log.trace("key username:" + confP.CMSI_DB_USERNAME + " value username:" + username);
        _log.trace("key password:" + confP.CMSI_DB_PASSWORD + " value password:" + password);

        _cnx = this.dbConnect(url, username, password);
        _log.trace("<= OracleDAO()");
    }

    /**
     * Initiates the connection.
     *
     * @return The connection on the database
     * @throws DaoException
     */
    private Connection dbConnect(String url, String user, String password) throws DAOException {
        Connection cnx = null;
        _log.trace("=> dbConnect()");
        _log.info("Connecting to the database...");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            _log.info("Driver established");
        } catch (Exception e) {
            throw new DAOException("DB Error: Driver not found");
        }

        try {
            cnx = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            _log.debug("DB URL = " + url);
            _log.debug("DB USER = " + user);
            _log.debug("DB PWD = " + password);
            throw new DAOException("DB Error: Could not connect to the database");
        }

        _log.info("Successfully connected to the database");
        _log.trace("<= dbConnect()");
        return cnx;
    }

    /**
     * Initiates the connection.
     *
     * @return The connection on the database
     * @throws DaoException
     */
    public void reconnection() throws DAOException {
        Connection cnx = null;
        _log.trace("=> dbConnect()");
        _log.info("Connecting to the database...");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            _log.info("Driver established");
        } catch (Exception e) {
            throw new DAOException("DB Error: Driver not found");
        }

        try {
            cnx = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            _log.debug("DB URL = " + url);
            _log.debug("DB USER = " + username);
            _log.debug("DB PWD = " + password);
            throw new DAOException("DB Error: Could not connect to the database");
        }

        _log.info("Successfully connected to the database");
        _log.trace("<= dbConnect()");
    }

    /**
     * Close the connection to the database.
     *
     * @throws DaoException
     */
    public void close() throws DAOException {
        _log.trace("=> close()");
        try {
            if (_cnx != null) {
                _cnx.close();
            }
        } catch (SQLException e) {
            String message = "Error while closing connection" + e.getMessage();
            _log.error(message, e);
            throw new DAOException(message);
        }
        _log.trace("<= close()");
    }

    /**
     * Used by the garbage collector when garbage collection determines that there are no
     * more references to the object.
     */
    @Override
    protected void finalize() throws Throwable {
        try {
            this.close();
        } finally {
            super.finalize();
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.dao.DAO#insert(com.alu.cmsi.writer.common.CMSIParameters, java.lang.String)
     */
    public int insert(CMSIParameters params, Long actionId, String inputData)
            throws DAOException, CMSIParametersException {
        _log.trace("=> insert()");
        int result = 0;
        PreparedStatement ps = null;
        params.checkParameters();



        try {
            // to be passed by the caller : REQUEST_ID, ORIGIN, ORIGINAL_ID, INSERTION_DATE, INPUT_DATA, PRIORITY, PARENT_REQ_ID
            // to be determined by the lib: STATUS=2, ACTION_ID
            String query =
                    "insert into CMS_INT (REQUEST_ID, ORIGIN, ORIGINAL_ID, STATUS, "
                    + "ACTION_ID, PRIORITY, INSERTION_DATE, INPUT_DATA, ADDITIONAL_INFO";
            if (ConfigurationProperties.getInstance().isParentReqIdActivated()) {
                query += ", PARENT_REQ_ID";
            }
            query += ") values (?,?,?," + CmsStatus.TO_BE_PROCESSED + ",?,?,?,?,?";
            if (ConfigurationProperties.getInstance().isParentReqIdActivated()) {
                query += ",?";
            }
            query += ")";

            _cnx.setAutoCommit(false);
            ps = _cnx.prepareStatement(query);

            int idx = 1;
            if (params.getRequestId() != null) {
                ps.setLong(idx++, params.getRequestId());
            } else {
                ps.setNull(idx++, Types.NUMERIC);
            }
            ps.setString(idx++, params.getOrigin());
            if (params.getOriginalId() != null) {
                ps.setLong(idx++, params.getOriginalId());
            } else {
                ps.setNull(idx++, Types.NUMERIC);
            }
            ps.setLong(idx++, actionId);
            ps.setLong(idx++, params.getPriority());
            ps.setTimestamp(idx++, convertDateToSqlTimestamp(params.getInsertionDate()));
            ps.setCharacterStream(idx++, new StringReader(inputData), inputData.length());
            ps.setString(idx++, params.getAdditionalInfo());
            
            if (ConfigurationProperties.getInstance().isParentReqIdActivated()) {
                if (params.getParentRequestId() != null) {
                    ps.setLong(idx++, params.getParentRequestId());
                } else {
                    ps.setNull(idx++, Types.NUMERIC);
                }
            }

            _log.debug(ps.toString());
            result = ps.executeUpdate();
            _log.debug("Query insertion result: " + result);

            _cnx.commit();
        } catch (SQLException e) {
            try {
                _cnx.rollback();
                _log.error(e.getMessage());
            } catch (SQLException e1) {
                throw new DAOException("An exception occurred while doing the rollback: " + e.getMessage());
            }
            throw new DAOException("An exception occurred while inserting statement: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("An exception occurred while closing the prepared statement: " + ex.getMessage());
            }
            ps = null;
        }
        _log.trace("<= insert");
        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.dao.DAO#getOutputArgs(java.lang.Long)
     */
    public OutputArguments getOutputArgs(Long requestId) throws DAOException {
        _log.trace("=> getOutputArgs()");
        OutputArguments outputArgs = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query =
                    "select STATUS, INSERTION_DATE, STATUS_UPDATE_DATE, ERROR_MESSAGE, OUTPUT_DATA"
                    + " from CMS_INT where REQUEST_ID = ?"
                    + " UNION ALL "
                    + "select STATUS, INSERTION_DATE, STATUS_UPDATE_DATE, ERROR_MESSAGE, OUTPUT_DATA"
                    + " from CMS_INT_HISTORY where REQUEST_ID = ?";

            ps = _cnx.prepareStatement(query);

            ps.setLong(1, requestId);
            ps.setLong(2, requestId);

            _log.debug(ps.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                outputArgs = new OutputArguments();
                outputArgs.setRequestId(requestId);
                outputArgs.setStatus(rs.getLong(1));
                outputArgs.setInsertionDate(this.convertSqlToDate(rs.getDate(2)));
                outputArgs.setLastUpdateDate(this.convertSqlToDate(rs.getDate(3)));
                outputArgs.setErrorMessage(rs.getString(4));
                if (rs.getClob(5) != null) {
                    Clob clob = rs.getClob(5);
                    outputArgs.setOutputData(clob.getSubString(1, (int) clob.length()));
                }
            }
            _log.debug("Query select result: " + outputArgs);

            _cnx.commit();
        } catch (SQLException e) {
            try {
                _cnx.rollback();
                _log.error(e.getMessage());
            } catch (SQLException e1) {
                throw new DAOException("An exception occurred while doing the rollback: " + e.getMessage());
            }
            throw new DAOException("An exception occurred while inserting statement: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("An exception occurred while closing the prepared statement: " + ex.getMessage());
            }
            rs = null;
            ps = null;
        }

        _log.trace("<= getOutputArgs()");
        return outputArgs;
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.dao.DAO#getNextRequestId()
     */
    public Long getNextRequestId() throws DAOException {
        _log.trace("=> getNextRequestId()");
        Long reqId = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query =
                    "select SEQ_CMSINT.nextval from DUAL";

            ps = _cnx.prepareStatement(query);

            _log.debug(ps.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                reqId = rs.getLong(1);
            }
            _log.debug("Query select result: " + reqId);

            _cnx.commit();

        } catch (SQLException e) {
            try {
                _cnx.rollback();
                _log.error(e.getMessage());
            } catch (SQLException e1) {
                throw new DAOException("An exception occurred while doing the rollback: " + e.getMessage());
            }
            throw new DAOException("An exception occurred while inserting statement: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("An exception occurred while closing the prepared statement: " + ex.getMessage());
            }
            rs = null;
            ps = null;
        }

        _log.trace("<= getNextRequestId()");
        return reqId;
    }

    /*
     * (non-Javadoc)
     * @see com.alu.cmsi.writer.dao.DAO#insertBatch(java.util.HashMap, java.lang.Long, java.util.HashMap)
     */
    public int[] insertBatch(HashMap<Long, CMSIParameters> params, Long actionId, HashMap<Long, String> inputDatas)
            throws DAOException, CMSIParametersException {
        _log.trace("=> insertBatch()");
        _log.error("=> insertBatch() : OracleDAOImpl : ActionId ==> "+actionId+" length of inputDatas "+inputDatas.size());
        int[] result;
        PreparedStatement ps = null;

//        params.checkParameters();

        try {
            // to be passed by the caller : REQUEST_ID, ORIGIN, ORIGINAL_ID, INSERTION_DATE, INPUT_DATA, PRIORITY, PARENT_REQ_ID
            // to be determined by the lib: STATUS=2, ACTION_ID

            // traitements
            _cnx.setAutoCommit(false);

            String query =
                    "insert into CMS_INT (REQUEST_ID, ORIGIN, ORIGINAL_ID, STATUS, "
                    + "ACTION_ID, PRIORITY, INSERTION_DATE, INPUT_DATA, ADDITIONAL_INFO";
            if (ConfigurationProperties.getInstance().isParentReqIdActivated()) {
                query += ", PARENT_REQ_ID";
            }
            query += ") values (?,?,?," + CmsStatus.TO_BE_PROCESSED + ",?,?,?,?,?";
            if (ConfigurationProperties.getInstance().isParentReqIdActivated()) {
                query += ",?";
            }
            query += ")";

            ps = _cnx.prepareStatement(query);
            String xmlData = null;
            Long loopId = 0l;
            int idx = 1;

            for (Entry<Long, String> entry : inputDatas.entrySet()) {
                xmlData = entry.getValue();
                loopId = entry.getKey();

                idx = 1;
                if (params.get(loopId).getRequestId() != null) {
                    ps.setLong(idx++, params.get(loopId).getRequestId());
                } else {
                    ps.setNull(idx++, Types.NUMERIC);
                }
                ps.setString(idx++, params.get(loopId).getOrigin());
                if (params.get(loopId).getOriginalId() != null) {
                    ps.setLong(idx++, params.get(loopId).getOriginalId());
                } else {
                    ps.setNull(idx++, Types.NUMERIC);
                }
                ps.setLong(idx++, actionId);
                ps.setLong(idx++, params.get(loopId).getPriority());
                ps.setTimestamp(idx++, convertDateToSqlTimestamp(params.get(loopId).getInsertionDate()));
                ps.setCharacterStream(idx++, new StringReader(xmlData), xmlData.length());
                ps.setString(idx++, params.get(loopId).getAdditionalInfo());
                if (ConfigurationProperties.getInstance().isParentReqIdActivated()) {
                    if (params.get(loopId).getParentRequestId() != null) {
                        ps.setLong(idx++, params.get(loopId).getParentRequestId());
                    } else {
                        ps.setNull(idx++, Types.NUMERIC);
                    }
                }

//                _log.debug(ps.toString());
                
                ps.addBatch();
                ps.clearParameters();
            }
            
            _log.error("Before executing insert batch -going to sleep for 30 sec ");

            try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            result = ps.executeBatch();
            
         
            
            _log.error("Batch inserted successfully in CMS_INT table :Size "+result.length+"Result "+result );
            
            _log.debug("Batch inserted successfully in CMS_INT table :Size "+result.length);

            _cnx.commit();
            
            
            
            
            _log.error("After executing commit insert batch -going to sleep for 30 sec ");

            try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } catch (SQLException e) {
            try {
                _cnx.rollback();
                _log.error(e.getMessage());
            } catch (SQLException e1) {
                throw new DAOException("An exception occurred while doing the rollback: " + e.getMessage());
            }
            throw new DAOException("An exception occurred while inserting statement: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("An exception occurred while closing the prepared statement: " + ex.getMessage());
            }
            ps = null;
        }
        _log.trace("<= insertBatch()");
        return result;
    }

    /**
     * Convert a date from java standard format to SQL standard format.
     *
     * @param date in the java standard format
     * @return a date in the SQL standard format
     */
    private java.sql.Date convertDateToSql(java.util.Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }

        /**
     * Convert a date from java standard format to SQL timestamp standard format.
     *
     * @param date in the java standard format
     * @return a timestamp in the SQL standard format
     */
    private java.sql.Timestamp convertDateToSqlTimestamp(java.util.Date date) {
        if (date != null) {
            return new java.sql.Timestamp(date.getTime());
        } else {
            return null;
        }
    }


    /**
     * Convert a date from SQL standard format to java standard format.
     *
     * @param date in the SQL standard format
     * @return a date in the java standard format
     */
    private java.util.Date convertSqlToDate(java.sql.Date date) {
        if (date != null) {
            return new java.util.Date(date.getTime());
        } else {
            return null;
        }
    }

    public boolean isValid() {
        if (_cnx == null) {
            return false;
        }
        ResultSet ping = null;
        try {
            if (_cnx.isClosed()) {
                return false;
            }
            ping = _cnx.createStatement().executeQuery("SELECT 1");
            return true;
        } catch (SQLException sqle) {
            try {
                close();
            } catch (Exception ex) {
            }

        } finally {
            if (ping != null) {
                try {
                    ping.close();
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}
