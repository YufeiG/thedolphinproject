package listingService;

import global.MarketplaceConfig;

import java.util.List;
import global.MarketplaceConfig;

import model.Item;
import model.Tag;

public interface ListingService {

	
	public boolean createItem(Item i);
	
<<<<<<< HEAD
	public List<Item> findItems(List<Tag> list, MarketplaceConfig.Category category, MarketplaceConfig.SortType sortBy);
=======
	public List<Item> findItems(List<Tag> list, int category, MarketplaceConfig.SortType sortBy);
>>>>>>> branch 'master' of https://github.com/YufeiG/thedolphinproject.git
	
	public boolean editItem(Item i);
	
	public boolean deleteItem(Item i);
}
