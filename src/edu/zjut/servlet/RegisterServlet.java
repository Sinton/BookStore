package edu.zjut.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.dao.impl.UserDaoImpl;
import edu.zjut.model.User;
import edu.zjut.utils.Helper;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register.do" })
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收表单中的数据
		String email = request.getParameter("email").trim().toString();
		String password = request.getParameter("password").trim().toString();
		String nickname = request.getParameter("nickname").trim().toString();
		nickname = new String(nickname.getBytes("ISO-8859-1"), "UTF-8");
		
		// 判断用户名、密码是否为空
		if (!"".equals(email) && !"".equals(password)) {
			// 判断用户名、密码是否符合规则
			if(validateEmail(email)) {
				if (validatePassword(password)) {
					// 注册新用户
					long timeStamp = new Helper().getCurrentTimeStamp();
					User user = new User(email, password, nickname, new Helper().timeStampToDate(timeStamp, Helper.TIME_SPECIFIC_HEIGH));
					UserDaoImpl userDao = new UserDaoImpl();
					try {
						if (userDao.createUser(user)) {
							response.sendRedirect("login.jsp");
						}else {
							System.out.println("对不起！您申请注册的帐号不可用．");
							response.sendRedirect("register.jsp");
						}
					} catch (SQLException exception) {
						System.out.println(exception);
					}
				}else {
					System.out.println("对不起！您的密码长度不符合规则，密码长度必须在6至15个字符．");
					response.sendRedirect("register.jsp");
				}
			} else {
				System.out.println("对不起，您的用户名不符合邮箱规则．");
				response.sendRedirect("register.jsp");
			}
		} 
		else {
			System.out.println("对不起！您的用户名或密码不为空．");
			response.sendRedirect("register.jsp");
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
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public String getCurrentTime() {
		long currentTime = new Date().getTime();
		return String.valueOf(currentTime).substring(0, 10);
	}
}