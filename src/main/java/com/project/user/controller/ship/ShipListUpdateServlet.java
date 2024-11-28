package com.project.user.controller.ship;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

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

@WebServlet("/ship/shipListUpdate")
public class ShipListUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShipListUpdateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User session_User = (User) session.getAttribute("user");
		int userNo = session_User.getUser_no();
			
		String selectedShipNo = request.getParameter("selectedShipNo");
	    
	    List<ShipList> shipList = new ShipService().choiseList(userNo, selectedShipNo);
	       
	    request.setAttribute("shipList", shipList);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/shipListUpdate.jsp");
	    dispatcher.forward(request, response);
		}

	}
