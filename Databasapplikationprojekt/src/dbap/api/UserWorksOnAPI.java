package dbap.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import dbap.dao.UserWorksOnDAO;
import dbap.api.base.BaseAPI;
import dbap.dao.dto.UserWorksOn ;

@Path("userWorksOn")
public class UserWorksOnAPI extends BaseAPI<UserWorksOn> {

	
	@PostConstruct
	public void init() {
		
		dao = new UserWorksOnDAO();
	}
	
	@POST
	@Path("connectProjectToMe")
    public Response create(String json) {

		System.out.println(json);
    	UserWorksOn userWorksOn = new Gson().fromJson(json, UserWorksOn.class);
    	
    	userWorksOn.userID = (int) request.getSession().getAttribute("id");
    	
    	int lastID = dao.add(userWorksOn);
    	
    	return Response.status(Status.ACCEPTED).entity("{\"id\":" + lastID + "}").build();
    	
    }
	
}
