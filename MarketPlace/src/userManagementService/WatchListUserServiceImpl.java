package userManagementService;

import java.util.List;

import model.Item;
import model.User;
import mysqldao.ItemMySQLDAO;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public class WatchListUserServiceImpl implements WatchListUserService{

	ItemMySQLDAO itemDAO;
	
	public WatchListUserServiceImpl() {
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getItemDAO();
		itemDAO = (ItemMySQLDAO) dao;
	}
	
	public List<Item> getWatchListItems(User u){
		return null;
	}
	
	public boolean exportList(User u, int typeOfReport){
		return false;
	}
	
	public boolean deleteFromWatchList(Item i, User u){
		return false;
	}
	
	public boolean addToWatchList(Item i, User u){
		return false;
	}
	
}
