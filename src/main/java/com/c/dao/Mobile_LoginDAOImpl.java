package com.c.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.c.dto.Moblie_LoginVO;

@Repository
public class Mobile_LoginDAOImpl implements Mobile_LoginDAO {
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";

	@Override
	public List<Moblie_LoginVO> select_mobilelogin(String userindex) throws Exception {
		return sqlSession.selectList(Namespace+".select_mobilelogin",userindex);
	}

	@Override
	public int delete_mobilelogin(String userindex) throws Exception {
		return sqlSession.delete(Namespace+".delete_mobilelogin",userindex);
	}

}
