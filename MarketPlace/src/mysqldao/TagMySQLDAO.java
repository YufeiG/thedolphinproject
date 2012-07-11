package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.File;

import dao.AbstractDAO;
import dao.FileDAO;

public class TagMySQLDAO extends AbstractDAO implements FileDAO{
		
		public TagMySQLDAO(){
			mConnection = createConnection();
		}

		@Override
		public File getFile(String username) {
			
			File file = null;
			
			try {
				Statement st = mConnection.createStatement();
				String query = "SELECT picid, file, userid " +
						"FROM user_profile_pics p JOIN users u ON (u.userid == p.userid) " +
						"WHERE username = '" + username + "'";
				st.execute(query);

				ResultSet rs = st.getResultSet();

				if (rs.next()) {
					file = new File(rs.getLong("picid"), 
							rs.getBlob("username"), rs.getInt("userid"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		public List<File> getFiles(long itemid) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean createFile(long itemid, File f, boolean fileType) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean deleteFile(File f) {
			// TODO Auto-generated method stub
			return false;
		}
}
