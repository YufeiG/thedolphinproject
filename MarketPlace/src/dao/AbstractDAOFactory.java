package dao;

import mysqldao.FileMySQLDAO;
import mysqldao.ItemMySQLDAO;
import mysqldao.UserMySQLDAO;

public interface AbstractDAOFactory {
	//abstract AbstractDAO getDAO(String daoType);
	
	abstract FileMySQLDAO getFileDAO();
	abstract ItemMySQLDAO getItemDAO();
	abstract UserMySQLDAO getUserDAO();
}
