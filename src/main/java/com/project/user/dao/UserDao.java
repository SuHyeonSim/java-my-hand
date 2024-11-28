package com.project.user.dao;

import static com.project.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.project.user.vo.Point;
import com.project.user.vo.Review;
import com.project.user.vo.User;

public class UserDao {
    
    public int addUser(User u, Connection conn) {
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            String sql = "INSERT INTO user (user_id, user_pw, user_birth, user_name, user_address, user_address_detail, user_email, user_mobile, user_phone) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getUser_id());
            pstmt.setString(2, u.getUser_pw());
            pstmt.setString(3, u.getUser_birth());
            pstmt.setString(4, u.getUser_name());
            pstmt.setString(5, u.getUser_address());
            pstmt.setString(6, u.getUser_address_detail());
            pstmt.setString(7, u.getUser_email());
            pstmt.setString(8, u.getUser_mobile());
            pstmt.setString(9, u.getUser_phone());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    public User loginUser(User u, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User result = null;
        
        try {
            String sql = "SELECT * FROM user WHERE user_id = ? AND user_pw = ? AND user_delete = 'N'";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getUser_id());
            pstmt.setString(2, u.getUser_pw());
            
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = new User();
            	result.setUser_no(rs.getInt("user_no"));
            	result.setUser_id(rs.getString("user_id"));
            	result.setUser_pw(rs.getString("user_pw"));
            	result.setUser_birth(rs.getString("user_birth"));
            	result.setUser_name(rs.getString("user_name"));
            	result.setUser_address(rs.getString("user_address"));
            	result.setUser_address_detail(rs.getString("user_address_detail"));
            	result.setUser_email(rs.getString("user_email"));
            	result.setUser_mobile(rs.getString("user_mobile"));
            	result.setUser_phone(rs.getString("user_phone"));
            	Timestamp userDateTimestamp = rs.getTimestamp("user_date");
            	result.setUser_point(rs.getInt("user_point"));
            	
            	if (userDateTimestamp != null) {
            	    result.setUser_date(userDateTimestamp.toLocalDateTime());
            	}
            	result.setUser_delete(rs.getString("user_delete"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        
        return result;
    }
    
    public User checkDuplicateUserId(String userId, Connection conn) {
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE user_id = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setUser_id(rs.getString("user_id"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
            
        }
        
        return user;
    }

    public List<Point> getPointHistory(int userNo, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Point> pointHistory = new ArrayList<>();
        String sql = "SELECT point_no, user_no, point_reason, point_change, point_date FROM point WHERE user_no = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Point point = new Point();
                point.setPointNo(rs.getInt("point_no"));
                point.setUserNo(rs.getInt("user_no"));
                point.setPointReason(rs.getString("point_reason"));
                point.setPointChange(rs.getInt("point_change"));
                point.setPointDate(rs.getString("point_date"));
                pointHistory.add(point);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return pointHistory;
    }
    public int editUser(User user, Connection conn) {
        PreparedStatement pstmt = null;
        String sql = "UPDATE user SET user_pw = ?, user_birth = ?, user_name = ?, user_address = ?, user_address_detail = ?, user_email = ?, user_mobile = ?, user_phone = ? WHERE user_no = ?";
        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_pw());
            pstmt.setString(2, user.getUser_birth());
            pstmt.setString(3, user.getUser_name());
            pstmt.setString(4, user.getUser_address());
            pstmt.setString(5, user.getUser_address_detail());
            pstmt.setString(6, user.getUser_email());
            pstmt.setString(7, user.getUser_mobile());
            pstmt.setString(8, user.getUser_phone());
            pstmt.setInt(9, user.getUser_no());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    public int deleteUser(int userNo, Connection conn) {
    	PreparedStatement pstmt = null;
    	int result = 0;
    	try {
    		String sql = "UPDATE `user` SET user_delete = 'Y' WHERE user_no = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1,userNo);
    		result = pstmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    	}return result;
    }
    public int userPoint(int userNo, Connection conn) {
    	PreparedStatement pstmt = null;
    	int result = 0;
    	ResultSet rs = null;
    	try {
    		String sql = "SELECT user_point FROM `user` WHERE user_no = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, userNo);
    		
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			result = rs.getInt("user_point");
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
    }
    
    
    public List<Review> getReviewList(int userNo, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Review> reviewList = new ArrayList<>();
        String sql = "SELECT review_no, prod_no, user_no, review_content, review_img_enroll, review_img_revise, review_date, review_star FROM user_review WHERE user_no = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Review review = new Review();
                review.setReviewNo(rs.getInt("review_no"));
                review.setProdNo(rs.getInt("prod_no"));
                review.setUserNo(rs.getInt("user_no"));
                review.setReviewContent(rs.getString("review_content"));
                review.setReviewImgEnroll(rs.getString("review_img_enroll"));
                review.setReviewImgRevise(rs.getString("review_img_revise"));
                review.setReviewDate(rs.getTimestamp("review_date"));
                review.setReviewStar(rs.getInt("review_star"));
                reviewList.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return reviewList;
    }
}





