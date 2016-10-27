package edu.zjut.model;

import java.io.Serializable;

public class ItemDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Book book;
	private int amount;
	private double totalPrice;
	
	public ItemDetail() {}
	
	public ItemDetail(Book book, int amount, double totalPrice) {
		setBook(book);
		setAmount(amount);
		setTotalPrice(totalPrice);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}