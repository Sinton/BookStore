package edu.zjut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.zjut.dao.AdminDao;
import edu.zjut.model.Admin;
import edu.zjut.utils.DBHelp;

public class AdminDaoImpl implements AdminDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public AdminDaoImpl() {
		connection = dbHelp.getConn();
	}
	
	/**
	 * 通过Email和密码获取管理对象
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Admin getAdmin(String email, String password) throws SQLException {
		connection = dbHelp.getConn();
		String sql = "SELECT * FROM t_admin WHERE name = ? AND adminpwd = ?";
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