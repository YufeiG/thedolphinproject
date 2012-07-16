package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Tag;

import dao.AbstractDAO;
import dao.TagDAO;

public class TagMySQLDAO extends AbstractDAO implements TagDAO{
		
		public TagMySQLDAO(){
			mConnection = createConnection();
		}
		
		private Tag createTagObj(ResultSet rs) throws SQLException {
			Tag tag = null;
			if (rs.next()) {
				tag = new Tag(rs.getLong("tagid"), rs.getString("tag_name"));
			}
			return tag;
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
