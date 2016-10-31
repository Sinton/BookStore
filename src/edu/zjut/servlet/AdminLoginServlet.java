package edu.zjut.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.dao.impl.AdminDaoImpl;
import edu.zjut.model.Admin;

@WebServlet(name = "AdminLoginServlet", urlPatterns = { "/admin/login.do" })
public class AdminLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String USERNAME = "RG@zjut.edu.cn";
	private static final String PASSWORD = "admin201615162";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").trim().toString();
		String password = request.getParameter("password").trim().toString();
		AdminDaoImpl adminDao = new AdminDaoImpl();
		try {
			adminDao.getAdmin(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 判断用户名、密码是否为空
		if (!"".equals(email) && !"".equals(password)) {
			// 判断用户名、密码是否符合规则
			if(validateEmail(email)) {
				if (validatePassword(password)) {
					// 判断用户名、密码是否正确
					if (email.equals(USERNAME) && password.equals(PASSWORD)) {
						Admin admin = new Admin(email, password);
						request.getSession().setAttribute("admin", admin);
						//response.sendRedirect("/BookStore/adminjsps/user/welcome.jsp");
					}else {
						System.out.println("对不起！您的用户名或密码不正确．");
						response.sendRedirect("/BookStore/adminjsps/user/login.jsp");
					}
				}else {
					System.out.println("对不起！您的密码长度不符合规则，密码长度必须在6至15个字符．");
					response.sendRedirect("/BookStore/adminjsps/user/login.jsp");
				}
			} else {
				System.out.println("对不起，您的用户名不符合邮箱规则．");
				response.sendRedirect("/BookStore/adminjsps/user/login.jsp");
			}
		} 
		else {
			System.out.println("对不起！您的用户名或密码不为空．");
			response.sendRedirect("/BookStore/adminjsps/user/login.jsp");
		}
	}
	
	/**
	 * 用正则表达式验证用户邮箱
	 * @param username
	 * @return
	 */
	public boolean validateEmail(String username) {
		String regx = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		Pattern pattern = Pattern.compile(regx);
		return pattern.matcher(username).matches();
	}
	
	/**
	 * 验证密码是否符合要求
	 * @param password
	 * @return
	 */
	public boolean validatePassword(String password) {
		return password.length() >= 6 && password.length() <= 15;
	}
}