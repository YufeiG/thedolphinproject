package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;

public abstract class AbstractDAO {
	protected static Connection mConnection;
	
	public void disconnect() {
		try
		{
			mConnection.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Connection createConnection(){

		String url = "jdbc:mysql://localhost:3306/";
		String db = "marketplace";
		String driver = "com.mysql.jdbc.Driver";
		try
		{
			//Class.forName(driver);

			Class.forName(driver);
			mConnection = DriverManager.getConnection(url + db, "root", "yufei");

			return mConnection;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;


	}
	
	protected ResultSet execSql(String query) {
		try {
			Statement st = mConnection.createStatement();
			st.execute(query);
			return st.getResultSet();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
