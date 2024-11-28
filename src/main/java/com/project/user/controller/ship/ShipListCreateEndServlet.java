package com.project.user.controller.ship;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.ShipService;
import com.project.user.vo.ShipList;
import com.project.user.vo.User;


@WebServlet("/ship/shipListCreateEnd")
public class ShipListCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShipListCreateEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		User session_User = (User) session.getAttribute("user");
		int userNo = session_User.getUser_no();
	    
		String alias = request.getParameter("ship_alias");
		String name = request.getParameter("ship_name");
		String phoneNumb = request.getParameter("phone_number");
		String address1 = request.getParameter("address_kakao");
		String address2 = request.getParameter("address_detail");
		String frontPw =  request.getParameter("front_pw"); 
		
		ShipList s = new ShipList();
		s.setUser_no(userNo);
		s.setShip_alias(alias);
		s.setShip_name(name);
		s.setShip_phone(phoneNumb);
		s.setShip_address1(address1);
		s.setShip_address2(address2);
		s.setFront_door_pw(frontPw);
		System.out.print(s.toString());
		int result = new ShipService().createShipList(s);
		RequestDispatcher view = null;
		
		if(result > 0) {
			view = request.getRequestDispatcher("/ship/shipList");  // success
		}else {
			view = request.getRequestDispatcher("/views/user/shipListCreate.jsp");  // fail
		}
		
		view.forward(request, response);
		
		doGet(request, response);
	}

}
