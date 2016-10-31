package edu.zjut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.dao.OrderDao;
import edu.zjut.model.Order;
import edu.zjut.utils.DBHelp;
import edu.zjut.utils.Helper;

public class OrderDaoImpl implements OrderDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public OrderDaoImpl() {
		connection = dbHelp.getConn();
	}
	
	/**
	 * 添加新订单
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean createOrder(Order order) throws SQLException {
		String sql = "INSERT INTO `t_order` (uid, order_seq, time, total, status) VALUES ( ?, ?, ?, ?, ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, order.getUid());
		pstmt.setString(2, order.getOrderSeq());
		pstmt.setLong(3, order.getTimeStamp());
		pstmt.setDouble(4, order.getTotalPrice());
		pstmt.setDouble(5, order.getStatus());
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 删除指定ID的订单
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean deleteOrder(int orderId) throws SQLException {
		String sql = "DELETE FROM t_order WHERE order_id = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderId);
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取全部订单
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Order> getOrders() throws SQLException {
		String sql = "SELECT * FROM t_order;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Order> orders = new ArrayList<Order>();
		while (rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt("order_id"));
			order.setUid(rs.getInt("uid"));
			order.setOrderSeq(rs.getString("order_seq"));
			order.setTimeStamp(rs.getLong("time"));
			order.setDate(new Helper().timeStampToDate(rs.getLong("time"), Helper.TIME_SPECIFIC_HEIGH));
			order.setTotalPrice(rs.getDouble("total"));
			order.setStatus(rs.getInt("status"));
			orders.add(order);
		}
		return orders;
	}
	
	/**
	 * 根据oderId获取指定orderId订单
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Order getOrdersByOrderId(int orderId) throws SQLException {
		String sql = "SELECT * FROM t_order WHERE order_id = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderId);
		rs = pstmt.executeQuery();
		Order order = new Order();
		while (rs.next()) {
			order.setOrderId(rs.getInt("order_id"));
			order.setOrderSeq(rs.getString("order_seq"));
			order.setUid(rs.getInt("uid"));
			order.setTimeStamp(rs.getLong("time"));
			order.setTotalPrice(rs.getDouble("total"));
			order.setStatus(rs.getInt("status"));
		}
		return order;
	}

	/**
	 * 获取该用户的全部订单
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Order> getOrdersByUid(int uid) throws SQLException {
		String sql = "SELECT * FROM t_order WHERE uid = ? ORDER BY time DESC;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		ArrayList<Order> orders = new ArrayList<>();
		OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
		while (rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt("order_id"));
			order.setOrderSeq(rs.getString("order_seq"));
			order.setUid(rs.getInt("uid"));
			order.setTimeStamp(rs.getLong("time"));
			order.setTotalPrice(rs.getDouble("total"));
			order.setStatus(rs.getInt("status"));
			order.setOrderItems(orderItemDao.getOrderItemsByOrderSeq(rs.getString("order_seq")));
			orders.add(order);
		}
		return orders;
	}
	
	/**
	 * 修改订单购物状态
	 * @param status
	 * @param orderSeq
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean changeStatus(int status, String orderSeq) throws SQLException {
		String sql = "UPDATE `t_order` SET status = ? WHERE order_seq = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, status);
		pstmt.setString(2, orderSeq);
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取当前订单的购物状态
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int getStatus(String orderSeq) throws SQLException {
		String sql = "SELECT status FROM t_order WHERE order_seq = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, orderSeq);
		rs = pstmt.executeQuery();
		int status = 1;
		while (rs.next()) {
			status = rs.getInt("status");
		}
		return status;
	}
}