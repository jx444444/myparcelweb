package com.c.dao;

import java.util.List;

import com.c.dto.Product_StarVO;

public interface Product_StarDAO {
	public List<Product_StarVO> selectProduct_Star() throws Exception;
	public List<String> selectProduct_Star_count(String productindex) throws Exception;//한 상품의 별점준 참여자의 수
	public List<String> selectProduct_Star_avg(String productindex) throws Exception;//한 상품의 별점 평균
	public int insertProduct_Star(Product_StarVO product_Star);
	public int deleteProduct_Star(Product_StarVO product_Star);
	public int deleteProduct_Star_productindex(String product_index);
	public int deleteProduct_Star_userindex(String user);
	public List<Product_StarVO> selectProduct_Star_user_prd(Product_StarVO product_Star) throws Exception;
}
