package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.AbstractDAO;
import dao.FileDAO;

public class TagMySQLDAO extends AbstractDAO implements FileDAO{
		
		public TagMySQLDAO(){
			mConnection = createConnection();
		}
}
