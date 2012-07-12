package userManagementService;

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
	
	public List<Item> getWatchList(User u){
		return watchListUserService.getWatchListItems(u);
	}
	
	public boolean addToWatchList(Item i, User u){
		return watchListUserService.addToWatchList(i, u);
	}
	
	public boolean deleteFromWatchList(Item i, User u){
		return watchListUserService.deleteFromWatchList(i, u);
	}
	
	public boolean exportWatchList(User u){
		return watchListUserService.exportList(u);
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
	
	public List<Tag> getWishList(User user){
		return wishListUserService.getItemsInWishList(user, "");
	}
	
	public boolean addToWishList(Tag t, User user){
		return wishListUserService.addToWishList(t, user);
	}
	
	public boolean deleteFromWishList(Tag t, User user){
		return wishListUserService.deleteFromWishList(t, user);
	}
}
