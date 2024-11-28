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

@WebServlet("/product_admin/product_inventory")
public class Product_adminInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Product_adminInventoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodNo = Integer.parseInt(request.getParameter("product_no"));
		
		Product_admin pa = new Product_adminService().infoProduct(prodNo);
		
		RequestDispatcher view = null;
		if(pa != null) {
			request.setAttribute("productInventoryInfo", pa);
			view = request.getRequestDispatcher("/product_admin/product_inventory.jsp");
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("/product_admin/product_fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
