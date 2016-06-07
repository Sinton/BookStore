package edu.zjut.model;

public class Book {

	private int bid;
	private String name;
	private String author;
	private double price;
	private double currPrice;
	private double discount;
	private String publishing;
	private String publishTime;
	private int edition;
	private int pageNum;
	private int wordNum;
	private String printTime;
	private int booksize;
	private String paper;
	private Category category;
	private String imgUrlBig;
	private String imgUrlSmall;

	public Book() {
		
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

	public double getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(double currPrice) {
		this.currPrice = currPrice;
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

	public int getWordNum() {
		return wordNum;
	}

	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}

	public String getPrintTime() {
		return printTime;
	}

	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}

	public int getBooksize() {
		return booksize;
	}

	public void setBooksize(int booksize) {
		this.booksize = booksize;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImgUrlBig() {
		return imgUrlBig;
	}

	public void setImgUrlBig(String imgUrlBig) {
		this.imgUrlBig = imgUrlBig;
	}

	public String getImgUrlSmall() {
		return imgUrlSmall;
	}

	public void setImgUrlSmall(String imgUrlSmall) {
		this.imgUrlSmall = imgUrlSmall;
	}
}