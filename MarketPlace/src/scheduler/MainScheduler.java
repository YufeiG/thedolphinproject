package scheduler;

import java.util.HashMap;

import model.Item;
import model.User;
import email.EmailNotification;

public class MainScheduler {
	
	static MainScheduler instance;
	
	WishListAlgorithm algorithm;
	EmailNotification email;
	
	//private constructors for singleton
	private MainScheduler(){
		email = new EmailNotification();
	}
	
	public static MainScheduler getInstance() {
		if(instance == null){
			instance = new MainScheduler();
		}
		
		return instance;
	}
	
	public void createSchedulerThread(){
		
	}
	
	public void selectWishListAlgorithm(int type){
		if(type == 1){
			algorithm = new MostRecentItemsFirstWishListAlgorithm();
		}
		else{
			algorithm = new MostTagsMatchedFirstWishListAlgorithm();
		}
		
	}
	
	public void runWishListAlgorithm(){
		HashMap<User, Item> list = algorithm.match();
		email.sendMessageToUser(list);
	}

}
