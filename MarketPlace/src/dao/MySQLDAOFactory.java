package dao;

public class MySQLDAOFactory implements AbstractDAOFactory{
	
	public AbstractDAO getDAO(String daoType){
		if(daoType.equals("USER")){
			return new UserDAO();
		}
		else if (daoType.equals("FILE")){
			return new FileDAO();
		}
		else if(daoType.equals("ITEM")){
			return new ItemDAO();
		}
		
		
		return null;
	}	
}
