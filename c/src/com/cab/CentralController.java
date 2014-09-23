package com.cab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import reqfilter.constants.FilterConstants;

/**
 * Servlet implementation class CentralController
 * 
 * @author : Nimesh Makwana
 */
@WebServlet("/CentralController")
public class CentralController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		System.out.println("do get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post");
	}
	
	
	public static JSONObject getRequestParamMap(HttpServletRequest request){
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
