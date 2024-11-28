package com.project.user.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.vo.User;
import com.project.user.service.UserService;

@WebServlet("/MyPage/CheckPassword")
public class UserPwCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserPwCheckServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String inputPassword = request.getParameter("password");
        String userPassword = user.getUser_pw();

        UserService userService = new UserService();
//        boolean isMatch = userService.checkPassword(inputPassword, userPassword);
//
//        if (isMatch) {
//            response.sendRedirect(request.getContextPath() + "/MyPage/EditUserInfo.jsp");
//        } else {
//            response.sendRedirect(request.getContextPath() + "/MyPage/CheckPassword.jsp?error=true");
//        }
    }
}