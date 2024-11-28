package com.project.user.vo;

import java.time.LocalDateTime;

public class Product_list {
	private int prod_no;
	private int cate_no;
	private String prod_name;
	private int prod_price;
	private int prod_sellCount;
	private String prod_info;
	private int prod_inventory;
	private LocalDateTime prod_regDate;
	private String prod_status;
	private String prod_enroll_image;
	private String prod_revise_image;
	
	public Product_list() {}

	public Product_list(int prod_no, int cate_no, String prod_name, int prod_price, int prod_sellCount,
			String prod_info, int prod_inventory, LocalDateTime prod_regDate, String prod_status,
			String prod_enroll_image, String prod_revise_image) {
		super();
		this.prod_no = prod_no;
		this.cate_no = cate_no;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_sellCount = prod_sellCount;
		this.prod_info = prod_info;
		this.prod_inventory = prod_inventory;
		this.prod_regDate = prod_regDate;
		this.prod_status = prod_status;
		this.prod_enroll_image = prod_enroll_image;
		this.prod_revise_image = prod_revise_image;
	}

	public int getProd_no() {
		return prod_no;
	}

	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}

	public int getCate_no() {
		return cate_no;
	}

	public void setCate_no(int cate_no) {
		this.cate_no = cate_no;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_sellCount() {
		return prod_sellCount;
	}

	public void setProd_sellCount(int prod_sellCount) {
		this.prod_sellCount = prod_sellCount;
	}

	public String getProd_info() {
		return prod_info;
	}

	public void setProd_info(String prod_info) {
		this.prod_info = prod_info;
	}

	public int getProd_inventory() {
		return prod_inventory;
	}

	public void setProd_inventory(int prod_inventory) {
		this.prod_inventory = prod_inventory;
	}

	public LocalDateTime getProd_regDate() {
		return prod_regDate;
	}

	public void setProd_regDate(LocalDateTime prod_regDate) {
		this.prod_regDate = prod_regDate;
	}

	public String getProd_status() {
		return prod_status;
	}

	public void setProd_status(String prod_status) {
		this.prod_status = prod_status;
	}

	public String getProd_enroll_image() {
		return prod_enroll_image;
	}

	public void setProd_enroll_image(String prod_enroll_image) {
		this.prod_enroll_image = prod_enroll_image;
	}

	public String getProd_revise_image() {
		return prod_revise_image;
	}

	public void setProd_revise_image(String prod_revise_image) {
		this.prod_revise_image = prod_revise_image;
	}

	@Override
	public String toString() {
		return "Product_admin [prod_no=" + prod_no + ", cate_no=" + cate_no + ", prod_name=" + prod_name
				+ ", prod_price=" + prod_price + ", prod_sellCount=" + prod_sellCount + ", prod_info=" + prod_info
				+ ", prod_inventory=" + prod_inventory + ", prod_regDate=" + prod_regDate + ", prod_status="
				+ prod_status + ", prod_enroll_image=" + prod_enroll_image + ", prod_revise_image=" + prod_revise_image
				+ "]";
	}

	
}
