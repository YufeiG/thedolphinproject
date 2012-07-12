package userManagementService;

import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;

public class UserAccountServiceImpl implements UserAccountService {

	UserMySQLDAO userDAO;
	
	public UserAccountServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();
		userDAO = (UserMySQLDAO) dao;
	}
	
	public boolean createAccount(User user){
		return userDAO.createAccount(user);
	}
	
	public boolean editAccount(User user){
		return userDAO.editUser(user);
	}
	
	public boolean deleteAccount(String username){
		return userDAO.deleteUser(username);
	}
	
	//ban user
	public boolean banAccount(User user){
		return false;
	}
	
}
