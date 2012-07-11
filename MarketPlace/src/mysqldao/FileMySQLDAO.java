package mysqldao;

import java.util.List;

import model.File;

import dao.AbstractDAO;
import dao.FileDAO;

public class FileMySQLDAO extends AbstractDAO implements FileDAO{
		
		public FileMySQLDAO(){
			mConnection = createConnection();
		}

		@Override
		public File getFile(String username) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<File> getFiles(long itemid) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean createFile(long itemid, File f, boolean fileType) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean deleteFile(File f) {
			// TODO Auto-generated method stub
			return false;
		}
}
