package com.cab.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CabUtil {
	public static Map<String,String> getRequestParamMap(JSONArray jsonArray){
		Map<String,String> requestParamMap = new TreeMap<String, String>();
		JSONObject tmp=null;
		for(int i=0;i<jsonArray.length();i++){
			try {
				tmp = jsonArray.getJSONObject(i);
				requestParamMap.put(tmp.getString("name"), tmp.getString("value"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return requestParamMap;
	}
}
