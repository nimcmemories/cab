package com.cab.bean;

public class HelperBean extends SystemBean{

	private int helperID;
	private int subentityID;
	private String name;
	private SubEntityBean subEntityBean ;
	public int getHelperID() {
		return helperID;
	}
	public void setHelperID(int helperID) {
		this.helperID = helperID;
	}
	public int getSubentityID() {
		return subentityID;
	}
	public void setSubentityID(int subentityID) {
		this.subentityID = subentityID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SubEntityBean getSubEntityBean() {
		return subEntityBean;
	}
	public void setSubEntityBean(SubEntityBean subEntityBean) {
		this.subEntityBean = subEntityBean;
	}

}
