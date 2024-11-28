package com.gn.shop_user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gn.inquiry_admin.service.InquiryService;
import com.gn.shop_user.vo.Inquiry;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/shop_user/inquiryCreateEnd")
public class Shop_userInquiryCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Shop_userInquiryCreateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			String dir = request.getServletContext().getRealPath("/upload");
			int maxSize = 1024 * 1024 * 10;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
			MultipartRequest mr = new MultipartRequest(request, dir, maxSize, encoding, dfr);
			String enrollName = mr.getOriginalFileName("inquiry_img");
			String reviseName = mr.getFilesystemName("inquiry_img");
			String title = mr.getParameter("inquiry_title");
			String content = mr.getParameter("inquiry_content");
			String userName = mr.getParameter("user_name");
			int userNo = Integer.parseInt(mr.getParameter("user_no"));
			Inquiry iq = new Inquiry();
			iq.setInquiry_img_reg(enrollName);
			iq.setInquiry_content(content);
			iq.setInquiry_img_mod(reviseName);
			iq.setWriter_name(userName);
			iq.setInquiry_title(title);
			iq.setUser_no(userNo);
			System.out.println(iq.toString());
			int result = new InquiryService().createInquiry(iq);
			RequestDispatcher view = request.getRequestDispatcher("/shop_user/inquiryList");
			if(result > 0) {
				response.sendRedirect("/shop_user/inquiryList");
			}else {
				System.out.println("실패");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
