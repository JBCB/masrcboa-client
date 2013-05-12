package com.jbcb.masrcbmobileoa.datamodel;

public class MailItem {
	private String title;
	private String count;
	
	public MailItem(String title, String count) {
		this.title = title;
		this.count = count;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
}
