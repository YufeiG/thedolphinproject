package dao;

import java.util.List;

import model.Item;
import model.Tag;

public interface ItemDAO {
	public Item getItem();
	public boolean deleteItem();
	public boolean editItem();
	public boolean createItem();
	public List<Item> getItems();
	public List<Item> getItems(List<Tag> tags);
}
