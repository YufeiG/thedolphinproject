package listingService;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.List;

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
	

	public List<Item> findItems(List<Tag> list,  MarketplaceConfig.Category category, MarketplaceConfig.SortType sortBy) throws SQLException{

		SearchProcessing processing;

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
		
		List<Item> result = itemDAO.getItems(list);
		
		processing.process(result);
				
	
		
		
		
		return result;
	}
	
	public boolean editItem(Item i){
		return false;
	}
	
	public boolean deleteItem(Item i){
		return false;
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
	public boolean createTag(String tagName) throws SQLException {
		return tagDAO.createTag(tagName);
	}


	@Override
	public List<Tag> getAllTags() throws SQLException {
		return tagDAO.getTags();
	}
}
