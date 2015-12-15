package dbap.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import dbap.api.base.BaseAPI;
import dbap.custom.annotation.Login;
import dbap.dao.EventDAO;
import dbap.dao.UserWorksOnDAO;
import dbap.dao.dto.Event;
import dbap.dao.dto.UserWorksOn;


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
	@Login
	@Path("addForYou")
	@POST
	public Response addForUser(String json)
	{
		Event event = new Gson().fromJson(json, Event.class);
		
		int id = (int) request.getSession().getAttribute("id");
		int projectId = (int) request.getSession().getAttribute("projectID");
		
		LocalDateTime ldt = null;
		LocalDateTime sldt = LocalDateTime.of(event.startDate.toLocalDate(), LocalTime.of(0, 0, 0 ,0));
		if(!event.endDate.toLocalDate().toString().equals("0000-00-00")) {
			ldt = LocalDateTime.of(event.endDate.toLocalDate(), LocalTime.of(0, 0, 0 ,0));
		}
		
		
		event.startDate = sldt;
		event.endDate = ldt;
		event.userID = id;
		event.projectID = projectId;
		((EventDAO)dao).add(event);
		
		return Response.status(Status.ACCEPTED).build();
	}
	
}

	
