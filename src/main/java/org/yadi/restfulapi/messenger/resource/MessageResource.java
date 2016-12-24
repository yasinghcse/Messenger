package org.yadi.restfulapi.messenger.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.yadi.restfulapi.messenger.model.Message;
import org.yadi.restfulapi.messenger.service.MessageService;
import org.yadi.restfulapi.filter.MessageFilterBean;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService obj = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean bean) {	
		if(bean.getYear() > 0){
			return obj.getAllMessageForYear(bean.getYear());
		}
		return obj.getAllMessage();
	}

	@GET
	@Path("/{messageId}")
	public Message getSingleMessage(@PathParam("messageId") Long messageId) {
		return obj.getMessage(messageId);
		}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message message1 = obj.addMessages(message);
		String newID= String.valueOf(message1.getId());
		URI uri= uriInfo.getAbsolutePathBuilder().path(newID).build();
		return Response.created(uri)
				.entity(message1)
				.build();
		}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long messageId, Message message) {
		message.setId(messageId);
		return obj.updateMessage(message);
		}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") Long messageId) {
		return obj.removeMessage(messageId);
		}
	
	
	@Path("/{messageId}/comment")
	public Subclass getTest() {
		return new Subclass();
		}
}
