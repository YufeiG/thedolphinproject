package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
	public boolean createAccount(User user) throws SQLException;
	public User getUser(long username) throws SQLException;
	public List<User> getUserList() throws SQLException;
	public boolean deleteUser(long username) throws SQLException;
	public boolean editUser(User user) throws SQLException;
}
