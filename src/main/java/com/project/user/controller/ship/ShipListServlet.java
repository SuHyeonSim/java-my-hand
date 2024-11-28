package com.project.user.controller.ship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet("/ship/shipList")

public class ShipListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShipListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User session_User = (User) session.getAttribute("user");
		int userNo = session_User.getUser_no();
        
		
		List<ShipList> shipList = new ShipService().selectShipList(userNo);

		
        request.setAttribute("shipList", shipList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/shipList.jsp");
        dispatcher.forward(request, response);
    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
