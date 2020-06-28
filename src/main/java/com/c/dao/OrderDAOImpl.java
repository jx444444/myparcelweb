package com.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.OrderVO;

@Repository
public class OrderDAOImpl implements OrderDAO{
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";
    
    @Override
    public List<OrderVO> selectOrder() throws Exception {
        return sqlSession.selectList(Namespace+".selectOrder");
    }
	@Override
	public List<String> select_empty_order(String index) throws Exception {
		return sqlSession.selectList(Namespace+".select_empty_order",index);
	}

	@Override
	public List<OrderVO> selectOrder_userorder(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectOrder_userorder",user);
	}

	@Override
	public int insertOrder(OrderVO order) {
		return sqlSession.insert(Namespace+".insertOrder",order);
	}

	@Override
	public int deleteOrder(String index) {
		return sqlSession.delete(Namespace+".deleteOrder",index);
	}

	@Override
	public int deleteOrder_userindex(String user) {
		return sqlSession.delete(Namespace+".deleteOrder_userindex",user);
	}
	
	
    
}
