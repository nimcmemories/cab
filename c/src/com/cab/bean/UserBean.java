package com.cab.bean;
/**
 * 
 * @author : Nimesh Makwana
 */
public class UserBean extends BaseBean {

	private int userID;
	private String username,password;
	private int userType;
	private int parentID;
	private int profileID;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see com.cab.bean.BaseBean#validateBean(java.lang.StringBuffer)
	 */
	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		
		return false;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString(){
		return "username:" + username + " password:" + password + " userType:" +userType;
		
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public int getProfileID() {
		return profileID;
	}
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
}
