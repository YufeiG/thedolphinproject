package mysqldao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Tag;

import dao.AbstractDAO;
import dao.ItemDAO;
import dao.TagDAO;

public class ItemMySQLDAO extends AbstractDAO implements ItemDAO {

	public ItemMySQLDAO() {
		mConnection = createConnection();
	}

	private Item getItemObj(ResultSet rs) throws SQLException {
		Item item = new Item(rs.getLong("itemid"), rs.getString("title"),
				rs.getInt("category"), rs.getLong("userid"),
				rs.getString("description"), rs.getInt("sold"),
				rs.getDate("avail_start"), rs.getDate("avail_end"),
				rs.getFloat("price_low"), rs.getFloat("price_high"),
				rs.getInt("popularity"), rs.getDate("time_added"),
				rs.getDate("time_mod"));
		return item;
	}

	public Item getItem(long itemid) throws SQLException {
		String query = "SELECT * FROM items WHERE itemid=" + itemid;
		ResultSet rs = execSql(query);
		if (rs.next())
			return getItemObj(rs);
		else return null;
	}

	public boolean deleteItem(Item item) throws SQLException {
		String query = "DELETE FROM items WHERE itemid = " + item.getItemid();
		execSql(query);

		return true;
	}

	public boolean editItem(Item item) throws SQLException {
		String query = "UPDATE users"
				+ String.format("SET title='%s', " + "category=%d, "
						+ "description=%s, " + "sold=%d, " + "avail_start=%s, "
						+ "avail_end=%s, " + "price_low=%f, "
						+ "price_high=%f, " + "popularity=%d, "
						+ "time_mod='%s'", item.getTitle(), item.getCategory(),
						strIsNull(item.getDescription()), item.getSold(),
						strIsNull(item.getAvailStart().toString()),
						strIsNull(item.getAvailEnd().toString()),
						item.getPriceLow(), item.getPriceHigh(),
						item.getPopularity(), item.getTimeModified().toString());
		execSql(query);
		return true;
	}

	public boolean createItem(Item item, List<String> tags) throws SQLException {
		TagDAO dao = new TagMySQLDAO();
		
		if (tags != null) {
			for (int i=0; i<tags.size();i++)
				dao.createTag(tags.get(i));
		}
		
		String query = "INSERT INTO items (title, category, userid, description, "
				+ "sold, avail_start, avail_end, price_low, price_high, popularity, "
				+ "time_added, time_mod) "
				+ String.format(
						"VALUES ('%s',%d, %d, %s, '%d', %s, %s, %f, %f, %d, '%s', '%s')",
						item.getTitle(), 
						item.getCategory(), 
						item.getUserid(),
						strIsNull(item.getDescription()), 
						item.getSold(),
						strIsNull(toSqlDate(item.getAvailStart())),
						strIsNull(toSqlDate(item.getAvailEnd())),
						item.getPriceLow(), 
						item.getPriceHigh(),
						item.getPopularity(), 
						toSqlDate(item.getTimeAdded()),
						toSqlDate(item.getTimeModified()));

		execSql(query);

		return true;
	}

	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> getItems(List<Tag> tags) throws SQLException {
		String strTags = "";
		int listSize = tags.size();

		if (listSize > 0)
			strTags = "'" + tags.get(0).toString() + "'";

		for (int i = 1; i < listSize; i++) {
			strTags += ", '" + tags.get(0).toString() + "'";
		}

		String query = "SELECT * FROM items i, tags t, item_tags r "
				+ "WHERE i.itemid = r.itemid AND t.tagid = item_tags.tagid "
				+ "AND t.tag_name IN (" + strTags + ")";
		ResultSet rs = execSql(query);

		List<Item> mylist = new ArrayList<Item>();
		if (rs.next()) {
			mylist.add(getItemObj(rs));
		}

		return mylist;
	}

}
