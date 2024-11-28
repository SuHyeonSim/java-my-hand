package com.project.user.controller.user;

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

@WebServlet(name="userLoginEnd",urlPatterns = "/user/loginEnd")
public class UserLoginEndServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public UserLoginEndServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("user_id");
        String pwd = request.getParameter("user_pw");

        User u = new User();
        u.setUser_id(id);
        u.setUser_pw(pwd);

        User result = new UserService().loginUser(u);

        if (result != null) {
            if (result.getUser_id().equals("admin")) {
                response.sendRedirect("/product_admin/product_listSellCount");
                return;
            }
            HttpSession session = request.getSession(true);
            if (session.isNew() || session.getAttribute("user") == null) {
                session.setAttribute("user", result);
                session.setMaxInactiveInterval(60 * 30);
            }
            response.sendRedirect("../index.jsp");
        } else {
            RequestDispatcher view = request.getRequestDispatcher("/views/user/login_fail.jsp");
            view.forward(request, response);
        }
    }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
