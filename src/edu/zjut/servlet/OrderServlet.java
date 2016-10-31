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

import edu.zjut.dao.impl.OrderDaoImpl;
import edu.zjut.model.Order;
import edu.zjut.model.User;

@WebServlet(name = "OrderServlet", urlPatterns = { "/order.do" }, description = "订单")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			User user = (User) request.getSession().getAttribute("user");
			int uid = user.getUid();
			OrderDaoImpl orderDao = new OrderDaoImpl();
			try {
				ArrayList<Order> orders = orderDao.getOrdersByUid(uid);
				request.getSession().setAttribute("orders", orders);
				RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		} else {
			OrderDaoImpl orderDao = new OrderDaoImpl();
			String orderSeq = "";
			switch (action) {
			case "pay":
				orderSeq = request.getParameter("orderSeq");
				try {
					// 支付成功
					if(orderDao.changeStatus(Order.HAS_PAYMENT, orderSeq)) {
						request.setAttribute("imgStyle", "succeed");
						request.setAttribute("msgHead", "支付成功");
						request.setAttribute("jumpUrl", "order.do");
						request.setAttribute("jumpName", "返回我的订单");
						request.setAttribute("level", "success");
						request.setAttribute("operate", "该订单已经支付成功");
						RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
						dispatcher.forward(request, response);
					}
					// 支付失败
					else {
						request.setAttribute("imgStyle", "error");
						request.setAttribute("msgHead", "支付失败");
						request.setAttribute("jumpUrl", "order.do");
						request.setAttribute("jumpName", "返回我的订单");
						request.setAttribute("level", "warning");
						request.setAttribute("operate", "该订单支付失败");
						RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				break;
			case "sure":
				orderSeq = request.getParameter("orderSeq");
				try {
					if(orderDao.changeStatus(Order.FINISH_TRADE, orderSeq)) {
						request.setAttribute("imgStyle", "succeed");
						request.setAttribute("msgHead", "确认签收");
						request.setAttribute("jumpUrl", "order.do");
						request.setAttribute("jumpName", "返回我的订单");
						request.setAttribute("level", "success");
						request.setAttribute("operate", "签收成功");
						RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}