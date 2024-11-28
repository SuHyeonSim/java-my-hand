package com.gn.product_admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.product_admin.service.Product_adminService;
import com.gn.product_admin.vo.Product_admin;

@WebServlet("/product_admin/product_deleteEnd")
public class Product_adminDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Product_adminDeleteEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodNo = Integer.parseInt(request.getParameter("product_no"));
		int result = new Product_adminService().deleteProduct(prodNo);
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
