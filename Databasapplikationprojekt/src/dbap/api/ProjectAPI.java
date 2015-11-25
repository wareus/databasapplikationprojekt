package dbap.api;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import dbap.api.base.BaseAPI;
import dbap.custom.annotation.Login;
import dbap.dao.EventDAO;
import dbap.dao.ProjectDAO;
import dbap.dao.dto.Event;
import dbap.dao.dto.Project;

@Path("project")
public class ProjectAPI extends BaseAPI<Project>{
	
	@PostConstruct
	public void init() {
		
		dao = new ProjectDAO();
	}
	@Login
	@Path("forUser/{id}")
	@GET
	public Response getForUser(@PathParam("id") int id)
	{
		System.out.println(id);
		ArrayList<Project> project = ((ProjectDAO)dao).getForUser(id);
		
		return Response.status(Status.ACCEPTED).entity(new Gson().toJson(project)).build();
	}
	
	@Login
	@Path("forNotUser/{id}")
	@GET
	public Response getForNotUser(@PathParam("id") int id)
	{
		System.out.println(id);
		ArrayList<Project> projectuser = ((ProjectDAO)dao).getForNotUser(id);
		
		return Response.status(Status.ACCEPTED).entity(new Gson().toJson(projectuser)).build();
}
}
