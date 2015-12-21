package dbap.dao;
import java.util.ArrayList;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.Project;


public class ProjectDAO extends BaseDAO<Project> {
	
	
	public ProjectDAO()
	{
		super(Project.class);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Project> getForUser(int id) {
		Object [] params = {id};
		String sql ="SELECT project.* FROM UserWorksOn JOIN project ON project.id = UserWorksOn.projectID WHERE UserWorksOn.userID=?";
		
		return (ArrayList<Project>)db.query(sql,params, getMapper()) ;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Project> getForNotUser(int id) {
		Object [] params = {id};
		
		
		String sql = "SELECT project.* FROM UserWorksOn JOIN project ON project.id = UserWorksOn.projectID  WHERE userID != ? GROUP BY projectID";
		
		return (ArrayList<Project>)db.query(sql,params, getMapper());
	}

	@Override
	public void delete(int id) {
		
		Object [] params = {id};
		
		db.update("DELETE FROM userworkson WHERE projectID=?" , params);
		
		super.delete(id);
	}
	
	


	}

