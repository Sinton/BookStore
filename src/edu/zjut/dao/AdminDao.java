package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.zjut.model.Admin;
import edu.zjut.utils.DBHelp;

public class AdminDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public AdminDao() {
		connection = dbHelp.getConn();
	}
	
	/**
	 * 通过Email和密码获取管理对象
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Admin getAdmin(String email, String password) throws SQLException {
		connection = dbHelp.getConn();
		String sql = "select * from t_admin where name = ? and adminpwd = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		Admin admin = new Admin();
		if (rs.next()) {
			admin.setAdminId(rs.getInt("adminId"));
			admin.setName(rs.getString("name"));
			admin.setPassword(rs.getString("password"));
		}
		dbHelp.closeConn();
		return admin;
	}
}