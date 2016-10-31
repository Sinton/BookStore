package edu.zjut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.dao.BookDao;
import edu.zjut.model.Book;
import edu.zjut.utils.DBHelp;
import edu.zjut.utils.Helper;

public class BookDaoImpl implements BookDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public BookDaoImpl() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加书籍
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean createBook (Book book) throws SQLException {
		String sql = "INSERT INTO `t_book` (name, author, price, discount, publishing, publish_time, edition, page_num, isnb, category_id, second_category_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setDouble(3, book.getPrice());
		pstmt.setDouble(4, book.getDiscount());
		pstmt.setString(5, book.getPublishing());
		pstmt.setString(6, new Helper().dateToTimeStamp(book.getPublishTime(), Helper.TIME_SPECIFIC_LOW));
		pstmt.setInt(7, book.getEdition());
		pstmt.setInt(8, book.getPageNum());
		pstmt.setString(9, book.getIsnb());
		pstmt.setInt(10, book.getCategoryId());
		pstmt.setInt(11, book.getSecondCategoryId());
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 修改书籍信息
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean updateBook (Book book) throws SQLException {
		String sql = "UPDATE `t_book` SET name = ?, author = ?, price = ?, discount = ?, publishing = ?, publish_time = ?, edition = ?, page_num = ?, isnb = ?, category_id = ?, second_category_id = ? WHERE bid = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setDouble(3, book.getPrice());
		pstmt.setDouble(4, book.getDiscount());
		pstmt.setString(5, book.getPublishing());
		pstmt.setString(6, new Helper().dateToTimeStamp(book.getPublishTime(), Helper.TIME_SPECIFIC_LOW));
		pstmt.setInt(7, book.getEdition());
		pstmt.setInt(8, book.getPageNum());
		pstmt.setString(9, book.getIsnb());
		pstmt.setInt(10, book.getCategoryId());
		pstmt.setInt(11, book.getSecondCategoryId());
		pstmt.setInt(12, book.getBid());
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}

	/**
	 * 删除指定bid书籍
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean deleteBook (int bid) throws SQLException {
		String sql = "DELETE FROM t_book WHERE bid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bid);
		int result = pstmt.executeUpdate();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取全部书籍
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> getBooks () throws SQLException {
		//String sql = "SELECT t_book.*, t_category.category_name FROM t_book, t_category WHERE t_book.category_id = t_category.category_id;";
		String sql = "SELECT * FROM t_book;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 根据bid获取指定bid书籍
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Book getBookByBid (int bid) throws SQLException {
		String sql = "SELECT * FROM t_book WHERE bid = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		Book book = new Book();
		while (rs.next()) {
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
		}
		return book;
	}
	
	/**
	 * 根据指定的出版社获取该出版社的全部书籍
	 * @param publishing
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> getBooksByPublishing (String publishing) throws SQLException {
		if (publishing.equals("其他")) {
			String[] publishs = this.getPublishs();
			String sql = "SELECT * FROM t_book WHERE publishing NOT IN (?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < publishs.length - 1; i++)
				pstmt.setString(i + 1, publishs[i]);
		}else {
			String sql = "SELECT * FROM t_book WHERE publishing = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, publishing);
		}
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 根据指定的价格区间获取该价格区间内的全部书籍
	 * @param priceRange
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> getBooksByPriceRange (String priceRange) throws SQLException {
		if (priceRange.equals("140以上")) {
			String sql = "SELECT * FROM t_book WHERE price > 140";
			pstmt = connection.prepareStatement(sql);
		} else {
			int index = priceRange.indexOf("-");
			String startPrice = priceRange.substring(0, index);
			String endPrice = priceRange.substring(index + 1);
			String sql = "SELECT * FROM t_book WHERE price BETWEEN ? AND ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, startPrice);
			pstmt.setString(2, endPrice);
		}
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 根据指定的折扣获取该折扣下的全部书籍
	 * @param discount
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> getBooksByDiscount (String discount) throws SQLException {
		if (discount.equals("7折及以上")) {
			String sql = "SELECT * FROM t_book WHERE discount > 7";
			pstmt = connection.prepareStatement(sql);
		} else {
			int index = discount.indexOf("-");
			String startDiscount = discount.substring(0, index);
			String endDiscount = discount.substring(index + 1, discount.length() - 1);
			String sql = "SELECT * FROM t_book WHERE discount BETWEEN ? AND ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, startDiscount);
			pstmt.setString(2, endDiscount);
		}
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 获取二级分类下的全部书籍
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> getBooksBySecondCategoryId (int categoryId) throws SQLException {
		String sql = "SELECT * FROM t_book WHERE second_category_id = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, categoryId);
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 模糊查询与该条件匹配的全部书籍
	 * @param search
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> vagueSearch(String search) throws SQLException {
		String sql = "SELECT * FROM t_book WHERE `name` LIKE '%" + search + "%';";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 随机获取4本书籍
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Book> getRandBooks() throws SQLException {
		String sql = "SELECT * FROM t_book ORDER BY RAND() limit 4";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setDiscount(rs.getDouble("discount"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(new Helper().timeStampToDate(rs.getLong("publish_time"), Helper.TIME_SPECIFIC_LOW));
			book.setEdition(rs.getInt("edition"));
			book.setPageNum(rs.getInt("page_num"));
			book.setIsnb(rs.getString("isnb"));
			book.setCategoryId(rs.getInt("category_id"));
			book.setSecondCategoryId(rs.getInt("second_category_id"));
			book.setImgUrlSmall(rs.getString("img_url_small"));
			book.setImgUrlMid(rs.getString("img_url_mid"));
			book.setImgUrlBig(rs.getString("img_url_big"));
			books.add(book);
		}
		return books;
	}
	
	/**
	 * 获取全部出版社
	 * @return
	 */
	public String[] getPublishs() {
		String[] publishs = {"清华大学出版社", "电子工业出版社", "机械工业出版社", "人民邮电出版社", "北京大学出版社", "其他"};
		return publishs;
	}
	
	/**
	 * 获取全部价格区间
	 * @return
	 */
	public String[] getPriceRanges() {
		String[] priceRange = {"0-19", "20-39", "40-59", "60-89", "90-139", "140以上"};
		return priceRange;
	}
	
	/**
	 * 获取全部折扣区间
	 * @return
	 */
	public String[] getDiscounts() {
		String[] discounts = {"0-3折", "3-5折", "5-7折", "7折及以上"};
		return discounts;
	}
}