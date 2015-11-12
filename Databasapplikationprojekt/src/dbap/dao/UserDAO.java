package dbap.dao;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.User;

public class UserDAO extends BaseDAO<User>
{
	public UserDAO(Class<User> type)
	{
		super(type);
	}

}
