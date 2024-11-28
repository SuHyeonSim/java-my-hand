package com.gn.order_admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.order_admin.service.Order_adminService;

@WebServlet("/order_admin/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = new Order_adminService().selectOrderList();
		request.setAttribute("resultListOrder", list);
		System.out.println(list.toString());
		RequestDispatcher view = null;
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("/order_admin/orderList.jsp");
			view.forward(request, response);
		}else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
