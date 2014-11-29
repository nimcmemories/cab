package com.cab.helper;

import hibernate.HibernateConfiguartion;
import hibernate.bean.CityMaster;

import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

public class CityNameListHelper extends BaseHelper{
	@Override
	public void insertRecord(JSONObject jsonObject){
		
	}
	@Override
	public void readRecords(JSONObject jsonObject) {
		System.out.println("TestHelper : readRecord method called.." );
	Session session = new HibernateConfiguartion().getSession(true);	
	try {
			String cityName = jsonObject.getJSONObject("formData").getJSONObject("formData").getString("cityName");
			List<CityMaster> cityList = session.createQuery("from CityMaster where cityName like '%"+cityName+"%' order by cityName").list();
			JSONArray cityArray = new JSONArray();
			JSONObject tmpJson=null;
			CityMaster city=null;
			for (int i = 0; i <cityList.size(); i++) {
				city = cityList.get(i);
				tmpJson = new JSONObject();
				tmpJson.put("id",city.getCityMasterId());
				tmpJson.put("name",city.getCityName());
				cityArray.put(tmpJson);
				System.out.println();
			}
			jsonObject.put("cityArray", cityArray);
		} catch (Exception e) {
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
