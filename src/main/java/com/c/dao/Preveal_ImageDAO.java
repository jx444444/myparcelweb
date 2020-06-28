package com.c.dao;

import java.util.List;

import com.c.dto.Preveal_ImageVO;
import com.c.dto.ProductVO;

public interface Preveal_ImageDAO {
	public List<Preveal_ImageVO> selectPreveal_Image() throws Exception;
	public List<Preveal_ImageVO> selectPreveal_Image_product_index(String index) throws Exception;
	public int insertProduct(Preveal_ImageVO preveal_ImageVO);
	public int deleteProduct(Preveal_ImageVO preveal_ImageVO);
	public int updateProduct(Preveal_ImageVO preveal_ImageVO);
}
