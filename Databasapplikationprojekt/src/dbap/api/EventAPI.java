package dbap.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import dbap.api.base.BaseAPI;
import dbap.dao.EventDAO;
import dbap.dao.dto.Event;


@Path("event")
public class EventAPI  extends BaseAPI<Event>{
	
	@PostConstruct
	public void init() {
		
		dao = new EventDAO();
	}

	}

