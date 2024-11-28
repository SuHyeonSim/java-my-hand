package com.gn.order_admin.vo;

public class Shiplist {
	private int ship_no;
	private int user_no;
	private String ship_alias;
	private String ship_name;
	private String ship_phone;
	private String ship_address;
	private int front_door_pw;
	
	public Shiplist() {}

	public Shiplist(int ship_no, int user_no, String ship_alias, String ship_name, String ship_phone,
			String ship_address, int front_door_pw) {
		super();
		this.ship_no = ship_no;
		this.user_no = user_no;
		this.ship_alias = ship_alias;
		this.ship_name = ship_name;
		this.ship_phone = ship_phone;
		this.ship_address = ship_address;
		this.front_door_pw = front_door_pw;
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

	public String getShip_alias() {
		return ship_alias;
	}

	public void setShip_alias(String ship_alias) {
		this.ship_alias = ship_alias;
	}

	public String getShip_name() {
		return ship_name;
	}

	public void setShip_name(String ship_name) {
		this.ship_name = ship_name;
	}

	public String getShip_phone() {
		return ship_phone;
	}

	public void setShip_phone(String ship_phone) {
		this.ship_phone = ship_phone;
	}

	public String getShip_address() {
		return ship_address;
	}

	public void setShip_address(String ship_address) {
		this.ship_address = ship_address;
	}

	public int getFront_door_pw() {
		return front_door_pw;
	}

	public void setFront_door_pw(int front_door_pw) {
		this.front_door_pw = front_door_pw;
	}

	@Override
	public String toString() {
		return "shiplist [ship_no=" + ship_no + ", user_no=" + user_no + ", ship_alias=" + ship_alias + ", ship_name="
				+ ship_name + ", ship_phone=" + ship_phone + ", ship_address=" + ship_address + ", front_door_pw="
				+ front_door_pw + "]";
	}
	
	
}
