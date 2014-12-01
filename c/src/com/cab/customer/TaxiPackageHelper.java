package com.cab.customer;

import hibernate.HibernateConfiguartion;
import hibernate.bean.PackageDetails;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;

public class TaxiPackageHelper extends BaseHelper{
public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		
		Session session = new HibernateConfiguartion().getSession(true);
		try {
			String name = jsonObject.getJSONObject("formData").getJSONObject("formData").getString("name");
			List<PackageDetails> listpackagedetails = session.createQuery("from PackageDetails").list();
			JSONArray packageArray = new JSONArray();
			PackageDetails packageDetails = null;
			JSONObject tmp =null;
			for(int i=0;i<listpackagedetails.size();i++){
				packageDetails = (PackageDetails)listpackagedetails.get(i);
				tmp = new JSONObject();
				tmp.put("name", packageDetails.getPackageName());
				packageArray.put(tmp);
			}
			jsonObject.put("packageList", packageArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
