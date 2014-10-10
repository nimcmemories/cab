package com.cab.helper;

import hibernate.HibernateConfiguartion;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.cab.bean.UserBean;
/*
* @author : Nimesh Makwana
*/

public class LoginHelper {
	private String userName,password,__userType;
	Logger logger=Logger.getLogger(LoginHelper.class);
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
	public UserBean validateParams(ServletRequest req,ServletResponse res){
		userName = req.getParameter("username");
		password = req.getParameter("password");
		__userType = req.getParameter("__usertype");
		if(userName == null || password == null){
			System.out.println("username/password is null");
			return null;
		}
		if(userName.contains(" ")){
			req.setAttribute("__loginvalidatormessage", "username can not contain space");
			return null;
		}
		return authenticate(userName, password);
	}
	public UserBean authenticate(String userName,String password){
		HibernateConfiguartion hibernateConfiguartion ;
		Session session  = null;
		UserBean userBean = null;
		try{
			hibernateConfiguartion = new HibernateConfiguartion();
			session = hibernateConfiguartion.getSession(true);
			session.beginTransaction();
			userBean = (UserBean)session.createQuery("from UserBean where username = '" + userName + "' and password = '" + password + "'").uniqueResult();
		}catch(Exception e){
			logger.debug("LoginHelper authenticationFailed");
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return userBean;
	
	}
}
