package com.cab.customer;

import hibernate.HibernateConfiguartion;
import hibernate.bean.BikePackage;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;

public class BikePackageHelper extends BaseHelper{

public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		Session session = new HibernateConfiguartion().getSession(true);
		
		try {
			String name = jsonObject.getJSONObject("formData").getJSONObject("formData").getString("name");
			List<BikePackage> listBikePackages = session.createQuery("from BikePackage").list();
			JSONObject tmp = null;
			JSONArray bikePackageArray = new JSONArray();
			BikePackage bikePackageDetails = null;
			for (int i = 0; i < listBikePackages.size(); i++) {
				bikePackageDetails = (BikePackage)listBikePackages.get(i);
				tmp = new JSONObject();
				tmp.put("name", bikePackageDetails.getName());
				bikePackageArray.put(tmp);
			}
			jsonObject.put("bikePackageList", bikePackageArray);
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
