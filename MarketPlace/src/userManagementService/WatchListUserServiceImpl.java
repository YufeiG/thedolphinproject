package userManagementService;

import java.util.List;

import model.Item;
import model.User;
import mysqldao.ItemMySQLDAO;
import mysqldao.MySQLDAOFactory;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.ItemDAO;

public class WatchListUserServiceImpl implements WatchListUserService{

	ItemDAO itemDAO;
	
	public WatchListUserServiceImpl() {
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getItemDAO();
		itemDAO = (ItemMySQLDAO) dao;
	}
	
	public List<Item> getWatchListItems(User u){
		return null;
	}
	
	public boolean exportList(User u, int typeOfReport){
		AbstractReport report;
		if(typeOfReport == 1){
			report = new PDFReport();
		}
		else{
			report = new HTMLReport();
		}
		
		report.export();
		
		return false;
	}
	
	public boolean deleteFromWatchList(Item i, User u){
		return false;
	}
	
	public boolean addToWatchList(Item i, User u){
		return false;
	}
	
}
