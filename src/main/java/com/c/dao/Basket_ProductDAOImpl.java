package com.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.Basket_ProductVO;

@Repository
public class Basket_ProductDAOImpl implements Basket_ProductDAO{
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";
    
    @Override
    public List<Basket_ProductVO> selectBasket_Product() throws Exception {
        return sqlSession.selectList(Namespace+".selectBasket_Product");
    }
    
	@Override
	public List<Basket_ProductVO> selectBasket_Product_usersbasket(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_usersbasket", user);
	}
	
	@Override
	public List<Basket_ProductVO> selectBasket_Product_basketproduct(Basket_ProductVO basket_prodoct) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_basketproduct", basket_prodoct);
	}
	

	@Override
	public int insertBasket_Product(Basket_ProductVO basket_prodoct) {
		return sqlSession.insert(Namespace+".insertBasket_Product",basket_prodoct);
	}

	@Override
	public int deleteBasket_Product(Basket_ProductVO basket_prodoct) {
		return sqlSession.delete(Namespace+".deleteBasket_Product",basket_prodoct);
	}
	
	@Override
	public int deleteBasket_Product_index(Basket_ProductVO basket_prodoct) {
		return sqlSession.delete(Namespace+".deleteBasket_Product_index",basket_prodoct);
	}

	@Override
	public int updateBasket_Product(Basket_ProductVO basket_prodoct) {
		return sqlSession.delete(Namespace+".updateBasket_Product",basket_prodoct);
	}

	@Override
	public int updateBasket_Product_checked(Basket_ProductVO basket_prodoct) {
		return sqlSession.delete(Namespace+".updateBasket_Product_checked",basket_prodoct);
	}

	@Override
	public List<String> selectBasket_Product_usersbasket_paytotal(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_usersbasket_paytotal", user);
	}

	@Override
	public List<String> selectBasket_Product_usersbasket_counttotal(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_usersbasket_counttotal", user);
	}

	@Override
	public int updateBasket_Product_allchecked(Basket_ProductVO basket_prodoct) {
		return sqlSession.delete(Namespace+".updateBasket_Product_allchecked",basket_prodoct);
	}

	@Override
	public List<Basket_ProductVO> selectBasket_Product_usersbasket_checked(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_usersbasket_checked", user);
	}

	@Override
	public List<String> selectBasket_Product_usersbasket_checkedcount(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_usersbasket_checkedcount", user);
	}

	@Override
	public List<String> selectBasket_Product_usersbasket_count(String user) throws Exception {
		return sqlSession.selectList(Namespace+".selectBasket_Product_usersbasket_count", user);
	}

	@Override
	public int deleteBasket_user_index(String user) {
		return sqlSession.delete(Namespace+".deleteBasket_user_index",user);
	}
	
	
	
	
	
    
}
