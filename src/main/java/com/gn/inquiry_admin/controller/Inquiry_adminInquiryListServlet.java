package com.gn.inquiry_admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.shop_user.service.Shop_userService;
import com.gn.shop_user.vo.Inquiry;

@WebServlet("/inquiry_admin/inquiry_adminInquiryList")
public class Inquiry_adminInquiryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Inquiry_adminInquiryListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Inquiry> list = new Shop_userService().selelctInquiryList();
		request.setAttribute("adminInquiryList", list);
		RequestDispatcher view = null;
			view = request.getRequestDispatcher("/inquiry_admin/inquiry_adminList.jsp");
			view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
