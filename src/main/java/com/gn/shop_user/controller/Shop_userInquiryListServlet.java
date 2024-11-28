package com.gn.shop_user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.inquiry_admin.service.InquiryService;
import com.gn.shop_user.service.Shop_userService;
import com.gn.shop_user.vo.Inquiry;

@WebServlet("/shop_user/inquiryList")
public class Shop_userInquiryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Shop_userInquiryListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Inquiry> list = new Shop_userService().selelctInquiryList();
        System.out.println(list.toString());
        request.setAttribute("resultInquiryList", list);
        RequestDispatcher view = null;
           view = request.getRequestDispatcher("/views/user/inquiryList.jsp");
           view.forward(request, response);
     }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
