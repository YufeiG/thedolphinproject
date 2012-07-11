package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.AbstractDAO;
import dao.ItemDAO;

public class ItemMySQLDAO extends AbstractDAO implements ItemDAO{
		
		public ItemMySQLDAO(){
			mConnection = createConnection();
		}
		
		public String query(){

			String htmlCode = "";
			
			try{
				Statement st = mConnection.createStatement();
				String query = "SELECT iditem FROM item";
				st.execute(query);
				
				ResultSet rs = st.getResultSet();
				
				while(rs.next()){
					htmlCode += "<p>" + rs.getInt("iditem") + "</p>";
				}
				
			}
			catch(Exception e){

			}
			
			return htmlCode;


		}

}
