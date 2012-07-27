package userManagementService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.Tag;
import mysqldao.MySQLDAOFactory;
import dao.AbstractDAOFactory;
import dao.TagDAO;

public class WishListUserServiceImpl implements WishListUserService{
	TagDAO tagDAO;
	
	public WishListUserServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		tagDAO = factory.getTagDAO();
	}
	
	
	public Iterator<Tag> getItemsInWishList(long userid) throws SQLException{
		List<Tag> tag = tagDAO.getTags(userid);
		
		return tagDAO.getTags(userid).iterator();
	}
	
	public boolean addToWishList(List<String> tagNames, long userId) throws SQLException{
		System.err.println(tagNames);
		return tagDAO.addTagsToWishlist(userId, tagNames);
	}
	
	public boolean deleteFromWishList(List<String> tagNames, long userId) throws SQLException{
		System.err.println(tagNames);
		return tagDAO.removeTagsFromWishlist(userId, tagNames);
	}
	
}
