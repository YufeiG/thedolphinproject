package userManagementService;

import global.MarketplaceConfig;

import java.sql.SQLException;
import java.util.List;

import model.Item;
import model.Tag;
import model.User;

public class UserManagementServiceImpl implements UserManagementService {
	UserAccountService userAccountService;
	WishListUserService wishListUserService;
	WatchListUserService watchListUserService;
	
	public UserManagementServiceImpl(){
		userAccountService = new UserAccountServiceImpl();
		wishListUserService = new WishListUserServiceImpl();
		watchListUserService = new WatchListUserServiceImpl();
	}
	
	public User getAccount(long userid) throws SQLException
	{
		return userAccountService.getAccount(userid);
	}
	public List<Item> getWatchList(User u){
		return watchListUserService.getWatchListItems(u);
	}
	
	public boolean addToWatchList(long itemid, long userid) throws SQLException{
		return watchListUserService.addToWatchList(itemid, userid);
	}
	
	public boolean deleteFromWatchList(long itemid, long userid) throws SQLException{
		return watchListUserService.deleteFromWatchList(itemid, userid);
	}
	
	public boolean exportWatchList(User u, MarketplaceConfig.ReportType typeOfReport){
		return watchListUserService.exportList(u, typeOfReport);
	}
	
	public boolean createAccount(User u) throws SQLException {
		return userAccountService.createAccount(u);
	}
	
	public boolean editAccount(User user) throws SQLException {
		return userAccountService.editAccount(user);
	}
	
	public boolean deleteAccount(long userid) throws SQLException {
		return userAccountService.deleteAccount(userid);
	}
	
	public boolean banAccount(User user){
		return userAccountService.banAccount(user);
	}
	
	public List<Tag> getWishList(long userid) throws SQLException{
		return wishListUserService.getItemsInWishList(userid);
	}
	
	public boolean addToWishList(List<String> tagNames, long userId) throws SQLException{
		return wishListUserService.addToWishList(tagNames, userId);
	}
	
	public boolean deleteFromWishList(List<String> tagNames, long userId) throws SQLException{
		return wishListUserService.deleteFromWishList(tagNames, userId);
	}
}
