package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.File;
import model.Tag;

import dao.AbstractDAO;
import dao.FileDAO;
import dao.TagDAO;

public class TagMySQLDAO extends AbstractDAO implements TagDAO{
		
		public TagMySQLDAO(){
			mConnection = createConnection();
		}

		@Override
		public String getTag(String tagName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean deleteTag(String tagName) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean createTag(String tagName) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<Tag> getTags() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
