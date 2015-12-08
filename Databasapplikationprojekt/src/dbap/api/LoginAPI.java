package dbap.api;




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
import dbap.dao.dto.User;

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
		
		if(user == null) return Response.status(Response.Status.BAD_REQUEST).build();
		
		User dbUser = new UserDAO().getByName(user.name);

		if (dbUser != null && dbUser.password.equals(user.password))
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("id", dbUser.id);
			session.setAttribute("userName", dbUser.name);
			session.setAttribute("rights", dbUser.rights);

			return Response.status(Response.Status.ACCEPTED).build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();

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