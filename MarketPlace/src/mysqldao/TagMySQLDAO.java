package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tag;

import dao.AbstractDAO;
import dao.TagDAO;

public class TagMySQLDAO extends AbstractDAO implements TagDAO {

	public TagMySQLDAO() {
		mConnection = createConnection();
	}

	private Tag createTagObj(ResultSet rs) throws SQLException {
		Tag tag = new Tag(rs.getLong("tagid"), rs.getString("tag_name"));
		return tag;
	}

	public boolean tagExists(String tagName) throws SQLException {
		ResultSet rs = execSql("SELECT * FROM tags WHERE tag_name='" + tagName + "'");
		if (rs.next()) return true;
		else return false;
	}

	@Override
	public boolean deleteTag(String tagName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createTag(String tagName) throws SQLException {
		if (!tagExists(tagName))
			execSql("INSERT INTO tags(tag_name) VALUES ('" + tagName + "')");
		return true;
	}

	public List<Tag> getTags() throws SQLException {
		ResultSet rs = execSql("SELECT * FROM Tags");
		List<Tag> ret = new ArrayList<Tag>();
		if (rs.next())
			ret.add(createTagObj(rs));
		return ret;
	}

}