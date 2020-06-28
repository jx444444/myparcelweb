package com.c.dto;

public class Product_StarVO {
	private String user;
	private String product_index;
	private String star;
	
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
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public Product_StarVO(String user, String product_index, String star) {
		super();
		this.user = user;
		this.product_index = product_index;
		this.star = star;
	}
	public Product_StarVO() {
		super();
	}
	
	
	
}
