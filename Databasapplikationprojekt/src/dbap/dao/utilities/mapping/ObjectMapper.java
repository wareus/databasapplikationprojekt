package dbap.dao.utilities.mapping;

import java.lang.reflect.Field;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

public class ObjectMapper<T> implements RowMapper<T>
{
	Class<T> type;

	public ObjectMapper(Class<T> type)
	{
		super();
		this.type = type;
	}

	@Override
	public T map(ResultSet resultSet)
	{
		T model = null;
		ResultSetMetaData metaData = null;
		try
		{
			metaData = resultSet.getMetaData();
		} catch (SQLException e2)
		{
			e2.printStackTrace();
		}
		
		try
		{
			@SuppressWarnings("unchecked")
			Class<T> c = (Class<T>) Class.forName(type.getName());
			
			model = c.newInstance();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1)
		{
			e1.printStackTrace();
		}

		
		HashMap<String, Field> fields = new HashMap<String, Field>();
		fields = getAllFields(fields, type);
//		System.out.println(fields);
		
		try {
		for (int i = 0; i < metaData.getColumnCount(); i++) {
				
				Field field = fields.get(metaData.getColumnName(i + 1));
				System.out.println(field);
				if(field != null)
				{
					String fieldType = field.getType().getName();
					String colName = field.getName();
//					System.out.println(fieldType);
					
					if(fieldType == "java.lang.String")
					{
						field.set(model, resultSet.getString(colName));
					}
					else if(fieldType == "int")
					{
						field.setInt(model, resultSet.getInt(colName));
					}
				}
				
			
		}
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	private static HashMap<String, Field> getAllFields(HashMap<String, Field> fields, Class<?> type) {
	    for (Field field: type.getDeclaredFields()) {
	        fields.put(field.getName(), field);
	    }

	    if (type.getSuperclass() != null) {
	        fields = getAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}
	
	
}
