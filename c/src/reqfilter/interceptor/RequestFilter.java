package reqfilter.interceptor;

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

import com.cab.CentralController;

public class RequestFilter implements Filter {
    private ServletContext context;
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

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("RequestFilter : init" );
	}

}
