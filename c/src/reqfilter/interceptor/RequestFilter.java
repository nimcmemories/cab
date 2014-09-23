package reqfilter.interceptor;

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

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cab.CentralController;
/*
 * @author : Nimesh Makwana
 */
public class RequestFilter implements Filter {
	
    private ServletContext context;
    public static String webappPath ;
    /*
     * 
     * 
     */
    public void loggingInitialization(String log4j_prop,String webappPath){
    	System.out.println("initializing logging ... ");
    	if(log4j_prop == null){
    		System.out.println("null log4j_prop");
			try {
				throw new Exception("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");				
			} catch (Exception e) {
				BasicConfigurator.configure();
				e.printStackTrace();
			}
		}else{
			System.out.println("else in logging initialization : ");
			String propWithPath = webappPath + "/" + log4j_prop;
			File file = new File(propWithPath);
			System.out.println("else in logging initialization : 2");
			if(file.exists()){
				System.out.println("else in logging initialization : 3");
				PropertyConfigurator.configure(propWithPath);
				System.out.println("else in logging initialization : 4");
				Logger log = Logger.getLogger(RequestFilter.class);
				System.out.println("else in logging initialization : 5");
				log.debug("hello i am debug .... ");
				log.warn("i am a new warning");
			}else{
				try {
					throw new Exception("*** No log4j-properties found in WEB-INF directory");
				} catch (Exception e) {	
					System.out.println("exception ...");
					e.printStackTrace();
				}
			}
		}//END OF ELSE
    }
    @Override
	public void init(FilterConfig config) throws ServletException {    	
    	context = config.getServletContext();
    	webappPath = context.getRealPath("/");
    	
		System.out.println("RequestFilter : init + webapp path  : " +  webappPath);
		String log4j_prop = config.getInitParameter("log4j-prop");
		System.out.println("init params : " + log4j_prop);
		loggingInitialization(log4j_prop,webappPath);
	}
	@Override
	public void destroy() {
		System.out.println("RequestFilter : destroy" );
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> params = req.getParameterNames();
        System.out.println("final json" + CentralController.getRequestParamMap((HttpServletRequest)request));
        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = request.getParameter(name);            
            System.out.println(req.getRemoteAddr() );
            System.out.println("::Request Params::{"+name+"="+value+"}");
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
