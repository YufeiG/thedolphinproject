package dao;

import java.sql.SQLException;
import java.util.List;
import model.Tag;

public interface TagDAO {
	public boolean tagExists(String tagName) throws SQLException;
	public boolean deleteTag(String tagName) throws SQLException;
	public boolean createTag(String tagName) throws SQLException;
	public List<Tag> getTags() throws SQLException ;
}
