package dbap.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import dbap.api.base.BaseAPI;
import dbap.dao.UserDAO;
import dbap.dao.dto.User;

@Path("user")
public class UserAPI extends BaseAPI<User>
{
	@PostConstruct
	public void init() {
		
		dao = new UserDAO(User.class);
	}
}
