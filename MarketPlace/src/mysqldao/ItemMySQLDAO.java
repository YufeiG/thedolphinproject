package mysqldao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.Item;

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

		@Override
		public Item getItem() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean deleteItem() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean editItem() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean createItem() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<Item> getItems() {
			// TODO Auto-generated method stub
			return null;
		}

}
