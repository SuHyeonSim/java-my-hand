package com.project.user.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.UserService;
import com.project.user.vo.User;


@WebServlet("/deleteEnd")
public class UserDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDeleteEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userNo = user.getUser_no();
        System.out.println(userNo);
        int result = new UserService().deleteUser(userNo);
        if (result > 0) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("message", "회원 탈퇴에 실패했습니다.");
            request.getRequestDispatcher("/views/user/user_delete.jsp").forward(request, response);
        }
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
