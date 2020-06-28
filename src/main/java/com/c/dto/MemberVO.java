package com.c.dto;

public class MemberVO {
	private String index;
	private String email;
	private String password;
	private String money;
	private String name;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public MemberVO(String index, String email, String password, String money, String name) {
		super();
		this.index = index;
		this.email = email;
		this.password = password;
		this.money = money;
		this.name = name;
	}
	public MemberVO() {
		super();
	}
	
	
	
}
