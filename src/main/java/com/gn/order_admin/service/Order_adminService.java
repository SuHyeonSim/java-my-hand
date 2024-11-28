package com.gn.order_admin.service;
import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.gn.order_admin.dao.Order_adminDao;

public class Order_adminService {
	public List<Map<String, Object>> selectOrderList(){
		Connection conn = getConnection();
		List<Map<String, Object>> result = new Order_adminDao().selectOrderList(conn);
		close(conn);
		return result;
	}
	public List<Map<String, Object>> selectOrderInfo(String orderNo){
		Connection conn = getConnection();
		List<Map<String, Object>> result = new Order_adminDao().selectOrderInfo(orderNo, conn);
		close(conn);
		return result;
	}
	public int orderDeliveryAccept(String orderNo) {
		Connection conn = getConnection();
		int result = new Order_adminDao().orderDeliveryAccept(orderNo, conn);
		close(conn);
		return result;
	}
	public int orderDeliveryComplete(String orderNo) {
		Connection conn = getConnection();
		int result = new Order_adminDao().orderDeliveryComplete(orderNo, conn);
		close(conn);
		return result;
	}
	public List<Map<String, Object>> userOrderList(int userNo){
		Connection conn = getConnection();
		List<Map<String, Object>> result = new Order_adminDao().userOrderList(userNo, conn);
		close(conn);
		return result;
	}
}
