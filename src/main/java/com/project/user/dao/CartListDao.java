package com.project.user.dao;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.user.vo.Cart;

public class CartListDao {
	
	 public void updateCartItemQuantity(int prodNo, int quantity, Connection conn) {
	        PreparedStatement pstmt = null;
	        
	        try {
	            String sql = "UPDATE cart SET cart_quantity = ? WHERE prod_no = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, quantity);
	            pstmt.setInt(2, prodNo);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
				close(pstmt);
			}
	    }
	        
	
    public Cart getCartItem(int userNo, int productNo, Connection conn) {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
        Cart cartItem = null;
        
        try {
            String sql = "SELECT * FROM cart WHERE user_no = ? AND prod_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            pstmt.setInt(2, productNo);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                cartItem = new Cart();
                cartItem.setUser_no(rs.getInt("user_no"));
                cartItem.setProd_no(rs.getInt("prod_no"));
                cartItem.setCart_quantity(rs.getInt("cart_quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
        
        return cartItem;
    }
	
	
	
	public int createCartList(Cart cart, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
		try {
		  String sql = "INSERT INTO cart (user_no, prod_no, cart_quantity) VALUES (?, ?, ?)";
		
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, cart.getUser_no());
	      pstmt.setInt(2, cart.getProd_no());
	      pstmt.setInt(3, cart.getCart_quantity());
	
	      result = pstmt.executeUpdate();
	
		  } catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  close(pstmt);
		  }
		  return result;
	
		  }


	public int deletePartial(int userNo, String prodNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM cart WHERE user_no = ? AND prod_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
            pstmt.setString(2, prodNo);
			
            result = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	public int deleteAll(int userNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM cart WHERE user_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
            result = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	
	public int updateCartList(int userNo, int prodNo, int cartQuantity, Connection conn){
		PreparedStatement pstmt = null;
		int result = 0;
        try {
        	String SQL = "UPDATE cart SET cart_quantity = ? WHERE user_no = ? AND prod_no = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, cartQuantity);
            pstmt.setInt(2, userNo);
            pstmt.setInt(3, prodNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			close(pstmt);
		}
        return result;
    }

	
	public List<Cart> selectCartList(int userNo, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Cart> list = new ArrayList<Cart>();
		
		try {
			String sql = "SELECT c.user_no, p.prod_no, p.prod_revise_image, p.prod_name, p.prod_price, p.prod_inventory, c.cart_quantity "
	                   + "FROM `cart` c "
	                   + "JOIN `product` p ON c.prod_no = p.prod_no "
	                   + "WHERE c.user_no = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, userNo);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
		        Cart c = new Cart();
		        c.setUser_no(rs.getInt("c.user_no"));
		        c.setProd_no(rs.getInt("p.prod_no"));
		        c.setProd_image(rs.getString("p.prod_revise_image"));
		        c.setProd_name(rs.getString("p.prod_name"));
		        c.setProd_price(rs.getInt("p.prod_price"));
		        c.setProd_inventory(rs.getInt("p.prod_inventory"));
		        c.setCart_quantity(rs.getInt("c.cart_quantity"));
		        
		        list.add(c);
	        }
		} catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	        	close(rs);
				close(pstmt);
			}
		
		
		return list;
	}



}
