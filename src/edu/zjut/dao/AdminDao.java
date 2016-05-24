package edu.zjut.dao;

import java.sql.SQLException;

import edu.zjut.model.Admin;

public class AdminDao {
	
	/**
	 * 通过管理员登录名和登录密码查询
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Admin find(String name, String password) throws SQLException {
		String sql = "select * from t_admin where name = ? and adminpwd = ?";
		return null;
	}
}