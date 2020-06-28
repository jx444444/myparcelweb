package com.c.dto;

import java.util.Date;

public class OrderVO {
	private String index;
	private String user;
	private String shipping_place;
	private Date day;
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getShipping_place() {
		return shipping_place;
	}
	public void setShipping_place(String shipping_place) {
		this.shipping_place = shipping_place;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	public OrderVO(String index, String user, String shipping_place, Date day) {
		super();
		this.index = index;
		this.user = user;
		this.shipping_place = shipping_place;
		this.day = day;
	}
	public OrderVO() {
		super();
	}
	
	
	
	
}
