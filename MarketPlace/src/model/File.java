package model;

import java.sql.Blob;

public class File {
	private long fileid;
	private Blob file;
	private int useType;

	public File(long fileid, Blob file, int useType) {
		this.fileid = fileid;
		this.file = file;
		this.useType = useType;
	}
	
	public long getFileid() {
		return fileid;
	}
	public void setFileid(long fileid) {
		this.fileid = fileid;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public int getUseType() {
		return useType;
	}
	public void setUseType(int useType) {
		this.useType = useType;
	}
} 
