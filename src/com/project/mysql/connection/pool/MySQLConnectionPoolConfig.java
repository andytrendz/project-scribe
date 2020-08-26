/**
 * 
 */
package com.project.mysql.connection.pool;

import java.io.File;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.project.constants.AppConstants;
import com.project.mysql.util.MySQLUtil;

/**
 * @author ravi-1979
 *
 */
public class MySQLConnectionPoolConfig extends GenericObjectPoolConfig {
	
private static final String FILE_URI = AppConstants.SERVER_HOME+File.separator+"conf"+File.separator;
	
	public static final Logger LOG = Logger.getLogger(MySQLConnectionPoolConfig.class.getName());
	
	public MySQLConnectionPoolConfig(){
		
		Properties configProps = MySQLUtil.loadProperties(FILE_URI+"mysql-conn-pool-cfg.properties");
		
		if(configProps != null){
			
			super.setMaxTotal(Integer.valueOf(configProps.getProperty("maxTotal",String.valueOf(20))));
			super.setMaxIdle(Integer.valueOf(configProps.getProperty("maxIdle",String.valueOf(20))));
			super.setMinIdle(Integer.valueOf(configProps.getProperty("minIdle",String.valueOf(5))));
			super.setTestOnBorrow(Boolean.valueOf(configProps.getProperty("testOnBorrow","true")));
			super.setTestWhileIdle(Boolean.valueOf(configProps.getProperty("testWhileIdle","false")));
			super.setTimeBetweenEvictionRunsMillis(Long.valueOf(configProps.getProperty("timeBetweenEvictionRunsMillis","-1")));
			super.setNumTestsPerEvictionRun(Integer.valueOf(configProps.getProperty("numTestsPerEvictionRun","-1")));
			super.setMaxWaitMillis(Long.valueOf(configProps.getProperty("maxWaitMillis","-1")));
			super.setBlockWhenExhausted(Boolean.valueOf(configProps.getProperty("blockWhenExhausted","true")));
		}
	}
}
