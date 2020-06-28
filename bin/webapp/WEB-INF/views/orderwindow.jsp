<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<body>

<c:set var="totalpay" value="0" />

<form method="post" action="/ordering">
	<input type="hidden" value='${p}' name="p">
	<input type="hidden" value='${num}' name="num">
	<input type="hidden" value='${ordererIndex}' name="ordererIndex">
	<table id="orderwindow">
		<tr>
			<td colspan='2' align="center">${strings.get(0)}</td>
		</tr>
		<tr>
			<td colspan='2' style="font-weight:bold;">${strings.get(1)}</td><!-- 상품 -->
		</tr>
		<tr>
			<td colspan='2' style="padding:24px;">
				<table id="orderwindow_product" style="border-collapse:collapse">
					<tr>
						<td align="center" colspan="2">${strings.get(6)}</td>
						<td align="center" width="10%">${strings.get(7)}</td>
					</tr>
					<c:forEach var="item" items="${productList}" varStatus="status">
					<c:set var="totalpay" value="${totalpay+Integer.parseInt(decoder.Base64StringEncode(item.pay))*productList_num[status.index]}" />
					<tr>
						<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item.index)[0]}" />
						<c:set var="p_pi" value="${service.selectProduct_product_index(item.index)[0]}" />
						<td width="0%">
							<img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='80' height='80'>
						</td>
						<td>${decoder.Base64StringEncode(item.name)}</td>
						<td align="center" >${productList_num[status.index]}</td>
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td style="font-weight:bold">${strings.get(2)}</td><!-- 주문자 -->
			<td>${ordererName}</td>
		</tr>
		<tr>
			<td style="font-weight:bold">${strings.get(3)}</td><!-- 배송지 -->
			<td><input type="text" name="area" width="300px"></td>
		</tr>
		<tr>
			<td style="font-weight:bold">${strings.get(4)}</td><!-- 총액 -->
			<td>${totalpay }</td>
		</tr>
		<tr>
			<td colspan='2' align="center">
				<input style="font-weight:bold" type="submit" value="${strings.get(5)}" class="SmallButton" width="50px">
			</td>
		</tr>
		
	</table>
	<input type="hidden" value='${totalpay}' id="totalpay">
</form>

</body>
</html>