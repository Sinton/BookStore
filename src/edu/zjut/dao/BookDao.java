package edu.zjut.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Book;

public interface BookDao {
	public boolean createBook (Book book) throws SQLException;
	boolean updateBook(Book book) throws SQLException;
	boolean deleteBook(int bid) throws SQLException;
	ArrayList<Book> getBooks() throws SQLException;
	Book getBookByBid(int bid) throws SQLException;
	ArrayList<Book> getBooksByPublishing(String publishing) throws SQLException;
	ArrayList<Book> getBooksByPriceRange(String priceRange) throws SQLException;
	ArrayList<Book> getBooksByDiscount(String discount) throws SQLException;
	ArrayList<Book> getBooksBySecondCategoryId(int categoryId) throws SQLException;
	ArrayList<Book> vagueSearch(String search) throws SQLException;
	ArrayList<Book> getRandBooks() throws SQLException;
}