package com.c.dao;

import java.util.List;

import com.c.dto.OrderProductPartVO;

public interface OrderProductPartDAO {
	public List<OrderProductPartVO> selectOrderproductpart() throws Exception;
	public List<OrderProductPartVO> selectOrderproductpart_orderindex(String order_index) throws Exception;
	public int insertorderproductpart(OrderProductPartVO orderproductpart);
	public int deleteorderproductpart(String order_index);
	public int deleteorderproductpart_productindex(String product_index);
	public List<String> select_empty_orderpart(String order_index);
}
