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
			<td>
				<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(productindex)[0]}" />
				<c:set var="p_pi" value="${service.selectProduct_product_index(productindex)[0]}" />
				
				<script>
					all_basket_product_index.push('${item2.product_index}')
				</script>
				
				<td><img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" onclick='location.href="/product?p=${productindex}"' width='120' height='120' class="Products_button"></td>
				<td align='left' width="100%">
					<table>
						<tr><td ><a href="/product?p=${productindex}" target="_blank">${decoder.Base64StringEncode(p_pi.name)}</a></td></tr>
						<tr><td style="font-size:12px;color:gray;">${strings_productkind.get(Integer.parseInt(decoder.Base64StringEncode(p_pi.kind))+1)}</td></tr>
					</table>
				</td>
			</td>
		</tr>
		
		<tr><td colspan='3' style="border-top:1px solid lightgray;"></td></tr>
		<tr>
			<td align="center" colspan='3'>
				${strings.get(8)}
			</td>
		</tr>
		<tr>
			<td align="center" colspan='3'>
				<input style="font-weight:bold" type="submit" onclick="bp_Delete('${productindex}')" value="${strings.get(3)}" class="SmallButton" width="50px">
			</td>
		</tr>
	</table>
	
	

</body>



</html>