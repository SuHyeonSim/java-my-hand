package com.project.user.vo;

public class OrderList {
	private String order_no;
	private int prod_no;
	private int order_count;
	public OrderList() {
		super();
	}
	public OrderList(String order_no, int prod_no, int order_count) {
		super();
		this.order_no = order_no;
		this.prod_no = prod_no;
		this.order_count = order_count;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getProd_no() {
		return prod_no;
	}
	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	@Override
	public String toString() {
		return "OrderList [order_no=" + order_no + ", prod_no=" + prod_no + ", order_count=" + order_count + "]";
	}

	
	
}