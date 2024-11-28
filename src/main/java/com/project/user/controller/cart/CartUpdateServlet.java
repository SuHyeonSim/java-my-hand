package com.project.user.controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.CartService;
import com.project.user.vo.User;


@WebServlet("/Cart/updateCart")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartUpdateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    User session_User = (User) session.getAttribute("user");
	    int userNo = session_User.getUser_no();
	    int prodNo = Integer.parseInt(request.getParameter("prod_no"));
	    System.out.println("servlet: " + prodNo);
	    int cartQuantity = Integer.parseInt(request.getParameter("cart_quantity"));

	    int result = new CartService().updateCartQuantity(userNo, prodNo, cartQuantity);

	    if (result > 0) {
	        // 업데이트 성공
	        response.sendRedirect("/Cart/cartList");
	    } else {
	        // 업데이트 실패
	        response.sendRedirect("/cart.jsp");   //실패 경로 추가해서 넣기
	    }
	}

}
