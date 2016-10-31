package edu.zjut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.dao.UserDao;
import edu.zjut.model.User;
import edu.zjut.utils.DBHelp;
import edu.zjut.utils.Helper;

public class UserDaoImpl implements UserDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public UserDaoImpl() {
		connection = dbHelp.getConn();
	}
	
	/**
	 * 添加新用户
	 * @return 
	 * @throws SQLException 
	 */
	@Override
	public boolean createUser(User user) throws SQLException {
		String sql = "insert into `t_user` (`email`, `nickname`, `password`, `register_date`, `status`, `token`) values (?, ?, ?, ?, ?, ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getEmail());
		pstmt.setString(2, user.getNickname());
		pstmt.setString(3, user.getPassword());
		pstmt.setLong(4, Long.parseLong(new Helper().dateToTimeStamp(user.getRegisterDate(), Helper.TIME_SPECIFIC_HEIGH)));
		pstmt.setInt(5, 0);
		pstmt.setString(6, "");
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
	@Override
	public boolean updateUser(User user) throws SQLException {
		String sql = "UPDATE `t_user` SET `nickname`= ? , `status`= ? , `token` = ? WHERE (`uid` = ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, "");
		pstmt.setInt(2, 0);
		pstmt.setString(3, "");
		pstmt.setInt(4, user.getUid());
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
	@Override
	public boolean deleteUser(int uid) throws SQLException {
		String sql = "DELETE FROM t_user WHERE uid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, uid);
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取指定ID的用户对象
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	@Override
	public User getUserByUid(int uid) throws SQLException {
		User user = new User();
		String sql = "select * from t_user where uid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setUid(rs.getInt("uid"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setRegisterDate(new Helper().timeStampToDate(rs.getLong("register_date"), Helper.TIME_SPECIFIC_HEIGH));
			user.setRegisterType(rs.getString("register_type"));
		}
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return user;
	}
	
	/**
	 * 根据Email获取用户对象
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	@Override
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
		return uid;
	}
	
	/**
	 * 获取注册的全部用户
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		String sql = "select * from t_user";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setUid(rs.getInt("uid"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setRegisterDate(new Helper().timeStampToDate(rs.getLong("register_date"), Helper.TIME_SPECIFIC_HEIGH));
			user.setRegisterType(rs.getString("register_type"));
			users.add(user);
		}
		return users;
	}
	
	/**
	 * 批量删除多个指定的用户
	 * @param uids
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean deleteAllUsers(ArrayList<Integer> uids) throws SQLException {
		boolean isAllFinish = false;
		String sql = "delete from `t_user` where uid = ?";
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
		return isAllFinish;
	}
}