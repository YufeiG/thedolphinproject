package userManagementService;

import java.sql.SQLException;

import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;
import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import dao.UserDAO;

public class UserAccountServiceImpl implements UserAccountService {

	UserDAO userDAO;
	
	public UserAccountServiceImpl(){
		AbstractDAOFactory factory = new MySQLDAOFactory();
		AbstractDAO dao = factory.getUserDAO();
		userDAO = (UserMySQLDAO) dao;
	}
	
	public boolean createAccount(User user) throws SQLException{
		return userDAO.createAccount(user);
	}
	
	public boolean editAccount(User user) throws SQLException{
		return userDAO.editUser(user);
	}
	
	public User getAccount(long userid) throws SQLException{
		return userDAO.getUser(userid);
	}
	public boolean deleteAccount(long userid) throws SQLException{
		return userDAO.deleteUser(userid);
	}
	
	//ban user
	public boolean banAccount(User user){
		return false;
	}
	
}
