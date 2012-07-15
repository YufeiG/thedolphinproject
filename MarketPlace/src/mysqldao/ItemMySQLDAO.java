package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Item;
import model.Tag;

import dao.AbstractDAO;
import dao.ItemDAO;

public class ItemMySQLDAO extends AbstractDAO implements ItemDAO{
		
		public ItemMySQLDAO(){
			mConnection = createConnection();
		}

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

		public boolean createItem(Item item) throws SQLException {

			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<Item> getItems() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Item> getItems(List<Tag> tags) {
			// TODO Auto-generated method stub
			return null;
		}

}
