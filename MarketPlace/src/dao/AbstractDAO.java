package dao;

import global.MarketplaceConfig;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.util.List;

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
			mConnection = DriverManager.getConnection(url + db, "root", MarketplaceConfig.DB_PW);

			return mConnection;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;


	}
	
	protected ResultSet execSql(String query) throws SQLException {
		Statement st = mConnection.createStatement();
		st.execute(query);
		return st.getResultSet();
	}
	
	protected ResultSet execSqlBatch(List<String> queries) throws SQLException {
		Statement st = mConnection.createStatement();
		for (int i=0; i<queries.size(); i++)
			st.addBatch(queries.get(i));
		
		st.executeBatch();
		return st.getResultSet();
	}
	
	protected String strIsNull(String s) {
		if (s.trim().isEmpty()) return "NULL";
		else return "'" + s + "'";
	}
}
