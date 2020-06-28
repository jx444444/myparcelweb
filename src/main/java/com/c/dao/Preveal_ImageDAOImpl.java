package com.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.Preveal_ImageVO;

@Repository
public class Preveal_ImageDAOImpl implements Preveal_ImageDAO{
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";
    
    @Override
    public List<Preveal_ImageVO> selectPreveal_Image() throws Exception {
        return sqlSession.selectList(Namespace+".selectPreveal_Image");
    }
    
	@Override
	public List<Preveal_ImageVO> selectPreveal_Image_product_index(String index) throws Exception {
		return sqlSession.selectList(Namespace+".selectPreveal_Image_product_index", index);
	}

	@Override
	public int insertProduct(Preveal_ImageVO preveal_ImageVO) {
		return sqlSession.insert(Namespace+".insertPreveal_Image",preveal_ImageVO);
	}

	@Override
	public int deleteProduct(Preveal_ImageVO preveal_ImageVO) {
		return sqlSession.delete(Namespace+".deletePreveal_Image",preveal_ImageVO);
	}

	@Override
	public int updateProduct(Preveal_ImageVO preveal_ImageVO) {
		return sqlSession.update(Namespace+".updatePreveal_Image",preveal_ImageVO);
	}
    
}
