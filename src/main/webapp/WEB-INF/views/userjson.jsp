<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${flag == 0}">
	<c:forEach var="item" items="${service.selectMember_userindex(userindex)}" varStatus="status">
		{
			"index": "${item.index}",
			"email": "${item.email}",
			"money": "${decoder.Base64StringEncode(item.money)}",
			"name": "${decoder.Base64StringEncode(item.name)}",
			"pwd": "${item.password}"
		}
	</c:forEach>
</c:if>

<c:if test="${flag == 1}">
	<c:forEach var="item2" items="${service.selectMember_idcheck(userindex)}" varStatus="status2">
		{
			"index": "${item2.index}",
			"email": "${item2.email}",
			"money": "${decoder.Base64StringEncode(item2.money)}",
			"name": "${decoder.Base64StringEncode(item2.name)}",
			"pwd": "${item2.password}"
		}
	</c:forEach>
</c:if>
