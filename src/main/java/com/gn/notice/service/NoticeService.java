package com.gn.notice.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.notice.dao.NoticeDao;
import com.gn.notice.vo.Notice;

public class NoticeService {
	public int createNotice(Notice n) {
		  Connection conn = getConnection();
	      int result = new NoticeDao().createNotice(n,conn);
	      close(conn);
	      return result;
	   }
	public List<Notice> selectnotice_adminList() {
		  Connection conn = getConnection();
	      List<Notice> result = new NoticeDao().selectnotice_adminList(conn);
	      close(conn);
	      return result;
	}
	public Notice selectUpdateInfo(int notice_no) {
		Connection conn = getConnection();
		Notice result = new NoticeDao().selectUpdateInfo(conn,notice_no);
		close(conn);
		return result;
	}
	public int UpdateNotice(Notice n) {
		 Connection conn = getConnection();
	      int result = new NoticeDao().updateNotice(n,conn);
	      close(conn);
	      return result;
	}
	public int deleteNotice(int notice_no) {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(notice_no,conn);
		close(conn);
		return result;
	}
	public List<Notice> selectNoticeUserList(){
		Connection conn = getConnection();
		List<Notice> result = new NoticeDao().selectNoticeUserList(conn);
		close(conn);
		return result;
	}
	public Notice selectNoticeInfo(int noticeNo) {
		Connection conn = getConnection();
		Notice result = new NoticeDao().selectNoticeInfo(noticeNo, conn);
		close(conn);
		return result;
	}
}
