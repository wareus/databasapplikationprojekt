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
	@Path("yourProjects")
	@GET
	public Response getYourProjects()
	{
		ArrayList<Project> project = ((ProjectDAO)dao).getForUser((int) request.getSession().getAttribute("id"));
		
		return Response.status(Status.ACCEPTED).entity(new Gson().toJson(project)).build();
	}
	
	@Login
	@Path("othersProjects")
	@GET
	public Response getOthersProjects()
	{
		ArrayList<Project> projectuser = ((ProjectDAO)dao).getForNotUser((int) request.getSession().getAttribute("id"));
		
		return Response.status(Status.ACCEPTED).entity(new Gson().toJson(projectuser)).build();
}
}
