package edu.zjut.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.dao.impl.BookDaoImpl;
import edu.zjut.model.Book;

@WebServlet(name = "BookDetailServlet", urlPatterns = { "/item.do" }, description = "书籍详情")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BookDaoImpl bookDao = new BookDaoImpl();
		try {
			Book book = bookDao.getBookByBid(bid);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/item.jsp");
			dispatcher.forward(request, response);
		} catch (NumberFormatException | SQLException exception) {
			exception.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}