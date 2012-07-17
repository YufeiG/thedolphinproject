package userManagementService;

import java.sql.SQLException;
import java.util.List;

import model.Tag;

public interface WishListUserService {
	
	public List<Tag> getItemsInWishList(long userid) throws SQLException;
	
	public boolean addToWishList(List<String> tagNames, long userId) throws SQLException;
	
	public boolean deleteFromWishList(List<String> tagNames, long userId) throws SQLException;
	
}
