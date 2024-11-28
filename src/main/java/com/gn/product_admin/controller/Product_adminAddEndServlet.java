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

@WebServlet("/product_admin/product_addEnd")
public class Product_adminAddEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Product_adminAddEndServlet() {
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
			String productName = mr.getParameter("product_name");
			int productInventory = Integer.parseInt(mr.getParameter("product_inventory"));
			int productPrice = Integer.parseInt(mr.getParameter("product_price"));
			int productCate = Integer.parseInt(mr.getParameter("product_category"));
			String productInfo = mr.getParameter("product_info");
			
			Product_admin pAdd = new Product_admin();
			pAdd.setProd_enroll_image(enrollName);
			pAdd.setProd_revise_image(reviseName);
			pAdd.setProd_name(productName);
			pAdd.setProd_price(productPrice);
			pAdd.setProd_inventory(productInventory);
			pAdd.setCate_no(productCate);
			pAdd.setProd_info(productInfo);
			
			int result = new Product_adminService().createProduct(pAdd);
			RequestDispatcher view = request.getRequestDispatcher("/product_admin/product_fail.jsp");
			if(result > 0) {
				view = request.getRequestDispatcher("/product_admin/product_success.jsp");
				view.forward(request, response);
			}
			view.forward(request, response);
		}
		else {
			response.sendRedirect("/product_admin/product_add");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
