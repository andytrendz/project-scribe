/**
 * 
 */
package com.project.resource;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.project.constants.APIConstants;

/**
 * @author ravi-1979
 *
 */
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig(){
		packages(APIConstants.CLIENT_REST_API_PACKAGES);
	}
}
