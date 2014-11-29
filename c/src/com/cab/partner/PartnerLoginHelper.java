package com.cab.partner;

import java.util.Map;

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
		System.out.println("=====================inside helper for partner login check=---->"+jsonObject);
		try {
			JSONArray dataArray = jsonObject.getJSONObject("formData").getJSONArray("formData");
			Map<String,String> fromData = CabUtil.getRequestParamMap(dataArray);
			System.out.println("==========map===========inside helper for partner login check=---->"+fromData);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateRecord(JSONObject jsonObject){
		
	}
	public void customProcedure(JSONObject jsonObject){
		System.out.println("base Helper custom procedure : ");
	}
}
