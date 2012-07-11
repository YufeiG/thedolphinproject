package recommendationService;

import java.util.List;

import model.Item;
import model.User;

public interface RecommendationAlgorithm {
	public List<Item> generateRecommendations(User u);
}
