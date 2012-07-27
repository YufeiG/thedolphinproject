package listingService;

import global.MarketplaceConfig;
import global.MarketplaceConfig.Category;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import model.Item;
import model.Tag;
import mysqldao.MySQLDAOFactory;
import dao.AbstractDAOFactory;
import dao.ItemDAO;
import dao.TagDAO;

public class ListingServiceImpl implements ListingService{

	ItemDAO itemDAO;
	TagDAO tagDAO;
	
	public ListingServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		itemDAO = factory.getItemDAO();
		tagDAO = factory.getTagDAO();
	}
	
	
	public boolean createItem(Item i, List<String> tags){
		try {
			return itemDAO.createItem(i, tags);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	public Iterator<Item> findItems(List<String> tokens,  MarketplaceConfig.Category category, MarketplaceConfig.SortType sortBy) throws SQLException{
		
		SearchProcessing processing;
		List<Item> result;
		List<MarketplaceConfig.Category> categoryList = new ArrayList<MarketplaceConfig.Category>();
		
		if(category != null) {
			processing = new RecencySearchProcessing();
			
			categoryList.add(category);
			result = itemDAO.getItemsByCategory(categoryList);
			
		} else {

			if(sortBy == MarketplaceConfig.SortType.POPULARITY){
				processing = new PopularitySearchProcessing();
			}
			else if(sortBy == MarketplaceConfig.SortType.PRICE){
				processing = new PriceSearchProcessing();
			}
			else if(sortBy == MarketplaceConfig.SortType.RECENCY){
				processing = new RecencySearchProcessing();
			}
			else{
				processing = new RandomSearchProcessing();
			}
		
			result = itemDAO.getItemsDetailed(tokens);
		
		}
		
		processing.process(result);
		
		return result.iterator();
	}
	
	public boolean editItem(Item i, List<String> tags) throws SQLException{
		return itemDAO.editItem(i);
	}
	
	public boolean deleteItem(Item i) throws SQLException{
		return itemDAO.deleteItem(i);
	}
	
	public Item getItem(long itemID)
	{
		try {
			return itemDAO.getItem(itemID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public boolean deleteTag(String tagName) throws SQLException {
		return tagDAO.deleteTag(tagName);
	}


	@Override
	public long createTag(String tagName) throws SQLException {
		return tagDAO.createTag(tagName);
	}


	@Override
	public Iterator<Tag> getAllTags() throws SQLException {
		return tagDAO.getTags().iterator();
	}


	@Override
	public Iterator<Item> getItemsByCategory(List<Category> cats) throws SQLException {
		return itemDAO.getItemsByCategory(cats).iterator();
	}
}
