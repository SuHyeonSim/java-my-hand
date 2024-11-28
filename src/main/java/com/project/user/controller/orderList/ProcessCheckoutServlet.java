package com.project.user.controller.orderList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.service.OrderService;
import com.project.user.vo.User;


@WebServlet("/order/processCheckOut")
public class ProcessCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProcessCheckoutServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        request.setCharacterEncoding("UTF-8");

	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");
	        if (user == null) {
	            response.sendRedirect("/views/user/login.jsp");
	            return;
	        }

	        int user_no = user.getUser_no();
	        System.out.println(user_no);
	        int ship_no = Integer.parseInt(request.getParameter("ship_no"));

	        // 쉼표로 구분된 문자열을 배열로 변환
	        String[] prodNosStr = request.getParameter("prodNos").split(",");
	        String[] prodQuantitiesStr = request.getParameter("prodQuantity").split(",");

	        int[] prodNos = new int[prodNosStr.length];
	        int[] prodQuantities = new int[prodQuantitiesStr.length];

	        for (int i = 0; i < prodNosStr.length; i++) {
	            prodNos[i] = Integer.parseInt(prodNosStr[i].trim()); // 문자열을 정수로 변환
	            prodQuantities[i] = Integer.parseInt(prodQuantitiesStr[i].trim()); // 문자열을 정수로 변환
	        }

	        String order_comment = request.getParameter("order_comment");
	        String order_no = generateOrderNo();  // orderNo 설정한 메소드 가져오기

	        int finalAmount = Integer.parseInt(request.getParameter("finalAmount"));

	        int usePoint  = Integer.parseInt(request.getParameter("usePoint"));
	        int minusPoint = -usePoint;
	        

	        int result = OrderService.OrderProcess(user_no, finalAmount, ship_no, prodNos, prodQuantities, order_comment, order_no, "상품 구매", minusPoint);
	        if (result > 0) {
	            OrderService.deleteCartItems(user_no, prodNos);
	        } else {
	            throw new Exception("주문 처리에 실패했습니다.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	    private String generateOrderNo() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMdd-HHmmss");
	        return sdf.format(new Date()) + (int)(Math.random() * 1000);
	    }


}