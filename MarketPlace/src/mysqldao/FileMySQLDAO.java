package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.AbstractDAO;
import dao.FileDAO;

public class FileMySQLDAO extends AbstractDAO implements FileDAO{
		
		public FileMySQLDAO(){
			mConnection = createConnection();
		}
}
