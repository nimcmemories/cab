package com.cab.bean;

public class EntityBean {
	private int entityID;
	private String name,description;
	private ProfileDetailBean profileDetailBean;
	public int getEntityID() {
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
	public ProfileDetailBean getProfileDetailBean() {
		return profileDetailBean;
	}
	public void setProfileDetailBean(ProfileDetailBean profileDetailBean) {
		this.profileDetailBean = profileDetailBean;
	}
	
}
