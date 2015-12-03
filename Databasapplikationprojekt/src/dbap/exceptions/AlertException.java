package dbap.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class AlertException extends WebApplicationException
{
	private String header, message;
	private Status status;
	public AlertException(String header, String message, Status status)
	{
		super();
		this.header = header;
		this.message = message;
		this.status = status;
	}
	@Override
	public Response getResponse()
	{
		return Response.status(status).build();
	}
	
	
}
