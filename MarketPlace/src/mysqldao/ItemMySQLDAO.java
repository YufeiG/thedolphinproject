package mysqldao;

import global.MarketplaceConfig;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
				rs.getInt("categoryid"), rs.getLong("userid"),
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
		else
			return null;
	}

	public boolean deleteItem(Item item) throws SQLException {
		String query = "DELETE FROM items WHERE itemid = " + item.getItemid();
		execSql(query);

		return true;
	}

	public boolean editItem(Item item) throws SQLException {
		Date d = new Date(System.currentTimeMillis());
		String query = "UPDATE items"
				+ String.format("SET title='%s', " + "categoryid=%d, "
						+ "description=%s, " + "sold=%d, " + "avail_start=%s, "
						+ "avail_end=%s, " + "price_low=%f, "
						+ "price_high=%f, " + "popularity=%d, "
						+ "time_mod='%s' WHERE itemid='%d'", item.getTitle(), item.getCategory(),
						strIsNull(item.getDescription()), item.getSold(),
						toSqlDate(item.getAvailStart()),
						toSqlDate(item.getAvailEnd()),
						item.getPriceLow(), item.getPriceHigh(),
						item.getPopularity(), toSqlDate(d), item.getItemid());
		execSql(query);
		return true;
	}

	public boolean createItem(Item item, List<String> tags) throws SQLException {
		TagDAO dao = new TagMySQLDAO();
		List<Long> tagIds = new ArrayList<Long>();

		if (tags != null) {
			for (int i = 0; i < tags.size(); i++) {
				long tagid = dao.createTag(tags.get(i));
				tagIds.add(tagid);
			}
		}

		String query = "INSERT INTO items (title, categoryid, userid, description, "
				+ "sold, avail_start, avail_end, price_low, price_high, popularity, "
				+ "time_added, time_mod) "
				+ String.format(
						"VALUES ('%s',%s, %d, %s, '%d', %s, %s, %f, %f, %d, '%s', '%s');",
						item.getTitle(), (item.getCategory() == 0 ? "NULL"
								: item.getCategory() + ""), item.getUserid(),
						strIsNull(item.getDescription()), item.getSold(),
						strIsNull(toSqlDate(item.getAvailStart())),
						strIsNull(toSqlDate(item.getAvailEnd())), item
								.getPriceLow(), item.getPriceHigh(), item
								.getPopularity(),
						toSqlDate(item.getTimeAdded()), toSqlDate(item
								.getTimeModified()));

		execSql(query);

		ResultSet rs = execSql("SELECT LAST_INSERT_ID();");

		if (rs.next()) {
			for (int k = 0; k < tagIds.size(); k++) {
				try {
					execSql("INSERT INTO item_tags VALUES ("
							+ rs.getLong("LAST_INSERT_ID()") + ","
							+ tagIds.get(k) + ")");
				} catch (SQLException e) {
					// Duplicate itemid-tagid pair was inserted. This means the
					// user created two of more tags
					// with the same string. We can safely ignore this
					System.err
							.println("User inserted two identical tags for the same item. Duplicate tag ignored.");
				}

			}
		}

		return true;
	}

	public List<Item> getItemsQuery(String query) throws SQLException {
		List<Item> mylist = new ArrayList<Item>();

		ResultSet rs = execSql(query);

		while (rs.next()) {
			mylist.add(getItemObj(rs));
		}

		return mylist;
	}

	public List<Item> getItems() throws SQLException {
		return getItemsQuery("SELECT * FROM items AND avail_end<='" + getCurDate()
				+ "'");
	}

	public List<Item> getItems(Iterator<Tag> tags) throws SQLException {

		if (tags == null || tags.hasNext() == false)
			return getItems();

		String strTags = "";

		Tag tag = tags.next();
		strTags = "'" + tag.getName() + "'";
		while (tags.hasNext()) {
			strTags += ", '" + tags.next().getName() + "'";
		}

		String query = "SELECT * FROM items i, tags t, item_tags r "
				+ "WHERE i.itemid = r.itemid AND t.tagid = r.tagid "
				+ "AND t.tag_name IN (" + strTags + ")" + "AND i.avail_end<='"
				+ getCurDate() + "'";

		return getItemsQuery(query);
	}

	public List<Item> getItemsDetailed(List<String> tokens) throws SQLException {

		List<Item> mylist = new ArrayList<Item>();
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();

		for (int i = 0; i < tokens.size(); i++) {
			String thisToken = tokens.get(i);
			String query = "SELECT * FROM items i WHERE (i.title LIKE '%"
					+ thisToken + "%' OR i.description LIKE '%" + thisToken
					+ "%'" + ") AND i.avail_end>='" + getCurDate() + "'";

			ResultSet rs = execSql(query);

			while (rs.next()) {
				if (!map.containsKey(rs.getLong("itemid"))) {
					mylist.add(getItemObj(rs));
					map.put(rs.getLong("itemid"), true);
				}
			}
		}

		return mylist;
	}

	public List<Item> getItemsByCategory(List<MarketplaceConfig.Category> cats)
			throws SQLException {

		List<Item> mylist = new ArrayList<Item>();

		if (cats.size() > 0) {
			String catIds = cats.get(0).getValue() + "";
			for (int i = 1; i < cats.size(); i++) {
				catIds += ", " + cats.get(i).getValue();
			}

			mylist = getItemsQuery("SELECT * FROM items WHERE categoryid IN ("
					+ catIds + ")");
		}

		return mylist;
	}

	public List<Item> getItemsByUser(long userid) throws SQLException {

		List<Item> mylist = new ArrayList<Item>();

		mylist = getItemsQuery("SELECT * FROM items WHERE userid=" + userid + "");

		return mylist;
	}

	@Override
	public List<String> getItemTags(long itemid) throws SQLException {
		String query = "SELECT tag_name FROM item_tags JOIN tags ON (tags.tagid = item_tags.tagid) WHERE itemid = " + itemid;
		ResultSet rs = execSql(query);
		List<String> ret = new ArrayList<String>();
		while (rs.next()) {
			ret.add(rs.getString("tag_name"));
		}
		return ret;
	}

	@Override
	public boolean setItemTags(List<String> tags, long itemid)
			throws SQLException {
		String query = "DELETE FROM item_tags WHERE itemid = " + itemid;
		execSql(query);
		
		TagDAO dao = new TagMySQLDAO();
		
		for (int i=0; i<tags.size(); i++) {
			long tagid = dao.createTag(tags.get(i));
			query = "INSERT INTO item_tags VALUES (" + itemid + "," + tagid + ")";
		}
		return true;
	}
}
