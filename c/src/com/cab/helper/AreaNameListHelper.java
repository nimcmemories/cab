package com.cab.helper;

import java.util.List;

import hibernate.HibernateConfiguartion;
import hibernate.bean.AreaMaster;
import hibernate.bean.CityMaster;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AreaNameListHelper extends BaseHelper{
	public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		System.out.println("----------inside readRecords"+jsonObject);
		Session session=null;
		try {
			int cityId = Integer.parseInt(jsonObject.getJSONObject("formData").getJSONObject("formData").getString("cityId"));
			String areaName = jsonObject.getJSONObject("formData").getJSONObject("formData").getString("areaName");
			System.out.println("area name--->"+areaName);
			System.out.println("city id----->"+cityId);
			session = new HibernateConfiguartion().getSession(true);
			System.out.println("from AreaMaster where cityMaster="+cityId+" and areaName like '%"+areaName+"%'");
			List<AreaMaster> cityBeanList = session.createQuery("from AreaMaster where cityMaster="+cityId+" and areaName like '%"+areaName+"%'").list();
			JSONArray cityArray = new JSONArray();
			//CityMaster cityMaster=null;
			JSONObject tmp=null;
			for (int i = 0; i < cityBeanList.size(); i++) {
				
				tmp = new JSONObject();
				tmp.put("id", cityBeanList.get(i).getAreaMasterId());
				tmp.put("areaName", cityBeanList.get(i).getAreaName());
				cityArray.put(tmp);
			}
			jsonObject.put("areaList", cityArray);
		} catch (Exception e) {
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
}
