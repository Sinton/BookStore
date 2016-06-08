package edu.zjut.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.dao.BookDao;
import edu.zjut.dao.CategoryDao;
import edu.zjut.model.Book;

@WebServlet(name="CategoryServlet",urlPatterns={"/category.do"})
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getQueryString();
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			int secondCategoryId = categoryDao.getCategoryIdByName(categoryName);
			BookDao bookDao = new BookDao();
			books = bookDao.getBooksBySecondCategoryId(secondCategoryId);
			request.getSession().setAttribute("books", books);
			request.getSession().setAttribute("publishs", getPublishs());
			request.getSession().setAttribute("priceRanges", getPriceRanges());
			request.getSession().setAttribute("discounts", getDiscounts());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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