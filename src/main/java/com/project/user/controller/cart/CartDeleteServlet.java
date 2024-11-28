package com.project.user.controller.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.CartService;
import com.project.user.vo.User;


@WebServlet("/Cart/deleteCart")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User session_User = (User) session.getAttribute("user");
		int userNo = session_User.getUser_no();
		
        String action = request.getParameter("action");
        CartService c = new CartService();

        try {
	        if ("all".equals(action)) {
	            c.deleteAll(userNo);
	        } else if ("selected".equals(action)) {
	            String[] prodNos = request.getParameterValues("item_check");
	            if (prodNos != null) {
		            for (String prodNo : prodNos) {
		                c.deletePartial(userNo, prodNo);
		            }
	            }
	        }
        } catch (Exception e) {
        	e.printStackTrace();
	        }
	        response.sendRedirect("/Cart/cartList");

		}
}