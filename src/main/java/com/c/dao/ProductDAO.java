package com.c.dao;

import java.util.HashMap;
import java.util.List;

import com.c.dto.ProductVO;

public interface ProductDAO {
	public List<ProductVO> selectProduct() throws Exception;
	public List<ProductVO> selectProduct_product_index(String index) throws Exception;
	public List<ProductVO> selectProduct_name(String name) throws Exception;
	
	//평균 별점으로 정렬
	public List<ProductVO> selectProduct_name_kind(ProductVO product) throws Exception;
	public List<String> selectProduct_name_tag(ProductVO product) throws Exception;
	public List<String> selectProduct_name_brand(ProductVO product) throws Exception;
	
	//가격 높은순
	public List<ProductVO> selectProduct_name_kind_paydesc(ProductVO product) throws Exception;
	
	//가격 낮은순
	public List<ProductVO> selectProduct_name_kind_payasc(ProductVO product) throws Exception;

	//신제품
	public List<ProductVO> selectProduct_name_kind_day(ProductVO product) throws Exception;
	
	public List<ProductVO> selectProduct_product_star() throws Exception;
	public int insertProduct(ProductVO product);
	public int deleteProduct(String index);
	public int updateProduct(ProductVO product);
	
	//다른 상품들도 보기
	public List<ProductVO> selectProduct_productpage_anothertag(ProductVO product) throws Exception;
	public List<ProductVO> selectProduct_productpage_anotherbrand(ProductVO product) throws Exception;
	public List<String> selectProduct_index_tag(String index) throws Exception;
	public List<String> selectProduct_index_brand(String index) throws Exception;
}
