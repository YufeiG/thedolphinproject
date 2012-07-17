package authenticationService;

import java.sql.SQLException;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.UserDAO;

public class AuthenticationServiceImpl implements AuthenticationService {

	UserDAO userDAO;

	public AuthenticationServiceImpl() {
		AbstractDAOFactory factory = new MySQLDAOFactory();
		userDAO = factory.getUserDAO();

	}

	public long authenticate(String username, String password)
			throws SQLException {
		User user;

		user = userDAO.getUser(username);
		if (user != null && password.equals(user.getPassword())) {
			return user.getUserid();
		} else {
			return -1;
		}

	}

	public boolean logout(User u) {
		return false;
	}
}
