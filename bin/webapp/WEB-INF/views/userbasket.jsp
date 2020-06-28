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



<script>
var checked_basket_product=new Array();
//특정한 것들을 죄다 한 방에 주문하기 위한 배열
//바로 모두 주문할 때를 대비해 미리 모두 체크해 두게 한다.
var all_basket_product_index=new Array();
//all체크 초기화를 위한 배열
</script>


<table width="100%">
	<tr>
		<td height="80px" style="border-radius:9px;background-color:#134F68;">
			<div id="tmenu"/>
		</td>
	</tr>
	
	<tr>
		<td>
			<table>
				<tr>
					<td width="100%" valign="top"><div id="basketlist"/></td>
					<td style="width:max-content;" align="right"><div id="basketorder"/></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<script>
$(document).ready(function () {
	$(document).ready( function() {
        $.get("/topmenu", function(res) {
            $("#tmenu").html(res);
        });
        $.get("/basketlist", function(res) {
            $("#basketlist").html(res);
        });
        $.get("/basketorder", function(res) {
            $("#basketorder").html(res);
        });
    });
})
function userbasketorder_Load(){
	$.get("/basketorder", function(res) {
        $("#basketorder").html(res);
    });
}
function Product_Pay_Field_Load(p,pay){
	num = document.getElementById('num'+p).value
	$.get("/userbasketlist_pay?total="+(pay*num), function(res) {
        $("#product_pay"+p).html(res);
    });
}
function productnumchange(productindex,inputnumberobject,p,pay){//수량을 바꾸면?
	num = document.getElementById('num'+p).value
	$.get("/basketupdate?num="+inputnumberobject.value+"&p="+p+"&total="+(pay*num), function(res) {
		//alert("/basketupdate?num="+inputnumberobject.value+"&p="+p+"&total="+(pay*num))
        $("#product_pay"+p).html(res);
        userbasketorder_Load();
    });
}


</script>







<div id="orderDialog" class="modalDialog">
</div>
<div id="orderCloseDialog" class="modalCloseDialog" onclick="OrderDialogClose()">
</div>

<script>
function MaximumPrevealimageChange(imagessrc){
	document.getElementById('maximum_prevealimage').src=imagessrc;
}
function BasketButton(){
	$(document).ready( function() {
        $.get("/product_basketbutton?p=${p}", function(res) {
            $("#product_basketbutton").html(res);
        });
    });
}
function BasketButton_Delete(){
	$(document).ready( function() {
        $.get("/product_basket_delete?p=${p}", function(res) {
            $("#product_basketbutton").html(res);
        });
    });
}
function BasketButton_Add(num){
	$(document).ready( function() {
        $.get("/product_basket_add?p=${p}&num="+num.value, function(res) {
            $("#product_basketbutton").html(res);
        });
    });
}
$(document).ready(function () {
	$(document).ready( function() {
        $.get("/topmenu", function(res) {
            $("#tmenu").html(res);
        });
    });
})


function OrderDialogClose(){
	document.getElementById('orderDialog').style.opacity="0";
	document.getElementById('orderDialog').style.pointerEvents="none";
	document.getElementById('orderCloseDialog').style.opacity="0";
	document.getElementById('orderCloseDialog').style.pointerEvents="none";
}
BasketButton()




function DeleteDialogOpen(p){
	//location.href="/orderwindow?p="+p+"&num="+num.value;
	user = "<%=session.getAttribute("id")%>";
	$.get("/userbasketDeleteQuastion?p="+p, function(res) {
        	$("#orderDialog").html(res);
        	if ( user!=null && user!="" && user!="null" ){
        		document.getElementById('orderDialog').style.opacity="1";
        		document.getElementById('orderDialog').style.pointerEvents="auto";
		    	document.getElementById('orderCloseDialog').style.opacity="1";
		    	document.getElementById('orderCloseDialog').style.pointerEvents="auto";
        	}
    });
}
</script>




</body>
</html>
