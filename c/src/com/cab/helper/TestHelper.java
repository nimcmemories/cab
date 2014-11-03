package com.cab.helper;

import org.json.JSONObject;

public class TestHelper extends BaseHelper{
	@Override
	public void insertRecord(JSONObject jsonObject){
		System.out.println("TestHelper : insertRecord method called.." );
	}
	@Override
	public void readRecords(JSONObject jsonObject) {System.out.println("TestHelper : readRecord method called.." );};
	@Override
	public void customProcedure(JSONObject jsonObject) {System.out.println("TestHelper : customRecord method called.." );};
	@Override
	public void deleteRecord(JSONObject jsonObject) {System.out.println("TestHelper : deleteRecord method called.." );};
	@Override
	public void updateRecord(JSONObject jsonObject) {System.out.println("TestHelper : updateRecord method called.." );};
	@Override
	public String toString(){
		return "I am test helper ";
	}
	
}
