package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.User;
import edu.zjut.utils.DBHelp;

public class UserDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection;
	private DBHelp dbHelp = new DBHelp();
	
	public UserDao() {
		connection = dbHelp.getConn();
	}
	
	/**
	 * 添加新用户
	 * @return 
	 * @throws SQLException 
	 */
	public boolean addUser(User user) throws SQLException {
		String sql = "insert into `t_user` (`email`, `nickname`, `password`, `register_date`, `status`, `token`) values (?, ?, ?, ?, ?, ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getEmail());
		pstmt.setString(2, "");
		pstmt.setString(3, user.getPassword());
		pstmt.setLong(4, user.getRegisterDate());
		pstmt.setInt(5, 0);
		pstmt.setString(6, "");
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 删除指定用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean removeUser(int uid) throws SQLException {
		String sql = "delete from where uid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, uid);
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 修改指定用户信息
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean modifyUser(User user) throws SQLException {
		String sql = "update where uid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, user.getUid());
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取指定ID的用户对象
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public User getUser(int uid) throws SQLException {
		User user = new User();
		String sql = "select * from t_user where uid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setUid(rs.getInt("uid"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setRegisterDate(rs.getLong("register_date"));
		}
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return user;
	}
	
	/**
	 * 获取指定Email的用户对象
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public int getUid(String email) throws SQLException {
		String sql = "select uid from t_user where email = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		rs = pstmt.executeQuery();
		int uid = 0;
		while (rs.next())
			uid = rs.getInt("uid");
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return uid;
	}
	
	/**
	 * 获取注册的全部用户
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getAllUsers() throws SQLException {
		String sql = "select * from t_user";
		rs = pstmt.executeQuery(sql);
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return rs;
	}
	
	/**
	 * 批量删除多个指定的用户
	 * @param uids
	 * @return
	 * @throws SQLException
	 */
	public boolean removeUsers(ArrayList<Integer> uids) throws SQLException {
		boolean isAllFinish = false;
		String sql = "update where uid = ?";
		for (int i = 0; i < uids.size(); i++) {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, uids.get(i));
			if(pstmt.executeUpdate() > 0)
				isAllFinish = true;
			else
				return false;
		}
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return isAllFinish;
	}
}