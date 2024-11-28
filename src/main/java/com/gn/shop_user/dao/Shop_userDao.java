package com.gn.shop_user.dao;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gn.shop_user.vo.Inquiry;

public class Shop_userDao {
	public List<Inquiry> selectInquiryList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Inquiry> list = new ArrayList<Inquiry>();
		try {
			String sql = "SELECT * FROM `user` u JOIN `inquiry` i ON u.user_no = i.inquiry_writer";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Inquiry resultVo = new Inquiry(
						rs.getInt("inquiry_no"),
						rs.getInt("inquiry_writer"),
						rs.getString("inquiry_title"),
						rs.getString("inquiry_content"),
						rs.getTimestamp("inquiry_reg_date").toLocalDateTime(),
						rs.getTimestamp("inquiry_mod_date").toLocalDateTime(),
						rs.getString("inquiry_img_reg"),
						rs.getString("inquiry_img_mod"),
						rs.getString("inquiry_delete"),
						rs.getString("user_name"),
						rs.getInt("user_no"));
				list.add(resultVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	public Inquiry infoInquiry(int inquiryNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Inquiry iq = new Inquiry();
		try {
			String sql = "SELECT * FROM `user` u JOIN `inquiry` i ON u.user_no = i.inquiry_writer WHERE i.inquiry_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inquiryNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				iq.setInquiry_no(rs.getInt("inquiry_no"));
				iq.setInquiry_writer(rs.getInt("inquiry_writer"));
				iq.setInquiry_title(rs.getString("inquiry_title"));
				iq.setInquiry_content(rs.getString("inquiry_content"));
				iq.setInquiry_reg_date(rs.getTimestamp("inquiry_reg_date").toLocalDateTime());
				iq.setInquiry_mod_date(rs.getTimestamp("inquiry_mod_date").toLocalDateTime());
				iq.setInquiry_img_reg(rs.getString("inquiry_img_reg"));
				iq.setInquiry_img_mod(rs.getString("inquiry_img_mod"));
				iq.setInquiry_delete(rs.getString("inquiry_delete"));
				iq.setWriter_name(rs.getString("user_name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return iq;
	}
}
