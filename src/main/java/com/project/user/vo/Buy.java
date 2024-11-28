package com.project.user.vo;

import java.time.LocalDateTime;

public class Buy {
	
	private String order_no;
	private int ship_no;
	private int user_no;
	private String order_comment;
	private LocalDateTime order_date;
	private String order_status;
	
	public Buy() {
		super();
	}

	public Buy(String order_no, int ship_no, int user_no, String order_comment, LocalDateTime order_date,
			String order_status) {
		super();
		this.order_no = order_no;
		this.ship_no = ship_no;
		this.user_no = user_no;
		this.order_comment = order_comment;
		this.order_date = order_date;
		this.order_status = order_status;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public int getShip_no() {
		return ship_no;
	}

	public void setShip_no(int ship_no) {
		this.ship_no = ship_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getOrder_comment() {
		return order_comment;
	}

	public void setOrder_comment(String order_comment) {
		this.order_comment = order_comment;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "Buy [order_no=" + order_no + ", ship_no=" + ship_no + ", user_no=" + user_no + ", order_comment="
				+ order_comment + ", order_date=" + order_date + ", order_status=" + order_status + "]";
	}

	
}