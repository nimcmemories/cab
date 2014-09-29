package com.cab.bean;

import java.util.Set;

/*
 * @author Nimesh Makwana
 */
public class ProfileBean extends BaseBean{
	private int profileID;
	private String profileName,description;
	private Set<ProfileDetailBean> setProfileDetailBean;

	
	public int getProfileID() {
		return profileID;
	}
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see com.cab.bean.BaseBean#validateBean(java.lang.StringBuffer)
	 */
	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		
		return false;
	}
	public Set<ProfileDetailBean> getSetProfileDetailBean() {
		return setProfileDetailBean;
	}
	public void setSetProfileDetailBean(Set<ProfileDetailBean> setProfileDetailBean) {
		this.setProfileDetailBean = setProfileDetailBean;
	}
	@Override
	public String toString(){
		return "profile Name " + profileName + " set profile detail bean :  " + setProfileDetailBean;
	}
}
