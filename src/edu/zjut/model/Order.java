package edu.zjut.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final int NO_PAYMENT = 1;   // 未付款
	public static final int HAS_PAYMENT = 2;  // 已付款
	public static final int Delivered = 3;    // 已发货
	public static final int FINISH_TRADE = 4; // 交易成功
	public static final int CANCEL_TRADE = 5; // 已取消
	
	private int orderId;
	private String orderSeq;
	private int uid;
	private long timeStamp;
	private String date;
	private double totalPrice;
	private int status;
	private String address;
	private ArrayList<OrderItem> orderItems;
	
	public Order() {}

	public Order(String orderSeq, int uid, long timeStamp, double totalPrice, int status, String address, ArrayList<OrderItem> orderItems) {
		setOrderSeq(orderSeq);
		setUid(uid);
		setTimeStamp(timeStamp);
		setTotalPrice(totalPrice);
		setStatus(status);
		setAddress(address);
		setOrderItems(orderItems);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}