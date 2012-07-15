package global;

public final class MarketplaceConfig {
	public static String DB_PW = "yufei";

	public static enum SortType {
		 NONE, RECENCY, POPULARITY, PRICE; 
	}
	
	public static enum ReportType {
		 PDF, HTML; 
	}

	public static enum Category {
		 HOUSING, TEXTBOOKS, FURNITURE, SERVICES;
	}
	
	public static enum RecommendationAlgorithm{
		MOST_RECENT_PRIORITY, QUANTITY_PRIORITY;
	}
	
	public static enum WishListAlgorithm{
		MOST_RECENT, MOST_TAGS
	}
	
	

   
	// prevent intialization
    private MarketplaceConfig() {
    }
}
