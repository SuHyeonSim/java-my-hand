package com.project.user.vo;

public class Cart {

	private int user_no;
	private int prod_no;
	private int cart_quantity;
    private String prod_image;
    private String prod_name;
    private int prod_inventory;
    private int prod_price;
	private int total_price;
	private int total_quantity;
	
	public Cart() {
		super();
	}

	public Cart(int user_no, int prod_no, int cart_quantity, String prod_image, String prod_name, int prod_inventory,
			int prod_price, int total_price, int total_quantity) {
		super();
		this.user_no = user_no;
		this.prod_no = prod_no;
		this.cart_quantity = cart_quantity;
		this.prod_image = prod_image;
		this.prod_name = prod_name;
		this.prod_inventory = prod_inventory;
		this.prod_price = prod_price;
		this.total_price = total_price;
		this.total_quantity = total_quantity;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getProd_no() {
		return prod_no;
	}

	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public String getProd_image() {
		return prod_image;
	}

	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_inventory() {
		return prod_inventory;
	}

	public void setProd_inventory(int prod_inventory) {
		this.prod_inventory = prod_inventory;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	@Override
	public String toString() {
		return "Cart [user_no=" + user_no + ", prod_no=" + prod_no + ", cart_quantity=" + cart_quantity
				+ ", prod_image=" + prod_image + ", prod_name=" + prod_name + ", prod_inventory=" + prod_inventory
				+ ", prod_price=" + prod_price + ", total_price=" + total_price + ", total_quantity=" + total_quantity
				+ "]";
	}

	
	
	
}