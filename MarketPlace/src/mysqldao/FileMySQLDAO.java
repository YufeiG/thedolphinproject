package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.AbstractDAO;
import dao.FileDAO;

public class FileMySQLDAO extends AbstractDAO implements FileDAO{
		Connection mConnection;

		public Connection ConnectToDatabase()
		{

			String url = "jdbc:mysql://localhost:3306/";
			String db = "marketplace";
			String driver = "com.mysql.jdbc.Driver";
			try
			{
				//Class.forName(driver);

				Class.forName("com.mysql.jdbc.Driver");
				mConnection = DriverManager.getConnection(url + db, "root", "dongfang");

				return mConnection;

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return null;
			
		}
}
