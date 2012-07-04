package dao;

public interface AbstractDAOFactory {
	//abstract AbstractDAO getDAO(String daoType);
	
	abstract FileDAO getFileDAO();
	abstract ItemDAO getItemDAO();
	abstract UserDAO getUserDAO();
}
