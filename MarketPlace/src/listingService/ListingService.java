package listingService;

import java.util.List;

import model.Item;
import model.Tag;

public interface ListingService {

	
	public boolean createItem(Item i);
	
	public List<Item> findItems(List<Tag> list, int category, int sortBy);
	
	public boolean editItem(Item i);
	
	public boolean deleteItem(Item i);
}
