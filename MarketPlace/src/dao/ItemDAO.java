package dao;

import java.util.List;
import model.Item;

public interface ItemDAO {
	public Item getItem(long id);
	public boolean deleteItem();
	public boolean editItem();
	public boolean createItem();
	public List<Item> getItems();
}
