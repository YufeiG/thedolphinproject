package recommendationService;

import global.MarketplaceConfig;

import java.util.List;

import model.Item;
import model.User;

public class RecommendationServiceImpl implements RecommendationService{
	RecommendationAlgorithm algorithm;
	
	public List<Item> generateRecommendations(User u){
		return algorithm.generateRecommendations(u);
	}
	
	public boolean selectRecommendationsAlgorithm(MarketplaceConfig.RecommendationAlgorithm select){
		switch (select) {
		case MOST_RECENT_PRIORITY:
			algorithm = new MostRecentPriorityAlgorithm();
			return true;
		case QUANTITY_PRIORITY:
			algorithm = new QuantityPriorityAlgorithm();
			return true;
		}
		
		return false;
	}
}
