<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<link rel="stylesheet" type="text/css" href="/css/ProductButton.css"/>
<table width="100%">
	<tr><td style="font-size:20px;font-weight:bold;" >${strings.get(0)}</td></tr>
	
	<tr><td>
	<table width="100%" id="baskets" >
		<tr style="border-bottom:1px solid lightgray;">
			<td></td>
			<td align='right'><div style="border-left:1px solid lightgray;">${strings.get(1)}</div></td>
			<td align='right'><div style="border-left:1px solid lightgray;">${strings.get(6)}</div></td>
			<td align='right'><div style="border-left:1px solid lightgray;">${strings.get(7)}</div></td>
		</tr>
		<c:set var="usercode" value='<%=session.getAttribute("usercode")%>' />
		<c:forEach var="item" items="${service.selectOrder_userorder(usercode)}" varStatus="status">
			<c:set var="totalpay" value="0" />
			<tr style="border-bottom:1px solid lightgray;">
				<td style="margin:0px;padding:0px;">
					<table>
						<tr>
							<td width="100%" style="margin:0px;padding:0px;">
							<c:forEach var="item2" items="${service.selectOrderproductpart_orderindex(item.index)}" varStatus="status2">
								<table>
									<tr>
										<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item2.product_index)[0]}" />
										<c:set var="product" value="${service.selectProduct_product_index(item2.product_index)[0]}" />
										
										<c:set var="totalpay" value="${totalpay+
										Integer.parseInt(decoder.Base64StringEncode(product.pay))*
										Integer.parseInt(decoder.Base64StringEncode(item2.num))}" />
										
										<td style="margin:0px;padding:0px;"><img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='40' height='40' onclick='location.href="/product?p=${item2.product_index}"' class="Products_button"></td>
										<td><a href="/product?p=${product.index}" target="_blank">${decoder.Base64StringEncode(product.name)}</a></td>
										<td>${strings.get(2)} : ${decoder.Base64StringEncode(item2.num)}</td>
									</tr>
								</table>
							</c:forEach>
							</td>
							<td valign='top'><input style="font-weight:bold" type="button" onclick="DeleteDialogOpen('${item.index}','${decoder.Base64StringEncode(item.shipping_place)}','${item.day}')" value="${strings.get(3)}" class="SmallButton" width="50px"></td> 
						</tr>
					</table>
				</td>
				<td align="right">${totalpay}</td>
				<td align="right">${decoder.Base64StringEncode(item.shipping_place)}</td>
				<td align="right">${item.day}</td>
			</tr>
		</c:forEach>
		
	</table>
	</td></tr>
	

	
</table>



</html>