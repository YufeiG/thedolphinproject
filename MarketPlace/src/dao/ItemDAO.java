package dao;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.Item;
import model.Tag;

public interface ItemDAO {

	public Item getItem(long itemid) throws SQLException;
	public boolean deleteItem(Item item) throws SQLException;
	public boolean editItem(Item item) throws SQLException;
	public boolean createItem(Item item, List<String> tags) throws SQLException;
	public List<Item> getItems(Iterator<Tag> tags) throws SQLException;
	public List<Item> getItemsDetailed(List<String> tokens) throws SQLException;
	public List<Item> getItemsByCategory(List<MarketplaceConfig.Category> cats) throws SQLException;
	public List<Item> getItemsByUser(long userid) throws SQLException;
	public List<Item> getItemsQuery(String query) throws SQLException;
	public List<String> getItemTags(long itemid) throws SQLException; //returns a list of tag names 
	public boolean setItemTags(List<String> tags, long itemid) throws SQLException; //takes a list of tags and replace the item's list of tags with the new one
	
}
