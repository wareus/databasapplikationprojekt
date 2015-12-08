package dbap.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

public class AlertException extends WebApplicationException
{

	private Status status;
	private AlertMessage alertMessage;
	
	public AlertException(String header, String message, Status status)
	{
		super();
		alertMessage = new AlertMessage(header, message);
		this.status = status;
	}
	@Override
	public Response getResponse()
	{
		return Response.status(status).entity(new Gson().toJson(alertMessage)).build();
	}
	
	
}
