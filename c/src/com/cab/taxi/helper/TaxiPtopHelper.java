package com.cab.taxi.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;

public class TaxiPtopHelper extends BaseHelper{

public void insertRecord(JSONObject jsonObject){
		System.out.println("inside ptop insert method------>>");
		
		try {
			System.out.println("=========>> "+jsonObject.getJSONObject("formData"));
			JSONObject tmp = jsonObject.getJSONObject("formData");
			System.out.println("---------tmp >> "+tmp);
			JSONArray jsonArray = jsonObject.getJSONObject("formData").getJSONArray("formData");
			
			JSONObject data= null;
			
			for (int i = 0; i < jsonArray.length(); i++) {
				data = (JSONObject)jsonArray.get(i);
			}
			JSONObject res = new JSONObject();
			res.put("msg", "hello---------");
			jsonObject.put("response", res);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		
	}
	public void updateRecord(JSONObject jsonObject){
		
	}
	public void customProcedure(JSONObject jsonObject){
		System.out.println("base Helper custom procedure : ");
	}
}
