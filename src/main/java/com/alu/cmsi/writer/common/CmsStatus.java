// <editor-fold defaultstate="collapsed" desc="History CVS">
/*
 * $Header: /home/BSCS_CVS/standard/commons/java/maven2/lib/CMSIWriter/src/main/java/com/alu/cmsi/writer/common/CmsStatus.java,v 1.1 2010/08/18 16:04:28 peltier Exp $ 
 *------------------------------------------------------------------------------
 *   ALCATEL-LUCENT/France                           
 *------------------------------------------------------------------------------
 *   Copyright (c) 2010 ALCATEL-LUCENT - All rights reserved
 *------------------------------------------------------------------------------
 *   CREATION DATE: 18 août 2010                          Author: tpeltier
 *------------------------------------------------------------------------------
 *
 *  HISTORY:
 *
 *         $Log: CmsStatus.java,v $
 *         Revision 1.1  2010/08/18 16:04:28  peltier
 *         Add:
 *         - getStatus feature => A procedure of XmlGeneratorI that allows to get the status of a given request id
 *         - getOutputArgs feature => A procedure of XmlGeneratorI that allows to get the status of a given request id
 *
 *
 */
// </editor-fold>
package com.alu.cmsi.writer.common;

/**
 * @version CmsStatus.java
 * @version Created on 18 août 2010, 11:56:51
 * @author tpeltier
 */
public final class CmsStatus {
	public final static CmsStatus ON_HOLD = new CmsStatus(new Long(3));
	public final static CmsStatus TO_BE_PROCESSED = new CmsStatus(new Long(2));
	public final static CmsStatus BEING_PROCESSED = new CmsStatus(new Long(99));
	public final static CmsStatus PROCESS_OK = new CmsStatus(new Long(1));
	public final static CmsStatus PROCESS_NOK = new CmsStatus(new Long(0));
	public final static CmsStatus UNKNOWN = new CmsStatus(new Long(-1));
	
	private Long value = null;
    /*
     * Constructor is PRIVATE
     */
    private CmsStatus(Long value) { this.value = value; }
    
    public Long getValue()  { return value; }
    public long longValue() { return value.longValue(); }
    public String toString(){ return value.toString(); }
    
    public static CmsStatus getCmsStatus(Long value) {
    	if (value == null) return UNKNOWN;
    	if (value.equals(ON_HOLD.value)) return ON_HOLD;
    	if (value.equals(TO_BE_PROCESSED.value)) return TO_BE_PROCESSED;
    	if (value.equals(BEING_PROCESSED.value)) return BEING_PROCESSED;
    	if (value.equals(PROCESS_OK.value)) return PROCESS_OK;
    	if (value.equals(PROCESS_NOK.value)) return PROCESS_NOK;
    	return UNKNOWN;
    }
}