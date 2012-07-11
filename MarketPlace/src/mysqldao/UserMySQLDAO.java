package mysqldao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import dao.UserDAO;

import model.User;

public class UserMySQLDAO extends AbstractDAO implements UserDAO{
	public UserMySQLDAO() {
		createConnection();
	}

	public User getUser(String username){

		User user = null;
		try {
			Statement st = mConnection.createStatement();
			String query = "SELECT * FROM users WHERE username = '" + username + "'";
			st.execute(query);

			ResultSet rs = st.getResultSet();

			if (rs.next()) {
				user = new User(rs.getLong("uid"), rs
						.getString("username"), rs.getString("password"), rs
						.getString("first_name"), rs.getString("last_name"), rs
						.getString("email"), rs.getString("phone_num"), rs
						.getDate("date_created"));

			}

		} catch (Exception e) {

		}

		return user;
		
	}
	
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		try {
			Statement st = mConnection.createStatement();
			String query = "SELECT * FROM users";
			st.execute(query);

			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				userList.add(new User(rs.getLong("uid"), rs
						.getString("username"), rs.getString("password"), rs
						.getString("first_name"), rs.getString("last_name"), rs
						.getString("email"), rs.getString("phone_num"), rs
						.getDate("date_created")));
			}

		} catch (Exception e) {

		}

		return userList;

	}
	
	public boolean deleteUser(String username) {
		try {
			if (!doesAccountExist(username))
				return false;
			
			Statement st = mConnection.createStatement();
			String query = "DELETE FROM users WHERE username = '" + username + "'";
			st.execute(query);

			ResultSet rs = st.getResultSet();

			if (rs.next()) {
				user = new User(rs.getLong("uid"), rs
						.getString("username"), rs.getString("password"), rs
						.getString("first_name"), rs.getString("last_name"), rs
						.getString("email"), rs.getString("phone_num"), rs
						.getDate("date_created"));

			}

		} catch (Exception e) {

		}

		return user;
		
	}
	
	public boolean editUser(User newuser) {
	
	
	}
	
	public boolean doesAccountExist(String username) {
		User user = getUser(username);
		if (user) return true;
		else return false;
	}
	
	public boolean isPasswordCorrect(String password) {
		
	}
}
