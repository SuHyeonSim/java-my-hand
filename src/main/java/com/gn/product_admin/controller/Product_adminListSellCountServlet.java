package com.gn.product_admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.product_admin.service.Product_adminService;
import com.gn.product_admin.vo.Product_admin;

@WebServlet("/product_admin/product_listSellCount")
public class Product_adminListSellCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Product_adminListSellCountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product_admin> list = new Product_adminService().selectProduct_adminList();

		request.setAttribute("resultListSellCount", list);
		RequestDispatcher view = null;
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("/product_admin/product_listSellCount.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
