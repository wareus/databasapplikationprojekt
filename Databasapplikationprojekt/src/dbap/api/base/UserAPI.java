package dbap.api.base;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

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
