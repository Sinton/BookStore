package edu.zjut.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelp {
	
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_HOST = "localhost:";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "root";
	private final String DB_DBNAME = "bookstore";
	private final String DB_PORT = "3306/";
	private final String DB_URL = "jdbc:mysql://" + DB_HOST + DB_PORT + DB_DBNAME;
	public Connection connection = null;
	
	/**
	 * 创建数据库连接
	 * @return
	 */
	public Connection getConn() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DB_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			} catch (ClassNotFoundException | SQLException exception) {
				exception.printStackTrace();
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
		} catch (SQLException exception) {
			exception.printStackTrace();
			return false;
		}
	}
}