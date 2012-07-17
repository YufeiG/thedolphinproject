package userManagementService;

import global.MarketplaceConfig.ReportType;

import java.sql.SQLException;
import java.util.List;

import model.Item;
import model.User;
import mysqldao.ItemMySQLDAO;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public interface WatchListUserService {

	public List<Item> getWatchListItems(User u);

	public boolean exportList(User u, ReportType typeOfReport);

	public boolean deleteFromWatchList(long itemid, long userid)
			throws SQLException;

	public boolean addToWatchList(long itemid, long userid) throws SQLException;

}
