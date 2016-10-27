package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Book;
import edu.zjut.model.OrderItem;
import edu.zjut.utils.DBHelp;

public class OrderItemDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public OrderItemDao() {
		connection = dbHelp.getConn();
	}
	
	/**
	 * 添加新订单
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public boolean createOrderItem(OrderItem orderItem) throws SQLException {
		String sql = "INSERT INTO `t_order_item` (order_seq, bid, amount) VALUES ( ?, ?, ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, orderItem.getOrderSeq());
		pstmt.setInt(2, orderItem.getBid());
		pstmt.setLong(3, orderItem.getAmount());
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 删除指定ID的订单
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteOrder(int itemId) throws SQLException {
		String sql = "DELETE FROM `t_order_item` WHERE item_id = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, itemId);
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取全部订单
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OrderItem> getOrderItems() throws SQLException {
		String sql = "SELECT * FROM `t_order_item`;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		while (rs.next()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemId(rs.getInt("item_id"));
			orderItem.setOrderSeq(rs.getString("order_seq"));
			orderItem.setBid(rs.getInt("bid"));
			orderItem.setAmount(rs.getInt("amount"));
			orderItems.add(orderItem);
		}
		return orderItems;
	}
	
	/**
	 * 根据orderId获取指定orderItem订单详情
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	public OrderItem getOrderItemByOrderId(int orderId) throws SQLException {
		String sql = "SELECT * FROM `t_order_item` WHERE order_id = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderId);
		rs = pstmt.executeQuery();
		OrderItem orderItem = new OrderItem();
		while (rs.next()) {
			orderItem.setItemId(rs.getInt("item_id"));
			orderItem.setOrderSeq(rs.getString("order_seq"));
			orderItem.setBid(rs.getInt("bid"));
			orderItem.setAmount(rs.getInt("amount"));
		}
		return orderItem;
	}
	
	/**
	 * 根据orderSeq获取指定orderItem订单详情
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OrderItem> getOrderItemsByOrderSeq(String orderSeq) throws SQLException {
		String sql = "SELECT * FROM `t_order_item` WHERE order_seq = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, orderSeq);
		rs = pstmt.executeQuery();
		ArrayList<OrderItem> orderItems = new ArrayList<>();
		BookDao bookDao = new BookDao();
		while (rs.next()) {
			Book book = new Book();
			OrderItem orderItem = new OrderItem();
			orderItem.setItemId(rs.getInt("item_id"));
			orderItem.setOrderSeq(rs.getString("order_seq"));
			orderItem.setBid(rs.getInt("bid"));
			orderItem.setAmount(rs.getInt("amount"));
			book = bookDao.getBookByBid(rs.getInt("bid"));
			orderItem.setBook(book);
			orderItems.add(orderItem);
		}
		return orderItems;
	}
}