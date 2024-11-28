package com.project.user.service;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.user.dao.CartListDao;
import com.project.user.vo.Cart;


public class CartService {
	
	public static void updateCartItemQuantity(int productNo, int updatedQuantity) {
		Connection conn = getConnection();
		new CartListDao().updateCartItemQuantity(productNo, updatedQuantity, conn);
		close(conn);
	}

    public Cart getCartItem(int userNo, int productNo) {
    	Connection conn = getConnection();
		Cart result = new CartListDao().getCartItem(userNo, productNo, conn);
		close(conn);
		return result;
    }

	
	public static int createCartList(Cart cart) {
		Connection conn = getConnection();
		int result = new CartListDao().createCartList(cart, conn);
		close(conn);
		return result;
	}


	public int deletePartial(int userNo, String prodNo) {
		Connection conn = getConnection();
		int result = new CartListDao().deletePartial(userNo, prodNo, conn);
		close(conn);
		return result;
	}
	
	
	
	public int deleteAll(int userNo) {
		Connection conn = getConnection();
		int result = new CartListDao().deleteAll(userNo, conn);
		close(conn);
		return result;
	}
	
	
	
	public int updateCartQuantity(int userNo, int prodNo, int cartQuantity) {
		Connection conn = getConnection();
		int result = new CartListDao().updateCartList(userNo, prodNo, cartQuantity, conn);
		close(conn);
		return result;
		
	}
	
	
	
	public List<Cart> listCart(int userNo) {
		Connection conn = getConnection();
		List<Cart> list = new CartListDao().selectCartList(userNo, conn);
		close(conn);
		return list;
	}



}
