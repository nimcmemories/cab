package com.cab.partner;

import hibernate.HibernateConfiguartion;
import hibernate.bean.PartnerDetails;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;
import com.cab.util.CabUtil;

public class PartnerLoginHelper extends BaseHelper{
	public void insertRecord(JSONObject jsonObject){
		
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		Session session = new HibernateConfiguartion().getSession(true);
		JSONObject resJson = new JSONObject();
		try {
			JSONArray dataArray = jsonObject.getJSONObject("formData").getJSONArray("formData");
			Map<String,String> formData = CabUtil.getRequestParamMap(dataArray);
			String username = formData.get("username");
			String password = formData.get("password");
			List<PartnerDetails> partnerDetailsList = session.createQuery("from PartnerDetails where partnerEmail='"+username+"' and partnerPassword='"+password+"'").list();
			if(partnerDetailsList.size()>0){
				PartnerDetails partnerDetails = (PartnerDetails)partnerDetailsList.get(0);
				resJson.put("status", "200");
			}else{
				resJson.put("status", "500");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				jsonObject.put("res", resJson);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void updateRecord(JSONObject jsonObject){
		
	}
	public void customProcedure(JSONObject jsonObject){
		System.out.println("base Helper custom procedure : ");
	}
}
