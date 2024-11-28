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

@WebServlet("/user/CheckDuplicateId")
public class UserDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UserDuplicateServlet() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("create_id");
        System.out.println(userId);

        User isDuplicateUser = new UserService().checkDuplicateUserId(userId);
        
        String result;
        if (isDuplicateUser != null) {
            result = "duplicate";
        } else {
            result = "available";
        }

        response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(result);
    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
