package edu.zjut.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.dao.impl.BookDaoImpl;
import edu.zjut.dao.impl.OrderDaoImpl;
import edu.zjut.dao.impl.OrderItemDaoImpl;
import edu.zjut.model.Book;
import edu.zjut.model.ItemDetail;
import edu.zjut.model.Order;
import edu.zjut.model.OrderItem;
import edu.zjut.model.User;
import edu.zjut.utils.Helper;

@WebServlet(name = "CartServlet", urlPatterns = { "/cart.do" }, description = "购物车")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BookDaoImpl bookDao = new BookDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			User user = (User) request.getSession(false).getAttribute("user");
			if (user == null) {
				request.setAttribute("imgStyle", "error");
				request.setAttribute("msgHead", "错误");
				request.setAttribute("jumpUrl", "login.jsp");
				request.setAttribute("jumpName", "立即登录");
				request.setAttribute("level", "warning");
				request.setAttribute("operate", "没有购买权限，请先登录");
				RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
				dispatcher.forward(request, response);
			}
			else {
				int bid = Integer.parseInt(request.getParameter("bid"));
				HashMap<Integer, ItemDetail> userCart = (HashMap<Integer, ItemDetail>) request.getSession().getAttribute("userCart");
				Book book = null;
				try {
					book = bookDao.getBookByBid(bid);
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				// 用户购物车为空，第一次购买
				if (userCart == null) {
					ItemDetail itemDetail = new ItemDetail(book, 1, book.getPrice() * book.getDiscount()* 0.1);
					userCart = new HashMap<Integer, ItemDetail>();
					userCart.put(bid, itemDetail);
				} else {
					if (userCart.get(bid) == null) {
						ItemDetail itemDetail = new ItemDetail(book, 1, book.getPrice() * book.getDiscount() * 0.1);
						userCart.put(bid, itemDetail);
					} 
					// 该书籍已经存在购物车中
					else {
						ItemDetail itemDetail = userCart.get(bid);
						itemDetail.setAmount(itemDetail.getAmount() + 1);
						itemDetail.setTotalPrice(book.getPrice() * book.getDiscount() * itemDetail.getAmount() * 0.1);
					}
				}
				double totalPrice = 0.0;
				int totalAmount = 0;
				Iterator<Map.Entry<Integer, ItemDetail>> iterator = userCart.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry<Integer, ItemDetail> entry = iterator.next();
					ItemDetail itemDetail = entry.getValue();
					totalPrice += itemDetail.getTotalPrice();
					totalAmount += itemDetail.getAmount();
				}
				request.getSession().setAttribute("totalPrice", totalPrice);
				request.getSession().setAttribute("totalAmount", totalAmount);
				request.getSession().setAttribute("userCart", userCart);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			switch (action) {
			case "up":
				upAction(request, response);
				break;
			case "down":
				downAction(request, response);
				break;
			case "delete":
				deleteAction(request, response);
				break;
			case "settlement":
				settlementAction(request, response);
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	/**
	 * 购物车结算
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void settlementAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemDetail> items = new ArrayList<>();
		HashMap<Integer, ItemDetail> userCart = (HashMap<Integer, ItemDetail>) request.getSession().getAttribute("userCart");
		User user = (User) request.getSession().getAttribute("user");
		int uid = user.getUid();
		double totalPrice = 0.0;
		Iterator<Map.Entry<Integer, ItemDetail>> iterator = userCart.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, ItemDetail> entry = iterator.next();
			ItemDetail itemDetail = entry.getValue();
			totalPrice += itemDetail.getTotalPrice();
			items.add(itemDetail);
		}
		OrderDaoImpl orderDao = new OrderDaoImpl();
		String orderSeqPre = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + String.valueOf(Calendar.getInstance().get(Calendar.MONTH + 1));
		String orderSeq = (new Helper().getHash(System.currentTimeMillis() + "", "MD5")).substring(0, 8);
		Order order = new Order(orderSeqPre + orderSeq, uid, new Date().getTime() / 1000, totalPrice, Order.NO_PAYMENT, "", null);
		try {
			orderDao.createOrder(order);
			// 结算成功之后清空购物车
			request.getSession().setAttribute("userCart", null);
			// 生成订单详情
			OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
			for (int i = 0; i < items.size(); i++) {
				OrderItem orderItem = new OrderItem(orderSeqPre + orderSeq, items.get(i).getBook().getBid(), items.get(i).getAmount());
				orderItemDao.createOrderItem(orderItem);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		request.getSession().setAttribute("totalPrice", 0);
		request.getSession().setAttribute("totalAmount", 0);
		request.getSession().setAttribute("userCart", null);
		request.setAttribute("imgStyle", "succeed");
		request.setAttribute("msgHead", "结算成功");
		request.setAttribute("jumpUrl", "order.do");
		request.setAttribute("jumpName", "查看订单");
		request.setAttribute("level", "success");
		request.setAttribute("operate", "购物车结算成功");
		RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * 删除购物车指定书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		HashMap<Integer, ItemDetail> userCart = (HashMap<Integer, ItemDetail>) request.getSession().getAttribute("userCart");
		Iterator<Map.Entry<Integer, ItemDetail>> iterator = userCart.entrySet().iterator();
		double totalPrice = (double) request.getSession().getAttribute("totalPrice");
		int totalAmount = (int) request.getSession().getAttribute("totalAmount");
		HashMap<Integer, ItemDetail> temp = new HashMap<>();
		while (iterator.hasNext()) {
			Map.Entry<Integer, ItemDetail> entry = iterator.next();
			ItemDetail itemDetail = entry.getValue();
			if (bid == entry.getKey()) {
				totalPrice -= itemDetail.getTotalPrice();
				totalAmount -= itemDetail.getAmount();
			}else
				temp.put(entry.getKey(), entry.getValue());
		}
		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("userCart", temp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * 在购物车中增加指定商品的数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void upAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		HashMap<Integer, ItemDetail> userCart = (HashMap<Integer, ItemDetail>) request.getSession().getAttribute("userCart");
		Iterator<Map.Entry<Integer, ItemDetail>> iterator = userCart.entrySet().iterator();
		double totalPrice = (double) request.getSession().getAttribute("totalPrice");
		int totalAmount = (int) request.getSession().getAttribute("totalAmount");
		while (iterator.hasNext()) {
			Map.Entry<Integer, ItemDetail> entry = iterator.next();
			ItemDetail itemDetail = entry.getValue();
			if (bid == entry.getKey()) {
				itemDetail.setAmount(itemDetail.getAmount() + 1);
				totalAmount += 1;
				totalPrice += itemDetail.getBook().getPrice() * itemDetail.getBook().getDiscount() * 0.1;
			}
		}
		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("userCart", userCart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * 在购物车中减少指定商品的数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void downAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		HashMap<Integer, ItemDetail> userCart = (HashMap<Integer, ItemDetail>) request.getSession().getAttribute("userCart");
		Iterator<Map.Entry<Integer, ItemDetail>> iterator = userCart.entrySet().iterator();
		double totalPrice = (double) request.getSession().getAttribute("totalPrice");
		int totalAmount = (int) request.getSession().getAttribute("totalAmount");
		while (iterator.hasNext()) {
			Map.Entry<Integer, ItemDetail> entry = iterator.next();
			ItemDetail itemDetail = entry.getValue();
			if (bid == entry.getKey()) {
				if (itemDetail.getAmount() > 1) {
					itemDetail.setAmount(itemDetail.getAmount() - 1);
					totalAmount -= 1;
					totalPrice -= itemDetail.getBook().getPrice() * itemDetail.getBook().getDiscount() * 0.1;
				}
			}
		}
		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("userCart", userCart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
	}
}