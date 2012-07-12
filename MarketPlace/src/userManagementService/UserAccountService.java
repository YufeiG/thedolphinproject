package userManagementService;

import dao.AbstractDAO;
import dao.AbstractDAOFactory;
import model.User;
import mysqldao.MySQLDAOFactory;
import mysqldao.UserMySQLDAO;

public interface UserAccountService {
	
	public boolean createAccount(User user);
	
	public boolean editAccount(User user);
	
	public boolean deleteAccount(String username);
	
	//ban user
	public boolean banAccount(User user);
	
}
