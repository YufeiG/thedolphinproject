package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.ItemDAO;
import dao.UserDAO;

import model.Item;
import model.User;

public class UserMySQLDAO extends AbstractDAO implements UserDAO{

	public UserMySQLDAO() {
		createConnection();
	}
	
	private boolean usernameExists(String name) throws SQLException {
		ResultSet rs = execSql("SELECT * FROM users WHERE username='" + name + "'");
		if (rs.next()) return true;
		else return false;
	}

	public boolean createAccount(User user) throws SQLException {
		if (usernameExists(user.getUsername())) return false;

		String query = "INSERT INTO users (username, password, firstname, lastname, " +
				"email, phone_num, date_created) VALUES ('" + 
				user.getUsername() + "', '" +
				user.getPassword() + "', '" +
				user.getFirstName() + "', '" +
				user.getLastName() + "', '" +
				user.getEmail() + "'," +
				strIsNull(user.getPhoneNumber()) + ", CURDATE())";
		
		System.err.println(query);
		execSql(query);
		
		return true;
	}
	
	public User getUser(String username) throws SQLException
	{
		User user = null;
		ResultSet rs = execSql("SELECT * FROM users WHERE username = '" + username + "'");
		if (rs.next()) {
		user = new User(rs.getLong("userid"), rs
				.getString("username"), rs.getString("password"), rs
				.getString("firstname"), rs.getString("lastname"), rs
				.getString("email"), rs.getString("phone_num"), rs
				.getDate("date_created"));
		}

		return user;
		
	}
	public User getUser(long userid) throws SQLException {

		User user = null;
		ResultSet rs = execSql("SELECT * FROM users WHERE userid = " + userid);
		if (rs.next()) {
		user = new User(rs.getLong("userid"), rs
				.getString("username"), rs.getString("password"), rs
				.getString("firstname"), rs.getString("lastname"), rs
				.getString("email"), rs.getString("phone_num"), rs
				.getDate("date_created"));
		}

		return user;
		
	}
	
	public List<User> getUserList() throws SQLException {
		List<User> userList = new ArrayList<User>();
		ResultSet rs = execSql("SELECT * FROM users");

		while (rs.next()) {
			userList.add(new User(rs.getLong("userid"), rs
					.getString("username"), rs.getString("password"), rs
					.getString("firstname"), rs.getString("lastname"), rs
					.getString("email"), rs.getString("phone_num"), rs
					.getDate("date_created")));
		}
		return userList;

	}
	
	public boolean deleteUser(long userid) throws SQLException {
		execSql("DELETE FROM users WHERE userid = " + userid + "");
		return true;
	}
	
	public boolean editUser(User user) throws SQLException {
		execSql("UPDATE users" +
				"SET username='" + user.getUsername() +
				"', password='" + user.getPassword() +
				"', firstname='" + user.getFirstName() +
				"', lastname='" + user.getLastName() +
				"', email" + user.getEmail() +
				"', phone_num=" + strIsNull(user.getPhoneNumber()) +
				"WHERE username='" + user.getUsername() + "'");
		return true;
	}

	public boolean deleteFromWatchList(long itemid, long userid) throws SQLException {
		String query = String.format(
				"DELETE FROM watchlist WHERE itemid=%d AND userid=%d", itemid, userid);
		execSql(query);
		
		return true;
	}

	public boolean addToWatchList(long itemid, long userid) throws SQLException {
		Date d = new Date(System.currentTimeMillis());
		
		String query = String.format(
				"INSERT INTO watchlist VALUES (%d, %d, '%s')", userid, itemid, toSqlDate(d));
		execSql(query);
		
		return true;
	}
	
	public List<Item> getWatchlist(long userid) throws SQLException {
		AbstractDAOFactory fact = new MySQLDAOFactory();
		ItemDAO itemdao = fact.getItemDAO();
		return itemdao.getItemsQuery("SELECT * FROM watchlist w JOIN items i ON (w.itemid = i.itemid) WHERE w.userid=" + userid);
	}
}
