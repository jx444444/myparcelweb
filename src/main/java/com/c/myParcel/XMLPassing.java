package com.c.myParcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLPassing {
	public List<String> HomeStrings(String expression) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		List<String> lists = new ArrayList<String>();
		
		String Language="";
		HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("lang"));
		
		switch(session.getAttribute("lang")+"") {
			case "1":Language="eng";break;
			case "2":Language="jap";break;
			default:Language="kor";break;
		}
		
		System.out.println(Language);
		
		Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("F:\\springtest2\\myParcel\\src\\main\\resources\\string_"+Language+".xml"));
		xml.getDocumentElement().normalize();
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node node = (Node) xpath.evaluate(expression, xml, XPathConstants.NODE);
		String Nodes = node.getFirstChild().getNodeValue().replaceAll("\t", "");
		Nodes = Nodes.trim();
		String[] strlist = Nodes.split("\\n");
		for (String str : strlist) {
			if (str!=null && str!="")
				str = str.replaceAll("\\\\n", "\n");
				lists.add(str);
		}
		return lists;
	}
}
