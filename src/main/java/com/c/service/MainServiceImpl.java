package com.c.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.c.dao.*;
import com.c.dto.*;
import com.c.myParcel.Base64Decoding;

@Service
public class MainServiceImpl implements MainService {
	@Inject
    private MemberDAO dao;
    @Override
    public List<MemberVO> selectMember() throws Exception {
        return dao.selectMember();
    }
	@Override
	public List<MemberVO> selectMember_idcheck(String id) throws Exception {
		return dao.selectMember_idcheck(id);
	}
	@Override
	public List<MemberVO> selectMember_login(MemberVO member) throws Exception {
		return dao.selectMember_login(member);
	}
	@Override
	public int insertMember(MemberVO member) throws Exception {
		return dao.insertMember(member);
	}
	@Override
	public int deleteMember(String index) throws Exception {
		return dao.deleteMember(index);
	}
	@Override
	public int updateMember(MemberVO member) throws Exception {
		return dao.updateMember(member);
	}
	@Override
	public List<MemberVO> selectMember_userindex(String index) throws Exception {
		return dao.selectMember_userindex(index);
	}




	@Inject
    private ProductDAO dao2;
    @Override
	public List<ProductVO> selectProduct_product_index(String index) throws Exception {
    	return dao2.selectProduct_product_index(index);
	}
	@Override
	public List<ProductVO> selectProduct_product_star() throws Exception {
		return dao2.selectProduct_product_star();
	}
	@Override
    public List<ProductVO> selectProduct() throws Exception {
        return dao2.selectProduct();
    }
    @Override
	public List<ProductVO> selectProduct_name(String name,String kind,int star,String tag,String brand,String align) throws Exception {
    	System.out.println("kind : "+kind);
    	ProductVO product = new ProductVO();
    	product.setName("%"+name+"%");
    	product.setKind( (Integer.parseInt(kind)-1) +"");
    	product.setExtra(star);//extra 요소는 별점 검사로 쓴다.
    	product.setTag("%"+tag+"%");
    	product.setBrand("%"+brand+"%");
    	System.out.println(star);
    	System.out.println("align : "+align);
    	switch(align) {
    		case "0": return dao2.selectProduct_name_kind_payasc(product);
    		case "1" : return dao2.selectProduct_name_kind_paydesc(product);
    		case "3" : return dao2.selectProduct_name_kind_day(product);
    		default:return dao2.selectProduct_name_kind(product);
    	}
	}
	@Override
	public List<String> selectProduct_tag(String name, String kind, int star, String tag, String brand)
			throws Exception {
		ProductVO product = new ProductVO();
    	product.setName("%"+name+"%");
    	product.setKind( (Integer.parseInt(kind)-1) +"");
    	product.setExtra(star);//extra 요소는 별점 검사로 쓴다.
    	product.setTag("%"+tag+"%");
    	product.setBrand("%"+brand+"%");
    	System.out.println(star);
    	
    	List<String> returnlst = dao2.selectProduct_name_tag(product);
    	Base64Decoding decoder=new Base64Decoding();
    	List<String> list = new ArrayList<String>();
    	for( String returnliststr : returnlst) {
    		String str = decoder.Base64StringEncode(returnliststr);
    		for (String arrtag : str.split(","))
    		list.add(arrtag);
    	}
    	
    	HashSet<String> hsh = new HashSet<String>(list);
    	list = new ArrayList<String>(hsh);
    	Collections.sort(list, new StringAscCompare());
    	
    	return list;
	}
	@Override
	public List<String> selectProduct_brand(String name, String kind, int star, String tag, String brand)
			throws Exception {
		ProductVO product = new ProductVO();
		System.out.println("brand : "+brand);
    	product.setName("%"+name+"%");
    	product.setKind( (Integer.parseInt(kind)-1) +"");
    	product.setExtra(star);//extra 요소는 별점 검사로 쓴다.
    	product.setTag("%"+tag+"%");
    	product.setBrand("%"+brand+"%");
    	System.out.println(star);
    	
    	List<String> returnlst = dao2.selectProduct_name_brand(product);
    	Base64Decoding decoder=new Base64Decoding();
    	for( int i = 0 ; i <returnlst.size() ; i++) {
    		returnlst.set(i, decoder.Base64StringEncode(returnlst.get(i))); 
    	}
    	return returnlst;
	}
	@Override
	public int insertProduct(ProductVO product) throws Exception {
    	return dao2.insertProduct(product);
	}
	@Override
	public int deleteProduct(String index) throws Exception {
		return dao2.deleteProduct(index);
	}
	@Override
	public int updateProduct(ProductVO product) throws Exception {
		return dao2.updateProduct(product);
	}
	@Override
	public List<ProductVO> selectProduct_productpage_anothertag(String index, String tag) throws Exception {
		ProductVO product = new ProductVO();
		product.setIndex(index);
    	product.setTag("%"+tag+"%");
    	List<ProductVO> list = dao2.selectProduct_productpage_anothertag(product);
    	System.out.println("list : "+list);
		return list;
	}
	@Override
	public List<ProductVO> selectProduct_productpage_anotherbrand(String index, String brand) throws Exception {
		ProductVO product = new ProductVO();
		product.setIndex(index);
		product.setBrand("%"+brand+"%");
		return dao2.selectProduct_productpage_anotherbrand(product);
	}
	
