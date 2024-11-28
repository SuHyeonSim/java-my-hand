package com.gn.shop_user.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.inquiry_admin.dao.InquiryDao;
import com.gn.shop_user.dao.Shop_userDao;
import com.gn.shop_user.vo.Inquiry;

public class Shop_userService {
	public List<Inquiry> selelctInquiryList(){
		Connection conn = getConnection();
		List<Inquiry> list = new Shop_userDao().selectInquiryList(conn);
		close(conn);
		return list;
	}
	public Inquiry infoInquiry(int inquiryNo) {
		Connection conn = getConnection();
		Inquiry iq = new Shop_userDao().infoInquiry(inquiryNo, conn);
		close(conn);
		return iq;
	}
	
}
