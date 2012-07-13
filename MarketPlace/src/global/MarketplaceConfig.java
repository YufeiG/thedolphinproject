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
	
	

   
	// prevent intialization
    private MarketplaceConfig() {
    }
}
