<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
{"bpl":[
<c:forEach var="item" items="${service.selectBasket_Product_usersbasket(ordererIndex)}" varStatus="status">
<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item.product_index)[0]}" />
<c:set var="p_pi" value="${service.selectProduct_product_index(item.product_index)[0]}" />
{
	"user": "${item.user}",
	"product_index": "${item.product_index}",
	"day": "<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ssZ" value="${item.day}"/>",
	"num": ${decoder.Base64StringEncode(item.num)},
	"checked": ${decoder.Base64StringEncode(item.checked)},
	"name": "${decoder.Base64StringEncode(p_pi.name)}",
	"category": "${strings_productkind.get(Integer.parseInt(decoder.Base64StringEncode(p_pi.kind))+1)}",
	"pay": ${decoder.Base64StringEncode(p_pi.pay)},
	"img": "/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}"
}<c:if test="${status.last != true}">,</c:if> </c:forEach>

],
"total": ${    Math.round(Double.valueOf( service.selectBasket_Product_usersbasket_paytotal(ordererIndex)[0]))    }
}
