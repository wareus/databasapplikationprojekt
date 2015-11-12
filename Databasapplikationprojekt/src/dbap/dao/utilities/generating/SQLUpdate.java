package dbap.dao.utilities.generating;


public class SQLUpdate {
	
	private String sql;
	private Object[] params;
	
	public SQLUpdate(String sql, Object[] params) {
		super();
		this.sql = sql;
		this.params = params;
	}

	public String getSql() {
		return sql;
	}

	public Object[] getParams() {
		return params;
	}
	
	

}
