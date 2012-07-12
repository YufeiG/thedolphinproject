package authenticationService;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.UserDAO;

public class AuthenticationServiceImpl implements AuthenticationService {

	UserDAO userDAO;
	
	
	public AuthenticationServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();
		userDAO = (UserMySQLDAO) dao;
	}
	
	public long authenticate(String username, String password) throws SQLException{
		
		try {
			User user;
			
			user = userDAO.getUser(username);
			System.err.println("password "+password);
			if(password.equals(user.getPassword())){
				return user.getUserid();
			}
			else{
				return -1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
			
		}

	}
	
	public boolean logout(User u){
		return false;
	}
}
