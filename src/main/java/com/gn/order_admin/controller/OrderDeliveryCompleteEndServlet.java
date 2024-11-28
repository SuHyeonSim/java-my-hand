package com.gn.order_admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.order_admin.service.Order_adminService;


@WebServlet("/order_admin/orderDeliveryCompleteEnd")
public class OrderDeliveryCompleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderDeliveryCompleteEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNo = request.getParameter("order_no");
		System.out.println(orderNo);
		int result = new Order_adminService().orderDeliveryComplete(orderNo);
		System.out.println(result);
		RequestDispatcher view = request.getRequestDispatcher("/product_admin/product_fail.jsp");
		if(result > 0) {
			view = request.getRequestDispatcher("/product_admin/product_success.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
