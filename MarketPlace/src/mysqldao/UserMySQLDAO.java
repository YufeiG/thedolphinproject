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

	public boolean createAccount(User user) {
		return false;
	}
	
	public User getUser(String username) {

		User user = null;
		try {
			ResultSet rs = execSql("SELECT * FROM users WHERE username = '" + username + "'");

			if (rs.next()) {
				user = new User(rs.getLong("uid"), rs
						.getString("username"), rs.getString("password"), rs
						.getString("first_name"), rs.getString("last_name"), rs
						.getString("email"), rs.getString("phone_num"), rs
						.getDate("date_created"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
		
	}
	
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		try {
			ResultSet rs = execSql("SELECT * FROM users");

			while (rs.next()) {
				userList.add(new User(rs.getLong("uid"), rs
						.getString("username"), rs.getString("password"), rs
						.getString("first_name"), rs.getString("last_name"), rs
						.getString("email"), rs.getString("phone_num"), rs
						.getDate("date_created")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;

	}
	
	public boolean deleteUser(String username) {
		try 
		{
			if (!doesAccountExist(username))
				return false;
			
			execSql("DELETE FROM users WHERE username = '" + username + "'");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editUser(User user) {
		try
		{
			execSql("UPDATE users" +
					"SET password=" + user.getPassword() +
					", firstname=" + user.getFirstName() +
					", lastname=" + user.getLastName() +
					", email" + user.getEmail() +
					", phone_num=" + user.getPhoneNumber() +
					"WHERE username=" + user.getUsername());
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean doesAccountExist(String username) {
		User user = getUser(username);
		if (user != null) return true;
		else return false;
	}
	
	public boolean isPasswordCorrect(String username, String password) {
		try {
			ResultSet rs = execSql("SELECT password FROM users WHERE username = '" + username + "'");

			if (rs.next() && password == rs.getString("password"))
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
