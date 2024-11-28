package com.gn.product_admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gn.product_admin.service.Product_adminService;
import com.gn.product_admin.vo.Product_admin;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/product_admin/product_updateEnd")
public class Product_adminUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Product_adminUpdateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			String dir = request.getServletContext().getRealPath("/upload");
			int maxSize = 1024 * 1024 * 10;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
			MultipartRequest mr = new MultipartRequest(request, dir, maxSize, encoding, dfr);
			String enrollName = mr.getOriginalFileName("product_img");
			String reviseName = mr.getFilesystemName("product_img");
			int prodNo = Integer.parseInt(mr.getParameter("product_no"));
			String prodName = mr.getParameter("product_name");
			int prodPrice = Integer.parseInt(mr.getParameter("product_price"));
			String prodInfo = mr.getParameter("product_info");
			Product_admin pa = new Product_admin();
			pa.setProd_no(prodNo);
			pa.setProd_name(prodName);
			pa.setProd_price(prodPrice);
			pa.setProd_info(prodInfo);
			pa.setProd_enroll_image(enrollName);
			pa.setProd_revise_image(reviseName);
			System.out.println(pa.toString());
			int result = new Product_adminService().updateProduct(pa);
			
			if(result > 0 ) {
				RequestDispatcher view = request.getRequestDispatcher("/product_admin/product_success.jsp");
				view.forward(request, response);
				
			}
		}
		else {
			response.sendRedirect("/product_admin/product_list");
		}
		
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
