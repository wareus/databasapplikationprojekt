package dbap.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import dbap.api.base.BaseAPI;
import dbap.custom.annotation.Login;
import dbap.dao.UserDAO;
import dbap.dao.dto.User;

@Path("user")
public class UserAPI extends BaseAPI<User>
{
	@PostConstruct
	public void init() {
		
		dao = new UserDAO();
	}

	@Override
	@Login
	public Response getAll()
	{
		return super.getAll();
	}

	@Override
	public Response getByID(String id) {
		// TODO Auto-generated method stub
//		return super.getByID(id);
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	
	
	
}
