package com.c.dao;

import java.util.List;

import com.c.dto.OrderVO;

public interface OrderDAO {
	public List<OrderVO> selectOrder() throws Exception;
	public List<String> select_empty_order(String index) throws Exception;
	public List<OrderVO> selectOrder_userorder(String user) throws Exception;
	public int insertOrder(OrderVO order);
	public int deleteOrder(String index);
	public int deleteOrder_userindex(String user);
}
