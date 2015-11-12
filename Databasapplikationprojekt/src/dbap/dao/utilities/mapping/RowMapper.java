package dbap.dao.utilities.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public interface RowMapper<T>
{
	T map(ResultSet resultSet);
}
