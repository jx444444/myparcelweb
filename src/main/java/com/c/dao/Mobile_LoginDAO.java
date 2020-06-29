package com.c.dao;

import java.util.List;
import com.c.dto.Moblie_LoginVO;

public interface Mobile_LoginDAO {
	public List<Moblie_LoginVO> select_mobilelogin(String userindex) throws Exception;
	public int delete_mobilelogin(String userindex) throws Exception;
}
