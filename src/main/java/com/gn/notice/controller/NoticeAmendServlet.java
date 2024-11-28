package com.gn.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.notice.service.NoticeService;
import com.gn.notice.vo.Notice;


@WebServlet("/notice/amend")
public class NoticeAmendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NoticeAmendServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		RequestDispatcher view = null;
		
		Notice notice = new NoticeService().selectUpdateInfo(notice_no);
	
		request.setAttribute("noticeInfo", notice);
		if(notice != null) {
			view = request.getRequestDispatcher("/notice_admin/notice_amend.jsp");
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("/notice_admin/notice_fail.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
    
	
}
