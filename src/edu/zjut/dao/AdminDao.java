package edu.zjut.dao;

import java.sql.SQLException;

import edu.zjut.utils.DBUtils;

public class AdminDao {
	
	/**
	 * 通过管理员登录名和登录密码查询
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public void find(String name, String password) throws SQLException {
		DBUtils dbUtils = new DBUtils();
		String sql = "select * from t_admin where name = '" + name + "' and adminpwd = '" + password + "'";
		System.out.println(dbUtils.exceteSQl(sql));
	}
}