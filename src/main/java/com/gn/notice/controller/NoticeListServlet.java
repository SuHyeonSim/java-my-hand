package com.gn.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.notice.service.NoticeService;
import com.gn.notice.vo.Notice;


@WebServlet("/notice_admin/notice_list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeListServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Notice> list = new NoticeService().selectnotice_adminList();
	      request.setAttribute("resultNoticeList", list);
	      RequestDispatcher view = null;
	         view = request.getRequestDispatcher("/notice_admin/notice_list.jsp");
	         view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
