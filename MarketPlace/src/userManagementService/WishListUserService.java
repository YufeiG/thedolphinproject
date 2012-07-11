package userManagementService;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Tag;
import model.User;

public class WishListUserService {
	
	public List<Tag> getItemsInWishList(User u, String option){
		return new ArrayList<Tag>();
	}
	
	public boolean addToWishList(Tag t, User u){
		return false;
	}
	
	public boolean deleteFromWishList(Tag t, User u){
		return false;
	}
	
}
