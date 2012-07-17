package userManagementService;

import global.MarketplaceConfig.ReportType;

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
		itemDAO = factory.getItemDAO();
	}
	
	public List<Item> getWatchListItems(User u){
		return null;
	}
	
	public boolean exportList(User u, ReportType typeOfReport){
		AbstractReport report;

		switch (typeOfReport){
		case PDF:
			report = new PDFReport();
			break;
		case HTML:
			report = new HTMLReport();
			break;
		default:
			return false;
		}
		
		report.export();
		
		return true;
	}
	
	public boolean deleteFromWatchList(Item i, User u){
		return false;
	}
	
	public boolean addToWatchList(Item i, User u){
		return false;
	}
	
}
