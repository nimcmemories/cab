package reqfilter.interceptor;

import hibernate.HibernateConfiguartion;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import reqfilter.constants.FilterConstants;

import com.cab.bean.BaseBean;
import com.cab.bean.EventBean;
import com.cab.bean.HelperBean;
import com.cab.bean.ProfileDetailBean;
import com.cab.bean.SubEntityBean;
import com.cab.bean.SystemBean;
import com.cab.bean.UserBean;
import com.cab.helper.LoginHelper;

import constant.SystemWideConstants;
/*
 * @author : Nimesh Makwana
 */
public class RequestFilter implements Filter {
	Logger logger = Logger.getLogger(RequestFilter.class);
    private ServletContext context;
    public static String webappPath ;
    
    
    public boolean checkSession(HttpServletRequest req){
    	HttpSession session = req.getSession();
    	if(session.isNew()){
    		logger.debug("session is new : " + session.getId());
    		session.setMaxInactiveInterval(SystemWideConstants.USER_SESSION_TIMEOUT);
    		return true;
    	}else{
    		logger.debug("session is old: " + session.getId());
    		session.setMaxInactiveInterval(SystemWideConstants.USER_SESSION_TIMEOUT);
    		return false;
    	}
    }
    public UserBean getUserBean(HttpSession session){
    	UserBean userBean = new UserBean();
    	Object userName = session.getAttribute("__isGuest");
    	Object userType = session.getAttribute("__usertype");
    	userBean.setUsername(userName!=null?"__guestuser":(session.getAttribute("__username")!=null?((String)session.getAttribute("__username")):"__unown"));
    	userBean.setUserType(userName!=null?(Integer)userType:null);
    	userBean.setParentID(0);
    	logger.debug("userBean : " + userBean);
    	return userBean;
    }
    /*
     * Logging initiated
     */
    public void loggingInitialization(String log4j_prop,String webappPath){
    	logger.debug("initializing logging ... ");
    	if(log4j_prop == null){
    		logger.debug("null log4j_prop");
			try {
				throw new Exception("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");				
			} catch (Exception e) {
				BasicConfigurator.configure();
				e.printStackTrace();
			}
		}else{
			logger.debug("else in logging initialization : ");
			String propWithPath = webappPath + "/" + log4j_prop;
			File file = new File(propWithPath);
			logger.debug("else in logging initialization : 2");
			if(file.exists()){
				PropertyConfigurator.configure(propWithPath);
				logger.debug("propertyConfigurator : setting properties ..." );
			}else{
				try {
					throw new Exception("*** No log4j-properties found in WEB-INF directory");
				} catch (Exception e) {	
					logger.debug("exception ...");
					e.printStackTrace();
				}
			}
		}//END OF ELSE
    }
    @Override
	public void init(FilterConfig config) throws ServletException {    	
    	context = config.getServletContext();
    	webappPath = context.getRealPath("/");
    	SystemWideConstants.WEBAPPPATH = webappPath;
    	SystemWideConstants.loadProperties();
    	
		logger.debug("RequestFilter : init + webapp path  : " +  webappPath);
		String log4j_prop = config.getInitParameter("log4j-prop");
		logger.debug("init params : " + log4j_prop);
		loggingInitialization(log4j_prop,webappPath);
		
		/*
		 * initialize hibernate engine
		 */
		System.out.println("=========================================================");
		HibernateConfiguartion.createSessionFactory();
		HibernateConfiguartion hbConf = new HibernateConfiguartion();
		//List<BaseBean> list = hbConf.selecBaseBeantQuery("from CityMaster");
		List<BaseBean> userList = hbConf.selecBaseBeanQuery("from UserBean");
		System.out.println("********************************************user****************>"+userList.size());
		//System.out.println("*********************************************area***************>"+list.size());
		
	}
	@Override
	public void destroy() {
		logger.debug("RequestFilter : destroy" );
	}
	
