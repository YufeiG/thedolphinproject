package dao;

import java.util.List;
import model.Item;
import model.Tag;

import java.sql.SQLException;

public interface ItemDAO {

	public Item getItem(long itemid) throws SQLException;
	public boolean deleteItem(Item item) throws SQLException;
	public boolean editItem(Item item) throws SQLException;
	public boolean createItem(Item item, List<Tag> tags) throws SQLException;
	public List<Item> getItems(List<Tag> tags) throws SQLException;
}
