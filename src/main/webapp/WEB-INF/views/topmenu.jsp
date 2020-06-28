<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Logo.css"/>

<table width="100%" height='100%'>
	<tr>
		<td style="width:5%">
			<img src="/image/logo.png" onclick="location.href='/'" id='myparcelLogo' width="128px" height="52px"/>
		</td>
		<td style="width:73%">
			<table style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<select id="serach_filter">
							<c:forEach var="productkind" items="${strings_productkind}" varStatus="status">
								<option>${productkind}</option>
							</c:forEach>
						</select>
					</td>
					<td style="width:100%"><input type="text" style="width:100%;" id="serach_textfield" placeholder='${strings.get(1)}' onKeyDown="SearchButtonEnter()"></td>
					<td><input type="image" id="serach_button" src="/image/searchbutton.png" onclick="SearchButton()"></td>
				</tr>
			</table>
		<td style="width:27%">
			<table style="table-layout: auto;display:inline-block;">
				<tr>
					<td style="white-space:nowrap;">
						<select id="lang" onchange="ChangeLangSelect()">
							<option>${strings.get(2)}</option>
							<option>${strings.get(3)}</option>
							<option>${strings.get(4)}</option>
						</select>
					</td >
					<td align='center' style="white-space:nowrap;">
						<% if (session.getAttribute("id")==null){ %>
						<input type="button" onclick="location.href='/login'" id="LoginButton" value='${strings.get(5)}'>
						<% }else{%>
						<b style="color:white;user-select:none;"><%=session.getAttribute("id")%></b><br>
						<input type="button" onclick="location.href='/logout'" id="LoginButton" value='${strings.get(9)}'>
						<% }%>
					</td>
					<td style="white-space:nowrap;"><input type="button" id="OrderButton" value='${strings.get(6)}' onclick="location.href='/order'"></td>
					<td style="white-space:nowrap;">
						<table id="BasketButton" onclick="location.href='/basket'"><tr>
						<td><img src='/image/shoppingcartimage.png' width='32px' height='32px'></td>
						<td>${strings.get(7)}</td>
						</tr></table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div id="lang_change">
</div>

<script>
document.getElementById("lang").selectedIndex=parseInt(<%=session.getAttribute("lang")%>)
	
function SearchButton(){
	location.href='/search?sch='+document.getElementById('serach_textfield').value+"&flt="+document.getElementById('serach_filter').selectedIndex
}
function SearchButtonEnter(){
	if(event.keyCode == 13)
		SearchButton()
}

function ChangeLangSelect(){
	var langSelect = document.getElementById("lang");
	$(document).ready( function() {
        $.get("/langchange?lang="+langSelect.selectedIndex, function(res) {
            $("#lang_change").html(res);
            location.reload();
        });
    });
	
}
</script>