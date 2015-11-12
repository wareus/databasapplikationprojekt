package dbap.dao.utilities.mapping;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import dbap.dao.dto.base.BaseDTO;

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
			Constructor<?> constructor = type.getConstructor();
			constructor.setAccessible(true);
			model = (T) constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1)
		{
			e1.printStackTrace();
		}

		
		HashMap<String, Field> fields = new HashMap<String, Field>();
		fields = getAllFields(fields, type);
		
		try {
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			
				Field field = fields.get(metaData.getColumnName(i + 1));
				
				if(field != null)
				{
					String fieldType = field.getType().getName();
					
					String colName = type.getSimpleName() + field.getName();
					
					if(fieldType == "java.lang.String")
					{
						field.set(model, resultSet.getString(colName));
					}
					else if(fieldType == "int")
					{
						field.setInt(model, resultSet.getInt(colName));
					}
					else if(fieldType == "boolean")
					{
						field.setBoolean(model, resultSet.getBoolean(colName));
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
