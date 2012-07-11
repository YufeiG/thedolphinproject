package userManagementService;

import java.util.List;

import model.Item;
import model.Tag;
import model.User;

public class UserManagementService {
	UserAccountService userAccountService;
	WishListUserService wishListUserService;
	WatchListUserService watchListUserService;
	
	public UserManagementService(){
		userAccountService = new UserAccountService();
		wishListUserService = new WishListUserService();
		watchListUserService = new WatchListUserService();
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
	
	public boolean createAccount(User u){
		return userAccountService.createAccount(u);
	}
	
	public boolean editAccount(User u){
		return userAccountService.editAccount(u);
	}
	
	public boolean deleteAccount(User u){
		return userAccountService.deleteAccount(u);
	}
	
	public boolean banAccount(User u){
		return userAccountService.banAccount(u);
	}
	
	public List<Tag> getWishList(User u){
		return wishListUserService.getItemsInWishList(u, "");
	}
	
	public boolean addToWishList(Tag t, User u){
		return wishListUserService.addToWishList(t, u);
	}
	
	public boolean deleteFromWishList(Tag t, User u){
		return wishListUserService.deleteFromWishList(t, u);
	}
}
