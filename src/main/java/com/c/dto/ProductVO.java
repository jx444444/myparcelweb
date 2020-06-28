package com.c.dto;

import java.util.Date;

public class ProductVO {
	private String index;
	private String name;
	private String pay;
	private String explanatory;
	private String by;
	private String kind;
	private Date day;
	private int extra;
	private String tag;
	private String brand;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getExplanatory() {
		return explanatory;
	}
	public void setExplanatory(String explanatory) {
		this.explanatory = explanatory;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	public int getExtra() {
		return extra;
	}
	public void setExtra(int extra) {
		this.extra = extra;
	}
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public ProductVO(String index, String name, String pay, String explanatory, String by, String kind, Date day, int extra, String tag, String brand) {
		super();
		this.index = index;
		this.name = name;
		this.pay = pay;
		this.explanatory = explanatory;
		this.by = by;
		this.kind = kind;
		this.day = day;
		this.extra = extra;
		this.tag = tag;
		this.brand = brand;
	}
	public ProductVO() {
		super();
	}
	
	
}
