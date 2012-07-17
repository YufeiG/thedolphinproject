package listingService;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.List;
import global.MarketplaceConfig;

import model.Item;
import model.Tag;

public interface ListingService {

	public boolean createItem(Item i, List<String> tags);

	public List<Item> findItems(List<Tag> list,
			MarketplaceConfig.Category category,
			MarketplaceConfig.SortType sortBy) throws SQLException;

	public boolean editItem(Item i);

	public boolean deleteItem(Item i);

	public Item getItem(long itemID);

	public boolean deleteTag(String tagName) throws SQLException;

	public boolean createTag(String tagName) throws SQLException;

	public List<Tag> getAllTags() throws SQLException;

}
