package listingService;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.Item;

public interface ListingService {

	public boolean createItem(Item i, List<String> tags);

	public Iterator findItems(List<String> tokens,
			MarketplaceConfig.Category category,
			MarketplaceConfig.SortType sortBy) throws SQLException;

	public boolean editItem(Item i);

	public boolean deleteItem(Item i);

	public Item getItem(long itemID);

	public boolean deleteTag(String tagName) throws SQLException;

	public long createTag(String tagName) throws SQLException;

	public Iterator getAllTags() throws SQLException;

}
