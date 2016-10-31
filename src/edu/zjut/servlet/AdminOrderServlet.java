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
import edu.zjut.dao.impl.OrderItemDaoImpl;
import edu.zjut.model.Order;
import edu.zjut.model.OrderItem;

@WebServlet(name = "AdminOrderServlet",  urlPatterns = {"/admin/order.do"})
public class AdminOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static OrderDaoImpl orderDao = new OrderDaoImpl();
	private static RequestDispatcher dispatcher;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET操作分流
		String action = request.getParameter("action");
		String orderSeq = "";
		if (action != null) {
			switch (action) {
			case "detail":
				orderSeq = request.getParameter("orderSeq");
				showDetailAction(orderSeq, request, response);
				break;
			case "deliver":
				orderSeq = request.getParameter("orderSeq");
				deliverAction(orderSeq, request, response);
				showDetailAction(orderSeq, request, response);
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

	/**
	 * 订单发货
	 * @param orderSeq
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deliverAction(String orderSeq, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OrderDaoImpl orderDao = new OrderDaoImpl();
			orderDao.changeStatus(Order.Delivered, orderSeq);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	/**
	 * 显示订单首页内容
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Order> orders = orderDao.getOrders();
			request.setAttribute("orders", orders);
			dispatcher = request.getRequestDispatcher("order/index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * 删除订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	protected void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		try {
			orderDao.deleteOrder(orderId);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		showIndex(request, response);
	}
	
	/**
	 * 展示订单详情页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showDetailAction(String orderSeq, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
		OrderDaoImpl orderDao = new OrderDaoImpl();
		try {
			int status = orderDao.getStatus(orderSeq);
			request.setAttribute("status", status);
			ArrayList<OrderItem> orderItems = orderItemDao.getOrderItemsByOrderSeq(orderSeq);
			request.setAttribute("orderDetail", orderItems);
			dispatcher = request.getRequestDispatcher("order/detail.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}