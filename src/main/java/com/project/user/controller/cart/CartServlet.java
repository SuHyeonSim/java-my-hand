package com.project.user.controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.CartService;
import com.project.user.vo.Cart;
import com.project.user.vo.User;


@WebServlet("/Cart/cartList")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User session_User = (User) session.getAttribute("user");
		int userNo = session_User.getUser_no();
		
			List<Cart> list = new CartService().listCart(userNo);
			
	        request.setAttribute("cartLists", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/cart.jsp");
	        dispatcher.forward(request, response);
        
        }
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
