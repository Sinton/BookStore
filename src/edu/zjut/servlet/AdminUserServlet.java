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

import edu.zjut.dao.impl.UserDaoImpl;
import edu.zjut.model.User;

@WebServlet(name = "AdminUserServlet",  urlPatterns = {"/admin/user.do"})
public class AdminUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao = new UserDaoImpl();
	private static RequestDispatcher dispatcher;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET操作分流
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
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
			ArrayList<User> users = userDao.getAllUsers();
			request.setAttribute("users", users);
			dispatcher = request.getRequestDispatcher("user/list.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * 删除指定UID用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	protected void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		try {
			userDao.deleteUser(uid);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		showIndex(request, response);
	}
	
	/**
	 * 展示用户修改页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showUpdateAction(int bid, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = userDao.getUserByUid(bid);
			request.setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("user/modify.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}