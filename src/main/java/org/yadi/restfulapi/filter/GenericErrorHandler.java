package org.yadi.restfulapi.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.yadi.restfulapi.messenger.model.ErrorMessage;

@Provider
public class GenericErrorHandler implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		System.out.println("Hello");
		ErrorMessage error  = new ErrorMessage("InternalError", 500);
		return Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR)
				.entity(error)
				.build();
	}

}
