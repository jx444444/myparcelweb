package com.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.OrderProductPartVO;

@Repository
public class OrderProductPartDAOImpl implements OrderProductPartDAO{
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";

	@Override
	public List<OrderProductPartVO> selectOrderproductpart() throws Exception {
		return sqlSession.selectList(Namespace+".selectorderproductpart");
	}

	@Override
	public List<OrderProductPartVO> selectOrderproductpart_orderindex(String order_index) throws Exception {
		return sqlSession.selectList(Namespace+".selectorderproductpart_orderindex",order_index);
	}

	@Override
	public int insertorderproductpart(OrderProductPartVO orderproductpart) {
		return sqlSession.insert(Namespace+".insertorderproductpart",orderproductpart);
	}

	@Override
	public int deleteorderproductpart(String order_index) {
		return sqlSession.delete(Namespace+".deleteorderproductpart",order_index);
	}

	@Override
	public int deleteorderproductpart_productindex(String product_index) {
		return sqlSession.delete(Namespace+".deleteorderproductpart_productindex",product_index);
	}

	@Override
	public List<String> select_empty_orderpart(String order_index) {
		return sqlSession.selectList(Namespace+".select_empty_orderpart",order_index);
	}
	
	
	
	
	
    
}
