package edu.zjut.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_HOST = "localhost:";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "root";
	private final String DB_DBNAME = "bookstore";
	private final String DB_PORT = "3306/";
	private final String DB_URL = "jdbc:mysql://" + DB_HOST + DB_PORT + DB_DBNAME;
	private Statement st = null;
	private ResultSet rs = null;
	public Connection connection;
	
	public DBUtils() {
		connection = this.getConn();
		String ssString;
		StringBuilder stringBuilder;
	}

	/**
	 * 连接MySQL数据库
	 * @return
	 */
	private Connection getConn() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DB_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}
			return connection;
		}
	}
	
	/**
	 * 关闭数据库连接
	 * @return
	 */
	public boolean closeConn() {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 执行各种SQL语句
	 * @param sql
	 * @return
	 */
	public ResultSet exceteSQl(String sql) {
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}