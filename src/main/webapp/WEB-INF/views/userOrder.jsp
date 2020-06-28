<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
	<title>${strings.get(0)}</title>
	<style type="text/css">
	#baskets {
		border-collapse: collapse;
	}
	#baskets tr, #baskets td{
		padding: 10px;
	}
	</style>
</head>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<body>



<table width="100%">
	<tr>
		<td height="80px" style="border-radius:9px;background-color:#134F68;">
			<div id="tmenu"/>
		</td>
	</tr>
	
	<tr>
		<td width="100%" valign="top"><div id="orderlist"/></td>
	</tr>
</table>

<div id="orderDialog" class="modalDialog">
</div>
<div id="orderCloseDialog" class="modalCloseDialog" onclick="OrderDialogClose()">
</div>

<script>
$(document).ready(function () {
	$(document).ready( function() {
        $.get("/topmenu", function(res) {
            $("#tmenu").html(res);
        });
        $.get("/orderlist", function(res) {
            $("#orderlist").html(res);
        });
    });
})


function DeleteDialogOpen(p,sp,day){
	//location.href="/orderwindow?p="+p+"&num="+num.value;
	user = "<%=session.getAttribute("id")%>";
	$.get("/userOrderDeleteQuastion?p="+p+"&sp="+sp+"&day="+day, function(res) {
        	$("#orderDialog").html(res);
        	if ( user!=null && user!="" && user!="null" ){
		        document.getElementById('orderDialog').style.opacity="1";
		    	document.getElementById('orderDialog').style.pointerEvents="auto";
		    	document.getElementById('orderCloseDialog').style.opacity="1";
		    	document.getElementById('orderCloseDialog').style.pointerEvents="auto";
        	}
    });
}
function OrderDialogClose(){
	document.getElementById('orderDialog').style.opacity="0";
	document.getElementById('orderDialog').style.pointerEvents="none";
	document.getElementById('orderCloseDialog').style.opacity="0";
	document.getElementById('orderCloseDialog').style.pointerEvents="none";
}
function ord_Delete(idx){
	$.get("/orderdelete?o_index="+idx, function(res) {
        $("#orderlist").html(res);
        OrderDialogClose()
    });
}
</script>


</body>
</html>
