package dao;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO {
	protected static Connection mConnection;

	public static Connection createConnection(){

		String url = "jdbc:mysql://localhost:3306/";
		String db = "marketplace";
		String driver = "com.mysql.jdbc.Driver";
		try
		{
			//Class.forName(driver);

			Class.forName("com.mysql.jdbc.Driver");
			mConnection = DriverManager.getConnection(url + db, "root", "tina");

			return mConnection;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;


	}
	
}
