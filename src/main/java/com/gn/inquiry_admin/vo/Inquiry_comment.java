package com.gn.inquiry_admin.vo;

import java.time.LocalDateTime;


public class Inquiry_comment {
	private int inquiry_no;
	private String comment_content;
	private LocalDateTime comment_reg_date;
	private LocalDateTime comment_mod_date;
	
	public Inquiry_comment() {}

	public Inquiry_comment(int inquiry_no, String comment_content, LocalDateTime comment_reg_date,
			LocalDateTime comment_mod_date) {
		super();
		this.inquiry_no = inquiry_no;
		this.comment_content = comment_content;
		this.comment_reg_date = comment_reg_date;
		this.comment_mod_date = comment_mod_date;
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public LocalDateTime getComment_reg_date() {
		return comment_reg_date;
	}

	public void setComment_reg_date(LocalDateTime comment_reg_date) {
		this.comment_reg_date = comment_reg_date;
	}

	public LocalDateTime getComment_mod_date() {
		return comment_mod_date;
	}

	public void setComment_mod_date(LocalDateTime comment_mod_date) {
		this.comment_mod_date = comment_mod_date;
	}

	@Override
	public String toString() {
		return "Inquiry_comment [inquiry_no=" + inquiry_no + ", comment_content=" + comment_content
				+ ", comment_reg_date=" + comment_reg_date + ", comment_mod_date=" + comment_mod_date + "]";
	}
	
	
}
