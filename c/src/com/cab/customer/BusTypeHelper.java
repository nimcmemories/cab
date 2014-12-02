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

public class BusTypeHelper extends BaseHelper{

	public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		Session session = new HibernateConfiguartion().getSession(true);
		try {
			String name = jsonObject.getJSONObject("formData").getJSONObject("formData").getString("name");
			List<BusType> listBusType = session.createQuery("from BusType").list();
			BusType busType =null;
			JSONObject tmp = null;
			JSONArray busArray = new JSONArray();
			for (int i = 0; i < listBusType.size(); i++) {
				busType =(BusType)listBusType.get(i);
				tmp = new JSONObject();
				tmp.put("name", busType.getBusType());
				busArray.put(tmp);
			}
			jsonObject.put("busPackageList", busArray);
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
