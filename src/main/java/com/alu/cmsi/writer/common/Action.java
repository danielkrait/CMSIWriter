// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/common/Action.java,v 1.5 2012/08/03 08:13:06 belbeze Exp $ 
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
 *         $Log: Action.java,v $
 *         Revision 1.5  2012/08/03 08:13:06  belbeze
 *         Add ResourcesUpdate action for CMSIWriter
 *
 *         Revision 1.4  2012/02/16 13:43:53  lszabo
 *         CMSIWRiter 0.18: ContractTakeover operation.
 *
 *         Revision 1.3  2010/12/16 16:36:06  peltier
 *         Add:
 *         - Method to make payments
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

/**
 * @version Action.java
 * @version Created on 16 aout 2010, 18:29:11
 * @author tpeltier
 */
public class Action {
	public final static Long CREATE_CUSTOMER_AND_CONTRACT_ACTION = new Long(1);
	public final static Long CREATE_CONTRACT_ACTION = new Long(2);
	public final static Long DEL_SERVICE_LIST_ACTION = new Long(3);
	public final static Long ADD_SERVICE_LIST_ACTION = new Long(4);
	public final static Long SUSPEND_CONTRACT_ACTION = new Long(5);
	public final static Long REACTIVATE_CONTRACT_ACTION = new Long(6);
	public final static Long DEACTIVATE_CONTRACT_ACTION = new Long(7);
	public final static Long INVOICE_PAYMENT2_ACTION = new Long(8);
	public final static Long ADVANCE_PAYMENT_ACTION = new Long(9);
	public final static Long DEPOSIT_PAYMENT_ACTION = new Long(10);
	// OCC 1/2
    public final static Long OCC_ACTION = new Long(11);
    public final static Long INVOICE_PAYMENT1_ACTION = new Long(12);
    // OCC 2/2
    public final static Long OCC_ADVANCE_PAYMENT_ACTION = new Long(13);
    public final static Long CREATE_FURTHER_CHARGE_ACTION = new Long(14);
    public final static Long MODIFY_CONTRACT_PRODUCT_ACTION = new Long(15);
    public final static Long ACTIVATE_CONTRACT_ACTION = new Long(16);
    public final static Long FAMILY_MOVE_ACTION = new Long(17);
    public final static Long MODIFY_CUSTOMER_ACTION = new Long(18);
    public final static Long CREATE_LARGE_ACCOUNT_AND_CONTRACT = new Long(19);
    public final static Long CREATE_TICKLER = new Long(20);
    public final static Long MODIFY_CONTRACT_ACTION = new Long(21);
    public final static Long CONVERT_TO_FLAT_ACTION = new Long(22);
    public final static Long MODIFY_SERVICE_PARAMETER_ACTION = new Long(23);
    
    // Only for Egypt Mobinil
    //public final static Long SET_ITEMIZE_ON_BILL_ACTION = new Long(24);
    
    public final static Long ADD_DELETE_MICROCELL_ACTION = new Long(25);
    public final static Long MODIFY_MICROCELL_ACTION = new Long(26);
    public final static Long MODIFY_CONTRACT_RATEPLAN_ACTION = new Long(29);
    
    // Only for Maroc Telecom
    //public final static Long TRACE_ACTION_ACTION = new Long(27);
    //public final static Long SEND_SMS_ACTION = new Long(28);
    //public final static Long ACTION_UPDATE_ACTION = new Long(30);
	//public final static Long PROMOTION_DELETE_ACTION = new Long(32);
	//public final static Long NPTE_ACTION_ACTION = new Long(33);

    public final static Long RESOURCE_UPDATE_ACTION = new Long(31);

    public final static Long MODIFY_CREDIT_LIMIT_ACTION = new Long(34);
    public final static Long PAYMENT_ACTION = new Long(35);
    public final static Long MODIFY_SERVICE_ACCESS_FEE_ACTION = new Long(36);

    //Only for Mongolie Mobicom
    public final static Long CONTRACT_TAKEOVER_ACTION = new Long(43);
    
    public final static Long WELCOME = new Long(99);
}