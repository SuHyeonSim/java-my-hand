package com.gn.shop_user.vo;

import java.time.LocalDateTime;

import com.gn.common.Paging;

public class Inquiry extends Paging{
	private int inquiry_no;
	private int inquiry_writer;
	private String inquiry_title;
	private String inquiry_content;
	private LocalDateTime inquiry_reg_date;
	private LocalDateTime inquiry_mod_date;
	private String inquiry_img_reg;
	private String inquiry_img_mod;
	private String inquiry_delete;
	private String writer_name;
	private int user_no;
	
	public Inquiry() {}
	
	

	
	

	public Inquiry(int inquiry_no, int inquiry_writer, String inquiry_title, String inquiry_content,
			LocalDateTime inquiry_reg_date, LocalDateTime inquiry_mod_date, String inquiry_img_reg,
			String inquiry_img_mod, String inquiry_delete, String writer_name, int user_no) {
		super();
		this.inquiry_no = inquiry_no;
		this.inquiry_writer = inquiry_writer;
		this.inquiry_title = inquiry_title;
		this.inquiry_content = inquiry_content;
		this.inquiry_reg_date = inquiry_reg_date;
		this.inquiry_mod_date = inquiry_mod_date;
		this.inquiry_img_reg = inquiry_img_reg;
		this.inquiry_img_mod = inquiry_img_mod;
		this.inquiry_delete = inquiry_delete;
		this.writer_name = writer_name;
		this.user_no = user_no;
	}






	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public int getInquiry_writer() {
		return inquiry_writer;
	}

	public void setInquiry_writer(int inquiry_writer) {
		this.inquiry_writer = inquiry_writer;
	}

	public String getInquiry_title() {
		return inquiry_title;
	}

	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public LocalDateTime getInquiry_reg_date() {
		return inquiry_reg_date;
	}

	public void setInquiry_reg_date(LocalDateTime inquiry_reg_date) {
		this.inquiry_reg_date = inquiry_reg_date;
	}

	public LocalDateTime getInquiry_mod_date() {
		return inquiry_mod_date;
	}

	public void setInquiry_mod_date(LocalDateTime inquiry_mod_date) {
		this.inquiry_mod_date = inquiry_mod_date;
	}

	public String getInquiry_img_reg() {
		return inquiry_img_reg;
	}

	public void setInquiry_img_reg(String inquiry_img_reg) {
		this.inquiry_img_reg = inquiry_img_reg;
	}

	public String getInquiry_img_mod() {
		return inquiry_img_mod;
	}

	public void setInquiry_img_mod(String inquiry_img_mod) {
		this.inquiry_img_mod = inquiry_img_mod;
	}

	public String getInquiry_delete() {
		return inquiry_delete;
	}

	public void setInquiry_delete(String inquiry_delete) {
		this.inquiry_delete = inquiry_delete;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}






	public int getUser_no() {
		return user_no;
	}






	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}






	@Override
	public String toString() {
		return "Inquiry [inquiry_no=" + inquiry_no + ", inquiry_writer=" + inquiry_writer + ", inquiry_title="
				+ inquiry_title + ", inquiry_content=" + inquiry_content + ", inquiry_reg_date=" + inquiry_reg_date
				+ ", inquiry_mod_date=" + inquiry_mod_date + ", inquiry_img_reg=" + inquiry_img_reg
				+ ", inquiry_img_mod=" + inquiry_img_mod + ", inquiry_delete=" + inquiry_delete + ", writer_name="
				+ writer_name + ", user_no=" + user_no + "]";
	}
	
	
	
}
