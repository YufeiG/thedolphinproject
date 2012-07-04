package authenticationService;

import model.User;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.MySQLDAOFactory;
import dao.UserDAO;

public class AuthenticationService {

	public boolean authenticate(String username, String password){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getDAO("USER");

		UserDAO userdao = (UserDAO) dao;
		User user = userdao.getUser(username);
		if(password.equals(user.getPassword())){
			return true;
		}
		else{
			return false;
		}
	
	}
}
