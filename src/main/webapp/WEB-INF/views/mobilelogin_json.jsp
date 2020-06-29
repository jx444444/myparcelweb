<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
{"ml":[
<c:forEach var="item" items="${service.select_mobilelogin(userindex)}" varStatus="status">
{
	"index": "${item.index}",
	"uuid": "${item.uuid}"
}<c:if test="${status.last != true}">,</c:if> </c:forEach>

]
}
