package dbap.dao.utilities.generating;


import java.lang.reflect.Field;

import dbap.dao.dto.base.BaseDTO;


public class SQLUpdateBuilder<T extends BaseDTO> {

	private Class<T> type;
	
	public SQLUpdateBuilder(Class<T> type)
	{
		this.type = type;
	}

	
	public SQLUpdate add(T model)
	{
		String tabelName = type.getSimpleName();
		Field [] fields = type.getDeclaredFields();
		
		int arraySize = fields.length;
		
		String [] coloumList= new String[arraySize];
		
		Object [] params = new Object[arraySize];
		
		for (int i = 0; i < fields.length; i++) {
			
			Field field = fields[i];
			
			try {
				String fieldName = field.getName();
				String fieldType = field.getType().getName();
				
				if(fieldType == "java.lang.String")
				{
					params[i] = field.get(model);
				}
				else if(fieldType == "int")
				{
					params[i] = field.getInt(model);
				}
				
				coloumList[i] = fieldName;
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
				
			
		}
		
		
		String sql = "";
		
				
		if(model.id == 0)
		{
			String colums = "", values ="";
			
			for (int i = 0; i < coloumList.length; i++) {
				
				if(i == 0)
				{
					colums += coloumList[i];
					values += "?";
				}
				else
				{
					colums += "," + coloumList[i];
					values += ",?";
				}
				
			}
			sql = "INSERT INTO " + tabelName + " (" + colums + ") VALUES (" + values + ")";
			
		}
		else
		{
			
			String colums = "";
			
			for (int i = 0; i < coloumList.length; i++) {
				
				if(i == 0)
				{
					colums += coloumList[i] + "=? ";
				}
				else
				{
					colums += "," + coloumList[i] + "=? ";
				}
				
			}
			
			sql = "UPDATE " + tabelName
					+ " SET " + colums
					+ " WHERE id = " + model.id;
		}
		
		return new SQLUpdate(sql, params);
	}
	
	public Class<T> getType() {
		return type;
	}
	
	
	
}
