package recommendationService;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.User;

public interface RecommendationService {
	
	public List<Item> generateRecommendations(User u);
	
	public boolean selectRecommendationsAlgorithm(int select);
}
