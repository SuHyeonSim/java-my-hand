package com.project.user.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.user.service.UserService;
import com.project.user.vo.User;

@WebServlet(name= "userCreateEnd",urlPatterns="/user/CreateEnd")
public class UserCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserCreateEndServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("create_id");
		String pw = request.getParameter("create_pw");
		String birth = request.getParameter("create_birth");
		String name = request.getParameter("create_name");
		String address = request.getParameter("create_address");
		String address_detail = request.getParameter("address_detail");
		String email = request.getParameter("create_email");
		String mobile = request.getParameter("create_mobile");
		String phone = request.getParameter("create_phone");
		
		
		User u = new User();
		u.setUser_id(id);
		u.setUser_pw(pw);
		u.setUser_birth(birth);
		u.setUser_name(name);
		u.setUser_address(address);
		u.setUser_address_detail(address_detail);
		u.setUser_email(email);
		u.setUser_mobile(mobile);
		u.setUser_phone(phone);
		
		System.out.println(u.toString());
		int result = new UserService().createUser(u);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/create_user_fail.jsp");
		if(result > 0) {
			view = request.getRequestDispatcher("/views/user/create_user_success.jsp");
			}
			view.forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
