package com.project.user.controller.ship;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.user.service.ShipService;
import com.project.user.vo.ShipList;


@WebServlet("/ship/shipListDelete")
public class ShipListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShipListDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ship_no = request.getParameter("selectedShipNo");
		
		int shipNo = Integer.parseInt(ship_no);
		
        ShipList s = new ShipList();
        s.setShip_no(shipNo);
        
        int result = new ShipService().deleteShipList(s);
        
        RequestDispatcher view = null;

        if(result > 0) {
			view = request.getRequestDispatcher("/ship/shipList");  // success
		}else {
			view = request.getRequestDispatcher("/ship/shipList");  // fail
		}
		
		view.forward(request, response);

		doGet(request, response);
	}

}
