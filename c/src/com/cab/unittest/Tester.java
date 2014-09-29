package com.cab.unittest;

import hibernate.HibernateConfiguartion;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.cab.bean.BaseBean;
import com.cab.bean.ProfileBean;

public class Tester {
	Logger logger = Logger.getLogger(Tester.class);
	public void testHibernateSelectQuery(){
		HibernateConfiguartion hibernateConfiguration  = new HibernateConfiguartion();
		List<BaseBean> baseBean = hibernateConfiguration.selectQuery("from ProfileBean");
		if(baseBean != null){
			logger.debug("call to CentralController list is not null now iterate that list");
			Iterator<BaseBean> profileIterator = (Iterator<BaseBean>)baseBean.iterator();
			while(profileIterator.hasNext()){
				System.out.println((ProfileBean)profileIterator.next());
			}
		}else{
			logger.debug("hibernate query did not return list");
		}
	}
}
