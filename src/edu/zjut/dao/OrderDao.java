package edu.zjut.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Order;

public interface OrderDao {
	boolean createOrder(Order order) throws SQLException;
	boolean deleteOrder(int orderId) throws SQLException;
	ArrayList<Order> getOrders() throws SQLException;
	Order getOrdersByOrderId(int orderId) throws SQLException;
	ArrayList<Order> getOrdersByUid(int uid) throws SQLException;
	boolean changeStatus(int status, String orderSeq) throws SQLException;
	int getStatus(String orderSeq) throws SQLException;
}