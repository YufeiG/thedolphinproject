package authenticationService;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public interface AuthenticationService {
	
	public long authenticate(String username, String password);
	
	public boolean logout(User u);
}
