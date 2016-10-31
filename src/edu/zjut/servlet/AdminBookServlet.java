package edu.zjut.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.zjut.dao.impl.BookDaoImpl;
import edu.zjut.dao.impl.CategoryDaoImpl;
import edu.zjut.dao.impl.SecondCategoryDaoImpl;
import edu.zjut.model.Book;
import edu.zjut.model.Category;
import edu.zjut.model.SecondCategory;

@WebServlet(name = "AdminBookServlet",  urlPatterns = {"/admin/book.do"})
public class AdminBookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static BookDaoImpl bookDao = new BookDaoImpl();
	private static CategoryDaoImpl categoryDao = new CategoryDaoImpl();
	private static SecondCategoryDaoImpl secondCategoryDao = new SecondCategoryDaoImpl();
	private static RequestDispatcher dispatcher;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET操作分流
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "create":
				showCreateAction(request, response);
				break;
			case "update":
				int bid = Integer.parseInt(request.getParameter("bid"));
				showUpdateAction(bid, request, response);
				break;
			case "delete":
				deleteAction(request, response);
				break;
			default:
				System.out.println(action);
				break;
			}
		} else {
			showIndex(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST操作分流
		String action = request.getParameter("action");
		switch (action) {
		case "create":
			createAction(request, response);
			break;
		case "update":
			updateAction(request, response);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 显示首页内容
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Book> books = bookDao.getBooks();
			request.setAttribute("books", books);
			dispatcher = request.getRequestDispatcher("book/index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * 添加书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	protected void createAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		double discount = Double.parseDouble(request.getParameter("discount"));
		String publishing = request.getParameter("publishing");
		String publishTime = request.getParameter("poublishtime");
		int edition = Integer.parseInt(request.getParameter("edition"));
		int pageNum = Integer.parseInt(request.getParameter("pagenum"));
		String isnb = request.getParameter("isnb");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int secondCategoryId = Integer.parseInt(request.getParameter("secondCategory"));
		
		// 中文编码转义
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		author = new String(author.getBytes("ISO-8859-1"), "UTF-8");
		publishing = new String(publishing.getBytes("ISO-8859-1"), "UTF-8");
		isnb = new String(isnb.getBytes("ISO-8859-1"), "UTF-8");
		Book book = new Book(name, author, price, discount, publishing, publishTime, edition, pageNum, isnb, categoryId, secondCategoryId, "", "", "");
		// 处理上传文件
		//uploadFileAction(book, request, response);
		try {
			bookDao.createBook(book);
			showIndex(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * 更新书籍信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	protected void updateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		double discount = Double.parseDouble(request.getParameter("discount"));
		String publishing = request.getParameter("publishing");
		String publishTime = request.getParameter("poublishtime");
		int edition = Integer.parseInt(request.getParameter("edition"));
		int pageNum = Integer.parseInt(request.getParameter("pagenum"));
		String isnb = request.getParameter("isnb");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int secondCategoryId = Integer.parseInt(request.getParameter("secondCategory"));
		
		// 中文编码转义
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		author = new String(author);
		publishing = new String(publishing.getBytes("ISO-8859-1"), "UTF-8");
		isnb = new String(isnb.getBytes("ISO-8859-1"), "UTF-8");
		Book book = new Book(name, author, price, discount, publishing, publishTime, edition, pageNum, isnb, categoryId, secondCategoryId, "", "", "");
		book.setBid(bid);
		book.setCategoryId(categoryId);
		book.setSecondCategoryId(secondCategoryId);
		try {
			bookDao.updateBook(book);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		showUpdateAction(bid, request, response);
	}
	
	/**
	 * 删除书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	protected void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		try {
			bookDao.deleteBook(bid);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		showIndex(request, response);
	}
	
	/**
	 * 展示书籍修改页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showUpdateAction(int bid, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Book book = bookDao.getBookByBid(bid);
			request.setAttribute("book", book);
			ArrayList<SecondCategory> secondCategories = secondCategoryDao.getAllSecondCategories();
			ArrayList<Category> categories = categoryDao.getAllCategories();
			request.setAttribute("categories", categories);
			request.setAttribute("secondCategories", secondCategories);
			dispatcher = request.getRequestDispatcher("book/modify.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * 展示添加书籍页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showCreateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<SecondCategory> secondCategories = secondCategoryDao.getAllSecondCategories();
			ArrayList<Category> categories = categoryDao.getAllCategories();
			request.setAttribute("categories", categories);
			request.setAttribute("secondCategories", secondCategories);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		dispatcher = request.getRequestDispatcher("book/add.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * 处理上传文件
	 * @param book
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	protected Book uploadFileAction(Book book, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(1 * 1024 * 1024);
		List<FileItem> fileItemList;
		try {
			fileItemList = sfu.parseRequest(request);
			for (int i = 0; i < fileItemList.size(); i++) {
				FileItem fileItem = fileItemList.get(i);
				String filename = fileItem.getName();
				int index = filename.lastIndexOf("\\");
				if(index != -1)
					filename = filename.substring(index + 1);
				String savepath = this.getServletContext().getRealPath("/upload");
				File destFile = new File(savepath, filename);
				fileItem.write(destFile);
				switch (i) {
				case 0:
					book.setImgUrlBig("upload/" + filename);
					break;
				case 1:
					book.setImgUrlMid("upload/" + filename);
					break;
				case 2:
					book.setImgUrlSmall("upload/" + filename);
					break;
				default:
					break;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		System.out.println(book.getImgUrlBig());
		System.out.println(book.getImgUrlMid());
		System.out.println(book.getImgUrlSmall());
		return book;
	}
}