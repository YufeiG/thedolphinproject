package listingService;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Tag;
import mysqldao.ItemMySQLDAO;
import mysqldao.MySQLDAOFactory;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.ItemDAO;

public class ListingServiceImpl implements ListingService{

	ItemDAO itemDAO;
	
	public ListingServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getItemDAO();
		itemDAO = (ItemMySQLDAO) dao;
	}
	
	
	public boolean createItem(Item i){
		return false;
	}
	
	public List<Item> findItems(List<Tag> list, int category, int sortBy){
		SearchProcessing processing;
		
		if(sortBy == 0){
			processing = new PopularitySearchProcessing();
		}
		else if(sortBy == 1){
			processing = new PriceSearchProcessing();
		}
		else if(sortBy == 2){
			processing = new RecencySearchProcessing();
		}
		else{
			processing = new RandomSearchProcessing();
		}
		
		List<Item> result = itemDAO.getItems();
		
		processing.process(result);
		
		
		
		return new ArrayList<Item>();
	}
	
	public boolean editItem(Item i){
		return false;
	}
	
	public boolean deleteItem(Item i){
		return false;
	}
}
