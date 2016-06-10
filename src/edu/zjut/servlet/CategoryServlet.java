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

@WebServlet(name = "CategoryServlet", urlPatterns = { "/category.do" })
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getQueryString();
		String search = request.getParameter("search") == null ? null : request.getParameter("search");
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Book> books = new ArrayList<Book>();
		BookDao bookDao = new BookDao();
		if (search != null) {
			switch (search) {
			case "publish":
				try {
					String publish = request.getParameter("publish");
					books = bookDao.getBooksByPublishing(publish);
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				break;
			case "priceRange":
				try {
					String priceRange = request.getParameter("priceRange");
					books = bookDao.getBooksByPriceRange(priceRange);
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				break;
			case "discount":
				try {
					String discount = request.getParameter("discount");
					books = bookDao.getBooksByDiscount(discount);
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				break;
			default:
				System.out.println(request.getQueryString());
				break;
			}
		} else {
			try {
				int secondCategoryId = categoryDao.getCategoryIdByName(categoryName);
				books = bookDao.getBooksBySecondCategoryId(secondCategoryId);
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		request.getSession().setAttribute("books", books);
		request.getSession().setAttribute("publishs", bookDao.getPublishs());
		request.getSession().setAttribute("priceRanges", bookDao.getPriceRanges());
		request.getSession().setAttribute("discounts", bookDao.getDiscounts());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}