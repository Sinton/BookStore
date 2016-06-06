package edu.zjut.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import edu.zjut.model.User;
import edu.zjut.utils.DBHelp;

public class UnitTest {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBHelp dbHelp = new DBHelp();
	private Connection connection = dbHelp.getConn();
	
	/**
	 * 将时间戳转化成具体时间
	 * @param timeStamp
	 * @return
	 */
	@Test
	public void TransDate() {
		long timeStamp = 1465138401;
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String time = timeFormat.format(new Date(timeStamp * 1000));
		System.out.println(time);
	}
	
	/**
	 * 获取指定Email的用户对象
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	@Test
	public void getUid() throws SQLException {
		String email = "2@qq.com";
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
	}
	
	/**
	 * 获取指定ID的用户对象
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	@Test
	public void getUser() throws SQLException {
		User user = new User();
		int uid = 2;
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
	}
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	@Test
	public void getCurrentTime() {
		long currentTime = new Date().getTime();
		System.out.println(currentTime / 1000);
	}
}