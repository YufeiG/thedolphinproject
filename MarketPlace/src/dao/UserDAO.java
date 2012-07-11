package dao;

import model.User;
import java.util.List;

public interface UserDAO {
	public boolean createAccount(User user);
	public User getUser(String username);
	public List<User> getUserList();
	public boolean deleteUser(String username);
	public boolean editUser(User user);
	public boolean doesAccountExist(String username);
	public boolean isPasswordCorrect(String password);
}
