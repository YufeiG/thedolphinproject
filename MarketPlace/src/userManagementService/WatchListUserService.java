package userManagementService;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.User;

public class WatchListUserService {
	
	
	public List<Item> getWatchListItems(User u){
		return new ArrayList<Item>();
	}
	
	public boolean exportList(User u){
		return false;
	}
	
	public boolean deleteFromWatchList(Item i, User u){
		return false;
	}
	
	public boolean addToWatchList(Item i, User u){
		return false;
	}
	
}
