package scheduler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import model.Item;
import model.User;
import email.EmailNotification;
import global.MarketplaceConfig;

public class MainScheduler {
	
	static MainScheduler instance;
	
	WishListAlgorithm algorithm;
	EmailNotification email;
	Timer timer;
	Date lastMatchedDate = new Date(0);
	
	
	
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
		if(timer == null){
			timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					runWishListAlgorithm(lastMatchedDate);
					lastMatchedDate = new Date(System.currentTimeMillis());
				}
			}, 0, MarketplaceConfig.WISH_LIST_MATCH_TIME_INTERVAL);
			
		}
		
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
	
	public void runWishListAlgorithm(Date date){
		HashMap<User, List<Item>> list = algorithm.match(date);
		emailToUser(list);
	}
	
	private void emailToUser(HashMap<User, List<Item>> list){
		email.sendMessageToUser(list);
	}

}
