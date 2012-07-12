package userManagementService;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Tag;
import model.User;

public interface WishListUserService {
	
	public List<Tag> getItemsInWishList(User u, String option);
	
	public boolean addToWishList(Tag t, User u);
	
	public boolean deleteFromWishList(Tag t, User u);
	
}
