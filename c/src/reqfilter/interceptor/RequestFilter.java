package reqfilter.interceptor;

import hibernate.HibernateConfiguartion;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cab.CentralController;

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
		HibernateConfiguartion.createSessionFactory();
	}
	@Override
	public void destroy() {
		logger.debug("RequestFilter : destroy" );
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> params = req.getParameterNames();
        /*
         * Check session for users's autheticity : 
         */
        System.out.println(checkSession(req));
        
        logger.debug("final json" + CentralController.getRequestParamMap((HttpServletRequest)request));
        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = request.getParameter(name);            
            System.out.println(req.getRemoteAddr() );
            logger.debug("::Request Params::{"+name+"="+value+"}");
        }
         
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
            }
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);	
	}
}
