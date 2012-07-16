package scheduler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.Item;
import model.Tag;
import model.User;
import mysqldao.MySQLDAOFactory;
import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;
import dao.ItemDAO;
import dao.TagDAO;
import dao.UserDAO;





public class MostRecentItemsFirstWishListAlgorithm implements WishListAlgorithm{

	@Override
	public HashMap<User, List<Item>> match(Date date) {
		MySQLDAOFactory factory = new MySQLDAOFactory();
		ItemDAO itemDao = factory.getItemDAO();
		UserDAO userDao = factory.getUserDAO();
		
		UserManagementService userManagementService = new UserManagementServiceImpl();
		
		
		HashMap<User, List<Item>> ret = new HashMap<User, List<Item>>();
		
		try {
			List<User> users = userDao.getUserList();
			Iterator<User> userIterator = users.iterator();
			
			while(userIterator.hasNext()){
				User currentUser = userIterator.next();
				List<Item> matchedItems = new ArrayList<Item>();
				List<Tag> tags = userManagementService.getWishList(currentUser);
				List<Item> items = itemDao.getItems(tags);				
				Iterator<Item> itemIterator = items.iterator();
				while(itemIterator.hasNext()){
					Item currentItem = itemIterator.next();
					if(currentItem.getTimeAdded().after(date)){
						matchedItems.add(currentItem);
					}					
				}
				
				Collections.sort(matchedItems, new Comparator<Item>() {

					@Override
					public int compare(Item o1, Item o2) {
						if(o1.getTimeAdded().before(o2.getTimeAdded())){
							return -1;
						}
						else if(o1.getTimeAdded().equals(o2.getTimeAdded())){
							return 0;
						}
						else{
							return 1;
						}
					}
				});
				
				ret.put(currentUser, matchedItems);
			}
			
			
			
			
			
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			return ret;
		}
		
		
		
		return ret;
	}

}
