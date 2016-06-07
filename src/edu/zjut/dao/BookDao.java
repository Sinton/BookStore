package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Book;
import edu.zjut.utils.DBHelp;

public class BookDao {
	
	private PreparedStatement pstmt = null;
	private Connection connection = null;
	private ResultSet rs = null;
	private DBHelp dbHelp = new DBHelp();
	
	public BookDao() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加书籍
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public boolean createBook (Book book) throws SQLException {
		String sql = "insert into `t_book` ( name, price, publishing) values(?, ?, ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getName());
		pstmt.setDouble(2, book.getPrice());
		pstmt.setString(3, book.getPublishing());
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 修改书籍信息
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public boolean updateBook (Book book) throws SQLException {
		String sql = "update `t_book` set name = ?, price = ?, publishing = ? WHERE bid = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getName());
		pstmt.setDouble(2, book.getPrice());
		pstmt.setString(3, book.getPublishing());
		pstmt.setInt(4, book.getBid());
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}

	/**
	 * 删除书籍
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteBook (int bid) throws SQLException {
		String sql = "delete from t_book where bid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bid);
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 根据bid获取书籍
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	public Book getBookByBid (int bid) throws SQLException {
		String sql = "select * from t_book where bid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		Book book = new Book();
		while (rs.next()) {
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setPublishing(rs.getString("publishing"));
		}
		return book;
	}
	
	/**
	 * 获取全部书籍
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Book> getBooks () throws SQLException {
		String sql = "select * from t_book;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setPublishing(rs.getString("publishing"));
			books.add(book);
		}
		return books;
	}
}