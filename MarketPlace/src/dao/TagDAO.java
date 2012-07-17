package dao;

import java.sql.SQLException;
import java.util.List;
import model.Tag;

public interface TagDAO {
	public long getTagId(String tagName) throws SQLException;
	public boolean tagExists(String tagName) throws SQLException;
	public boolean deleteTag(String tagName) throws SQLException;
	public boolean createTag(String tagName) throws SQLException;
	public List<Tag> getTags() throws SQLException;
	public List<Tag> getTags(long userid) throws SQLException;
	public boolean addTagsToWishlist(long userid, List<String> tagNames) throws SQLException;
	public boolean removeTagsFromWishlist(long userid, List<String> tagNames) throws SQLException;
}
