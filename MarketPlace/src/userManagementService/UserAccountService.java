package userManagementService;

import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;

public class UserAccountService {

	UserMySQLDAO userDAO;
	
	public UserAccountService(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();
		userDAO = (UserMySQLDAO) dao;
	}
	
	public boolean createAccount(User u){
		return false;
	}
	
	public boolean editAccount(User u){
		return false;
	}
	
	public boolean deleteAccount(User u){
		return false;
	}
	
	public boolean banAccount(User u){
		return false;
	}
	
}
