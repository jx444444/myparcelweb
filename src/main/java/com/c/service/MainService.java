package com.c.service;

import java.util.List;

import com.c.dto.*;

public interface MainService {
	public List<MemberVO> selectMember() throws Exception;
	public List<ProductVO> selectProduct() throws Exception;
	public List<Basket_ProductVO> selectBasket_Product() throws Exception;
	public List<Preveal_ImageVO> selectPreveal_Image() throws Exception;
	public List<OrderVO> selectOrder() throws Exception;
	public List<Product_StarVO> selectProduct_Star() throws Exception;
	
	public List<MemberVO> selectMember_idcheck(String id) throws Exception;
	public List<MemberVO> selectMember_login(MemberVO member) throws Exception;
	public int insertMember(MemberVO member) throws Exception;
	public int deleteMember(String index) throws Exception;
	public int updateMember(MemberVO member) throws Exception;
	
	public List<ProductVO> selectProduct_product_index(String index) throws Exception;
	public List<ProductVO> selectProduct_product_star() throws Exception;
	public List<ProductVO> selectProduct_name(String name,String kind,int star,String tag,String brand,String align) throws Exception;
	public List<String> selectProduct_tag(String name,String kind,int star,String tag,String brand) throws Exception;
	public List<String> selectProduct_brand(String name,String kind,int star,String tag,String brand) throws Exception;
	public int insertProduct(ProductVO product) throws Exception;
	public int deleteProduct(String index) throws Exception;
	public int updateProduct(ProductVO product) throws Exception;
	public List<ProductVO> selectProduct_productpage_anothertag(String index, String tag) throws Exception;
	public List<ProductVO> selectProduct_productpage_anotherbrand(String index, String brand) throws Exception;
	public List<String> selectProduct_index_tag(String index) throws Exception;
	public List<String> selectProduct_index_brand(String index) throws Exception;
	
	public List<Basket_ProductVO> selectBasket_Product_usersbasket(String user) throws Exception;
	public List<Basket_ProductVO> selectBasket_Product_basketproduct(Basket_ProductVO b_product) throws Exception;
	public int insertBasket_Product(Basket_ProductVO b_product) throws Exception;
	public int deleteBasket_Product(Basket_ProductVO b_product) throws Exception;
	public int deleteBasket_Product_index(Basket_ProductVO b_product) throws Exception;
	public int updateBasket_Product(Basket_ProductVO b_product) throws Exception;
	public int updateBasket_Product_checked(Basket_ProductVO b_product) throws Exception;
	public int updateBasket_Product_allchecked(Basket_ProductVO b_product) throws Exception;
	public List<String> selectBasket_Product_usersbasket_paytotal(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_counttotal(String user) throws Exception;
	public List<Basket_ProductVO> selectBasket_Product_usersbasket_checked(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_checkedcount(String user) throws Exception;
	public List<String> selectBasket_Product_usersbasket_count(String user) throws Exception;
	public int deleteBasket_user_index(String user) throws Exception;
	
	public List<Preveal_ImageVO> selectPreveal_Image_product_index(String index) throws Exception;
	public int insertPreveal_Image(Preveal_ImageVO preveal_ImageVO) throws Exception;
	public int deletePreveal_Image(Preveal_ImageVO preveal_ImageVO) throws Exception;
	public int updatePreveal_Image(Preveal_ImageVO preveal_ImageVO) throws Exception;
	
	public List<OrderVO> selectOrder_userorder(String user) throws Exception;
	public int insertOrder(OrderVO order) throws Exception;
	public int deleteOrder(String index) throws Exception;
	public int deleteOrder_userindex(String user) throws Exception;
	
	public List<String> selectProduct_Star_count(String productindex) throws Exception;
	public List<String> selectProduct_Star_avg(String productindex) throws Exception;
	public int insertProduct_Star(Product_StarVO product_Star) throws Exception;
	public int deleteProduct_Star(Product_StarVO product_Star) throws Exception;
	public int deleteProduct_Star_productindex(String product_index) throws Exception;
	public List<Product_StarVO> selectProduct_Star_user_prd(Product_StarVO product_Star) throws Exception;
	public int deleteProduct_Star_userindex(String user) throws Exception;
	
	public List<OrderProductPartVO> selectOrderproductpart() throws Exception;
	public List<OrderProductPartVO> selectOrderproductpart_orderindex(String order_index) throws Exception;
	public int insertorderproductpart(OrderProductPartVO orderproductpart);
	public int deleteorderproductpart(String order_index);
	public int deleteorderproductpart_productindex(String product_index);
	
	public List<String> select_empty_orderpart(String order_index) throws Exception;
	public List<String> select_empty_order(String index) throws Exception;
	public List<MemberVO> selectMember_userindex(String index) throws Exception;
	
	public List<Moblie_LoginVO> select_mobilelogin(String userindex) throws Exception;
	public int delete_mobilelogin(String userindex) throws Exception;
}
