package edu.zjut.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.OrderItem;

public interface OrderItemDao {
	boolean createOrderItem(OrderItem orderItem) throws SQLException;
	boolean deleteOrder(int itemId) throws SQLException;
	ArrayList<OrderItem> getOrderItems() throws SQLException;
	OrderItem getOrderItemByOrderId(int orderId) throws SQLException;
	ArrayList<OrderItem> getOrderItemsByOrderSeq(String orderSeq) throws SQLException;
}