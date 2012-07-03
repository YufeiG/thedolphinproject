package model;

import java.util.Date;

public class Item {
	private long itemid;
	private String name;
	private int category;
	private long userid;
	private String description;
	private boolean sold;
	private Date availStart;
	private Date availEnd;
	private double priceLow;
	private double priceHigh;
	private int popularity;
	private Date timePosted;
	private Date lastModified;
	
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public Date getAvailStart() {
		return availStart;
	}
	public void setAvailStart(Date availStart) {
		this.availStart = availStart;
	}
	public Date getAvailEnd() {
		return availEnd;
	}
	public void setAvailEnd(Date availEnd) {
		this.availEnd = availEnd;
	}
	public double getPriceLow() {
		return priceLow;
	}
	public void setPriceLow(double priceLow) {
		this.priceLow = priceLow;
	}
	public double getPriceHigh() {
		return priceHigh;
	}
	public void setPriceHigh(double priceHigh) {
		this.priceHigh = priceHigh;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public Date getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
