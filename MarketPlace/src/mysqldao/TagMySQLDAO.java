package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	
	public long getTagId(String tagName) throws SQLException {
		ResultSet rs = execSql("SELECT tagid FROM tags WHERE tag_name='"
				+ tagName + "'");
		
		if (rs.next()) {
			return rs.getLong("tagid");
		}
		return 0;
	}


	public boolean tagExists(String tagName) throws SQLException {
		ResultSet rs = execSql("SELECT * FROM tags WHERE tag_name='" + tagName
				+ "'");
		if (rs.next())
			return true;
		else
			return false;
	}

	public boolean deleteTag(String tagName) throws SQLException {
		execSql("DELETE FROM tags WHERE tag_name = '" + tagName + "'");
		return true;
	}

	public boolean createTag(String tagName) throws SQLException {
		if (!tagExists(tagName))
			execSql("INSERT INTO tags(tag_name) VALUES ('" + tagName + "')");
		return true;
	}

	public boolean addTagsToWishlist(long userid, List<String> tagNames)
			throws SQLException {
		for (int i = 0; i < tagNames.size(); i++) {
			String thisTag = tagNames.get(i);
			Date d = new Date(System.currentTimeMillis());
			createTag(thisTag);

			long thisTagid = getTagId(thisTag);

			if (thisTagid != 0) {
				execSql("INSERT INTO wishlist VALUES (" + userid + "," +
						thisTagid + "," + toSqlDate(d) + ")");
				return true;
			}
		}
		return false;
	}
	
	public boolean removeTagsFromWishlist(long userid, List<String> tagNames)
			throws SQLException {
		
		for (int i = 0; i < tagNames.size(); i++) {
			String thisTag = tagNames.get(i);
			long thisTagid = getTagId(thisTag);

			if (thisTagid != 0) {
				execSql("DELETE FROM wishlist " +
						"WHERE userid=" + userid + " AND tagid=" + thisTagid);
				return true;
			}
		}
		return false;
	}

	public List<Tag> getTags(long userid) throws SQLException {
		ResultSet rs = execSql("SELECT * " + "FROM Tags t, wishlist w "
				+ "WHERE t.tagid = w.tagid AND w.userid = " + userid);
		List<Tag> ret = new ArrayList<Tag>();
		if (rs.next())
			ret.add(createTagObj(rs));
		return ret;
	}

	public List<Tag> getTags() throws SQLException {
		ResultSet rs = execSql("SELECT * FROM Tags");
		List<Tag> ret = new ArrayList<Tag>();
		if (rs.next())
			ret.add(createTagObj(rs));
		return ret;
	}

}