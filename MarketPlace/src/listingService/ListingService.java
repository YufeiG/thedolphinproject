package listingService;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.Item;
import model.Tag;

public interface ListingService {

	public boolean createItem(Item i, List<String> tags);

	public Iterator<Item> findItems(List<String> tokens,
			MarketplaceConfig.Category category,
			MarketplaceConfig.SortType sortBy) throws SQLException;

	public boolean editItem(Item i, List<String> tags) throws SQLException;

	public boolean deleteItem(Item i) throws SQLException;

	public Item getItem(long itemID);

	public boolean deleteTag(String tagName) throws SQLException;

	public long createTag(String tagName) throws SQLException;

	public Iterator<Tag> getAllTags() throws SQLException;

}
