package com.cab.taxi.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;

public class EditDriverHelper extends BaseHelper{

	@Override
	public void insertRecord(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		super.insertRecord(jsonObject);
	}

	@Override
	public void deleteRecord(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		super.deleteRecord(jsonObject);
	}

	@Override
	public void readRecords(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		super.readRecords(jsonObject);
	}

	@Override
	public void updateRecord(JSONObject jsonObject) {
		System.out.println("inside update method----"+jsonObject);
		
		try {
			System.out.println("--->"+jsonObject.getJSONObject("formData"));
			JSONObject tmp = jsonObject.getJSONObject("formData");
		
			System.out.println("---------tmp > "+tmp);
			JSONArray jsonArray = jsonObject.getJSONObject("formData").getJSONArray("formData");
			JSONObject data = null;
			
			for (int i = 0; i < jsonArray.length(); i++) {
				data = (JSONObject)jsonArray.get(i);
				System.out.println("param name--->"+data.getString("name"));
				System.out.println("value ---->"+data.getString("value"));
				JSONObject res = new JSONObject();
				res.put("mit","hii");
				jsonObject.put("response",res);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void customProcedure(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		super.customProcedure(jsonObject);
	}

	
	

}
