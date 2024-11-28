package com.gn.order_admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.order_admin.service.Order_adminService;


@WebServlet("/order_admin/orderInfo")
public class OrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNo = request.getParameter("order_no");
		List<Map <String, Object>> list = new Order_adminService().selectOrderInfo(orderNo);
		request.setAttribute("resultOrderInfo", list);
		RequestDispatcher view = null;
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("/order_admin/orderInfo.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
