package model;

import java.util.Date;

public class Item {
	private long itemid;
	private String title;
	private int category;
	private long userid;
	private String description;
	private int sold;
	private Date availStart;
	private Date availEnd;
	private double priceLow;
	private double priceHigh;
	private int popularity;
	private Date timeAdded;
	private Date timeModified;
	
	public Item(long itemid, String title, int category, long userid,
			String description, int sold, Date availStart, Date availEnd,
			double priceLow, double priceHigh, int popularity, Date timeAdded,
			Date timeModified) {
		this.itemid = itemid;
		this.title = title;
		this.category = category;
		this.userid = userid;
		this.description = description;
		this.sold = sold;
		this.availStart = availStart;
		this.availEnd = availEnd;
		this.priceLow = priceLow;
		this.priceHigh = priceHigh;
		this.popularity = popularity;
		this.timeAdded = timeAdded;
		this.timeModified = timeModified;
	}
	
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	public String getTitle() {
		return title;
	}
	public void setName(String title) {
		this.title = title;
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
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
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
	public Date getTimeAdded() {
		return timeAdded;
	}
	public void setTimeAdded(Date timeAdded) {
		this.timeAdded = timeAdded;
	}
	public Date getTimeModified() {
		return timeModified;
	}
	public void setTimeModified(Date timeModified) {
		this.timeModified = timeModified;
	}
	
}
