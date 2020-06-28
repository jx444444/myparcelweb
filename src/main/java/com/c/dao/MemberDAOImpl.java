package com.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.c.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.c.mapper.mainMapper";
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
        return sqlSession.selectList(Namespace+".selectMember");
    }
    
	@Override
	public List<MemberVO> selectMember_idcheck(String id) throws Exception {
		return sqlSession.selectList(Namespace+".selectMember_idcheck",id);
	}

	@Override
	public List<MemberVO> selectMember_login(MemberVO member) throws Exception {
		return sqlSession.selectList(Namespace+".selectMember_login",member);
	}

	@Override
	public int insertMember(MemberVO member) {
		return sqlSession.insert(Namespace+".insertMember",member);
	}

	@Override
	public int deleteMember(String index) {
		return sqlSession.delete(Namespace+".deleteMember",index);
	}

	@Override
	public int updateMember(MemberVO member) {
		return sqlSession.update(Namespace+".updateMember",member);
	}

	@Override
	public List<MemberVO> selectMember_userindex(String index) throws Exception {
		return sqlSession.selectList(Namespace+".selectMember_userindex",index);
	}
	
	
    
}
