package userManagementService;

import java.sql.SQLException;

import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;

public interface UserAccountService {
	
	public boolean createAccount(User user) throws SQLException;
	
	public boolean editAccount(User user) throws SQLException;
	
	public boolean deleteAccount(long userid) throws SQLException;
	
	public User getAccount(long userid) throws SQLException;
	
	//ban user
	public boolean banAccount(User user);
	
}
