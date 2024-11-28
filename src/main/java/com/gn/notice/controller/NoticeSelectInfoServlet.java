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

@WebServlet("/notice/noticeSelectInfo")
public class NoticeSelectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeSelectInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("notice_no"));
		
		Notice result = new NoticeService().selectNoticeInfo(noticeNo);
		RequestDispatcher view = null;
		request.setAttribute("noticeInfo", result);
		view = request.getRequestDispatcher("/views/user/noticeInfo.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
