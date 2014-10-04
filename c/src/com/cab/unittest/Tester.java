package com.cab.unittest;

import hibernate.HibernateConfiguartion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.cab.bean.BaseBean;
import com.cab.bean.ProfileBean;
import com.cab.bean.SystemBean;
import com.cab.helper.BaseHelper;
import com.cab.helper.TestHelper;

public class Tester {
	Logger logger = Logger.getLogger(Tester.class);
	public void testHibernateSelectQuery(){
		/*HibernateConfiguartion hibernateConfiguration  = new HibernateConfiguartion();
		List<SystemBean> baseBean = hibernateConfiguration.selectQuery("from ProfileBean");
		if(baseBean != null){
			logger.debug("call to CentralController list is not null now iterate that list");
			Iterator<BaseBean> profileIterator = (Iterator<BaseBean>)baseBean.iterator();
			while(profileIterator.hasNext()){
				System.out.println((ProfileBean)profileIterator.next());
			}
		}else{
			logger.debug("hibernate query did not return list");
		}*/
	}
	public static void main(String[] args) {
		try {
			Class classObject = Class.forName("com.cab.helper.TestHelper");
			BaseHelper baseHelper = (BaseHelper)classObject.newInstance();
			 baseHelper.customProcedure();
			 baseHelper.insertRecord();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
