package com.gn.inquiry_admin.dao;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gn.inquiry_admin.vo.Inquiry_comment;
import com.gn.shop_user.vo.Inquiry;

public class InquiryDao {
	public int createInquiry(Inquiry iq, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO inquiry (inquiry_writer, inquiry_title, inquiry_content, inquiry_img_reg, inquiry_img_mod)"
			+ " SELECT u.user_no, ?, ?, ?, ?"
			+ " FROM `user` u" 
			+ " WHERE u.user_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, iq.getInquiry_title());
			pstmt.setString(2, iq.getInquiry_content());
			pstmt.setString(3, iq.getInquiry_img_reg());
			pstmt.setString(4, iq.getInquiry_img_mod());
			pstmt.setString(5, iq.getWriter_name());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	public int inquiryCommentInsert(Inquiry_comment ic, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO `inquiry_comment` (inquiry_no, comment_content) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ic.getInquiry_no());
			pstmt.setString(2, ic.getComment_content());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	public List<Inquiry_comment> selectInquiryComment(int inquiryNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Inquiry_comment> result = new ArrayList<Inquiry_comment>();
		try {
			String sql = "SELECT * FROM `inquiry_comment` WHERE inquiry_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inquiryNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Inquiry_comment resultVo = new Inquiry_comment(
						rs.getInt("inquiry_no"),
						rs.getString("comment_content"),
						rs.getTimestamp("comment_reg_date").toLocalDateTime(),
						rs.getTimestamp("comment_mod_date").toLocalDateTime()
						);
				result.add(resultVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public int selectInquiryCount(Inquiry option, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(*) AS cnt FROM inquiry";
			if(option.getInquiry_title() != null) {
				sql += "WHERE inquiry_title LIKE CONCAT('%','"+option.getInquiry_title()+"','%')";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
}
