/**
 * 
 */
package com.project.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.project.model.Volunteer;

/**
 * @author ravi-1979
 *
 */
@Path("/volunteers")
public class VolunteersResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addVolunteer(@BeanParam Volunteer volunteer){
		
		System.out.println("------- query-params :::: "+volunteer.toString());
		return Response.status(Status.CREATED).entity("created").build();
	}

}