	private int checkACL(UserBean userBean,int __eventId,HelperBean helperBean){
		 List<SystemBean> list = null;
	        Session hibernateSession = null;
	        Transaction tx = null;
	        try{
		        hibernateSession = new HibernateConfiguartion().getSession(true);
		        tx = hibernateSession.beginTransaction();
		        		//selectQuery(");
		        // get action access check here
		        	list = hibernateSession.createQuery("from EventBean where eventID = " + __eventId).list();
		        	EventBean eventBean = (EventBean)list.get(0);
			        Hibernate.initialize(eventBean.getHelperBean());
			        helperBean = eventBean.getHelperBean();
			        SubEntityBean subEntityBean = eventBean.getHelperBean().getSubEntityBean();
			        logger.debug("Subentity resolved : " + subEntityBean.getName());
			        userBean = (UserBean)hibernateSession.createQuery("from UserBean where username = '" + 
			        		(userBean.getUsername().equals("__guestuser")?"guestuser":userBean.getUsername()) + "' and parentID = " + userBean.getParentID()).uniqueResult();
			        ProfileDetailBean profileDetailBean = (ProfileDetailBean)hibernateSession.createQuery("from ProfileDetaiBean where profileID = " + userBean.getProfileID() + " and subEntityID = " + subEntityBean.getSubentityID());
			        return profileDetailBean.getAccessType();
	        }catch (Exception e){
	        	//*** ITS TOO CRITICAL IF I FALL IN THIS BLOCK 
	        	logger.debug(" ITS TOO CRITICAL TO BE HERE .. RESOLVE ME FIRST for now I am replying with denial of access : ");
	        	e.printStackTrace();
	        	return 0;
	        }finally{
	        	if(hibernateSession!=null){
	        		logger.debug("hibernate session closed in checkACL(*,*) method");
	        		hibernateSession.close();
	        	}
	        }
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.debug("doFilter called :");
		HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> params = req.getParameterNames();
        boolean isNewSession = checkSession(req);
        HttpSession session = req.getSession();
        boolean isGuest = false;
        int __eventId = 0;//Integer.parseInt((String)request.getParameter(FilterConstants.__EVENT_ID));
        // userTypes can be : Admin,Partner,EndUser,Guest respectively 0,1,2,3 where 2,3 type are for end user 3 is guest user 2 is authenticated user
        /*
         * Check session for users's autheticity : 
         */
        logger.debug("session state : isNewSession " + isNewSession);
        
        UserBean userBean = null;
        if(isNewSession){
            if(__eventId == 10914){
            	logger.debug("DO FILTER  : LOGIN ACTION");
            	LoginHelper loginHelper = new LoginHelper();
            	userBean = loginHelper.validateParams(request, response);
            	if(userBean != null){
            		session.setAttribute("__username",userBean.getUsername());
            		session.setAttribute("__usertype",userBean.getUserType());
            	}else{
            		//***AUTHENTICATION FAILURE
            		//***REDIRECT TO LOGIN PAGE WITH FAILURE REASON
            		System.out.println("login request with 10914 event id ");
            		session.invalidate();
            		return;
            	}
            }else{
            	//session creation for non login request
            	session.setAttribute("__username", session.getId());
            	session.setAttribute("__isGuest", true);
        		session.setAttribute("__usertype",3);
        		userBean = this.getUserBean(session);
        		isGuest = true;
            }
            session.setAttribute("userBean", userBean);
        }
        HelperBean helperBean = null ;
        userBean = (UserBean)session.getAttribute("userBean");
        int aclStatus = checkACL(userBean, __eventId,helperBean);
        if(helperBean!=null){
        	System.out.println("helperbean is not null");
        }else
        	System.out.println("helperbean is null");
        
        if(aclStatus == 2){
        	/*
        	 * userHas readWrite access for event
        	 */
        	request.setAttribute("permission", "allowRW");
        	request.setAttribute("helperBean", helperBean);
        	logger.debug("acl status is 2");
        }else if(aclStatus == 1){
        	/*
        	 * userHas readOnly access for event
        	 */
        	request.setAttribute("permission", "allowRO");
        	logger.debug("acl status is 1");
        }else{
        	/*
        	 * denial of access for this event
        	 */
        	request.setAttribute("permission", "deny");
        	logger.debug("acl status is 0");
        }
        
       /* if(list != null){
	        	
	        	        
	        if(list!= null){
	        	logger.debug("HELPER BEAN SELECT QUERY : HELPER NOT NULL " );
	        }else
	        	logger.debug("HELPER BEAN SELECT QUERY : HELPER is NULL ");
	        Cookie[] cookies = req.getCookies();
	        if(cookies != null){
	            for(Cookie cookie : cookies){
	                this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
	            }
	        }
	        // pass the request along the filter chain
	        System.out.println("doFilter chain controll pass on ");
        }*/
       chain.doFilter(request, response);	
	}
	public void eventIDManipulate(int eventID){
		HibernateConfiguartion hibernateConfiguration = new HibernateConfiguartion();
		hibernateConfiguration.selectSystemBeanQuery("from EventBean");
	}
}
