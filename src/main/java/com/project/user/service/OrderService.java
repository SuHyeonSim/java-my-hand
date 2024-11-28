package com.project.user.service;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.project.user.dao.OrderDao;

public class OrderService {
	

	
	public int cancelPoint(int userNo, int cancelAmount, String reason, String orderNo) {
		Connection conn = getConnection();
		int result = new OrderDao().cancelPoint(userNo, cancelAmount, reason, orderNo, conn);
		close(conn);
		return result;
	}
	
	public static void deleteCartItems (int user_no, int[] prodNos) {
		Connection conn = getConnection();
		OrderDao.deleteCartItems(user_no, prodNos, conn);
		close(conn);
	}
	
	public static int OrderProcess(int user_no, int totalPrice, int ship_no, int[] prodNos, int[] prodQuantities, String order_comment, String order_no, String reason, int minusPoint) {
		Connection conn = getConnection();
		int result = new OrderDao().OrderProcess(user_no, totalPrice, ship_no, prodNos, prodQuantities, order_comment, order_no, reason, minusPoint, conn);
		close(conn);
		return result;
	}
}