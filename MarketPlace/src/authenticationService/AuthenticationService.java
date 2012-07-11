package authenticationService;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public class AuthenticationService {

	public boolean authenticate(String username, String password){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();

		UserMySQLDAO userdao = (UserMySQLDAO) dao;
		User user = userdao.getUser(username);
		if(password.equals(user.getPassword())){
			return true;
		}
		else{
			return false;
		}
	}
}
