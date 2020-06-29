package com.c.myParcel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.c.dto.*;
import com.c.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Base64Encoding encoder;
	Base64Decoding decoder;
	String prevealimagesavepath = "C:/Users/user/git/myparcelweb/src/main/webapp/preveal_images/";
	@Inject
	private MainService service;
	
	
	@RequestMapping(value = "/topmenu", method = RequestMethod.GET)
	public String TopMenu(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		System.out.println("TopMenu");
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/home"));
		model.addAttribute("strings_productkind", new XMLPassing().HomeStrings("//*/productkind"));
		
		new AutoBlankTableClean().BlankOrderDelete(service);
		new AutoBlankTableClean().BlankOrderPartDelete(service);
		
		
		
		
		
		return "topmenu";
	}
	//맨 위 파츠
	@RequestMapping(value = "/sessiontest", method = RequestMethod.GET)
	public String sessiontest(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		HttpSession session = request.getSession();
		String usercode = request.getParameter("usercode");
		session.setAttribute("usercode", usercode);
		session.setAttribute("id", service.selectMember_userindex(usercode).get(0).getEmail());
		System.out.println(request.getParameter("usercode")+" 세션 테스트 완료");
		return "blank";
	}

	@RequestMapping(value = "/dbselect", method = RequestMethod.GET)
	public String DBselect(Locale locale, Model model) throws Exception {
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		List<MemberVO> list1 = service.selectMember();
		List<ProductVO> list2 = service.selectProduct();
		List<Basket_ProductVO> list3 = service.selectBasket_Product();
		List<Preveal_ImageVO> list4 = service.selectPreveal_Image();
		List<OrderVO> list5 = service.selectOrder();
		List<Product_StarVO> list6 = service.selectProduct_Star();
		List<OrderProductPartVO> list7 = service.selectOrderproductpart();
		
//		try{
//			Date now = new Date ();
//			String star_user="NA==";
//			String star_product_index="MQ==";
//			String star_star=encoder.Base64StringEncode("8");
//			service.insertProduct_Star(new Product_StarVO(star_user,star_product_index,star_star));
//			
//			String star_user2="Ng==";
//			String star_product_index2="Mg==";
//			String star_star2=encoder.Base64StringEncode("10");
//			service.insertProduct_Star(new Product_StarVO(star_user2,star_product_index2,star_star2));
//
//			String star_user3="Nw==";
//			String star_product_index3="MQ==";
//			String star_star3=encoder.Base64StringEncode("7");
//			service.insertProduct_Star(new Product_StarVO(star_user3,star_product_index3,star_star3));
//			
//			String star_product_index3_2="Mg==";
//			String star_star3_2=encoder.Base64StringEncode("7");
//			service.insertProduct_Star(new Product_StarVO(star_user3,star_product_index3_2,star_star3_2));
//		}
//		catch(Exception e) {
//			
//		}
//		try{
//			Date now = new Date ();
//			
//			String order_index=encoder.Base64StringEncode("1");
//			String order_user="NA==";
//			String order_shipping_place=encoder.Base64StringEncode("경기 김포시 풍무로96번길 42");
//			service.deleteOrder(order_index);
//			service.insertOrder(new OrderVO(order_index,order_user,order_shipping_place,now));
//			
//			String order_index2=encoder.Base64StringEncode("2");
//			String order_user2="Ng==";
//			String order_shipping_place2=encoder.Base64StringEncode("인천광역시 계양구 황어로115번길 12");
//			service.deleteOrder(order_index2);
//			service.insertOrder(new OrderVO(order_index2,order_user2,order_shipping_place2,now));
//			
//			String Basket_Product_user="Ng==";
//			String Basket_Product_product_index="MQ==";
//			service.deleteBasket_Product(new Basket_ProductVO(Basket_Product_user, Basket_Product_product_index,null));
//			service.insertBasket_Product(new Basket_ProductVO(Basket_Product_user, Basket_Product_product_index, now));
//			
//			String Basket_Product_user2="Ng==";
//			String Basket_Product_product_index2="Mg==";
//			service.deleteBasket_Product(new Basket_ProductVO(Basket_Product_user2, Basket_Product_product_index2,null));
//			service.insertBasket_Product(new Basket_ProductVO(Basket_Product_user2, Basket_Product_product_index2, now));
//			
//			String Basket_Product_user3="Nw==";
//			String Basket_Product_product_index3="Mg==";
//			service.deleteBasket_Product(new Basket_ProductVO(Basket_Product_user3, Basket_Product_product_index3,null));
//			service.insertBasket_Product(new Basket_ProductVO(Basket_Product_user3, Basket_Product_product_index3, now));
//		}
//		catch(Exception e) {
//			
//		}
//		try{
//			String pi_product_index=encoder.Base64StringEncode("1");
//			String pi_imagenum=encoder.Base64StringEncode("0");
//			String pi_image_name=encoder.Base64StringEncode("MQ==:미리보기1:0");
//			String pi_fne=encoder.Base64StringEncode("jpg");
//			service.insertPreveal_Image(new Preveal_ImageVO(pi_product_index, pi_imagenum, pi_image_name,pi_fne));
//			String pi_product_index2=encoder.Base64StringEncode("1");
//			String pi_imagenum2=encoder.Base64StringEncode("1");
//			String pi_image_name2=encoder.Base64StringEncode("MQ==:미리보기2:1");
//			service.insertPreveal_Image(new Preveal_ImageVO(pi_product_index2, pi_imagenum2, pi_image_name2,pi_fne));
//			String pi_product_index3=encoder.Base64StringEncode("2");
//			String pi_imagenum3=encoder.Base64StringEncode("1");
//			String pi_image_name3=encoder.Base64StringEncode("Mg==:미리보기1:0");
//			service.insertPreveal_Image(new Preveal_ImageVO(pi_product_index3, pi_imagenum3, pi_image_name3,pi_fne));
//			
//		}
//		catch(Exception e) {
//			
//		}
//		try{
//			
//			Date now = new Date ();
//			System.out.println("55656556565665");
//			String mem_index=encoder.Base64StringEncode("1");
//			String mem_name=encoder.Base64StringEncode("유희왕카드/7000 스트럭처덱/진제왕강림");
//			String mem_pay=encoder.Base64StringEncode("5200");
//			String mem_explanatory=encoder.Base64StringEncode("유희왕, 스트럭처 덱 R. 재생과 파괴, 강대한 힘을 휘두르는 옛 제왕. 지금, 여기에 부활한다! 강림하라, 진 제왕! 당신의 덱에 새로운 제왕의 힘이 깃들었을 때, 승리를 손에 넣을지어다. 유희왕, 오피셜 카드 게임. 듀얼몬스터즈, 스트럭처 덱 R, 진제왕강림. 9월 19일 발매.");
//			String mem_by=encoder.Base64StringEncode("태양샵");
//			String mem_kind=encoder.Base64StringEncode("0");
//			service.insertProduct(new ProductVO(mem_index, mem_name, mem_pay, mem_explanatory, mem_by, mem_kind,now));
//			System.out.println("aaaaaa");
//			String mem_index2=encoder.Base64StringEncode("2");
//			String mem_name2=encoder.Base64StringEncode("[반디] 소프트 애니멀/백상아리/감각발달/상어 장난감/해양");
//			String mem_pay2=encoder.Base64StringEncode("4600");
//			String mem_explanatory2=encoder.Base64StringEncode(".");
//			String mem_by2=encoder.Base64StringEncode("태양샵");
//			String mem_kind2=encoder.Base64StringEncode("0");
//			service.insertProduct(new ProductVO(mem_index2, mem_name2, mem_pay2, mem_explanatory2, mem_by2, mem_kind2,now));
//			
//		}
//		catch(Exception e) {
//			
//		}
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings_productkind", new XMLPassing().HomeStrings("//*/productkind"));
		return "DBSelect";
	}
	//DB 페이지
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);//존재하지 않는 유저라면 강제 로그아웃
		
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
//		service.deleteMember(encoder.Base64StringEncode("4"));
//		service.deleteMember(encoder.Base64StringEncode("6"));
//		service.deleteMember(encoder.Base64StringEncode("7"));
//		
//		String mem_index=encoder.Base64StringEncode("4");
//		String mem_email=encoder.Base64StringEncode("mega@naver.com");
//		String mem_password=encoder.Base64StringEncode("ab1234");
//		String mem_money=encoder.Base64StringEncode("3000");
//		String mem_name=encoder.Base64StringEncode("록맨");
//		
//		String mem_index2=encoder.Base64StringEncode("6");
//		String mem_email2=encoder.Base64StringEncode("octopus@naver.com");
//		String mem_password2=encoder.Base64StringEncode("8888");
//		String mem_money2=encoder.Base64StringEncode("5000");
//		String mem_name2=encoder.Base64StringEncode("왕문어");
//		
//		String mem_index3=encoder.Base64StringEncode("7");
//		String mem_email3=encoder.Base64StringEncode("whitedragon@naver.com");
//		String mem_password3=encoder.Base64StringEncode("abababab");
//		String mem_money3=encoder.Base64StringEncode("3500");
//		String mem_name3=encoder.Base64StringEncode("백룡");
//		
//		MemberVO newmember1 = new MemberVO(mem_index,mem_email,mem_password,mem_money,mem_name);
//		MemberVO newmember2 = new MemberVO(mem_index2,mem_email2,mem_password2,mem_money2,mem_name2);
//		MemberVO newmember3 = new MemberVO(mem_index3,mem_email3,mem_password3,mem_money3,mem_name3);
//		try{
//			service.insertMember(newmember1);
//		}
//		catch(Exception e) {
//			
//		}
//		try{
//			service.insertMember(newmember2);
//		}
//		catch(Exception e) {
//			
//		}
//		try{
//			service.insertMember(newmember3);
//		}
//		catch(Exception e) {
//			
//		}
//		newmember2.setEmail(encoder.Base64StringEncode("squid@naver.com"));
//		service.updateMember(newmember2);
//		
//		List<MemberVO> list1 = service.selectMember();
//		
//		for ( MemberVO mv : list1) {
//			System.out.println(decoder.Base64StringEncode(mv.getIndex())+" , "+
//								decoder.Base64StringEncode(mv.getEmail())+" , "+
//								decoder.Base64StringEncode(mv.getPassword())+" , "+
//								decoder.Base64StringEncode(mv.getMoney()));
//		}
//		
			
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/home"));
		
		
		return "home";
	}
	//메인 페이지
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/login"));
		return "login";
	}
	//로그인 페이지
	
	@RequestMapping(value = "/login_submit", method = RequestMethod.POST)
	public String login_submit(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		System.out.println("aaaaaa");
		String id = encoder.Base64StringEncode(request.getParameter("login_email_textfield"));
		String pwd = encoder.Base64StringEncode(request.getParameter("login_pwd_textfield"));
		List<MemberVO> list1 = null;
		try {
			list1 = service.selectMember_login(
										new MemberVO("", id, pwd,"","")
										);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리스트 : "+list1);
		PrintWriter out = response.getWriter();
		if (list1.size()==0) {
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('이메일 또는 비밀번호가 틀립니다.'); location.href='/login';</script>");
			out.flush();
			return home(locale, model);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("id", decoder.Base64StringEncode(list1.get(0).getName()));
		session.setAttribute("usercode", list1.get(0).getIndex());
		out.println("<script>location.href='/';</script>");
		out.flush();
		return home(locale, model);
	}
	//로그인 함
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		session.setAttribute("usercode", null);
		return login(locale, model);
	}
	//로그아웃함
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/login"));
		return "signup";
	}
	//회원가입 페이지
	
	@RequestMapping(value = "/signup_submit", method = RequestMethod.POST)
	public String signup_submit(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		System.out.println("aaaaaa");
		String name = encoder.Base64StringEncode(request.getParameter("signup_name_textfield"));
		String id = encoder.Base64StringEncode(request.getParameter("signup_email_textfield"));
		String normalpwd = request.getParameter("signup_pwd_textfield");
		String pwd = encoder.Base64StringEncode(request.getParameter("signup_pwd_textfield"));
		String pwdcheck = encoder.Base64StringEncode(request.getParameter("signup_pwd_check_textfield"));
		pwd=pwd.trim();
		//---------------------------------------------------------------------------------
		PrintWriter out = response.getWriter();
		System.out.println("비번길이 : "+normalpwd.length() + "("+normalpwd+")");
		if (normalpwd.length()<6) {//비번6자
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('비밀번호는 6자 이상 입력해야 합니다.'); location.href='/signup';</script>");
			out.flush();
			return home(locale, model);
		}
		else if (pwd.equals(pwdcheck)!=true) {//비번다시입력이 안 맞는다면?
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('비밀번호와 비밀번호 다시 입력은 동일하게 입력해야 합니다.'); location.href='/signup';</script>");
			out.flush();
			return home(locale, model);
		}
		else {//---------------------------------------------------------------------------------
			List<MemberVO> list1 = null;
			try {
				list1 = service.selectMember_idcheck(id);//같은 아이디를 가진 사람이 있는지 체크
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list1.size()>0) {//있으면 중복 표시
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script>alert('아이디가 이미 존재합니다.'); location.href='/login';</script>");
				out.flush();
				return home(locale, model);
			}
			else {
				//---------------------------------------------------------------------------------
				try {
					list1 = service.selectMember();//인덱스를 생성하기 위한 체크
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int index = Integer.parseInt(decoder.Base64StringEncode(list1.get(0).getIndex()))+1;
				MemberVO newmember = new MemberVO(encoder.Base64StringEncode(index+""),
												id,
												pwd,
												encoder.Base64StringEncode("0"),
												name);
				try{
					service.insertMember(newmember);
				}
				catch(Exception e) {
					
				}
			}
			//---------------------------------------------------------------------------------
		}
		HttpSession session = request.getSession();
		out.println("<script>location.href='/';</script>");
		out.flush();
		return home(locale, model);
	}
	//회원가입 완료
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		model.addAttribute("p", request.getParameter("p"));
		//p는 상품의 번호다.
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/product"));
		return "product";
	}
	//상품 정보 페이지
	@RequestMapping(value = "/product_basketbutton", method = RequestMethod.GET)
	public String product_basketbutton(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		HttpSession session = request.getSession();
		Basket_ProductVO bsk=new Basket_ProductVO();
		bsk.setUser(session.getAttribute("usercode")+"");
		bsk.setProduct_index(request.getParameter("p"));
		bsk.setChecked(encoder.Base64StringEncode("1"));
		List<Basket_ProductVO> bsklist = service.selectBasket_Product_basketproduct(bsk);
		System.out.println("bsk : "+bsk.getUser()+","+bsk.getProduct_index());
		System.out.println("bsklist : "+bsklist);
		System.out.println("basketresult : "+bsklist.size());
		
		model.addAttribute("p", request.getParameter("p"));
		model.addAttribute("basketresult", bsklist.size()+"");
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/product"));
		return "productBasketAddButton";
	}
	//상품 정보 페이지)장바구니버튼
	
	
	@RequestMapping(value = "/product_basket_add", method = RequestMethod.GET)//
	public String product_basket_add(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return product_basketbutton(request, response, locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		HttpSession session = request.getSession();
		Date now = new Date();
		String product = request.getParameter("p");
		String num = encoder.Base64StringEncode(request.getParameter("num"));
		String checked = encoder.Base64StringEncode("1");
		try {
		Basket_ProductVO newBasketProduct = new Basket_ProductVO(session.getAttribute("usercode")+"", product, now,num, checked);
		service.insertBasket_Product(newBasketProduct);
		}
		catch(Exception e) {
			
		}
		return product_basketbutton(request, response, locale, model);
	}
	//상품 정보 페이지)장바구니버튼)장바구니넣기
	
	@RequestMapping(value = "/product_basket_delete", method = RequestMethod.GET)
	public String product_basket_delete(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return product_basketbutton(request, response, locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		String user = session.getAttribute("usercode")+"";
		String p = request.getParameter("p");
		try {
		service.deleteBasket_Product(new Basket_ProductVO(user,p,null,null,null));
		}
		catch(Exception e) {}
		return product_basketbutton(request, response, locale, model);
	}
	//상품 정보 페이지)장바구니버튼)장바구니에서삭제
	

	
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/basket"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userbasket";
	}
	//장바구니 페이지
	
	@RequestMapping(value = "/basketlist", method = RequestMethod.GET)
	public String basketlist(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("ordererIndex", session.getAttribute("usercode")+"");
		model.addAttribute("strings", xl.HomeStrings("//*/basket"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userbasketlist";
	}
	//장바구니 페이지)리스트 표시
	
	@RequestMapping(value = "/basketlist_json", method = RequestMethod.GET)
	public String basketlist_json(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("ordererIndex", request.getParameter("u")+"");
		return "userbasketlistjson";
	}
	//장바구니 페이지)리스트 표시(json전용)
	
	@RequestMapping(value = "/todaydeal_json", method = RequestMethod.GET)
	public String todaydeal_json(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		return "todaydeal_json";
	}
	//홈 페이지)오늘의딜(json전용)
	
	@RequestMapping(value = "/searchresult_json", method = RequestMethod.GET)
	public String searchresult_json(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("searchword", request.getParameter("sch"));
		model.addAttribute("filter", request.getParameter("flt"));
		model.addAttribute("star", request.getParameter("st"));
		model.addAttribute("tag", request.getParameter("tag"));
		model.addAttribute("brand", request.getParameter("br"));
		model.addAttribute("align", request.getParameter("agn"));
		return "searchresult_json";
	}
	//홈 페이지)검색결과(json전용)
	
	
	@RequestMapping(value = "/productpage_json", method = RequestMethod.GET)
	public String productpage_json(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		Basket_ProductVO bsk=new Basket_ProductVO();
		bsk.setUser(request.getParameter("u"));
		bsk.setProduct_index(request.getParameter("pid"));
		bsk.setChecked(encoder.Base64StringEncode("1"));
		List<Basket_ProductVO> bsklist = service.selectBasket_Product_basketproduct(bsk);
		
		model.addAttribute("basketresult", bsklist.size()+"");
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("productIndex", request.getParameter("pid")+"");
		return "productpagejson";
	}//상품페이지(json전용)
	
	
	
	@RequestMapping(value = "/user_json", method = RequestMethod.GET)
	public String user_json(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("userindex", request.getParameter("ui")+"");
		
		String flag = request.getParameter("flag");
		if(flag == null || flag.equals("") || flag.equals(null)) {
			flag = "0";
		}
		model.addAttribute("flag", flag);
		return "userjson";
	}//상품페이지(json전용)
	
	
	
	
	@RequestMapping(value = "/mobilelogin_json", method = RequestMethod.GET)
	public String mobilelogin_json(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("uuid", request.getParameter("uuid")+"");
		return "mobilelogin_json";
	}
	//장바구니 페이지)리스트 표시(json전용)
	
	
	
	
	@RequestMapping(value = "/basketorder", method = RequestMethod.GET)
	public String basketorder(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("ordererIndex", session.getAttribute("usercode")+"");
		model.addAttribute("strings", xl.HomeStrings("//*/basket"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userbasketorder";
	}
	//장바구니 페이지)바구니에 담은 총액, 총 품목수 표시
	
	@RequestMapping(value = "/basketdelete", method = RequestMethod.GET)
	public String basketdelete(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		String user = session.getAttribute("usercode")+"";
		String b_productindex = request.getParameter("b_productindex");
		
		service.deleteBasket_Product(new Basket_ProductVO(user,b_productindex,null,null,null));
		
		return basketlist(request, response, locale, model);
	}
	//장바구니 페이지)장바구니에서 삭제하기
	
	@RequestMapping(value = "/basketupdate", method = RequestMethod.GET)
	public String basketupdate(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		HttpSession session = request.getSession();
		Basket_ProductVO b_product = new Basket_ProductVO();
		String num = encoder.Base64StringEncode(request.getParameter("num"));
		b_product.setUser(session.getAttribute("usercode")+"");
		String flag = request.getParameter("flag");
		System.out.println("flag : "+flag);
		if(flag.equals("0")) {
			b_product.setProduct_index(encoder.Base64StringEncode(request.getParameter("p")));
		}
		else
			b_product.setProduct_index(request.getParameter("p"));
		b_product.setNum(num);
		System.out.println("b_product.setNum(num);");
		System.out.println(b_product.getNum()+","+b_product.getProduct_index()+","+b_product.getUser());
		 
		service.updateBasket_Product(b_product);
		
		return Userbasketlist_pay(request, response, locale, model);
	}
	//장바구니 페이지)장바구니에서 수량을 바꾸기(총 품목 수와 총액도 계산)
	
	
	
	
	
	
	
	@RequestMapping(value = "/basketupdatecheck", method = RequestMethod.GET)
	public String basketupdatecheck(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		System.out.println(encoder.Base64StringEncode(request.getParameter("chk")));
		HttpSession session = request.getSession();
		Basket_ProductVO b_product = new Basket_ProductVO();
		b_product.setUser(session.getAttribute("usercode")+"");
		b_product.setProduct_index(request.getParameter("p"));
		b_product.setChecked(encoder.Base64StringEncode(request.getParameter("chk")));
		 System.out.println("session.getAttribute(\"usercode\") : "+session.getAttribute("usercode"));
		service.updateBasket_Product_checked(b_product);
		
		return "blank";
	}
	//장바구니 페이지)장바구니에서 체크여부 바꾸기(총 품목 수와 총액도 계산)
	
	@RequestMapping(value = "/basketupdateallcheck", method = RequestMethod.GET)
	public String basketupdateallcheck(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		System.out.println(encoder.Base64StringEncode(request.getParameter("chk")));
		HttpSession session = request.getSession();
		Basket_ProductVO b_product = new Basket_ProductVO();
		b_product.setUser(session.getAttribute("usercode")+"");
		b_product.setChecked(encoder.Base64StringEncode(request.getParameter("chk")));
		service.updateBasket_Product_allchecked(b_product);
		
		return "blank";
	}
	//장바구니 페이지)장바구니에서 체크여부 모두 바꾸기(총 품목 수와 총액도 계산)
	
	
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String Order(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/order"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userOrder";
	}
	//주문현황 페이지
	
	@RequestMapping(value = "/orderlist", method = RequestMethod.GET)
	public String Orderlist(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/order"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userOrderlist";
	}
	//주문현황 페이지)리스트 표시
	
	
	
	
	@RequestMapping(value = "/orderlistjson", method = RequestMethod.GET)
	public String Orderlistjson(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("ordererIndex", request.getParameter("u")+"");
		model.addAttribute("strings", xl.HomeStrings("//*/order"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userorderlistjson";
	}
	//json:주문내역리스트
	
	
	
	
	@RequestMapping(value = "/orderwindow", method = RequestMethod.GET)
	public String OrderWindow(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		String[] productindex = (request.getParameter("p")+"").split("_");
		List<ProductVO> pd = new ArrayList<ProductVO>();
		for (int i=0 ; i<productindex.length ;i++)
			pd.add(service.selectProduct_product_index(encoder.Base64StringEncode(productindex[i])).get(0));
		
		model.addAttribute("productList", pd);
		model.addAttribute("ordererName", session.getAttribute("id")+"");
		
		String[] productnum = (request.getParameter("num")+"").split("_");
		List<String> pd_num = new ArrayList<String>();
		for (int i=0 ; i<productnum.length ;i++)
			pd_num.add(productnum[i]);
		
		System.out.println(pd_num);
		model.addAttribute("productList_num", pd_num);
		
		model.addAttribute("p", request.getParameter("p"));
		model.addAttribute("num", request.getParameter("num"));
		model.addAttribute("ordererIndex", session.getAttribute("usercode")+"");
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/orderwindow"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "orderwindow";
	}
	//주문 창(여기서 배송지를 입력하고 확인버튼을 눌러야 주문됨.)
	
	
	
	@RequestMapping(value = "/ordering", method = RequestMethod.POST)
	public String Ordering(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		Date now = new Date ();
		String order_index="0";
		String order_user=request.getParameter("ordererIndex");
		String order_shipping_place=request.getParameter("area");
		String flag=request.getParameter("flag").toString();
		
		try {
			List<OrderVO> list1 = service.selectOrder();//인덱스를 생성하기 위한 체크
			int index = Integer.parseInt(decoder.Base64StringEncode(list1.get(0).getIndex()))+1;
			order_index=index+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(encoder.Base64StringEncode(order_index)+" "+order_user+" "+encoder.Base64StringEncode(order_shipping_place));
			service.insertOrder(new OrderVO(encoder.Base64StringEncode(order_index),
											order_user,
											encoder.Base64StringEncode(order_shipping_place),
											now));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String[] productindex = (request.getParameter("p")+"").split("_");
		String[] productnum = (request.getParameter("num")+"").split("_");
		System.out.println(request.getParameter("p"));
		System.out.println(request.getParameter("num"));
		for (int i=0 ; i<productindex.length ; i++) {
			OrderProductPartVO opp = new OrderProductPartVO( (flag.equals("0") ? encoder.Base64StringEncode(productindex[i]) : productindex[i]), 
															encoder.Base64StringEncode(order_index), 
															encoder.Base64StringEncode(productnum[i]));
			//flag=0 : 웹전용
			//flag=1 : 안드로이드전용
			service.insertorderproductpart(opp);
		}
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/order"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		
		PrintWriter out = response.getWriter();
		out.println("<script>location.href='/order';</script>");
		out.flush();
		return home(locale, model);
	}
	//주문중(주문 뒤 주문내역으로 돌아감)
	
	@RequestMapping(value = "/orderdelete", method = RequestMethod.GET)
	public String orderdelete(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		String index = request.getParameter("o_index");
		
		service.deleteOrder(index);
		service.deleteorderproductpart(index);
		
		return Orderlist(request, response, locale, model);
	}
	//주문내역 페이지)주문내역 삭제하기
	
	@RequestMapping(value = "/userbasketlist_pay", method = RequestMethod.GET)
	public String Userbasketlist_pay(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		String total = request.getParameter("total");
		
		model.addAttribute("total", total);
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		return "userbasketlist_pay";
	}
	//로그인 함
	
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String searchword = request.getParameter("sch");
		String filter = request.getParameter("flt");
		model.addAttribute("searchword", searchword);
		model.addAttribute("filter", filter);
		model.addAttribute("service", service);
		model.addAttribute("encoder", encoder);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/search"));
		return "search";
	}
	//검색 결과
	
	
	@RequestMapping(value = "/searchlist", method = RequestMethod.GET)
	public String searchlist(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String searchword = request.getParameter("sch");
		String filter = request.getParameter("flt");
		String star = request.getParameter("st");
		model.addAttribute("searchword", searchword);
		model.addAttribute("filter", filter);
		model.addAttribute("star", star);
		model.addAttribute("tag", request.getParameter("tag"));
		model.addAttribute("brand", request.getParameter("br"));
		model.addAttribute("align", request.getParameter("agn"));
		model.addAttribute("service", service);
		model.addAttribute("encoder", encoder);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/search"));
		return "searchlist";
	}
	//검색 결과 일부
	
	@RequestMapping(value = "/searchlist_tag", method = RequestMethod.GET)
	public String searchtag(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String searchword = request.getParameter("sch");
		String filter = request.getParameter("flt");
		String star = request.getParameter("st");
		model.addAttribute("searchword", searchword);
		model.addAttribute("filter", filter);
		model.addAttribute("star", star);
		model.addAttribute("tag", request.getParameter("tag"));
		model.addAttribute("brand", request.getParameter("br"));
		model.addAttribute("service", service);
		model.addAttribute("encoder", encoder);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/search"));
		return "searchtag";
	}
	//검색 결과 일부_태그 검색
	
	@RequestMapping(value = "/searchlist_brand", method = RequestMethod.GET)
	public String searchbrand(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String searchword = request.getParameter("sch");
		String filter = request.getParameter("flt");
		String star = request.getParameter("st");
		model.addAttribute("searchword", searchword);
		model.addAttribute("filter", filter);
		model.addAttribute("star", star);
		model.addAttribute("tag", request.getParameter("tag"));
		model.addAttribute("brand", request.getParameter("br"));
		model.addAttribute("service", service);
		model.addAttribute("encoder", encoder);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/search"));
		return "searchbrand";
	}
	//검색 결과 일부_브랜드로 검색
	
	
	
	@RequestMapping(value = "/searchlist_star", method = RequestMethod.GET)
	public String searchliststar(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String id = encoder.Base64StringEncode(request.getParameter("id"));
		List<String> lst = service.selectProduct_Star_avg(id);
		double num = Double.parseDouble(lst.get(0));
		num = Math.round(num);
		model.addAttribute("num", (int)num);
		model.addAttribute("id", request.getParameter("id"));
		return "productStarReadOnly";
	}
	//검색 결과_별점
	
	
	
	@RequestMapping(value = "/product_star", method = RequestMethod.GET)
	public String product_star(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		HttpSession session = request.getSession();
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String id = encoder.Base64StringEncode(request.getParameter("id"));
		
		String user = session.getAttribute("usercode")+"";
		Product_StarVO psvo = new Product_StarVO(
				user,
				encoder.Base64StringEncode(request.getParameter("id")),"");
		
		List<Product_StarVO> lst = service.selectProduct_Star_user_prd(psvo);
		if(lst.size()<=0) {
			model.addAttribute("num", 0);
		}
		else {
			int num = Integer.parseInt( decoder.Base64StringEncode(lst.get(0).getStar()) );
			System.out.println("num : "+num);
			model.addAttribute("num", num);
		}
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("encoder", encoder);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", new XMLPassing().HomeStrings("//*/product"));
		return "productStar";
	}
	//검색 결과_별점등록
	
	
	
	@RequestMapping(value = "/langchange", method = RequestMethod.GET)
	public String langchange(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		HttpSession session = request.getSession();
		String lang = request.getParameter("lang");
		session.setAttribute("lang", lang);
		return "blank";
	}
	//언어 바꾸기
	
	
	@RequestMapping(value = "/starupdate", method = RequestMethod.GET)
	public String starupdate(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		HttpSession session = request.getSession();
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String productid = request.getParameter("id");//상품식별자
		String starnum = encoder.Base64StringEncode(request.getParameter("num"));//별점
		String user = session.getAttribute("usercode")+"";
		
		service.deleteProduct_Star(new Product_StarVO(user,productid,""));
		service.insertProduct_Star(new Product_StarVO(user,productid,starnum));
		return "blank";
	}
	//별점주기
	
	
	
	@RequestMapping(value = "/userOrderDeleteQuastion", method = RequestMethod.GET)
	public String userOrderDeleteQuastion(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("orderindex", request.getParameter("p"));
		model.addAttribute("shipping_place", request.getParameter("sp"));
		model.addAttribute("day", request.getParameter("day"));
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/order"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userOrderDeleteQuastion";
	}
	//주문페이지의 주문취소 다이얼로그
	
	
	
	@RequestMapping(value = "/userbasketDeleteQuastion", method = RequestMethod.GET)
	public String userbasketDeleteQuastion(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if(UserOnly.NonUser(request, response)==false)return home(locale, model);
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		model.addAttribute("productindex", request.getParameter("p"));
		
		model.addAttribute("service", service);
		model.addAttribute("decoder", decoder);
		model.addAttribute("strings", xl.HomeStrings("//*/basket"));
		model.addAttribute("strings_productkind", xl.HomeStrings("//*/productkind"));
		return "userbasketDeleteQuastion";
	}
	//장바구니페이지의 주문취소 다이얼로그
	
	
	
	
	@RequestMapping(value = "/productadd", method = RequestMethod.POST)
	public String ProductAdd(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		
		Date day = new Date ();
		String index=encoder.Base64StringEncode((Integer.parseInt(decoder.Base64StringEncode(service.selectProduct().get(0).getIndex()))+1)+"");
		System.out.println("index : "+index);
		String pname=encoder.Base64StringEncode(request.getParameter("pname")+"");
		System.out.println("pname : "+pname+"("+request.getParameter("pname")+")");
		String pay=encoder.Base64StringEncode(request.getParameter("pay")+"");
		System.out.println("pay : "+pay+"("+request.getParameter("pay")+")");
		String explanatory=encoder.Base64StringEncode(request.getParameter("explanatory")+"");
		System.out.println("explanatory : "+explanatory+"("+request.getParameter("explanatory")+")");
		String by=encoder.Base64StringEncode(request.getParameter("by")+"");
		System.out.println("by : "+by+"("+request.getParameter("by")+")");
		String kind=encoder.Base64StringEncode(request.getParameter("kind")+"");
		System.out.println("kind : "+kind+"("+request.getParameter("kind")+")");
		String tag=encoder.Base64StringEncode(request.getParameter("tag")+"");
		System.out.println("tag : "+tag+"("+request.getParameter("tag")+")");
		String brand=encoder.Base64StringEncode(request.getParameter("brand")+"");
		System.out.println("brand : "+brand+"("+request.getParameter("brand")+")");
		ProductVO newproduct = new ProductVO(index, pname, pay, explanatory, by, kind, day,0, tag, brand);
		System.out.println("newproduct : "+newproduct);
		service.insertProduct(newproduct);
		
		
		MultipartHttpServletRequest request2 = (MultipartHttpServletRequest)request;
		List<MultipartFile> fileList = request2.getFiles("file");
		System.out.println("fileList : "+fileList);
		List<File> outputFilelist = new MultipartFileConvert().convert(fileList,index,encoder);
		
		
		for(int i = 0 ; i<outputFilelist.size() ; i++) {
			BufferedImage bi = null;      
			try {
			    bi = ImageIO.read(outputFilelist.get(i));
			    int pos = outputFilelist.get(i).getName().lastIndexOf( "." );
			    
			    System.out.println(outputFilelist.get(i).getName());
			    System.out.println(prevealimagesavepath);
			    String extension = outputFilelist.get(i).getName().substring(pos+1);
			    
			    ImageIO.write(bi, extension, new File(prevealimagesavepath+outputFilelist.get(i).getName()));
			    
			    String pi_product_index=index;
				String pi_imagenum=encoder.Base64StringEncode(i+"");
				String pi_image_name=outputFilelist.get(i).getName().substring(0,pos);
				String pi_fne=encoder.Base64StringEncode(extension);
				service.insertPreveal_Image(new Preveal_ImageVO(pi_product_index, pi_imagenum, pi_image_name,pi_fne));
			    
			    System.out.println("filesaved");
			} catch (MalformedURLException e) {
			    ;
			} catch (IOException e) {
			    ;
			}
		}
		
		return DBselect(locale, model);
	}
	//상품 추가
	
	@RequestMapping(value = "/productdelete", method = RequestMethod.GET)
	public String root_ProductDelete(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		String product_index=request.getParameter("pindex");
		
		Preveal_ImageVO Pimage = new Preveal_ImageVO();
		Pimage.setProduct_index(product_index);
		service.deletePreveal_Image(Pimage);
		//미리보기 이미지들 삭제
		
		Basket_ProductVO bp = new Basket_ProductVO();
		bp.setProduct_index(product_index);
		service.deleteBasket_Product_index(bp);//장바구니에 있는 상품삭제
		service.deleteorderproductpart_productindex(product_index);//주문내역에 있는 상품 삭제
		service.deleteProduct_Star_productindex(product_index);//해당 상품의 별점삭제
		
		service.deleteProduct(product_index);//해당 상품 삭제
		return DBselect(locale, model);
	}
	//상품삭제
	
	@RequestMapping(value = "/userdelete", method = RequestMethod.GET)
	public String root_UserDelete(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		String user_index=request.getParameter("uindex");
		
		service.deleteMember(user_index);
		//유저삭제
		service.deleteBasket_user_index(user_index);
		//삭제될 유저와 관련된 장바구니 열 삭제
		service.deleteOrder_userindex(user_index);
		//삭제될 유저와 관련된 주문 열 삭제
		service.deleteProduct_Star_userindex(user_index);
		//삭제될 유저와 관련된 주문 별점 열 삭제
		
		
		//삭제될 유저와 관련된 주문 제품들 리스트 이미지 열 삭제
		return DBselect(locale, model);
	}//유저삭제
	
	
	
	
	
	@RequestMapping(value = "/mobilelogin_insert", method = RequestMethod.GET)
	public String mobilelogin_(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		if (new UserNoExist().NoExist(service))return home(locale, model);
		encoder=new Base64Encoding();
		decoder=new Base64Decoding();
		XMLPassing xl = new XMLPassing();
		HttpSession session = request.getSession();
		
		String index = request.getParameter("uindex");
		String uuid = request.getParameter("uuid");
		
		List<Moblie_LoginVO> list = service.select_mobilelogin(uuid);
		if(list.size()==0) {//로그인을 안 한 상태라면?
			service.insert_mobilelogin(new Moblie_LoginVO(index,uuid));//로그인한 상태로 만든다.(모바일로그인 테이블에 저장)
		}
		return "blank";
	}
	//장바구니 페이지)리스트 표시(json전용)
}
