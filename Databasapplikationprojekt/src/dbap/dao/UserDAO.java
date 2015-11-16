package dbap.dao;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.User;

public class UserDAO extends BaseDAO<User>
{
	public UserDAO()
	{
		super(User.class);
	}
	
	public User getByName(String name)
	{
		Object [] params = {name};
		
		
		String sql ="SELECT * FROM " + getTabelName() + " WHERE name=?";
		
		return returnSingelValue(sql, params);
	}

}
