/**
 * 
 */
package com.project.config;

import java.io.File;
import java.util.Properties;

import com.project.util.AppUtil;

/**
 * @author ravi-1979
 *
 */
public class AppConfig {
	
	private final static String PROPS_FILE_BASE_URI = "/Users/ravi-1979/Docs/qwerty/apache-tomcat/wtpwebapps/projectvision/WEB-INF";	
	private final static Properties PROPERTIES = AppUtil.loadProperties(PROPS_FILE_BASE_URI+File.separator+"conf"+File.separator+"app.properties");
	
	
	public static String getProperty(String name){
		if(PROPERTIES == null || PROPERTIES.isEmpty()){
			return null;
		}
		return PROPERTIES.getProperty(name);
	}
}
