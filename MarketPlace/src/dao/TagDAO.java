package dao;

import java.util.List;
import model.Tag;

public interface TagDAO {
	public String getTag(String tagName);
	public boolean deleteTag(String tagName);
	public boolean createTag(String tagName);
	public List<Tag> getTags();
}
