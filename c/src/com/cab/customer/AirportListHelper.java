package com.cab.customer;

import java.util.List;

import hibernate.HibernateConfiguartion;
import hibernate.bean.AirportDetails;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;

public class AirportListHelper extends BaseHelper {

	public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		Session session=new HibernateConfiguartion().getSession(true);
		try {
			int cityId = jsonObject.getJSONObject("formData").getJSONObject("formData").getInt("cityId");
			List<AirportDetails> airportDetailsList = session.createSQLQuery("select * from airport_details where city_master_id="+cityId+" order by airport_name").addEntity(AirportDetails.class).list();
			JSONArray airportArray = new JSONArray();
			AirportDetails airportDetails=null;
			JSONObject tmp=null;
			for(int i=0;i<airportDetailsList.size();i++){
				airportDetails =(AirportDetails) airportDetailsList.get(i);
				tmp = new JSONObject();
				tmp.put("id",airportDetails.getAirportId());
				tmp.put("name",airportDetails.getAirportName());
				airportArray.put(tmp);
			}
			jsonObject.put("airportList", airportArray);
		} catch (JSONException e) {
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
