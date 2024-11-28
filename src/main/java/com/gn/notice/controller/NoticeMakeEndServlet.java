package com.gn.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gn.notice.service.NoticeService;
import com.gn.notice.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@WebServlet("/notice_admin/notice_makeEnd")
public class NoticeMakeEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public NoticeMakeEndServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {			
			String dir = request.getServletContext().getRealPath("/upload");			
			int maxSize = 1024 * 1024 * 10;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
			MultipartRequest mr 
			= new MultipartRequest(request,dir,maxSize,encoding,dfr);
			String oriName = mr.getOriginalFileName("notice_img");
			String reName = mr.getFilesystemName("notice_img");
			String title = mr.getParameter("notice_title");
			String content = mr.getParameter("notice_content");
			
			Notice n = new Notice();
			n.setNotice_title(title);
			n.setNotice_content(content);
			n.setNotice_img_enroll(oriName);
			n.setNotice_img_revise(reName);
			
	
			int result = new NoticeService().createNotice(n);
			RequestDispatcher view = request.getRequestDispatcher("/notice_admin/notice_make_fail.jsp");
			if(result > 0) {
				view = request.getRequestDispatcher("/notice_admin/notice_list");
			}
			view.forward(request, response);
		} else {
			response.sendRedirect("/notice_admin/notice_list");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

