package com.gn.notice.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gn.notice.vo.Notice;

public class NoticeDao {
	public int createNotice(Notice n, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO `notice` (notice_title,notice_content,notice_img_enroll,notice_img_revise) VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_content());
			pstmt.setString(3, n.getNotice_img_enroll());
			pstmt.setString(4, n.getNotice_img_revise());
			result=pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<Notice> selectnotice_adminList(Connection conn){
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Notice> list = new ArrayList<Notice>();
	      try {
	         String sql = "SELECT * FROM `notice` WHERE notice_status = 'Y' ";
	         pstmt = conn.prepareStatement(sql );
	         rs = pstmt.executeQuery( );
	         
	         while(rs.next()) {
	        	 Notice resultVo = new Notice(
	                  rs.getInt("notice_no"),
	                  rs.getString("notice_title"),
	                  rs.getString("notice_content"),
	                  rs.getTimestamp("notice_reg_date").toLocalDateTime(),
	                  rs.getTimestamp("notice_mod_date").toLocalDateTime(),
	                  rs.getString("notice_img_enroll"),
	                  rs.getString("notice_img_revise"),
	                  rs.getString("notice_status"));

	            list.add(resultVo);
	         
	         }
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(rs);
	         close(pstmt);
	      }return list;
	   }
	
	public Notice selectUpdateInfo(Connection conn, int notice_no) {
		 PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     Notice result = new Notice();
	     try {
	    	 String sql = "SELECT * FROM `notice` WHERE notice_status = 'Y' AND notice_no = ?";
	    	 pstmt = conn.prepareStatement(sql);
	    	 pstmt.setInt(1, notice_no);
	    	 rs = pstmt.executeQuery();
	    	 
	    	 if(rs.next()) {
	    		 result.setNotice_no(rs.getInt("notice_no"));
	    		 result.setNotice_title(rs.getString("notice_title"));
	    		 result.setNotice_content( rs.getString("notice_content"));
	    		 result.setNotice_reg_date(rs.getTimestamp("notice_reg_date").toLocalDateTime());
	    		 result.setNotice_mod_date( rs.getTimestamp("notice_mod_date").toLocalDateTime());
	    		 result.setNotice_img_enroll( rs.getString("notice_img_enroll"));
	    		 result.setNotice_img_revise( rs.getString("notice_img_revise"));
	    		 result.setnotice_status( rs.getString("notice_status"));
	    		 
	    	 }
	    	 
	     } catch(Exception e) {
	    	 e.printStackTrace();
	     } finally {
	    	close(rs);
	    	close(pstmt);
	     } return result;
	}
	
	public int updateNotice(Notice n, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0; 
		try {
			String sql = "UPDATE `notice` SET notice_title = ?, notice_content = ?, notice_img_enroll = ?, notice_img_revise = ?, notice_status = 'Y'  where notice_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_content());
			pstmt.setString(3, n.getNotice_img_enroll());
			pstmt.setString(4, n.getNotice_img_revise());
		
//			pstmt.setString(5, n.getnotice_status());
			pstmt.setInt(5, n.getNotice_no());
			
			result= pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		return result;
	}
	
	public int deleteNotice(int notice_no, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0; 
		try {
			String sql = "UPDATE `notice` SET notice_status = 'N' WHERE notice_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_no);
			
			System.out.println();
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		return result;
	}
	
	public List<Notice> selelctUserList(Connection conn){
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Notice> list = new ArrayList<Notice>();
	      try {
	         String sql = "SELECT * FROM `notice` WHERE notice_status = 'Y' ";
	         pstmt = conn.prepareStatement(sql );
	         rs = pstmt.executeQuery( );
	         
	         while(rs.next()) {
	        	 Notice resultVo = new Notice(
	                  rs.getInt("notice_no"),
	                  rs.getString("notice_title"),
	                  rs.getString("notice_content"),
	                  rs.getTimestamp("notice_reg_date").toLocalDateTime(),
	                  rs.getTimestamp("notice_mod_date").toLocalDateTime(),
	                  rs.getString("notice_img_enroll"),
	                  rs.getString("notice_img_revise"),
	                  rs.getString("notice_status"));

	            list.add(resultVo);
	         
	         }
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(rs);
	         close(pstmt);
	      }return list;
	   }
	public List<Notice> selectNoticeUserList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> list = new ArrayList<Notice>();
		try {
			String sql = "SELECT * FROM `notice` WHERE notice_status = 'Y' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice resultVo = new Notice(
						rs.getInt("notice_no"),
		                  rs.getString("notice_title"),
		                  rs.getString("notice_content"),
		                  rs.getTimestamp("notice_reg_date").toLocalDateTime(),
		                  rs.getTimestamp("notice_mod_date").toLocalDateTime(),
		                  rs.getString("notice_img_enroll"),
		                  rs.getString("notice_img_revise"),
		                  rs.getString("notice_status"));

		            list.add(resultVo);
						
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	public Notice selectNoticeInfo(int noticeNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice result = new Notice();
		try {
			String sql = "SELECT * FROM `notice` WHERE notice_status = 'Y' AND notice_no = ?";
	    	 pstmt = conn.prepareStatement(sql);
	    	 pstmt.setInt(1, noticeNo);
	    	 rs = pstmt.executeQuery();
	    	 
	    	 if(rs.next()) {
	    		 result.setNotice_no(rs.getInt("notice_no"));
	    		 result.setNotice_title(rs.getString("notice_title"));
	    		 result.setNotice_content( rs.getString("notice_content"));
	    		 result.setNotice_reg_date(rs.getTimestamp("notice_reg_date").toLocalDateTime());
	    		 result.setNotice_mod_date( rs.getTimestamp("notice_mod_date").toLocalDateTime());
	    		 result.setNotice_img_enroll( rs.getString("notice_img_enroll"));
	    		 result.setNotice_img_revise( rs.getString("notice_img_revise"));
	    		 result.setnotice_status( rs.getString("notice_status"));
	    		 
	    	 }
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
		
	}
}
