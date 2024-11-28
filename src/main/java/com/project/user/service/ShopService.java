package com.project.user.service;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.product_admin.vo.Product_admin;
import com.project.user.dao.ShopDao;

public class ShopService {
	
	public List<Product_admin> selectProduct_userList() {
		Connection conn = getConnection();
		List<Product_admin> list = new ShopDao().selectProduct_userList(conn);
		close(conn);
		return list;
	}
}
