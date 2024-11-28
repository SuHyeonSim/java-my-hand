package com.gn.order_admin.dao;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order_adminDao {
	public List<Map<String, Object>> selectOrderList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		try {
			String sql = "SELECT b.order_no, b.ship_no, b.user_no, s.ship_name, u.user_name, b.order_comment, b.order_date, b.order_status";
			sql += " FROM buy b";
			sql += " JOIN (";
			sql += " SELECT DISTINCT order_no";
			sql += " FROM orderlist";
			sql += " ) ol ON b.order_no = ol.order_no";
			sql += " JOIN shiplist s ON b.ship_no = s.ship_no";
			sql += " JOIN `user` u ON b.user_no = u.user_no";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> info = new HashMap<>();
				info.put("주문번호", rs.getString("order_no"));
				info.put("회원명", rs.getString("u.user_name"));
				info.put("수취인", rs.getString("s.ship_name"));
				info.put("주문일자", rs.getTimestamp("order_date").toLocalDateTime());
				info.put("주문상태", rs.getString("order_status"));
				result.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public List<Map<String, Object>> userOrderList(int userNo, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		try {
			String sql = "SELECT b.order_no, b.ship_no, b.user_no, s.ship_name, u.user_name, b.order_comment, b.order_date, b.order_status";
			sql += " FROM buy b";
			sql += " JOIN (";
			sql += " SELECT DISTINCT order_no";
			sql += " FROM orderlist";
			sql += " ) ol ON b.order_no = ol.order_no";
			sql += " JOIN shiplist s ON b.ship_no = s.ship_no";
			sql += " JOIN `user` u ON b.user_no = u.user_no";
			sql += " WHERE u.user_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> info = new HashMap<>();
				info.put("주문번호", rs.getString("order_no"));
				info.put("회원명", rs.getString("u.user_name"));
				info.put("수취인", rs.getString("s.ship_name"));
				info.put("주문일자", rs.getTimestamp("order_date").toLocalDateTime());
				info.put("주문상태", rs.getString("order_status"));
				result.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public List<Map<String, Object>> selectOrderInfo(String orderNo, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		try {
			String sql = "SELECT * FROM `user` u";
			sql += " JOIN buy b ON b.user_no = u.user_no";
			sql += " JOIN shiplist sl ON sl.ship_no = b.ship_no AND sl.user_no = u.user_no";
			sql += " JOIN orderlist ol ON ol.order_no = b.order_no";
			sql += " JOIN product p ON ol.prod_no = p.prod_no";
			sql += " JOIN category c ON p.cate_no = c.cate_no";
			sql += " WHERE b.order_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> info = new HashMap<>();
				info.put("상품명", rs.getString("p.prod_name"));
				info.put("상품가격", rs.getInt("p.prod_price"));
				info.put("구매수량", rs.getInt("ol.order_count"));
				info.put("배송지 주소", rs.getString("sl.ship_address1"));
				info.put("공동현관 비밀번호", rs.getString("sl.front_door_pw"));
				info.put("요청사항", rs.getString("b.order_comment"));
				info.put("주문번호", rs.getString("b.order_no"));
				
				result.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public int orderDeliveryAccept(String orderNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql1 = "UPDATE product p JOIN orderlist ol ON ol.prod_no = p.prod_no";
			conn.setAutoCommit(false);
			sql1 += " JOIN buy b ON b.order_no = ol.order_no";
			sql1 += " SET p.prod_inventory = p.prod_inventory - ol.order_count,";
			sql1 += " p.prod_sellCount = p.prod_sellCount + ol.order_count";
			sql1 += " WHERE b.order_no = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, orderNo);
			result = pstmt.executeUpdate();
			if(result > 0) {
				String sql2 = "UPDATE buy";
				sql2 += " SET order_status = '발송중'";
				sql2 += " WHERE order_no = ? AND order_status = '발송 대기중'";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, orderNo);
				result = pstmt.executeUpdate();
			}else {
				result = 0;
			}
			conn.commit();
		}catch (Exception e1) {
			e1.printStackTrace();
		}try {
			conn.rollback();
		}catch (SQLException e2) {
			e2.printStackTrace();
		}
		finally {
			close(pstmt);
		}return result;
	}
	
	public int orderDeliveryComplete(String orderNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE buy SET order_status = '배송완료' WHERE order_no = ? AND order_status = '발송중'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
}
