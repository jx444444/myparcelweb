package com.c.dao;

import java.util.List;

import com.c.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectMember() throws Exception;
	public List<MemberVO> selectMember_idcheck(String id) throws Exception;
	public List<MemberVO> selectMember_login(MemberVO member) throws Exception;
	public int insertMember(MemberVO member);
	public int deleteMember(String index);
	public int updateMember(MemberVO member);
	public List<MemberVO> selectMember_userindex(String index) throws Exception;
}
