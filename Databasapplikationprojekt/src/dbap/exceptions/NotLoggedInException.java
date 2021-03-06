package dbap.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class NotLoggedInException extends WebApplicationException
{

	@Override
	public Response getResponse()
	{
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
}
