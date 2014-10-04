package com.cab.bean;

public class SubEntityBean  extends SystemBean {
	private int subentityID,entityID;
	private String name,description;
	private EntityBean entityBean;
	public int getSubentityID() {
		return subentityID;
	}
	public void setSubentityID(int subentityID) {
		this.subentityID = subentityID;
	}
	public int getEntitsyID() {
		return entityID;
	}
	public void setEntityID(int entityID) {
		this.entityID = entityID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EntityBean getEntityBean() {
		return entityBean;
	}
	public void setEntityBean(EntityBean entityBean) {
		this.entityBean = entityBean;
	}
}
