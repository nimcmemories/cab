package com.cab.helper;

import java.util.Map;

import org.json.JSONObject;
public abstract class BaseHelper {
	public void insertRecord(JSONObject jsonObject){
		
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
	public boolean validateRequest(Map<String,String> requestParamMap){return true;}
}

