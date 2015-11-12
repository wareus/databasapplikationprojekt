package dbap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import dbap.dao.utilities.connection.DataBaseConfig;
import dbap.dao.utilities.connection.DataBaseDriver;

@SuppressWarnings("serial")
public class StartUp extends HttpServlet
{

	@Override
	public void init() throws ServletException
	{
		String adress = "localhost";
		String userName = "root";
		String password = "";
		String database = "arnprojectplanner";
		int port = 3306;
		DataBaseDriver.setConfig(new DataBaseConfig(adress, userName, password, database, port));
	}
	
}
