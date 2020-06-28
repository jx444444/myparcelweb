<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
{"prdlist":[
<c:forEach var="item" items="${service.selectProduct_product_star()}" varStatus="status">
<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item.index)[0]}" />
<c:set var="p_pi" value="${service.selectProduct_product_index(item.index)[0]}" />
<c:set var="staravg" value="${Math.round(Double.parseDouble(service.selectProduct_Star_avg(item.index)[0]))}" />
{	
	"index": "${item.index}",
	"name": "${decoder.Base64StringEncode(item.name)}",
	"pay": "${decoder.Base64StringEncode(item.pay)}",
	"explanatory": "${decoder.Base64StringEncode(item.explanatory)}",
	"by": "${decoder.Base64StringEncode(item.by)}",
	"kind": "${decoder.Base64StringEncode(item.kind)}",
	"day": "<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ssZ" value="${item.day}"/>",
	"extra": "${item.extra}",
	"tag": [
	<c:forEach var="tagarray" items="${decoder.Base64StringEncode(item.tag).split(',')}" varStatus="status2">
	"${tagarray}"<c:if test="${status2.last != true}">,</c:if>
	</c:forEach>
	],
	"brand": "${decoder.Base64StringEncode(item.brand)}",
	"img": "/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}",
	"star": "${staravg}",
	"basketed": 0
	
}<c:if test="${status.last != true}">,</c:if> </c:forEach>

]
}
