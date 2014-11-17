package com.cab.helper;

import java.util.List;

import hibernate.HibernateConfiguartion;
import hibernate.bean.CityMaster;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityNameListHelper extends BaseHelper{
	@Override
	public void insertRecord(JSONObject jsonObject){
		
	}
	@Override
	public void readRecords(JSONObject jsonObject) {System.out.println("TestHelper : readRecord method called.." );
	Session session = new HibernateConfiguartion().getSession(true);	
	try {
			System.out.println("----------------------1");
			
			List<CityMaster> cityList = session.createQuery("from CityMaster").list();
			JSONObject cityObject = new JSONObject();
			JSONArray cityArray = new JSONArray();
			JSONObject tmpJson=null;
			CityMaster city=null;
			System.out.println("-------cityList size---->"+cityList.size());
			for (int i = 0; i <cityList.size(); i++) {
				System.out.println("--------->"+i);
				city = cityList.get(i);
				tmpJson = new JSONObject();
				//tmpJson.put(city.getCityMasterId(),city.getCityName());
				tmpJson.put(city.getCityMasterId()+"", city.getCityName());
				cityArray.put(tmpJson);
			}
			System.out.println("----------array sizw----->"+cityArray.length());
			jsonObject.put("cityArray", cityArray);
			//jsonObject.p
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	@Override
	public void customProcedure(JSONObject jsonObject) {System.out.println("TestHelper : customRecord method called.." );};
	@Override
	public void deleteRecord(JSONObject jsonObject) {System.out.println("TestHelper : deleteRecord method called.." );};
	@Override
	public void updateRecord(JSONObject jsonObject) {System.out.println("TestHelper : updateRecord method called.." );};
	@Override
	public String toString(){
		return "I am test helper ";
	}

}
