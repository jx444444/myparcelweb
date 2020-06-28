<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/Star.css"/>
<link rel="stylesheet" type="text/css" href="/css/ProductButton.css"/>
<body>

<table width="100%">
	<tr><td width="100%">
		<table style="border-collapse:collapse;">
			<c:forEach var="item" items="${service.selectProduct_name(searchword,filter,star,tag,brand,align)}" varStatus="status">
			<tr>
			
				<td style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;padding:15px;">
					<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item.index)[0]}" />
					<c:set var="p_pi" value="${service.selectProduct_product_index(item.index)[0]}" />
					<img onclick='location.href="/product?p=${item.index}"' src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='240' height='240' class='Products_button'/>
				</td>
				<td width="100%" align="left" valign="top" style="font-weight:bold;border-top:1px solid lightgray;border-bottom:1px solid lightgray;">
					<table style="font-weight:bold;padding:15px;margin:8px;">
						<tr><td>
							<a onclick='location.href="/product?p=${item.index}"'>${decoder.Base64StringEncode(item.name)}</a>
						</td></tr>
						
						<tr><td align="left">
							<table><tr><td>
							<div class="stars" align="left" id="star_${decoder.Base64StringEncode(item.index)}"></div>
							<script>
							$(document).ready( function() {
						        $.get("/searchlist_star?id=${decoder.Base64StringEncode(item.index)}", function(res) {
						            $("#star_${decoder.Base64StringEncode(item.index)}").html(res);
						        });
						    });
							</script>
							</td></tr></table>
						</td></tr>
						
						<tr><td>
							KRW ${decoder.Base64StringEncode(item.pay)}
						</td></tr>
						
					</table>
					
				</td>
			
			</tr>
			</c:forEach>
		</table>
	</td></tr>
</table>


</body>
</html>