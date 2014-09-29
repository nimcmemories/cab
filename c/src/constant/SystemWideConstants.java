package constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;
/*
* @author : Nimesh Makwana
*/
public class SystemWideConstants {
	public static int USER_SESSION_TIMEOUT ;
	public static String WEBAPPPATH = "";
	static  Logger logger = Logger.getLogger(SystemWideConstants.class);
	static public void loadProperties(){
		WEBAPPPATH = WEBAPPPATH  + "/WEB-INF/classes/";
		File systemWidePropertyFile = new File(WEBAPPPATH+"/system.properties");   
		try {
			PropertyResourceBundle propBundle = new PropertyResourceBundle(new FileInputStream(systemWidePropertyFile));
			USER_SESSION_TIMEOUT  = Integer.parseInt((String)propBundle.getObject("usersessiontimeout"));
			logger.debug("user session timeout : " + USER_SESSION_TIMEOUT);
		} catch (FileNotFoundException e) {
			logger.error("Setting system wide proprties file not found exception system.properties ", e);
		} catch (IOException e) {
			logger.error("Setting system wide proprties throws error ", e);
		}
		
	}
}
