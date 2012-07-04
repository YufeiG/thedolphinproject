package dao;

public class MySQLDAOFactory implements AbstractDAOFactory{
	
	public FileDAO getFileDAO(){
		return new FileDAO();
	}
	
	public ItemDAO getItemDAO(){
		return new ItemDAO();
	}
	
	public UserDAO getUserDAO(){
		return new UserDAO();
	}
		
}
