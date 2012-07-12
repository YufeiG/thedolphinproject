package recommendationService;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.User;

public class RecommendationServiceImpl implements RecommendationService{
	RecommendationAlgorithm algorithm;
	
	public List<Item> generateRecommendations(User u){
		return algorithm.generateRecommendations(u);
	}
	
	public boolean selectRecommendationsAlgorithm(int select){
		switch (select) {
		case 1:
			algorithm = new MostRecentPriorityAlgorithm();
			return true;
		case 2:
			algorithm = new QuantityPriorityAlgorithm();
			return true;
		}
		
		return false;
	}
}
