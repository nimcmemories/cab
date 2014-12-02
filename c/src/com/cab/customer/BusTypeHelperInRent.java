package com.cab.customer;

import hibernate.HibernateConfiguartion;
import hibernate.bean.BusType;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;

public class BusTypeHelperInRent extends BaseHelper{

public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		Session session = new HibernateConfiguartion().getSession(true);
		try {
			String name = jsonObject.getJSONObject("formData").getJSONObject("formData").getString("name");
			List<BusType> listInBusType = session.createQuery("from BusType").list();
			BusType busType =null;
			JSONObject tmp = null;
			JSONArray busInRentArray = new JSONArray();
			for (int i = 0; i < listInBusType.size(); i++) {
				busType =(BusType)listInBusType.get(i);
				tmp = new JSONObject();
				tmp.put("name", busType.getBusType());
				busInRentArray.put(tmp);
			}
			jsonObject.put("busRentPackageList", busInRentArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	public void updateRecord(JSONObject jsonObject){
		
	}
	public void customProcedure(JSONObject jsonObject){
		System.out.println("base Helper custom procedure : ");
	}
	public boolean validateRequest(Map<String,String> requestParamMap){return true;}
}
