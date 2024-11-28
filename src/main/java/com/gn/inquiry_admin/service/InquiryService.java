package com.gn.inquiry_admin.service;
import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.inquiry_admin.dao.InquiryDao;
import com.gn.inquiry_admin.vo.Inquiry_comment;
import com.gn.shop_user.vo.Inquiry;
public class InquiryService {
	public int inquiryCommentInsert(Inquiry_comment ic) {
		Connection conn = getConnection();
		int result = new InquiryDao().inquiryCommentInsert(ic, conn);
		close(conn);
		return result;
	}
	public List<Inquiry_comment> selectInquiryComment(int inquiryNo) {
		Connection conn = getConnection();
		List<Inquiry_comment> result = new InquiryDao().selectInquiryComment(inquiryNo, conn);
		close(conn);
		return result;
	}
	public int createInquiry(Inquiry iq) {
		Connection conn = getConnection();
		int result = new InquiryDao().createInquiry(iq, conn);
		close(conn);
		return result;
	}
}
