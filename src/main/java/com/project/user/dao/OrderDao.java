package com.project.user.dao;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.rollback;
import static com.project.common.sql.JDBCTemplate.close;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao {
	
	public int cancelPoint(int userNo, int cancelAmount, String reason, String orderNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE `user` SET user_point = user_point + ? WHERE user_no = ?";
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cancelAmount);
			pstmt.setInt(2, userNo);
			result = pstmt.executeUpdate();
	
	        if(result > 0) {
	            String sq2 = "UPDATE `buy` SET order_status = '결제 취소' WHERE order_no = ? AND order_status = '발송 대기중'";
	            pstmt = conn.prepareStatement(sq2);
	            pstmt.setString(1, orderNo);
	            result = pstmt.executeUpdate();
            
	            if(result > 0) {
	            	String sq3 = "INSERT INTO point (user_no, point_reason, point_change) VALUES (?,?,?)";
	                pstmt = conn.prepareStatement(sq3);
	                
	                pstmt.setInt(1, userNo);
	                pstmt.setString(2, reason);
	                pstmt.setInt(3, cancelAmount);
	                result = pstmt.executeUpdate();
	            }
	        } else {
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
	
	
    public static void deleteCartItems(int user_no, int[] prodNos, Connection conn) {
        PreparedStatement pstmt = null;
        try {
            String sqlDelete = "DELETE FROM cart WHERE user_no = ? AND prod_no = ?";
            pstmt = conn.prepareStatement(sqlDelete);
            
            for (int prodNo : prodNos) {
            	pstmt.setInt(1, user_no);
            	pstmt.setInt(2, prodNo);
            	pstmt.addBatch();
            }
            
            pstmt.executeBatch();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
            close(pstmt);
        }
    }

	
	public int OrderProcess(int user_no, int totalPrice, int ship_no, int[] prodNos, int[] prodQuantities, String order_comment, String order_no, String reason, int minusPoint, Connection conn) {
        PreparedStatement psBuy = null;
        PreparedStatement psOrderList = null;
        PreparedStatement psUpdateUser = null;
		PreparedStatement pspoint = null;
        int result = 0;

        try {
            conn.setAutoCommit(false);

            String sqlBuy = "INSERT INTO buy (order_no, ship_no, user_no, order_comment) VALUES (?, ?, ?, ?)";
            psBuy = conn.prepareStatement(sqlBuy);
            psBuy.setString(1, order_no);
            psBuy.setInt(2, ship_no);
            psBuy.setInt(3, user_no);
            psBuy.setString(4, order_comment);
            psBuy.executeUpdate();

            String sqlOrderList = "INSERT INTO orderlist (order_no, prod_no, order_count) VALUES (?, ?, ?)";
            psOrderList = conn.prepareStatement(sqlOrderList);
            for (int i = 0; i < prodNos.length; i++) {
            	psOrderList.setString(1, order_no);
                psOrderList.setInt(2, prodNos[i]);
                psOrderList.setInt(3, prodQuantities[i]);
                psOrderList.addBatch();
            }
            psOrderList.executeBatch();

            String sqlUpdateUser = "UPDATE user SET user_point = user_point - ? WHERE user_no = ? AND user_point >= ?";
            psUpdateUser = conn.prepareStatement(sqlUpdateUser);
            psUpdateUser.setInt(1, minusPoint);
            psUpdateUser.setInt(2, user_no);
            psUpdateUser.setInt(3, minusPoint);
            result = psUpdateUser.executeUpdate();
            
            if (result == 0) {
                throw new SQLException("포인트가 부족합니다.");
            }
            
            String sqlInsertPointList = "INSERT INTO point (user_no, point_reason, point_change) VALUES (?,?,?)";
            pspoint = conn.prepareStatement(sqlInsertPointList);
            
            pspoint.setInt(1, user_no);
            pspoint.setString(2, reason);
            pspoint.setInt(3, minusPoint);
            result = pspoint.executeUpdate();
            
            conn.commit();
            
        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            close(psBuy);
            close(psOrderList);
            close(psUpdateUser);
        }
        return result;
	}
}