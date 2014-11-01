package com.cab;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.cab.bean.EventBean;
import com.cab.bean.HelperBean;
import com.cab.helper.BaseHelper;
import com.cab.unittest.Tester;

import constant.SystemWideConstants;
import reqfilter.constants.FilterConstants;

/**
 * Servlet implementation class CentralController
 * 
 * @author : Nimesh Makwana
 */
@WebServlet("/CentralController")
public class CentralController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(CentralController.class);
	Tester tester = new Tester();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentralController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		System.out.println("do get");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post");
		JSONObject jsonObjectOfRequest = getRequestParamMap((HttpServletRequest)request);
		HelperBean helperBean = (HelperBean)request.getAttribute("helperBean");
		EventBean eventBean = (EventBean)request.getAttribute("eventBean");
		if(helperBean != null && eventBean != null){
			System.out.println("helperbean in central controller is not null load helper -> " + helperBean.getName());
			Class baseClass;
			BaseHelper baseHelper;
			try {
				baseClass = Class.forName(helperBean.getName());
				baseHelper = (BaseHelper)baseClass.newInstance();
				if(SystemWideConstants.SYSTEM_READ_EVENT == eventBean.getEventType()){
					System.out.println("system read event");
					baseHelper.readRecords(jsonObjectOfRequest);
				}else if(SystemWideConstants.SYSTEM_INSERT_EVENT== eventBean.getEventType()){
					System.out.println("system insert event");
					baseHelper.insertRecord(jsonObjectOfRequest);
				}else if(SystemWideConstants.SYSTEM_UPDATE_EVENT == eventBean.getEventType()){
					System.out.println("system update event");
					baseHelper.updateRecord(jsonObjectOfRequest);
				}else if(SystemWideConstants.SYSTEM_DELETE_EVENT == eventBean.getEventType()){
					System.out.println("system delete event");
					baseHelper.deleteRecord(jsonObjectOfRequest);
				}else if(SystemWideConstants.SYSTEM_CUSTOM_EVENT == eventBean.getEventType()){
					System.out.println("system custom event");
					baseHelper.customProcedure(jsonObjectOfRequest);
				}
				System.out.println("printing helper "  + baseHelper.toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			 
		}
		tester.testHibernateSelectQuery();
	}
	
	
	public JSONObject getRequestParamMap(HttpServletRequest request){
		JSONObject jsonObject = null;
		try {
			if(request.getParameter("json") !=null)
				jsonObject = new JSONObject(request.getParameter("json"));
			else
				jsonObject = new JSONObject();
			if(request.getParameter("elid")!=null)
				jsonObject.put("elid", request.getParameter("elid"));
			if(request.getParameter("ipType")!=null)
				jsonObject.put("ipType", request.getParameter("ipType"));
			jsonObject.put(FilterConstants.__EVENT_ID, request.getParameter(FilterConstants.__EVENT_ID));
			jsonObject.put(FilterConstants.__REQUEST_TYPE, request.getParameter(FilterConstants.__REQUEST_TYPE));
			System.out.println("req json :  " + jsonObject);
		} catch (Exception e) {
			System.out.println("Exception while casting to JSON");
		}
		return jsonObject;
	}
	
}
