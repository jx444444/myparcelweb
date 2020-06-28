package com.c.myParcel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xml.sax.SAXException;

import com.c.service.MainService;

public class UserNoExist {

	public boolean NoExist(MainService service) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException, Exception {
		HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getRequest();
		HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getResponse();
		HttpSession session = request.getSession(true);
		
		Object userid = session.getAttribute("usercode");
		System.out.println("userid = "+userid);
		if(userid!=null) {
			if(service.selectMember_userindex(userid.toString()).size()==0) {
				PrintWriter out = response.getWriter();
				List<String> logoutmessage = new XMLPassing().HomeStrings("//*/message");
				response.setContentType("text/html; charset=UTF-8");
				session.setAttribute("id", null);
				session.setAttribute("usercode", null);
				out.println("<script>alert('"+logoutmessage.get(0)+"');location.reload();</script>");
				out.flush();
				return true;
			}
		}
		return false;
	}
}
