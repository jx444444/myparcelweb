<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
	<title>${strings.get(0)}</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<link rel="stylesheet" type="text/css" href="/css/ProductButton.css"/>
<body>


<table width="100%">
	<tr>
		<td height="80px" style="border-radius:9px;background-color:#134F68;" >
			<div id="tmenu"/>
		</td>
	</tr>
	
	<tr>
		<td>
			<table>
				<tr><td>${strings.get(8)}</td></tr>
				
				<tr><td>
					<table><tr>
						<c:forEach var="item" items="${service.selectProduct_product_star()}" varStatus="status">
							<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item.index)[0]}" />
							<c:set var="p_pi" value="${service.selectProduct_product_index(item.index)[0]}" />
							<td><img onclick='location.href="/product?p=${item.index}"' src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='240' height='240' class="Products_button"/></td>
						</c:forEach>
					</tr></table>
				</td></tr>
			</table>
		</td>
	</tr>
</table>


<script>
$(document).ready(function () {
	$(document).ready( function() {
        $.get("/topmenu", function(res) {
            $("#tmenu").html(res);
        });
    });
})
</script>



</body>
</html>
