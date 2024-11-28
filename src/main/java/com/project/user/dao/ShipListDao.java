package com.project.user.dao;

import static com.project.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.user.vo.ShipList;
import com.project.user.vo.User;

public class ShipListDao {
	
	public int deleteShipList(ShipList s, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE shiplist SET status = 'N' WHERE ship_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getShip_no());
			System.out.println("머여 업데이트임");
            result = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int updateShipList(ShipList s, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
				String sql = "UPDATE shiplist SET ship_alias = ?, ship_name = ?, ship_phone = ?, ship_address1 = ?, ship_address2 = ?, front_door_pw = ? WHERE user_no = ? AND ship_no = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, s.getShip_alias());
	            pstmt.setString(2, s.getShip_name());
	            pstmt.setString(3, s.getShip_phone());
	            pstmt.setString(4, s.getShip_address1());
	            pstmt.setString(5, s.getShip_address2());
	            pstmt.setString(6, s.getFront_door_pw());
	            pstmt.setInt(7, s.getUser_no());
	            pstmt.setInt(8, s.getShip_no());

	            result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		}
	
	
	
	public List<ShipList> choiseList(int userNo, String shipNo, Connection conn) {
		
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<ShipList> list = new ArrayList<ShipList>();
	    try {

	        String sql = "SELECT * FROM shiplist WHERE user_no = ? AND ship_no = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, userNo);
	        pstmt.setString(2, shipNo);

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	ShipList ship = new ShipList();
	        	ship.setShip_no(rs.getInt("ship_no"));
	        	ship.setUser_no(rs.getInt("user_no"));
	        	ship.setShip_alias(rs.getString("ship_alias"));
	        	ship.setShip_name(rs.getString("ship_name"));
	        	ship.setShip_phone(rs.getString("ship_phone"));
	        	ship.setShip_address1(rs.getString("ship_address1"));
	        	ship.setShip_address2(rs.getString("ship_address2"));
	        	ship.setFront_door_pw(rs.getString("front_door_pw"));
	        	list.add(ship);
	            
	        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		            close(rs);
		            close(pstmt);
		    }
			
			return list;
			
			
		}
	
	
	
	
	public List<ShipList> selectShipList(int userNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShipList> list = new ArrayList<ShipList>();
		
		try {
			String sql = "SELECT * FROM shiplist WHERE user_no = ? AND status = 'Y' ";

			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, userNo);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
		        ShipList ship = new ShipList();
		        ship.setShip_no(rs.getInt("ship_no"));
		        ship.setUser_no(rs.getInt("user_no"));
		        ship.setShip_alias(rs.getString("ship_alias"));
		        ship.setShip_name(rs.getString("ship_name"));
		        ship.setShip_phone(rs.getString("ship_phone"));
		        ship.setShip_address1(rs.getString("ship_address1"));
		        ship.setShip_address2(rs.getString("ship_address2"));
		        ship.setFront_door_pw(rs.getString("front_door_pw"));
		        list.add(ship);
	        }
		} catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	        	close(rs);
				close(pstmt);
			}
	    return list;
	}
	
	

	public int createShipList(ShipList s, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			String sql = "INSERT INTO shiplist (user_no, ship_alias, ship_name, ship_phone, ship_address1, ship_address2, front_door_pw) VALUES(?,?,?,?,?,?, ?)";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getUser_no());
			pstmt.setString(2, s.getShip_alias());
			pstmt.setString(3, s.getShip_name());
			pstmt.setString(4, s.getShip_phone());
			pstmt.setString(5, s.getShip_address1());
			pstmt.setString(6, s.getShip_address2());
			pstmt.setString(7, s.getFront_door_pw());
			
			result = pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

}
