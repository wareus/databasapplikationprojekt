package dbap.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import dbap.api.base.BaseAPI;
import dbap.dao.ProjectDAO;
import dbap.dao.dto.Project;

@Path("project")
public class ProjectAPI extends BaseAPI<Project>{
	
	@PostConstruct
	public void init() {
		
		dao = new ProjectDAO();
	}
	

}
