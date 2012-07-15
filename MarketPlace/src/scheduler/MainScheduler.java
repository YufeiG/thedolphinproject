package scheduler;

import java.util.HashMap;
import java.util.List;

import model.Item;
import model.User;
import email.EmailNotification;
import global.MarketplaceConfig;

public class MainScheduler {
	
	static MainScheduler instance;
	
	WishListAlgorithm algorithm;
	EmailNotification email;
	
	//private constructors for singleton
	private MainScheduler(){
		email = new EmailNotification();
		algorithm = new MostRecentItemsFirstWishListAlgorithm();
	}
	
	public static MainScheduler getInstance() {
		if(instance == null){
			instance = new MainScheduler();
		}
		
		return instance;
	}
	
	public void createSchedulerThread(){
		
	}
	
	public void selectWishListAlgorithm(MarketplaceConfig.WishListAlgorithm type){
		switch (type) {
		case MOST_RECENT:
			algorithm = new MostRecentItemsFirstWishListAlgorithm();
			break;

		case MOST_TAGS:
			algorithm = new MostTagsMatchedFirstWishListAlgorithm();
			break;
		}
		
	}
	
	private void runWishListAlgorithm(){
		HashMap<User, List<Item>> list = algorithm.match();
		email.sendMessageToUser(list);
	}

}
