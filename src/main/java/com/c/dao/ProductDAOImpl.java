package com.c.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";
    
    @Override
    public List<ProductVO> selectProduct() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectProduct");
    }
    @Override
	public List<ProductVO> selectProduct_product_index(String index) throws Exception {
    	return sqlSession.selectList(Namespace+".selectProduct_product_index", index);
	}
    
	@Override
	public List<ProductVO> selectProduct_name(String name) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name", name);
	}
	@Override
	public List<ProductVO> selectProduct_name_kind(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name_kind", product);
	}
	@Override
	public List<String> selectProduct_name_tag(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name_tag", product);
	}
	@Override
	public List<String> selectProduct_name_brand(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name_brand", product);
	}
	
	@Override
	public List<ProductVO> selectProduct_name_kind_paydesc(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name_kind_paydesc", product);
	}
	
	@Override
	public List<ProductVO> selectProduct_name_kind_payasc(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name_kind_payasc", product);
	}
	
	@Override
	public List<ProductVO> selectProduct_name_kind_day(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_name_kind_day", product);
	}
	
	
	
	@Override
	public List<ProductVO> selectProduct_product_star() throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_product_star");
	}
	@Override
	public int insertProduct(ProductVO product) {
    	return sqlSession.insert(Namespace+".insertProduct",product);
	}
	@Override
	public int deleteProduct(String index) {
		return sqlSession.delete(Namespace+".deleteProduct",index);
	}
	@Override
	public int updateProduct(ProductVO product) {
		return sqlSession.update(Namespace+".updateProduct",product);
	}
	
	
	
	@Override
	public List<ProductVO> selectProduct_productpage_anothertag(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_productpage_anothertag", product);
	}
	@Override
	public List<ProductVO> selectProduct_productpage_anotherbrand(ProductVO product) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_productpage_anotherbrand", product);
	}
	@Override
	public List<String> selectProduct_index_tag(String index) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_index_tag", index);
	}
	@Override
	public List<String> selectProduct_index_brand(String index) throws Exception {
		return sqlSession.selectList(Namespace+".selectProduct_index_brand", index);
	}
	
	
	

}
