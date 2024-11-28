package com.project.user.controller.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.inquiry_admin.service.InquiryService;
import com.gn.shop_user.vo.Inquiry;
import com.project.user.service.CartService;
import com.project.user.vo.Cart;


@WebServlet("/Cart/cartCreate")
public class CartCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartCreateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터에서 제품 번호와 수량을 가져옴
        int userNo = Integer.parseInt(request.getParameter("user_no"));
        int productNo = Integer.parseInt(request.getParameter("product_no"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Cart cart = new Cart();
        cart.setUser_no(userNo);
        cart.setProd_no(productNo);
        cart.setCart_quantity(quantity);
        System.out.println(cart.toString());
        Cart existingCartItem = new CartService().getCartItem(userNo, productNo);
        if (existingCartItem != null) {
            // 기존에 장바구니에 있는 상품이면 수량을 증가시킴
            int updatedQuantity = existingCartItem.getCart_quantity() + quantity;
            CartService.updateCartItemQuantity(productNo, updatedQuantity);
        } else {
            // 장바구니에 새로운 상품으로 추가
        	CartService.createCartList(cart);
        }
        // 한글 처리
        response.setContentType("text/html; charset=UTF-8");
        // PrintWriter를 사용하여 응답
        PrintWriter out = response.getWriter();
        // JavaScript를 이용한 confirm 창을 띄워 사용자에게 확인 여부
        out.println("<html><head><title>페이지 이동 확인</title></head><body>");
        out.println("<script>");
        out.println("if (confirm('담기 완료! 장바구니 페이지로 이동하시겠습니까?')) {");
        out.println("    window.location.href = '/Cart/cartList';");  // 확인을 선택한 경우 이동
        out.println("} else {");
        out.println("    window.location.href = '/shop/shopProduct';");  // 취소를 선택한 경우 /shop/shopProduct로 이동
        out.println("}");
        out.println("</script>");
        out.println("</body></html>");
        out.close();
    }
}
