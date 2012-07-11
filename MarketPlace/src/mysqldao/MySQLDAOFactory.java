package mysqldao;

import dao.AbstractDAOFactory;

public class MySQLDAOFactory implements AbstractDAOFactory{
	
	public FileMySQLDAO getFileDAO(){
		return new FileMySQLDAO();
	}
	
	public ItemMySQLDAO getItemDAO(){
		return new ItemMySQLDAO();
	}
	
	public UserMySQLDAO getUserDAO(){
		return new UserMySQLDAO();
	}
	
	public TagMySQLDAO getTagDAO(){
		return new TagMySQLDAO();
	}
		
}
