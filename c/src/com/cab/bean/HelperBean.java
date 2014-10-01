package com.cab.bean;

public class HelperBean extends BaseBean{

	private int helperID;
	private int subentityID;
	private String name;
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
	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		return false;
	}

}
