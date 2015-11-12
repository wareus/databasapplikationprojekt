package dbap.api.base;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.base.BaseDTO;

import com.google.gson.Gson;


@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class BaseAPI <T extends BaseDTO>{
	
	protected BaseDAO<T> dao;
	
	@Context protected HttpServletRequest request;
    
	
	@PostConstruct
	public void init() {
	}

    @GET
    public Response getAll() {
    	
    	ArrayList<T> users = dao.getAll();

    	return Response.status(Status.ACCEPTED).entity(new Gson().toJson(users)).build();
    	
    }
    @GET
    @Path("{id}")
    public Response getByID(@PathParam("id") String id) {
    	
    	T model = dao.getByID(Integer.parseInt(id));
    	
    	
    	return Response.status(Status.ACCEPTED).entity(new Gson().toJson(model)).build();
    	
    }
    @POST
    public Response create(String json) {

    	System.out.println(json);
    	
    	T model = new Gson().fromJson(json, dao.getType());
    	
    	int lastID = dao.add(model);
    	
    	return Response.status(Status.ACCEPTED).entity("{\"id\":" + lastID + "}").build();
    	
    }
    @PUT
    @Path("{id}")
    public Response update(String json) {
    	
    	T model = new Gson().fromJson(json, dao.getType());
    	
    	dao.add(model);
    	
    	return Response.status(Status.ACCEPTED).build();
    	
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
    	
    	dao.delete(id);
    	
    	return Response.status(Status.ACCEPTED).build();
    	
    }
    
    protected boolean isAdmin()
    {
    	HttpSession session = request.getSession(true);
    	return (int) session.getAttribute("admin") == 1;
    }
    
    
}
