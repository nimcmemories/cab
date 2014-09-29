package com.cab.bean;

public class ProfileDetailBean extends BaseBean{
	private int profileDetailID ;
	private int profileID,subEntityID;
	private int accessType;
	public int getProfileDetailID() {
		return profileDetailID;
	}

	public void setProfileDetailID(int profileDetailID) {
		this.profileDetailID = profileDetailID;
	}

	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public int getSubEntityID() {
		return subEntityID;
	}
	
	public void setSubEntityID(int subEntityID) {
		this.subEntityID = subEntityID;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}

	/* (non-Javadoc)
	 * @see com.cab.bean.BaseBean#validateBean(java.lang.StringBuffer)
	 */
	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {

		return false;
	}

}
