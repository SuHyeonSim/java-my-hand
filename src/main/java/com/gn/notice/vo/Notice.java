package com.gn.notice.vo;

import java.time.LocalDateTime;

	public class Notice {
		private int notice_no;
		private String notice_title;
		private String notice_content;		
		private LocalDateTime notice_reg_date;
		private LocalDateTime notice_mod_date;
		private String notice_img_enroll;
		private String notice_img_revise;
		private String notice_status;
		public Notice() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Notice(int notice_no, String notice_title, String notice_content, LocalDateTime notice_reg_date,
				LocalDateTime notice_mod_date, String notice_img_enroll, String notice_img_revise,
				String notice_status) {
			super();
			this.notice_no = notice_no;
			this.notice_title = notice_title;
			this.notice_content = notice_content;
			this.notice_reg_date = notice_reg_date;
			this.notice_mod_date = notice_mod_date;
			this.notice_img_enroll = notice_img_enroll;
			this.notice_img_revise = notice_img_revise;
			this.notice_status = notice_status;
		}
		public int getNotice_no() {
			return notice_no;
		}
		public void setNotice_no(int notice_no) {
			this.notice_no = notice_no;
		}
		public String getNotice_title() {
			return notice_title;
		}
		public void setNotice_title(String notice_title) {
			this.notice_title = notice_title;
		}
		public String getNotice_content() {
			return notice_content;
		}
		public void setNotice_content(String notice_content) {
			this.notice_content = notice_content;
		}
		public LocalDateTime getNotice_reg_date() {
			return notice_reg_date;
		}
		public void setNotice_reg_date(LocalDateTime notice_reg_date) {
			this.notice_reg_date = notice_reg_date;
		}
		public LocalDateTime getNotice_mod_date() {
			return notice_mod_date;
		}
		public void setNotice_mod_date(LocalDateTime notice_mod_date) {
			this.notice_mod_date = notice_mod_date;
		}
		public String getNotice_img_enroll() {
			return notice_img_enroll;
		}
		public void setNotice_img_enroll(String notice_img_enroll) {
			this.notice_img_enroll = notice_img_enroll;
		}
		public String getNotice_img_revise() {
			return notice_img_revise;
		}
		public void setNotice_img_revise(String notice_img_revise) {
			this.notice_img_revise = notice_img_revise;
		}
		public String getnotice_status() {
			return notice_status;
		}
		public void setnotice_status(String notice_status) {
			this.notice_status = notice_status;
		}
		@Override
		public String toString() {
			return "Notice [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
					+ notice_content + ", notice_reg_date=" + notice_reg_date + ", notice_mod_date=" + notice_mod_date
					+ ", notice_img_enroll=" + notice_img_enroll + ", notice_img_revise=" + notice_img_revise
					+ ", notice_status=" + notice_status + "]";
		}
		
		
		
	}
	
		
	