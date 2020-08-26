/**
 * 
 */
package com.project.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author ravi-1979
 *
 */
@Path("/test")
public class TestResource {
	@GET
	public Response makeTest(){
		
		return Response.ok("success").build();
	}
}
