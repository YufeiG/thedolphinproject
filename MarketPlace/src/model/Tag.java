package model;

public class Tag {
	long tagid;
	String name;
	

	public Tag(long tagid, String name) {
		this.tagid = tagid;
		this.name = name;
	}

	public long getTagid() {
		return tagid;
	}

	public void setId(long tagid) {
		this.tagid = tagid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
