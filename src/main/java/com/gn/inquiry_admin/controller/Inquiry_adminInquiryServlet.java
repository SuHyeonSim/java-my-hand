package com.gn.inquiry_admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.inquiry_admin.service.InquiryService;
import com.gn.inquiry_admin.vo.Inquiry_comment;
import com.gn.shop_user.service.Shop_userService;
import com.gn.shop_user.vo.Inquiry;

@WebServlet("/inquiry_admin/inquiry_adminInquiry")
public class Inquiry_adminInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Inquiry_adminInquiryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inquiryNo = Integer.parseInt(request.getParameter("inquiry_no"));
		Inquiry iq = new Shop_userService().infoInquiry(inquiryNo);
		List<Inquiry_comment> ic = new InquiryService().selectInquiryComment(inquiryNo);
		RequestDispatcher view = null;
		if(iq != null) {
			request.setAttribute("adminInquiryInfo", iq);
			request.setAttribute("adminInquiryCommentInfo", ic);
			view = request.getRequestDispatcher("/inquiry_admin/inquiry_adminInfo.jsp");
			view.forward(request, response);
		}else {
			System.out.println("실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
