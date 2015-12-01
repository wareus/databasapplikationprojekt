package dbap.dao;
import java.util.ArrayList;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.Project;

import dbap.dao.utilities.mapping.RowMapper;
import java.sql.ResultSet;


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
		String sql = "SELECT* FROM project INNER JOIN userworkson ON userworkson.projectID=userworkson.userID where project.id!=? group by project.id";
		
		return (ArrayList<Project>)db.query(sql,params, getMapper()) ;
	}


	}

