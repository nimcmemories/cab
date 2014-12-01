package com.cab.partner;

import hibernate.HibernateConfiguartion;
import hibernate.bean.BikeDetails;
import hibernate.bean.PackageDetails;
import hibernate.bean.PartnerDetails;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cab.bean.BaseBean;
import com.cab.helper.BaseHelper;
import com.cab.util.CabUtil;

public class BikeHelper extends BaseHelper {
	public void insertRecord(JSONObject jsonObject){
		
		System.out.println("-----------inside bike helper insret method---->"+jsonObject);
		Session session = new HibernateConfiguartion().getSession(false);
		Transaction transaction = session.beginTransaction();
		JSONObject res = new JSONObject();
		try {
			Map<String,String> requestParamMap = CabUtil.getRequestParamMap(jsonObject.getJSONObject("formData").getJSONArray("formData"));
			if(this.validateRequest(requestParamMap)){
				//requeest valid
				BikeDetails bike = new BikeDetails();
				bike.setBikeImagePath("");
				bike.setBikeName(requestParamMap.get("bikeName"));
				bike.setDeposite(Integer.parseInt(requestParamMap.get("bikedeposite")));
				bike.setDescription(requestParamMap.get("description"));
				bike.setPartnerDetails((PartnerDetails)session.get(PartnerDetails.class, 1));//here partner id should be from session which partner logged in
				bike.setPerDayRate(Integer.parseInt(requestParamMap.get("bikeperdayrate")));
				bike.setPerHourRate(Integer.parseInt(requestParamMap.get("bikepwrhourrate")));
				int bikeID = (Integer)session.save(bike);
				System.out.println("-------------bike created and bikeid--99999999999999---->"+bikeID);
				res.put("status", 200);
				res.put("msg", "Bike added successfully.");
			}else{
				res.put("status",500);
				res.put("msg", "Bike could not be added.");
			}
		} catch (Exception e) {
			try {
				res.put("status", 500);
				res.put("msg", "Bike could not be added.");
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
		System.out.println("------------read reecod for bike helper");
		JSONObject res = new JSONObject();
		Session session = new HibernateConfiguartion().getSession(true);
		try{
		List<BikeDetails> bikeList = session.createQuery("from BikeDetails where partnerDetails.partnerDetailsId=1").list();  //need to add filter by logged in partener
		JSONArray bikeArray = new JSONArray();
		BikeDetails bike=null;
		for(int i=0;i<bikeList.size();i++){
			bike = bikeList.get(i);
			bikeArray.put(bike.getJsonObj());
		}
		res.put("status", 200);
		res.put("bikrArray", bikeArray);
		}catch(Exception e){
			try {
				res.put("status", 500);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				jsonObject.put("response", res);
			} catch (JSONException e) {
				// TODO Auto-generated c	atch block
				e.printStackTrace();
			}
		}
	}
	public void updateRecord(JSONObject jsonObject){
		
	}
	public void customProcedure(JSONObject jsonObject){
		System.out.println("base Helper custom procedure : ");
	}
	@Override
	public boolean validateRequest(Map<String, String> requestParamMap) {
		// TODO Auto-generated method stub
		return true;
	}

}
