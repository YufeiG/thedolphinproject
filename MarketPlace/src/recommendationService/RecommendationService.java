package recommendationService;

import global.MarketplaceConfig;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.User;

public interface RecommendationService {
	
	public List<Item> generateRecommendations(User u);
	
	public boolean selectRecommendationsAlgorithm(MarketplaceConfig.RecommendationAlgorithm select);
}
