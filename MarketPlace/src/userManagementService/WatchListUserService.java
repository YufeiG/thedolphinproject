package userManagementService;

import global.MarketplaceConfig.ReportType;

import java.sql.SQLException;
import java.util.Iterator;

import model.Item;
import model.User;

public interface WatchListUserService {

	public Iterator<Item> getWatchListItems(long userid) throws SQLException;

	public boolean exportList(User u, ReportType typeOfReport);

	public boolean deleteFromWatchList(long itemid, long userid)
			throws SQLException;

	public boolean addToWatchList(long itemid, long userid) throws SQLException;
	
	public boolean isInWatchList(long itemid, long userid) throws SQLException;

}
