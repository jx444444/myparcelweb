<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>

<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>

<body>
<c:choose>
	<c:when test="${basketresult eq '1'}">
		<input type="button" onclick="BasketButton_Delete()" id='product_addedtobasket' value='${strings.get(4)}'>
	</c:when>
	<c:otherwise>
		<input type="button" onclick="BasketButton_Add(document.getElementById('product_num'))" id='product_addtobasket' value='${strings.get(3)}'>
	</c:otherwise>
</c:choose>
<!-- 1이면 이미 장바구니에 추가됨, 0이면 아직 장바구니에 없음 -->

</body>
</html>