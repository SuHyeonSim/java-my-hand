package com.project.user.dao;

import static com.project.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gn.product_admin.vo.Product_admin;


public class ShopDao {
	
	public List<Product_admin> selectProduct_userList (Connection conn) {
		List<Product_admin> list = new ArrayList<Product_admin>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `product` WHERE prod_status = 'Y'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product_admin resultVo = new Product_admin(
								rs.getInt("prod_no"),
								rs.getInt("cate_no"),
								rs.getString("prod_name"),
								rs.getInt("prod_price"),
								rs.getInt("prod_sellCount"),
								rs.getString("prod_info"),
								rs.getInt("prod_inventory"),
								rs.getTimestamp("prod_regDate").toLocalDateTime(),
								rs.getString("prod_status"),
								rs.getString("prod_enroll_image"),
								rs.getString("prod_revise_image"));
				list.add(resultVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
