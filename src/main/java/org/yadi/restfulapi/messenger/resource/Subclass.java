package org.yadi.restfulapi.messenger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Subclass {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest() {
		return "Hello Insider subclass";
		}
	
}
