<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>

<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<body>
	<table style="border:solid 1px lightgray;width:300px;height:400px;">
		<tr>
			<td>
				<table>
					<tr><td>
						<c:set var="paytotal" value='${service.selectBasket_Product_usersbasket_paytotal(usercode)[0]}' />
						<c:set var="bpcount" value='${service.selectBasket_Product_usersbasket_counttotal(usercode)[0]}' />
						<b style="font-weight:bold;font-size:18px;">${strings.get(4)}(${Integer.parseInt(String.valueOf(Math.round(Double.valueOf(bpcount))))} ${strings.get(5)}) : </b>
						<b style="color:#cc0000;font-weight:bold;font-size:18px;">KRW ${Integer.parseInt(String.valueOf(Math.round(Double.valueOf(paytotal))))}</b>
					</td></tr>
					<tr><td>
							<input type="button" id="allordering" value="${strings.get(6)}" onclick='Basket_AllOrdering()'>
					</td></tr>
				</table>
			</td>
		</tr>
	</table>
</body>

<script>
function Basket_AllOrdering(){
	//체크한 것들 모두 주문한다.
	if(checked_basket_product.length<=0){
		alert('${strings.get(7)}');
		return;
	}
	
	pd = ""
	pn = ""
	for (var i=0 ; i<checked_basket_product.length ; i++){
		pd+=window.atob(checked_basket_product[i])+"_"
		pn+=document.getElementById("num"+window.atob(checked_basket_product[i])).value+"_";
	}
	//checked_basket_product.splice(0,checked_basket_product.length)//우선 배열을 초기화
	//alert(checked_basket_product)
	
	$.get("/orderwindow?p="+pd+"&num="+pn, function(res) {
        $("#orderDialog").html(res);
        document.getElementById('orderDialog').style.opacity="1";
    	document.getElementById('orderDialog').style.pointerEvents="auto";
    	document.getElementById('orderCloseDialog').style.opacity="1";
    	document.getElementById('orderCloseDialog').style.pointerEvents="auto";
    });
}
</script>


</html>