package com.c.dto;

public class Preveal_ImageVO {
	private String product_index;
	private String imagenum;
	private String image_name;
	private String fn_Extension;
	
	public String getProduct_index() {
		return product_index;
	}
	public void setProduct_index(String product_index) {
		this.product_index = product_index;
	}
	public String getImagenum() {
		return imagenum;
	}
	public void setImagenum(String imagenum) {
		this.imagenum = imagenum;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getFn_Extension() {
		return fn_Extension;
	}
	public void setFn_Extension(String fn_Extension) {
		this.fn_Extension = fn_Extension;
	}
	public Preveal_ImageVO(String product_index, String imagenum, String image_name, String fn_Extension) {
		super();
		this.product_index = product_index;
		this.imagenum = imagenum;
		this.image_name = image_name;
		this.fn_Extension = fn_Extension;
	}
	public Preveal_ImageVO() {
		super();
	}
	
	
}
