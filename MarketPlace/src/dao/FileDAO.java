package dao;

import java.util.List;
import model.File;

public interface FileDAO {
	/**
	 * Get profile picture of a user.
	 * @param Username
	 * @return User profile picture
	 */
	public File getFile(String username);
	
	/**
	 * Get attachments of an item.
	 * @param itemid
	 * @return List of files
	 */
	public List<File> getFiles(long itemid);
	public boolean createFile(long itemid, File f, boolean fileType);
	public boolean deleteFile(File f);
}
