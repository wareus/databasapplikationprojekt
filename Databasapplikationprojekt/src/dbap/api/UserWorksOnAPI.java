package dbap.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import dbap.dao.UserWorksOnDAO;
import dbap.api.base.BaseAPI;

import dbap.dao.dto.UserWorksOn ;

@Path("userWorksOn")

public class UserWorksOnAPI extends BaseAPI<UserWorksOn> {

	
	@PostConstruct
	public void init() {
		
		dao = new UserWorksOnDAO();
	}
	
}
