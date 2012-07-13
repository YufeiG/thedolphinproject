package global;

public final class MarketplaceConfig {
	//private static MarketplaceConfig _instance;
	public static String DB_PW = "yufei";

	public static enum SortType {
		 NONE, RECENCY, POPULARITY, PRICE; 
	}
	
	public static enum ReportType {
		 PDF, HTML; 
	}

	/*
	public static MarketplaceConfig Instance() {
    	if(_instance == null)
    	{
    		_instance = new MarketplaceConfig();
    	}
    	return _instance;
    }

    private MarketplaceConfig() {
    }
    
    */
}
