<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<c:forEach var="item" items="${service.selectMember_userindex(userindex)}" varStatus="status">
	{
		"index": "${item.index}",
		"email": "${decoder.Base64StringEncode(item.email)}",
		"money": "${decoder.Base64StringEncode(item.money)}",
		"name": "${decoder.Base64StringEncode(item.name)}"
	}
</c:forEach>


