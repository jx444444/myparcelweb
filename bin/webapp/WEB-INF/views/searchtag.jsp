<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<table>
	<c:forEach var="item" items="${service.selectProduct_tag(searchword,filter,star,tag,brand)}" varStatus="status">
		<tr><td>
			<a onclick="SearchlistLoad(0,'${item}','')">${item}</a>
		</td></tr>
	</c:forEach>
</table>