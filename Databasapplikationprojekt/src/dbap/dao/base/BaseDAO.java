package dbap.dao.base;

import java.util.ArrayList;

import com.google.inject.Inject;

import dbap.dao.dto.base.BaseDTO;
import dbap.dao.utilities.connection.DataBaseConfig;
import dbap.dao.utilities.connection.DataBaseDriver;
import dbap.dao.utilities.connection.DataBaseHandler;
import dbap.dao.utilities.generating.SQLUpdate;
import dbap.dao.utilities.generating.SQLUpdateBuilder;
import dbap.dao.utilities.mapping.ObjectMapper;
import dbap.dao.utilities.mapping.RowMapper;



@SuppressWarnings("unchecked")
public class BaseDAO <T extends BaseDTO>{
	protected DataBaseHandler db;
	private Class <T> type;
	private String tabelName;
	private RowMapper<T> mapper;
	

	public BaseDAO(Class<T> type) {
		super();
		this.type = type;
		tabelName = getType().getSimpleName();

		this.db = new DataBaseHandler();
		mapper = new ObjectMapper<T>(type);
		
	}



	public ArrayList<T> getAll()
	{
		String sql ="SELECT * FROM " + tabelName;
		
		return (ArrayList<T>)db.query(sql, mapper) ;
		
	}
	
	public T getByID(int id) {
		
		Object [] params = {id};
		
		String sql ="SELECT * FROM " + tabelName + " WHERE id=?";
		
		return returnSingelValue(sql, params);
	}
	
	public int add(T model)
	{
		SQLUpdate sqlUpdate = new SQLUpdateBuilder<T>(type).add(model);
		return db.update(sqlUpdate.getSql(), sqlUpdate.getParams());
	}
	
	public void delete(int id)
	{
		
		Object [] params = {id};
		
		db.update("DELETE FROM " + tabelName + " WHERE id=?" , params);
	}
	

	public Class<T> getType() {
		return type;
	}
	
	protected T returnSingelValue(String sql, Object[] params)
	{
		ArrayList<T> models = (ArrayList<T>)db.query(sql, params, mapper);
		if(models.size() != 0)
			return models.get(0);
		return null;
	}
}

