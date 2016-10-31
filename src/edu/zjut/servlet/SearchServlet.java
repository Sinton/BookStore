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

import edu.zjut.dao.impl.BookDaoImpl;
import edu.zjut.dao.impl.CategoryDaoImpl;
import edu.zjut.dao.impl.SecondCategoryDaoImpl;
import edu.zjut.model.Book;

@WebServlet(name = "SearchServlet", urlPatterns = { "/search.do" })
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String secondCategoryName = request.getQueryString();
		String search = request.getParameter("search") == null ? null : request.getParameter("search");
		SecondCategoryDaoImpl secondCategoryDao = new SecondCategoryDaoImpl();
		ArrayList<Book> books = new ArrayList<Book>();
		BookDaoImpl bookDao = new BookDaoImpl();
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
				break;
			}
		} else {
			try {
				int secondCategoryId = secondCategoryDao.getSecondCategoryIdByName(secondCategoryName);
				books = bookDao.getBooksBySecondCategoryId(secondCategoryId);
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		try {
			int categoryId = secondCategoryDao.getCategoryIdByName(secondCategoryName);
			CategoryDaoImpl categoryDao = new CategoryDaoImpl();
			String categoryName = categoryDao.getCategoryNameByCategoryId(categoryId);
			request.getSession().setAttribute("categoryName", categoryName);
		} catch (Exception exception) {
			exception.printStackTrace();
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
		String search = request.getParameter("search");
		search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
		ArrayList<Book> books = new ArrayList<Book>();
		BookDaoImpl bookDao = new BookDaoImpl();
		try {
			books = bookDao.vagueSearch(search);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		request.getSession().setAttribute("books", books);
		request.getSession().setAttribute("search", search);
		request.getSession().setAttribute("publishs", bookDao.getPublishs());
		request.getSession().setAttribute("priceRanges", bookDao.getPriceRanges());
		request.getSession().setAttribute("discounts", bookDao.getDiscounts());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
		dispatcher.forward(request, response);
	}
}