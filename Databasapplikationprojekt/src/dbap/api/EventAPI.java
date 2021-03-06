package dbap.api;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.DELETE;
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
import dbap.dao.dto.Event;
import dbap.exceptions.NoProjectSelectedException;


@Path("event")
public class EventAPI  extends BaseAPI<Event>{
	
	@PostConstruct
	public void init() {
		dao = new EventDAO();
	}	
	

	@Login
	@Path("forCategory/{category}")
	@GET
	public Response getForCategory(@PathParam("category") String category)
	{
		ArrayList<Event> events = ((EventDAO)dao).getAllFromCategory(category);
		
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
	@Login
	@Path("removeEvent/{id}")
	@DELETE
	public Response removeEvent(@PathParam("id") int id)
	{
		
		((EventDAO)dao).delete(id);
		return Response.status(Status.ACCEPTED).build();
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
	@Path("updateEvent/{id}")
	@POST
	public Response update(String json,@PathParam("id") int id)
	{
		int userID = (int) request.getSession().getAttribute("id");
		if(request.getSession().getAttribute("projectID") == null) throw new NoProjectSelectedException();
		
		Integer projectId = (Integer) request.getSession().getAttribute("projectID");
		
		if(projectId == null) throw new NoProjectSelectedException();
		
		Event event = new Gson().fromJson(json, Event.class);
		LocalDateTime ldt = null;
		LocalDateTime sldt = LocalDateTime.of(event.startDate.toLocalDate(), LocalTime.of(0, 0, 0 ,0));
		if(event.endDate != null && !event.endDate.toLocalDate().toString().equals("0000-00-00")) {
			ldt = LocalDateTime.of(event.endDate.toLocalDate(), LocalTime.of(0, 0, 0 ,0));
		}
		event.startDate = sldt;
		event.endDate = ldt;
		event.userID = userID;
		event.projectID = projectId;
		((EventDAO)dao).add(event);
		
		return Response.status(Status.ACCEPTED).build();
	}
	
}

