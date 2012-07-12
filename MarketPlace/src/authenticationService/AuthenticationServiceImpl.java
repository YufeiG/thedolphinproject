package authenticationService;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;

public class AuthenticationServiceImpl implements AuthenticationService {

	UserMySQLDAO userDAO;
	
	
	public AuthenticationServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();
		userDAO = (UserMySQLDAO) dao;
	}
	
	public long authenticate(String username, String password){
		User user = userDAO.getUser(username);
		if(password.equals(user.getPassword())){
			return user.getUserid();
		}
		else{
			return -1;
		}
	}
	
	public boolean logout(User u){
		return false;
	}
}
