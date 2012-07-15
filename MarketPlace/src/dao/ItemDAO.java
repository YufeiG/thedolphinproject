package dao;

import java.sql.SQLException;
import java.util.List;

import model.Item;
import model.Tag;

public interface ItemDAO {
	public Item getItem();
	public boolean deleteItem();
	public boolean editItem();
	public boolean createItem(Item item) throws SQLException;
	public List<Item> getItems();
	public List<Item> getItems(List<Tag> tags);
}
