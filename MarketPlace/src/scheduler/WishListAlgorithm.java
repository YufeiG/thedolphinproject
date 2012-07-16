package scheduler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.Item;
import model.User;





public interface WishListAlgorithm {
	public HashMap<User, List<Item>> match(Date date);
}
