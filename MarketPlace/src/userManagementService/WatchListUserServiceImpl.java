package userManagementService;

import global.MarketplaceConfig.ReportType;

import java.sql.SQLException;
import java.util.List;

import model.Item;
import model.User;
import mysqldao.MySQLDAOFactory;
import dao.AbstractDAOFactory;
import dao.ItemDAO;
import dao.UserDAO;

public class WatchListUserServiceImpl implements WatchListUserService{

	ItemDAO itemDAO;
	UserDAO userDAO;
	
	public WatchListUserServiceImpl() {
		AbstractDAOFactory factory = new MySQLDAOFactory();
		itemDAO = factory.getItemDAO();
		userDAO = factory.getUserDAO();
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

	@Override
	public boolean deleteFromWatchList(long itemid, long userid)
			throws SQLException {
		return userDAO.deleteFromWatchList(itemid, userid);
		
		
	}

	@Override
	public boolean addToWatchList(long itemid, long userid) throws SQLException {
		return userDAO.addToWatchList(itemid, userid);
	}
	

	
}
