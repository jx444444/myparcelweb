<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
</head>
<body>
	<table class="questionialog" id="questionialog">
		<c:set var="totalpay" value="0" />
		<tr>
			<td style="border-right:1px solid lightgray;"></td>
			<td>${strings.get(2)}</td>
		</tr>
		<tr><td colspan='2' style="border-bottom:1px solid lightgray;"></td></tr>
		<c:forEach var="item2" items="${service.selectOrderproductpart_orderindex(orderindex)}" varStatus="status2">
			<tr>
				<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item2.product_index)[0]}" />
				<c:set var="product" value="${service.selectProduct_product_index(item2.product_index)[0]}" />
				
				<c:set var="totalpay" value="${totalpay+
				Integer.parseInt(decoder.Base64StringEncode(product.pay))*
				Integer.parseInt(decoder.Base64StringEncode(item2.num))}" />
				
				<td >
					<table>
						<tr>
							<td style="margin:0px;padding:0px;"><img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='40' height='40' onclick='location.href="/product?p=${item2.product_index}"' class="Products_button"></td>
							<td><a href="/product?p=${product.index}" target="_blank">${decoder.Base64StringEncode(product.name)}</a></td>
						</tr>
					</table>
				</td>
				<td>${decoder.Base64StringEncode(item2.num)}</td>
			</tr>
		</c:forEach>
		<tr><td colspan='2' style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;height:20px;"></td></tr>
		<tr><td>${strings.get(1)}</td><td>${totalpay}</td></tr>
		<tr><td colspan='2' style="border-bottom:1px solid lightgray;"></td></tr>
		<tr><td>${strings.get(6)}</td><td>${shipping_place}</td></tr>
		<tr><td colspan='2' style="border-bottom:1px solid lightgray;"></td></tr>
		<tr><td>${strings.get(7)}</td><td>${day}</td></tr>
		<tr><td colspan='2' style="border-bottom:1px solid lightgray;"></td></tr>
		<tr>
			<td align="center" colspan='2'>
				${strings.get(8)}
			</td>
		</tr>
		<tr>
			<td align="center" colspan='2'>
				<input style="font-weight:bold" type="submit" onclick="ord_Delete('${orderindex}')" value="${strings.get(3)}" class="SmallButton" width="50px">
			</td>
		</tr>
	</table>
	
	

</body>



</html>