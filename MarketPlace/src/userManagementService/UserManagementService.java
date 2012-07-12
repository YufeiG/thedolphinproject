package userManagementService;

import java.util.List;

import model.Item;
import model.Tag;
import model.User;

public interface UserManagementService {
	
	public List<Item> getWatchList(User u);
	
	public boolean addToWatchList(Item i, User u);
	
	public boolean deleteFromWatchList(Item i, User u);
	
	public boolean exportWatchList(User u);
	
	public boolean createAccount(User u);
	
	public boolean editAccount(User user);
	
	public boolean deleteAccount(String username);
	
	public boolean banAccount(User user);
	
	public List<Tag> getWishList(User user);
	
	public boolean addToWishList(Tag t, User user);
	
	public boolean deleteFromWishList(Tag t, User user);
}
