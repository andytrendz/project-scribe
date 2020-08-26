/**
 * 
 */
package com.project.listener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author ravi-1979
 *
 */
public class ServiceStartupListener extends HttpServlet {
	public void init() throws ServletException
    {
          System.out.println("----------");
          System.out.println("---------- ProjectVision Server Initialized successfully ----------");
          System.out.println("----------");
    }
}
