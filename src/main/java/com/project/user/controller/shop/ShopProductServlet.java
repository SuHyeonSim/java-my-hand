package com.project.user.controller.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.product_admin.vo.Product_admin;
import com.project.user.service.ShopService;


@WebServlet("/shop/shopProduct")
public class ShopProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShopProductServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product_admin> list = new ShopService().selectProduct_userList();

		request.setAttribute("products", list);
		RequestDispatcher view = null;
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("/views/shop/shop.jsp");
			view.forward(request, response);
		}

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
