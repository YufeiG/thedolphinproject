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
			String query = 
					"INSERT INTO items (title, category, userid,, description, " +
					"sold, avail_start, avail_end, price_low, price_high, popularity, " +
					"time_added, time_mod) " +
					String.format("VALUES ('%s',%d, %d, %s, '%d', %s, %s, %f, %f, %d, '%s', '%s')",
							item.getTitle(), item.getCategory(), item.getUserid(),
							strIsNull(item.getDescription()), item.getSold(),
							strIsNull(item.getAvailStart().toString()), 
							strIsNull(item.getAvailEnd().toString()),
							item.getPriceLow(), item.getPriceHigh(), item.getPopularity(),
							item.getTimeAdded().toString(),
							item.getTimeModified().toString());
			
			execSql(query);

			return true;
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
