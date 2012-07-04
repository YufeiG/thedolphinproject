package dao;

public interface AbstractDAOFactory {
	abstract AbstractDAO getDAO(String daoType);
	
}
