package com.cab.bean;

import java.util.HashSet;
import java.util.Set;

public class EventBean extends SystemBean{
	private int eventID;
	private int eventType,helperID;
	private HelperBean helperBean ;
	 private Set cbresponseDetailses = new HashSet(0);
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public int getHelperID() {
		return helperID;
	}
	public void setHelperID(int helperID) {
		this.helperID = helperID;
	}
	public HelperBean getHelperBean() {
		return helperBean;
	}
	public void setHelperBean(HelperBean helperBean) {
		this.helperBean = helperBean;
	}
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	 public Set getCbresponseDetailses() {
	        return this.cbresponseDetailses;
	    }
	    
	    public void setCbresponseDetailses(Set cbresponseDetailses) {
	        this.cbresponseDetailses = cbresponseDetailses;
	    }
}
