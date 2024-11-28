package com.gn.shop_user.vo;

import java.time.LocalDateTime;

public class User {
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_birth;
	private String user_name;
	private String user_address;
	private String user_address_detail;
	private String user_email;
	private String user_mobile;
	private String user_phone;
	private LocalDateTime user_date;
	private LocalDateTime user_del_date;
	private String user_delete;
	private int user_point;
	
	public User() {}

	public User(int user_no, String user_id, String user_pw, String user_birth, String user_name, String user_address,
			String user_address_detail, String user_email, String user_mobile, String user_phone,
			LocalDateTime user_date, LocalDateTime user_del_date, String user_delete, int user_point) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_birth = user_birth;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_address_detail = user_address_detail;
		this.user_email = user_email;
		this.user_mobile = user_mobile;
		this.user_phone = user_phone;
		this.user_date = user_date;
		this.user_del_date = user_del_date;
		this.user_delete = user_delete;
		this.user_point = user_point;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_address_detail() {
		return user_address_detail;
	}

	public void setUser_address_detail(String user_address_detail) {
		this.user_address_detail = user_address_detail;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public LocalDateTime getUser_date() {
		return user_date;
	}

	public void setUser_date(LocalDateTime user_date) {
		this.user_date = user_date;
	}

	public LocalDateTime getUser_del_date() {
		return user_del_date;
	}

	public void setUser_del_date(LocalDateTime user_del_date) {
		this.user_del_date = user_del_date;
	}

	public String getUser_delete() {
		return user_delete;
	}

	public void setUser_delete(String user_delete) {
		this.user_delete = user_delete;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_birth="
				+ user_birth + ", user_name=" + user_name + ", user_address=" + user_address + ", user_address_detail="
				+ user_address_detail + ", user_email=" + user_email + ", user_mobile=" + user_mobile + ", user_phone="
				+ user_phone + ", user_date=" + user_date + ", user_del_date=" + user_del_date + ", user_delete="
				+ user_delete + ", user_point=" + user_point + "]";
	}
	
	
}
