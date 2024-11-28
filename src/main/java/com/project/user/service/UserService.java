package com.project.user.service;

import static com.project.common.sql.JDBCTemplate.close;
import static com.project.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.project.user.dao.UserDao;
import com.project.user.vo.Point;
import com.project.user.vo.Review;
import com.project.user.vo.User;
public class UserService {
	
    public List<Review> getReviewList(int userNo) {
        Connection conn = getConnection();
        List<Review> reviewList = new UserDao().getReviewList(userNo, conn);
        close(conn);
        return reviewList;
    }
	
	public int createUser(User u) {
		Connection conn = getConnection();
		int result = new UserDao().addUser(u,conn);
		close(conn);
		return result; 
	}
	public User loginUser(User u) {
		Connection conn = getConnection();
		User result = new UserDao().loginUser(u,conn);
		close(conn);
		return result; 
	}
	public User checkDuplicateUserId(String userId) {
	    Connection conn = getConnection();
	    User result = new UserDao().checkDuplicateUserId(userId, conn);
	    close(conn);
	    return result;
	}
	public int editUser(User u) {
		Connection conn = getConnection();
		int result = new UserDao().editUser(u,conn);
		close(conn);
		return result; 
	}
	public int deleteUser(int userNo) {
		Connection conn = getConnection();
		int result = new UserDao().deleteUser(userNo,conn);
		close(conn);
		return result; 
	}
    public List<Point> getPointHistory(int userNo) {
        Connection conn = getConnection();
        List<Point> pointHistory = new UserDao().getPointHistory(userNo, conn);
        close(conn);
        return pointHistory;
    }
    public int userPoint(int userNo) {
    	Connection conn = getConnection();
    	int result = new UserDao().userPoint(userNo, conn);
    	close(conn);
    	return result;
    }
}