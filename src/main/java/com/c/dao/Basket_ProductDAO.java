package com.c.dao;

import java.util.List;

import com.c.dto.Basket_ProductVO;

public interface Basket_ProductDAO {
	public List<Basket_ProductVO> selectBasket_Product() throws Exception;
	public List<Basket_ProductVO> selectBasket_Product_usersbasket(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_paytotal(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_counttotal(String user) throws Exception;
	public List<Basket_ProductVO> selectBasket_Product_basketproduct(Basket_ProductVO basket_prodoct) throws Exception;
	public int insertBasket_Product(Basket_ProductVO basket_prodoct);
	public int deleteBasket_Product(Basket_ProductVO basket_prodoct);
	public int deleteBasket_Product_index(Basket_ProductVO basket_prodoct);
	public int updateBasket_Product(Basket_ProductVO basket_prodoct);
	public int updateBasket_Product_checked(Basket_ProductVO basket_prodoct);
	public int updateBasket_Product_allchecked(Basket_ProductVO basket_prodoct);
	public List<Basket_ProductVO> selectBasket_Product_usersbasket_checked(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_checkedcount(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_count(String user) throws Exception;
	public int deleteBasket_user_index(String user);
}
