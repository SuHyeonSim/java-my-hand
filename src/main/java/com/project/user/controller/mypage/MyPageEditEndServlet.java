package com.project.user.controller.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.UserService;
import com.project.user.vo.User;

@WebServlet(name="userEditEnd", urlPatterns="/MyPage/EditEnd")
public class MyPageEditEndServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyPageEditEndServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        int userNo = 0;
        if (session != null) {
            User user = (User) session.getAttribute("user");
            userNo = user.getUser_no();
        }

        String newUserPw = request.getParameter("new_user_pw");
        String confirmUserPw = request.getParameter("confirm_user_pw");
        String userBirth = request.getParameter("user_birth");
        String userName = request.getParameter("user_name");
        String userAddress = request.getParameter("user_address");
        String userAddressDetail = request.getParameter("user_address_detail");
        String userEmail = request.getParameter("user_email");
        String userMobile = request.getParameter("user_mobile");
        String userPhone = request.getParameter("user_phone");

        if (!newUserPw.equals(confirmUserPw)) {
            request.setAttribute("message", "비밀번호 확인이 일치하지 않습니다.");
            request.getRequestDispatcher("/views/mypage/mypage_edit.jsp").forward(request, response);
            return;
        }

        User u = new User();
        u.setUser_no(userNo);
        u.setUser_pw(newUserPw);
        u.setUser_birth(userBirth);
        u.setUser_name(userName);
        u.setUser_address(userAddress);
        u.setUser_address_detail(userAddressDetail);
        u.setUser_email(userEmail);
        u.setUser_mobile(userMobile);
        u.setUser_phone(userPhone);

        UserService userService = new UserService();
        int result = userService.editUser(u);

        if (result > 0) {
            session.setAttribute("user", u);
            response.sendRedirect(request.getContextPath() + "/views/mypage/mypage_edit.jsp");
        } else {
            request.setAttribute("message", "회원 정보 업데이트에 실패했습니다.");
            RequestDispatcher view = request.getRequestDispatcher("/views/mypage/mypage_edit.jsp");
            view.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
