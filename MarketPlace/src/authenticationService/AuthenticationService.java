package authenticationService;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public class AuthenticationService {

	UserMySQLDAO userDAO;
	
	
	public AuthenticationService(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();
		userDAO = (UserMySQLDAO) dao;
	}
	
	public boolean authenticate(String username, String password){
		User user = userDAO.getUser(username);
		if(password.equals(user.getPassword())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean logout(User u){
		return false;
	}
}