	@Override
	public List<String> selectProduct_index_tag(String index) throws Exception {
    	List<String> returnlst = dao2.selectProduct_index_tag(index);
    	Base64Decoding decoder=new Base64Decoding();
    	List<String> list = new ArrayList<String>();
    	for( String returnliststr : returnlst) {
    		String str = decoder.Base64StringEncode(returnliststr);
    		for (String arrtag : str.split(","))
    		list.add(arrtag);
    	}
    	
    	HashSet<String> hsh = new HashSet<String>(list);
    	list = new ArrayList<String>(hsh);
    	Collections.sort(list, new StringAscCompare());
    	
    	System.out.println("list : "+list);
    	return list;
	}
	@Override
	public List<String> selectProduct_index_brand(String index) throws Exception {
		List<String> returnlst = dao2.selectProduct_index_brand(index);
    	Base64Decoding decoder=new Base64Decoding();
    	for( int i = 0 ; i <returnlst.size() ; i++) {
    		returnlst.set(i, decoder.Base64StringEncode(returnlst.get(i))); 
    	}
    	return returnlst;
	}



	@Inject
    private Basket_ProductDAO dao3;
	@Override
	public List<Basket_ProductVO> selectBasket_Product_usersbasket(String user) throws Exception {
		return dao3.selectBasket_Product_usersbasket(user);
	}
	@Override
	public List<Basket_ProductVO> selectBasket_Product_basketproduct(Basket_ProductVO b_product) throws Exception {
		return dao3.selectBasket_Product_basketproduct(b_product);
	}
	@Override
	public List<Basket_ProductVO> selectBasket_Product() throws Exception {
		return dao3.selectBasket_Product();
	}
	@Override
	public int insertBasket_Product(Basket_ProductVO b_product) throws Exception {
		return dao3.insertBasket_Product(b_product);
	}
	@Override
	public int deleteBasket_Product(Basket_ProductVO b_product) throws Exception {
		return dao3.deleteBasket_Product(b_product);
	}
	@Override
	public int deleteBasket_Product_index(Basket_ProductVO b_product) throws Exception {
		return dao3.deleteBasket_Product_index(b_product);
	}
	@Override
	public int updateBasket_Product(Basket_ProductVO b_product) throws Exception {
		return dao3.updateBasket_Product(b_product);
	}
	@Override
	public int updateBasket_Product_checked(Basket_ProductVO b_product) throws Exception {
		return dao3.updateBasket_Product_checked(b_product);
	}
	public int updateBasket_Product_allchecked(Basket_ProductVO b_product) throws Exception {
		return dao3.updateBasket_Product_allchecked(b_product);
	}
	@Override
	public List<String> selectBasket_Product_usersbasket_paytotal(String user) throws Exception {
		return dao3.selectBasket_Product_usersbasket_paytotal(user);
	}
	@Override
	public List<String> selectBasket_Product_usersbasket_counttotal(String user) throws Exception {
		return dao3.selectBasket_Product_usersbasket_counttotal(user);
	}
	@Override
	public List<Basket_ProductVO> selectBasket_Product_usersbasket_checked(String user) throws Exception {
		return dao3.selectBasket_Product_usersbasket_checked(user);
	}
	@Override
	public List<String> selectBasket_Product_usersbasket_checkedcount(String user) throws Exception {
		return dao3.selectBasket_Product_usersbasket_checkedcount(user);
	}
	@Override
	public List<String> selectBasket_Product_usersbasket_count(String user) throws Exception {
		return dao3.selectBasket_Product_usersbasket_count(user);
	}
	@Override
	public int deleteBasket_user_index(String user) throws Exception {
		return dao3.deleteBasket_user_index(user);
	}



