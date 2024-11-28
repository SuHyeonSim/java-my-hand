package com.gn.product_admin.service;
import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.product_admin.dao.Product_adminDao;
import com.gn.product_admin.vo.Product_admin;

public class Product_adminService {
	public int createProduct(Product_admin pa) {
		Connection conn = getConnection();
		int result = new Product_adminDao().createProduct(pa,conn);
		close(conn);
		return result;
	}
	public List<Product_admin> selectProduct_adminList(){
		Connection conn = getConnection();
		List<Product_admin> list = new Product_adminDao().selectProduct_adminList(conn);
		close(conn);
		return list;
	}
	public int updateProduct(Product_admin pa) {
		Connection conn = getConnection();
		int result = new Product_adminDao().updateProduct(pa,conn);
		close(conn);
		return result;
	}
	public Product_admin infoProduct(int prodNo) {
		Connection conn = getConnection();
		Product_admin result = new Product_adminDao().infoProduct(prodNo, conn);
		close(conn);
		return result;
	}
	public int deleteProduct(int prodNo) {
		Connection conn = getConnection();
		int result = new Product_adminDao().deleteProduct(prodNo, conn);
		close(conn);
		return result;
	}
	public int inventoryProduct(int prodNo, int prodNum) {
		Connection conn = getConnection();
		int result = new Product_adminDao().inventoryProduct(prodNo, prodNum, conn);
		close(conn);
		return result;
	}
}
