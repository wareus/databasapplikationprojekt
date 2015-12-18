package dbap.dao;
import java.util.ArrayList;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.UserWorksOn;


public class UserWorksOnDAO extends BaseDAO<UserWorksOn> {
	
	
	public UserWorksOnDAO()
	{
		super(UserWorksOn.class);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UserWorksOn> getByUserID(int id) {
		
		Object [] params = {id};
		
		String sql ="SELECT * FROM userworkson WHERE userID=?";
		
		return (ArrayList<UserWorksOn>) db.query(sql, params, getMapper());
	}

}