package com.cab.partner;

import hibernate.HibernateConfiguartion;
import hibernate.bean.BusDetails;
import hibernate.bean.BusType;
import hibernate.bean.PartnerDetails;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.helper.BaseHelper;
import com.cab.util.CabUtil;

public class BusHelper extends BaseHelper{
	
public void insertRecord(JSONObject jsonObject){
	System.out.println("inside of the bus insert records------------------><><><><><>");
	Session session = new HibernateConfiguartion().getSession(false);
	Transaction transaction = session.beginTransaction();
	JSONObject res = new JSONObject();
	
	try {
		Map<String, String> requestParamMap = CabUtil.getRequestParamMap(jsonObject.getJSONObject("formData").getJSONArray("formData"));
		if(this.validateRequest(requestParamMap)){
			BusDetails bus = new BusDetails();
			bus.setBusType((BusType)session.get(BusType.class,1));
			bus.setPartnerDetails((PartnerDetails)session.get(PartnerDetails.class,1));
			bus.setBusTittle(requestParamMap.get("bustittle"));
			bus.setNoOfSeat(Integer.parseInt(requestParamMap.get("seat")));
			bus.setPerKmRate(Integer.parseInt(requestParamMap.get("perkmrate")));
			bus.setWaitingChargeHour(Integer.parseInt(requestParamMap.get("waitingchargeperhour")));
			bus.setBusImage("");
			bus.setBusNumber(requestParamMap.get("busnumber"));
			bus.setEnableForTicker((byte)1);
			bus.setNote(requestParamMap.get("note"));
			bus.setIsEnable((byte)1);
			
			int BusId = (Integer)session.save(bus);
			System.out.println("got inside of the database bus ....................");
			res.put("status", 200);
			res.put("msg", "bus added successfully.");
		}else{
			res.put("status",500);
			res.put("msg", "bus could not be added.");
		}
	} catch (Exception e) {
		try {
			res.put("status", 500);
			res.put("msg", "bus could not be added.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
		}
		e.printStackTrace();
	}finally{
		try {
			jsonObject.put("response", res);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transaction.commit();
		session.close();
	}
}
	public void deleteRecord(JSONObject jsonObject){
		
	}
	public void readRecords(JSONObject jsonObject){
		System.out.println("in read bus records-------------->>>");
		JSONObject res = new JSONObject();
		Session session = new HibernateConfiguartion().getSession(true);
		BusDetails bus = null;
		JSONArray busArray = new JSONArray();
		List<BusDetails> busDetailsList = session.createQuery("from BusDetails").list();
		for (int i = 0; i < busDetailsList.size(); i++) {
			bus = busDetailsList.get(i);
			busArray.put(bus.getJsonObj());
		}
	}
	public void updateRecord(JSONObject jsonObject){
		
	}
	public void customProcedure(JSONObject jsonObject){
		System.out.println("base Helper custom procedure : ");
	}
	public boolean validateRequest(Map<String,String> requestParamMap){return true;}
}
