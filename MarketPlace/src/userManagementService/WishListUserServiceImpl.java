package userManagementService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tag;
import mysqldao.MySQLDAOFactory;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.TagDAO;

public class WishListUserServiceImpl implements WishListUserService{
	TagDAO tagDAO;
	
	public WishListUserServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		tagDAO = factory.getTagDAO();
	}
	
	
	public List<Tag> getItemsInWishList(long userid) throws SQLException{
		return tagDAO.getTags(userid);
	}
	
	public boolean addToWishList(List<String> tagNames, long userId) throws SQLException{
		return tagDAO.addTagsToWishlist(userId, tagNames);
	}
	
	public boolean deleteFromWishList(List<String> tagNames, long userId) throws SQLException{
		return tagDAO.removeTagsFromWishlist(userId, tagNames);
	}
	
}
