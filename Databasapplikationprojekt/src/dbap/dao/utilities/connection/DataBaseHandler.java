package dbap.dao.utilities.connection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.inject.Inject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dbap.dao.dto.base.BaseDTO;
import dbap.dao.utilities.mapping.RowMapper;

public class DataBaseHandler
{

	public ArrayList<? extends BaseDTO> query(String sql, RowMapper<? extends BaseDTO> mapper)
	{
		Object[] o = {};
		return query(sql, o, mapper);

	}

	public ArrayList<? extends BaseDTO> query(String sql, Object[] params, RowMapper<? extends BaseDTO> mapper)
	{
		ArrayList<BaseDTO> modelList = new ArrayList<BaseDTO>();

		try (Connection connection = DataBaseDriver.getConnection())
		{
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

			preparedStatement = preparedStatementMapper(preparedStatement, params);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				modelList.add(mapper.map(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return modelList;
	}

	public int update(String sql, Object[] params)
	{

		int lastID = 0;
		try (Connection connection = DataBaseDriver.getConnection())
		{

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement = preparedStatementMapper(preparedStatement, params);

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next())
			{
				lastID = rs.getInt(1);
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return lastID;
	}

	private PreparedStatement preparedStatementMapper(PreparedStatement statement, Object[] params) throws SQLException
	{
		for (int i = 0; i < params.length; i++)
		{
			statement.setObject(i + 1, params[i]);
		}
		return statement;

	}

}
