/**
 * 
 */
package com.project.mysql.connection.pool;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.mysql.connection.MySQLConnection;

/**
 * @author ravi-1979
 *
 */
public class MySQLConnectionPoolHandler {
	
	public static MySQLConnectionPool MYSQL_CONNECTION_POOL;
	private static final Logger LOG = Logger.getLogger(MySQLConnectionPoolHandler.class.getName());
	
	public static void initializeConnectionPool(){
		
		try {
			MySQLConnectionPoolFactory MySQLConnectionPoolFactory = new MySQLConnectionPoolFactory();
			MySQLConnectionPoolConfig MySQLConnectionPoolConfig = new MySQLConnectionPoolConfig();
			
			MYSQL_CONNECTION_POOL = new MySQLConnectionPool(MySQLConnectionPoolFactory,MySQLConnectionPoolConfig);
			
			for(int i=0;i<=MYSQL_CONNECTION_POOL.getMaxIdle();i++){
				MYSQL_CONNECTION_POOL.addObject();
			}
			
			LOG.log(Level.INFO,"@@Raviiii MySQL Connection Pool Successfully initialized ");
		} catch (Exception e) {
			LOG.log(Level.SEVERE,"@@Raviiii Exception caught while initializing MySQL connection pool ::: Exception ::: ",e);
		}
	}
	
	public static void shutDownConnectionPool(){
		if(MySQLConnectionPoolHandler.MYSQL_CONNECTION_POOL != null){
		}
	}
	
	public static MySQLConnection getConnection(){
		try {
			if(MySQLConnectionPoolHandler.MYSQL_CONNECTION_POOL == null){
				return null;
			}
			return MySQLConnectionPoolHandler.MYSQL_CONNECTION_POOL.borrowObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.log(Level.SEVERE,"@@Raviiii Exception caught while fetching mysql connection ::: Exception ::: ",e);
		}
		return null;
	}
	
	public static void putConnection(MySQLConnection mySQLConnection){
		MySQLConnectionPoolHandler.MYSQL_CONNECTION_POOL.returnObject(mySQLConnection);
	}
}
