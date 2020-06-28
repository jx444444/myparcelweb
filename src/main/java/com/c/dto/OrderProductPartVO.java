package com.c.dto;

import java.util.Date;

public class OrderProductPartVO {
	private String product_index;
	private String order_index;
	private String num;
	
	public String getProduct_index() {
		return product_index;
	}
	public void setProduct_index(String product_index) {
		this.product_index = product_index;
	}
	public String getOrder_index() {
		return order_index;
	}
	public void setOrder_index(String order_index) {
		this.order_index = order_index;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public OrderProductPartVO(String product_index, String order_index, String num) {
		super();
		this.product_index = product_index;
		this.order_index = order_index;
		this.num = num;
	}
	
	
	
	
}
