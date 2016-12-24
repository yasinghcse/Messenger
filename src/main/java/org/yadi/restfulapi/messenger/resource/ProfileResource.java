package org.yadi.restfulapi.messenger.resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.yadi.restfulapi.messenger.model.Message;
import org.yadi.restfulapi.messenger.model.Profile;
import org.yadi.restfulapi.messenger.service.MessageService;
import org.yadi.restfulapi.messenger.service.ProfileService;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

ProfileService obj = new ProfileService();
	
	@GET
	public List<Profile> getMessages() {	
		return obj.getAllProfile();
	}


	@GET
	@Path("/{messageId}")
	public Profile getSingleMessage(@PathParam("messageId") String messageId) {
		return obj.getProfile(messageId);
		}
	
	@POST
	public Profile addMessage(Profile message) {
		return obj.addProfile(message);
		}
	
	@PUT
	@Path("/{messageId}")
	public Profile updateMessage(@PathParam("messageId") String messageId, Profile message) {
		message.setMessage(messageId);
		return obj.updateProfile(message);
		}
	
	@DELETE
	@Path("/{messageId}")
	public Profile deleteMessage(@PathParam("messageId") String messageId) {
		return obj.removeProfile(messageId);
		}
	
}
