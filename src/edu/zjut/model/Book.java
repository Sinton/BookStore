package edu.zjut.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bid;
	private String name;
	private String author;
	private double price;
	private double discount;
	private String publishing;
	private String publishTime;
	private int edition;
	private int pageNum;
	private String isnb;
	private int categoryId;
	private int secondCategoryId;
	private String imgUrlBig;
	private String imgUrlMid;
	private String imgUrlSmall;

	public Book() {
	}
	
	public Book(int bid, String name, String author, double price,
			double discount, String publishing, String publishTime,
			int edition, int pageNum, String isnb, int categoryId,
			int secondCategoryId, String imgUrlBig, String imgUrlMid, String imgUrlSmall) {
		setBid(bid);
		setName(name);
		setAuthor(author);
		setPrice(price);
		setDiscount(discount);
		setPublishing(publishing);
		setPublishTime(publishTime);
		setEdition(edition);
		setPageNum(pageNum);
		setIsnb(isnb);
		setCategoryId(categoryId);
		setSecondCategoryId(secondCategoryId);
		setImgUrlBig(imgUrlBig);
		setImgUrlMid(imgUrlMid);
		setImgUrlSmall(imgUrlSmall);
	}
	
	public Book(String name, String author, double price,
			double discount, String publishing, String publishTime,
			int edition, int pageNum, String isnb, int categoryId,
			int secondCategoryId, String imgUrlBig, String imgUrlMid, String imgUrlSmall) {
		setName(name);
		setAuthor(author);
		setPrice(price);
		setDiscount(discount);
		setPublishing(publishing);
		setPublishTime(publishTime);
		setEdition(edition);
		setPageNum(pageNum);
		setIsnb(isnb);
		setCategoryId(categoryId);
		setSecondCategoryId(secondCategoryId);
		setImgUrlBig(imgUrlBig);
		setImgUrlMid(imgUrlMid);
		setImgUrlSmall(imgUrlSmall);
	}
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getIsnb() {
		return isnb;
	}

	public void setIsnb(String isnb) {
		this.isnb = isnb;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getSecondCategoryId() {
		return secondCategoryId;
	}
	
	public void setSecondCategoryId(int secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	public String getImgUrlBig() {
		return imgUrlBig;
	}

	public void setImgUrlBig(String imgUrlBig) {
		this.imgUrlBig = imgUrlBig;
	}
	
	public String getImgUrlMid() {
		return imgUrlMid;
	}

	public void setImgUrlMid(String imgUrlMid) {
		this.imgUrlMid = imgUrlMid;
	}

	public String getImgUrlSmall() {
		return imgUrlSmall;
	}

	public void setImgUrlSmall(String imgUrlSmall) {
		this.imgUrlSmall = imgUrlSmall;
	}
}