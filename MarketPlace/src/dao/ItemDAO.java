package dao;

import global.MarketplaceConfig;

import java.util.List;
import model.Item;
import model.Tag;

import java.sql.SQLException;

public interface ItemDAO {

	public Item getItem(long itemid) throws SQLException;
	public boolean deleteItem(Item item) throws SQLException;
	public boolean editItem(Item item) throws SQLException;
	public boolean createItem(Item item, List<String> tags) throws SQLException;
	public List<Item> getItems(List<Tag> tags) throws SQLException;
	public List<Item> getItemsDetailed(List<String> tokens) throws SQLException;
	public List<Item> getItemsByCategory(List<MarketplaceConfig.Category> cats) throws SQLException;
	public List<Item> getItemsByUser(long userid) throws SQLException;
}
