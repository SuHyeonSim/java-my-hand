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


@WebServlet("/ship/shipListUpdateEnd")
public class ShipListUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShipListUpdateEndServlet() {
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
	    
        int ship_no = Integer.parseInt(request.getParameter("ship_no"));
        
        
        String ship_alias = request.getParameter("ship_alias");
        String ship_name = request.getParameter("ship_name");
        String phone_number = request.getParameter("phone_number");
        String address_kakao = request.getParameter("address_kakao");
        String address_detail = request.getParameter("address_detail");
        String front_pw = request.getParameter("front_pw");

        ShipList s = new ShipList();
        s.setUser_no(userNo);
        s.setShip_no(ship_no);
        s.setShip_alias(ship_alias);
        s.setShip_name(ship_name);
        s.setShip_phone(phone_number);
        s.setShip_address1(address_kakao);
        s.setShip_address2(address_detail);
        s.setFront_door_pw(front_pw);
        System.out.print(s.toString());

        int result = new ShipService().updateShipList(s);
        RequestDispatcher view = null;

        if(result > 0) {
			view = request.getRequestDispatcher("/ship/shipList");  // success
		}else {
			view = request.getRequestDispatcher("/ship/shipListUpdate");  // fail
		}
		
		view.forward(request, response);
		
		doGet(request, response);
		}
	}