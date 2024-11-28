package com.project.user.controller.mypage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.order_admin.service.Order_adminService;
import com.project.user.vo.User;


@WebServlet("/MyPage/OrderList")
public class MyPageOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyPageOrderListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/User/Login");
            return;
        }
        User user = (User) session.getAttribute("user");
        int userNo = user.getUser_no();
		
        List<Map<String, Object>> list = new Order_adminService().userOrderList(userNo);
        request.setAttribute("userListOrder", list);
		RequestDispatcher view = request.getRequestDispatcher("/views/mypage/mypage_orderList.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
