package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Item;

import dao.AbstractDAO;
import dao.ItemDAO;

public class ItemMySQLDAO extends AbstractDAO implements ItemDAO{
		
		public ItemMySQLDAO(){
			mConnection = createConnection();
		}

		public Item getItem(long itemid) throws SQLException {
			String query = "SELECT * FROM items WHERE itemid=" + itemid;
			ResultSet rs = execSql(query);
			
			return getItemObj(rs);
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