	@Inject
    private Preveal_ImageDAO dao4;
	@Override
	public List<Preveal_ImageVO> selectPreveal_Image() throws Exception {
		return dao4.selectPreveal_Image();
	}
	@Override
	public List<Preveal_ImageVO> selectPreveal_Image_product_index(String index) throws Exception {
		return dao4.selectPreveal_Image_product_index(index);
	}
	@Override
	public int insertPreveal_Image(Preveal_ImageVO preveal_ImageVO) throws Exception {
    	return dao4.insertProduct(preveal_ImageVO);
	}
	@Override
	public int deletePreveal_Image(Preveal_ImageVO preveal_ImageVO) throws Exception {
		return dao4.deleteProduct(preveal_ImageVO);
	}
	@Override
	public int updatePreveal_Image(Preveal_ImageVO preveal_ImageVO) throws Exception {
		return dao4.updateProduct(preveal_ImageVO);
	}
	
	

	@Inject
    private OrderDAO dao5;
	@Override
	public List<OrderVO> selectOrder() throws Exception {
		return dao5.selectOrder();
	}
	@Override
	public List<OrderVO> selectOrder_userorder(String user) throws Exception {
		return dao5.selectOrder_userorder(user);
	}
	@Override
	public int insertOrder(OrderVO order) throws Exception {
		return dao5.insertOrder(order);
	}
	@Override
	public int deleteOrder(String index) throws Exception {
		return dao5.deleteOrder(index);
	}
	@Override
	public int deleteOrder_userindex(String user) throws Exception {
		return dao5.deleteOrder_userindex(user);
	}



	@Inject
    private Product_StarDAO dao6;
	@Override
	public List<Product_StarVO> selectProduct_Star() throws Exception {
		return dao6.selectProduct_Star();
	}
	@Override
	public List<String> selectProduct_Star_count(String productindex) throws Exception {
		return dao6.selectProduct_Star_count(productindex);
	}
	@Override
	public List<String> selectProduct_Star_avg(String productindex) throws Exception {
		return dao6.selectProduct_Star_avg(productindex);
	}
	@Override
	public int insertProduct_Star(Product_StarVO product_Star) throws Exception {
		return dao6.insertProduct_Star(product_Star);
	}
	@Override
	public int deleteProduct_Star(Product_StarVO product_Star) throws Exception {
		return dao6.deleteProduct_Star(product_Star);
	}
	@Override
	public int deleteProduct_Star_productindex(String product_index) throws Exception {
		return dao6.deleteProduct_Star_productindex(product_index);
	}
	@Override
	public List<Product_StarVO> selectProduct_Star_user_prd(Product_StarVO product_Star) throws Exception {
		return dao6.selectProduct_Star_user_prd(product_Star);
	}
	@Override
	public int deleteProduct_Star_userindex(String user) throws Exception {
		return dao6.deleteProduct_Star_userindex(user);
	}

	
	


	@Inject
    private OrderProductPartDAO dao7;
	@Override
	public List<OrderProductPartVO> selectOrderproductpart() throws Exception {
		return dao7.selectOrderproductpart();
	}
	@Override
	public List<OrderProductPartVO> selectOrderproductpart_orderindex(String order_index) throws Exception {
		return dao7.selectOrderproductpart_orderindex(order_index);
	}
	@Override
	public int insertorderproductpart(OrderProductPartVO orderproductpart) {
		return dao7.insertorderproductpart(orderproductpart);
	}
	@Override
	public int deleteorderproductpart(String order_index) {
		return dao7.deleteorderproductpart(order_index);
	}
	@Override
	public int deleteorderproductpart_productindex(String product_index) {
		return dao7.deleteorderproductpart_productindex(product_index);
	}
	
	
	
	
	
	
	
	
	@Override
	public List<String> select_empty_orderpart(String order_index) throws Exception {
		return dao7.select_empty_orderpart(order_index);
	}
	@Override
	public List<String> select_empty_order(String index) throws Exception {
		return dao5.select_empty_order(index);
	}
	
	
	
	
	
    
    

	
}
