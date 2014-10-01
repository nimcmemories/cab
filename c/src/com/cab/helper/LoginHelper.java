package com.cab.helper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginHelper {
	private String userName,password,__userType;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String get__userType() {
		return __userType;
	}
	public void set__userType(String __userType) {
		this.__userType = __userType;
	}
	public boolean validateParams(ServletRequest req,ServletResponse res){
		userName = req.getParameter("username");
		password = req.getParameter("password");
		__userType = req.getParameter("__usertype");
		if(userName.contains(" ")){
			req.setAttribute("__loginvalidatormessage", "username can not contain space");
			return false;
		}
		return authenticate(userName, password);
	}
	public boolean authenticate(String userName,String password){
		//AUTHENTICATION CODE GOES HERE , CALL HIBERNATE QUERIES TO GET USERNAME ACCORDING TO ITS TYPE AND MATCH
		return true;
	}
}
