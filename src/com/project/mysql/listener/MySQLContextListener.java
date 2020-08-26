/**
 * 
 */
package com.project.mysql.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.project.mysql.connection.pool.MySQLConnectionPoolHandler;

/**
 * @author ravi-1979
 *
 */
public class MySQLContextListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger(MySQLContextListener.class.getName());

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try {
			MySQLConnectionPoolHandler.initializeConnectionPool();
			LOG.log(Level.INFO,"@@Raviiii MySQL connection pool initialized successfully ");
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.log(Level.SEVERE,"@@Raviiii Exception caught while intializing mysql connection pool :::: Exception :::",e );
		}
	}

}
