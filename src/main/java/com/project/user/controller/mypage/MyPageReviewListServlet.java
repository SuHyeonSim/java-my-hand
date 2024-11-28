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
import com.project.user.vo.Review;
import com.project.user.vo.User;

@WebServlet("/MyPage/ReviewList")
public class MyPageReviewListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyPageReviewListServlet() {
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

        UserService reviewService = new UserService();
        List<Review> reviewList = reviewService.getReviewList(userNo);

        request.setAttribute("reviewList", reviewList);
        request.getRequestDispatcher("/views/mypage/mypage_review.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
