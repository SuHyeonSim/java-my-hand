package com.project.user.service;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.project.user.dao.ShipListDao;
import com.project.user.vo.ShipList;
import com.project.user.vo.User;

public class ShipService {
	
	
	public static int deleteShipList(ShipList s) {
		Connection conn = getConnection();
		int result = new ShipListDao().deleteShipList(s,conn);
		close(conn);
		return result;
	}


	public static int updateShipList(ShipList s){
		Connection conn = getConnection();
		int result = new ShipListDao().updateShipList(s,conn);
		close(conn);
		return result;
	}
	
	public List<ShipList> choiseList(int userNo, String shipNo) {
		Connection conn = getConnection();
		List<ShipList> list = new ShipListDao().choiseList(userNo,shipNo,conn);
		close(conn);
		return list;
	}

	public List<ShipList> selectShipList(int userNo) {
		Connection conn = getConnection();
		List<ShipList> list = new ShipListDao().selectShipList(userNo,conn);
		close(conn);
		return list;
	}
	
	public int createShipList(ShipList s) {
		Connection conn = getConnection();
		int result = new ShipListDao().createShipList(s,conn);
		close(conn);
		return result;
	}


}