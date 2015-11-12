package dbap.dao.utilities.connection;

public class DataBaseConfig
{
	private String adress, userName, password, database;
	private int port;

	public DataBaseConfig(String adress, String userName, String password, String database, int port)
	{
		super();
		this.adress = adress;
		this.userName = userName;
		this.password = password;
		this.database = database;
		this.port = port;
	}

	public String getAdress()
	{
		return adress;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getPassword()
	{
		return password;
	}

	public String getDatabase()
	{
		return database;
	}

	public int getPort()
	{
		return port;
	}

}
