package com.project.user.vo;

public class Point {
    private int pointNo;
    private int userNo;
    private String pointReason;
    private int pointChange;
    private String pointDate;
    
	public Point() {
		super();
	}

	public Point(int pointNo, int userNo, String pointReason, int pointChange, String pointDate) {
		super();
		this.pointNo = pointNo;
		this.userNo = userNo;
		this.pointReason = pointReason;
		this.pointChange = pointChange;
		this.pointDate = pointDate;
	}

	public int getPointNo() {
		return pointNo;
	}

	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getPointReason() {
		return pointReason;
	}

	public void setPointReason(String pointReason) {
		this.pointReason = pointReason;
	}

	public int getPointChange() {
		return pointChange;
	}

	public void setPointChange(int pointChange) {
		this.pointChange = pointChange;
	}

	public String getPointDate() {
		return pointDate;
	}

	public void setPointDate(String pointDate) {
		this.pointDate = pointDate;
	}

	@Override
	public String toString() {
		return "Point [pointNo=" + pointNo + ", userNo=" + userNo + ", pointReason=" + pointReason + ", pointChange="
				+ pointChange + ", pointDate=" + pointDate + "]";
	}
    
    
}