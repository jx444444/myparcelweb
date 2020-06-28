package com.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.Product_StarVO;

@Repository
public class Product_StarDAOImpl implements Product_StarDAO{
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";
    
    @Override
    public List<Product_StarVO> selectProduct_Star() throws Exception {
        return sqlSession.selectList(Namespace+".selectProduct_Star");
    }
	@Override
	public List<String> selectProduct_Star_count(String productindex) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_Star_count",productindex);
	}
	@Override
	public List<String> selectProduct_Star_avg(String productindex) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_Star_avg",productindex);
	}
	@Override
	public int insertProduct_Star(Product_StarVO product_Star) {
		return sqlSession.insert(Namespace+".insertProduct_Star",product_Star);
	}
	@Override
	public int deleteProduct_Star(Product_StarVO product_Star) {
		return sqlSession.delete(Namespace+".deleteProduct_Star",product_Star);
	}
	@Override
	public int deleteProduct_Star_productindex(String product_index) {
		return sqlSession.delete(Namespace+".deleteProduct_Star_productindex",product_index);
	}
	@Override
	public int deleteProduct_Star_userindex(String user) {
		return sqlSession.delete(Namespace+".deleteProduct_Star_userindex",user);
	}
	@Override
	public List<Product_StarVO> selectProduct_Star_user_prd(Product_StarVO product_Star) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_Star_user_prd",product_Star);
	}
	
	

}
