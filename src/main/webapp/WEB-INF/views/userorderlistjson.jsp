<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
{"ol":[
<c:forEach var="item" items="${service.selectOrder_userorder(ordererIndex)}" varStatus="status">
<c:set var="totalpay" value="0" />
{
	"index": "${item.index}",
	"user": "${item.user}",
	"shipping_place": "${decoder.Base64StringEncode(item.shipping_place)}",
	"day": "<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ssZ" value="${item.day}"/>",
	
	"prds":[
	<c:forEach var="item2" items="${service.selectOrderproductpart_orderindex(item.index)}" varStatus="status2">
		{
			<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item2.product_index)[0]}" />
			<c:set var="product" value="${service.selectProduct_product_index(item2.product_index)[0]}" />
			"index": "${item2.product_index}",
			"order_index": "${item2.order_index}",
			"num": ${decoder.Base64StringEncode(item2.num)},
			"name": "${decoder.Base64StringEncode(product.name)}",
			"img": "/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}"
			<c:set var="totalpay" value="${totalpay+
			Integer.parseInt(decoder.Base64StringEncode(product.pay))*
			Integer.parseInt(decoder.Base64StringEncode(item2.num))}" />
		}
		<c:if test="${status2.last != true}">,</c:if> 
	</c:forEach>
	],
	"total": ${totalpay}
}
<c:if test="${status.last != true}">,</c:if>

</c:forEach>
]
}
