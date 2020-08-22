package model;

import java.time.LocalDate;

public class Blog{
	int blogId;
	String blogTitle;
	String blogDescription;
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public void setPostedOn(LocalDate postedOn) {
		// TODO Auto-generated method stub
		
	}
	public char[] getPostedOn() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}