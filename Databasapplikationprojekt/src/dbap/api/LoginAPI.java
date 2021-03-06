package dbap.api;




import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dbap.custom.annotation.Login;
import dbap.dao.UserDAO;
import dbap.dao.UserWorksOnDAO;
import dbap.dao.dto.User;
import dbap.dao.dto.UserWorksOn;
import dbap.exceptions.AlertException;
import dbap.exceptions.BadRequestException;
import dbap.exceptions.NoProjectSelectedException;
import dbap.exceptions.NotLoggedInException;

@Path("login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginAPI
{

	@Context
	private HttpServletRequest request;
	@POST
	@Path("/")
	public Response login(String json)
	{

		System.out.println(json);
		User user = new Gson().fromJson(json, User.class);
		
		if(user == null) 
			throw new BadRequestException();
		
		User dbUser = new UserDAO().getByName(user.name);

		if (dbUser != null && dbUser.password.equals(user.password))
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("id", dbUser.id);
			session.setAttribute("userName", dbUser.name);
			session.setAttribute("rights", dbUser.rights);
			
			ArrayList<UserWorksOn> worksOnList = new UserWorksOnDAO().getByUserID(dbUser.id);

			if(worksOnList.size() == 0) throw new NoProjectSelectedException();
			session.setAttribute("projectID", worksOnList.get(0).id);
			
			
			
			return Response.status(Response.Status.ACCEPTED).build();
		}
		
		throw new NotLoggedInException();
		
	}

	@GET
	@Path("/logout")
	public Response logout()
	{
		System.out.println("logout");
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			session.invalidate();
		}
		return Response.status(Response.Status.ACCEPTED).build();

	}
  
	@Login
	@GET
	@Path("/isLoggedIn")
	public Response loggedIn()
	{
	System.out.println("logIn");
 
	HttpSession session = request.getSession(false);
	if (session!=null)
	{
    session.getAttribute("userName");
	}
	return Response.status(Response.Status.ACCEPTED).build();

}

}	
