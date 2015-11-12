package dbap.dao.utilities.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DataBaseDriver
{
	private static DataBaseConfig config;
	

	public static void setConfig(DataBaseConfig config)
	{
		DataBaseDriver.config = config;
	}



	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + config.getAdress() + ":" + config.getPort() + "/" + config.getDatabase(), config.getUserName(), config.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
