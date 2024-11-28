package com.gn.inquiry_admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.inquiry_admin.service.InquiryService;
import com.gn.inquiry_admin.vo.Inquiry_comment;
import com.gn.shop_user.vo.Inquiry;

@WebServlet("/inquiry_admin/inquiry_adminInquiryEnd")
public class Inquiry_adminInquiryEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Inquiry_adminInquiryEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("inquiry_comment");
		int inquiryNo = Integer.parseInt(request.getParameter("inquiry_no"));
		Inquiry_comment ic = new Inquiry_comment();
		ic.setComment_content(comment);
		ic.setInquiry_no(inquiryNo);
		int result = new InquiryService().inquiryCommentInsert(ic);
		
		RequestDispatcher view = request.getRequestDispatcher("/product_admin/product_fail.jsp");
		if(result > 0) {
			view = request.getRequestDispatcher("/product_admin/product_success.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
