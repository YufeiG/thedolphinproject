package mysqldao;

import dao.AbstractDAOFactory;
import dao.FileDAO;
import dao.ItemDAO;
import dao.TagDAO;
import dao.UserDAO;

public class MySQLDAOFactory implements AbstractDAOFactory{
	
	public FileDAO getFileDAO(){
		return new FileMySQLDAO();
	}
	
	public ItemDAO getItemDAO(){
		return new ItemMySQLDAO();
	}
	
	public UserDAO getUserDAO(){
		return new UserMySQLDAO();
	}
	
	public TagDAO getTagDAO(){
		return new TagMySQLDAO();
	}
		
}
