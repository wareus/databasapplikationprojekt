package dbap.api;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import dbap.api.base.BaseAPI;
import dbap.custom.annotation.Login;
import dbap.dao.EventDAO;
import dbap.dao.dto.Event;


@Path("event")
public class EventAPI  extends BaseAPI<Event>{
	
	@PostConstruct
	public void init() {
		dao = new EventDAO();
	}
	@Override
	@Login
	public Response getAll()
	{
		return super.getAll();
	}
	
	
	@Login
	@Path("forUser/{id}")
	@GET
	public Response getForUser(@PathParam("id") int id)
	{
		
		System.out.println(id);
		ArrayList<Event> events = ((EventDAO)dao).getAllForUser(id);
		
		return Response.status(Status.ACCEPTED).entity(new Gson().toJson(events)).build();
	}
	@Login
	@Path("forYou")
	@GET
	public Response getForUser()
	{
		int id = (int) request.getSession().getAttribute("id");
		
		ArrayList<Event> events = ((EventDAO)dao).getAllForUser(id);
		
		return Response.status(Status.ACCEPTED).entity(new Gson().toJson(events)).build();
	}
	
}

	
