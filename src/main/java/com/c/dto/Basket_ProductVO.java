package com.c.dto;

import java.util.Date;

public class Basket_ProductVO {
	
	private String user;
	private String product_index;
	private Date day;
	private String num;
	private String checked;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getProduct_index() {
		return product_index;
	}
	public void setProduct_index(String product_index) {
		this.product_index = product_index;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	public Basket_ProductVO(String user, String product_index, Date day, String num, String checked) {
		super();
		this.user = user;
		this.product_index = product_index;
		this.day = day;
		this.num = num;
		this.checked = checked;
	}
	public Basket_ProductVO() {
		super();
	}
	
	
	
	
	
}
