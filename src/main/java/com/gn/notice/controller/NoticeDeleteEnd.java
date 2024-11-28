package com.gn.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.notice.service.NoticeService;


@WebServlet("/notice_admin/notice_deleteEnd")
public class NoticeDeleteEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeDeleteEnd() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("notice_no"));
		int result = new NoticeService().deleteNotice(noticeNo);
		RequestDispatcher view = request.getRequestDispatcher("/notice_admin/notice_list");
		if(result > 0) {
			view = request.getRequestDispatcher("/notice_admin/notice_list");
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
