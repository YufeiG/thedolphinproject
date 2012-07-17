package userManagementService;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.List;

import model.Item;
import model.Tag;
import model.User;

public interface UserManagementService {
	
	public List<Item> getWatchList(User u);
	
	public boolean addToWatchList(Item i, User u);
	
	public boolean deleteFromWatchList(Item i, User u);
	
	public boolean exportWatchList(User u, MarketplaceConfig.ReportType typeOfReport);
	
	public boolean createAccount(User u) throws SQLException ;
	
	public boolean editAccount(User user) throws SQLException ;
	
	public boolean deleteAccount(long userid) throws SQLException ;
	
	public User getAccount(long userid) throws SQLException;
	
	public boolean banAccount(User user);
	
	public List<Tag> getWishList(long userid) throws SQLException;
	
	public boolean addToWishList(List<String> tagNames, long userId) throws SQLException;
	
	public boolean deleteFromWishList(List<String> tagNames, long userId) throws SQLException;
}
