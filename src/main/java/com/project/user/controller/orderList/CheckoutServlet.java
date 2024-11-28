package com.project.user.controller.orderList;

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
import com.project.user.service.ShipService;
import com.project.user.vo.Cart;
import com.project.user.vo.ShipList;
import com.project.user.vo.User;


@WebServlet("/order/checkOut")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckoutServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setCharacterEncoding("UTF-8");
		
			HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");
	        if (user == null) {
	            response.sendRedirect("/views/user/login.jsp");
	            return;
	        }

	        
	        int user_no = user.getUser_no();


	        String[] prodNos = request.getParameter("prodNos").split(",");
	        String[] prodQuantity = request.getParameter("prodQuantity").split(",");
	        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
	        int totalQuantity = Integer.parseInt(request.getParameter("totalQuantity"));
	        List<ShipList> shipList = new ShipService().selectShipList(user_no);
	        
	        System.out.println("금액: "+totalPrice);
	        System.out.println("수량: "+totalQuantity);
	        System.out.println("prodNo:"+prodNos);
	        System.out.println("shiplist:"+shipList);
			
	        request.setAttribute("shipList", shipList);
	        System.out.println(prodNos);
	        System.out.println(totalPrice);
	        System.out.println(totalQuantity);

	        request.setAttribute("user", user);
	        request.setAttribute("prodNos", prodNos);
	        request.setAttribute("prodQuantity", prodQuantity);
	        request.setAttribute("totalPrice", totalPrice);
	        request.setAttribute("totalQuantity", totalQuantity);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/checkout.jsp");
	        dispatcher.forward(request, response);
			}

}
		
		
