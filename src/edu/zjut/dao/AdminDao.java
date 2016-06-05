package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.zjut.utils.DBHelp;

public class AdminDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection;
	private DBHelp dbHelp = new DBHelp();
	
	/**
	 * 通过管理员帐号和密码查询
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean find(String email, String password) throws SQLException {
		connection = dbHelp.getConn();
		String sql = "select * from t_admin where name = ? and adminpwd = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
}