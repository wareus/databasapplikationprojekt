package dbap.dao;

import java.util.ArrayList;

import dbap.dao.base.BaseDAO;
import dbap.dao.dto.Event;

public class EventDAO  extends BaseDAO<Event> {
	
	
	public EventDAO()
	{
		super(Event.class);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Event> getAllForUser(int id)
	{
		Object [] params = {id};
		String sql ="SELECT event.* FROM event JOIN user ON user.id = event.UserID where user.id=?";
		
		return (ArrayList<Event>)db.query(sql,params, getMapper()) ;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Event> getAllFromProject(int id)
	{
		Object [] params = {id};
		String sql ="SELECT event.* FROM event JOIN project ON projectID = event.id where projectID=?";
		
		return (ArrayList<Event>)db.query(sql,params, getMapper()) ;
		
	}
	


@SuppressWarnings("unchecked")
public ArrayList<Event> getAllFromUser(int id)
{
	Object [] params = {id};
	String sql ="SELECT event.* FROM event JOIN project ON userID = userID where userID=?";
	
	return (ArrayList<Event>)db.query(sql,params, getMapper()) ;

}
}