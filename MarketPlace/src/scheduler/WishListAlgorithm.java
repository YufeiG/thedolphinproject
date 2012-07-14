package scheduler;

import java.util.HashMap;

import model.Item;
import model.User;



public interface WishListAlgorithm {
	public HashMap<User, Item> match();
}
