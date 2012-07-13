package global;

public final class MarketplaceConfig {
	private static MarketplaceConfig _instance;
	public String DB_PW = "yufei";

	public enum SortType {
		 NONE, RECENCY, POPULARITY, PRICE; 
	}


    public static MarketplaceConfig Instance() {
    	if(_instance == null)
    	{
    		_instance = new MarketplaceConfig();
    	}
    	return _instance;
    }

    private MarketplaceConfig() {
    }
}
