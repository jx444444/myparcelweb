package com.c.myParcel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserOnly {
	static public boolean NonUser(HttpServletRequest request, HttpServletResponse response) {
		//비회원 가리기 전용
		HttpSession session = request.getSession();
		PrintWriter out;
		try {
			out = response.getWriter();
			if (session.getAttribute("usercode")==null) {
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script>alert('로그인이 필요한 서비스입니다.'); </script>");
				out.flush();
				return false;
				//비회원
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		//회원
	}
}
