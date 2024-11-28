package com.project.user.controller.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.UserService;
import com.project.user.vo.Point;
import com.project.user.vo.User;

@WebServlet("/MyPage/PointHistory")
public class MyPagePointHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyPagePointHistoryServlet() {
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
        int userPoint = new UserService().userPoint(userNo);
        UserService userService = new UserService();
        List<Point> pointHistory = userService.getPointHistory(userNo);
        request.setAttribute("userPoint", userPoint);
        request.setAttribute("pointHistory", pointHistory);
        request.getRequestDispatcher("/views/mypage/mypage_point.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}