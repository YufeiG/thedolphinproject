package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
		ResultSet rs = execSql(String.format(
				"SELECT tagid FROM tags WHERE tag_name='%s'", tagName));
		
		if (rs.next()) {
			return rs.getLong("tagid");
		}
		return 0;
	}


	private long tagExists(String tagName) throws SQLException {
		ResultSet rs = execSql(String.format(
				"SELECT * FROM tags WHERE tag_name='%s'", tagName));
		if (rs.next())
			return rs.getLong("tagid");
		else
			return 0;
	}

	public boolean deleteTag(String tagName) throws SQLException {
		execSql(String.format("DELETE FROM tags WHERE tag_name = '%s'", tagName));
		return true;
	}

	public long createTag(String tagName) throws SQLException {
		long id = tagExists(tagName);
		if (id == 0) {
			execSql(String.format("INSERT INTO tags(tag_name) VALUES ('%s')", tagName));
			ResultSet rs = execSql("SELECT LAST_INSERT_ID();");
			if (rs.next()) id = rs.getLong("LAST_INSERT_ID()");
		}
		return id;
	}

	public boolean addTagsToWishlist(long userid, List<String> tagNames)
			throws SQLException {

		HashMap<Long,Boolean> addedTagids = new HashMap<Long,Boolean>();
		HashMap<Long,Boolean> existingTags = new HashMap<Long,Boolean>();
		
		List<Tag> usersTags = getTags(userid);
		for (int k=0; k<usersTags.size(); k++) {
			existingTags.put(usersTags.get(k).getTagid(), true);
		}

		for (int i = 0; i < tagNames.size(); i++) {
			String thisTag = tagNames.get(i);
			Date d = new Date(System.currentTimeMillis());
			long thisTagid = createTag(thisTag);

			if (!addedTagids.containsKey(thisTagid) && !existingTags.containsKey(thisTagid)) {
				execSql(String.format("INSERT INTO wishlist VALUES (%d,%d,'%s')",
						userid, thisTagid, toSqlDate(d)));
				addedTagids.put(thisTagid, true);
			}
		}
		return true;
	}
	
	public boolean removeTagsFromWishlist(long userid, List<String> tagNames)
			throws SQLException {
		
		for (int i = 0; i < tagNames.size(); i++) {
			String thisTag = tagNames.get(i);
			long thisTagid = getTagId(thisTag);

			if (thisTagid != 0) {
				execSql(String.format("DELETE FROM wishlist WHERE userid=%d AND tagid=%d", 
						userid, thisTagid));

			}
		}
		return true;
	}

	public List<Tag> getTags(long userid) throws SQLException {
		ResultSet rs = execSql("SELECT * " + "FROM Tags t, wishlist w "
				+ "WHERE t.tagid = w.tagid AND w.userid = " + userid);
		List<Tag> ret = new ArrayList<Tag>();
		while (rs.next())
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