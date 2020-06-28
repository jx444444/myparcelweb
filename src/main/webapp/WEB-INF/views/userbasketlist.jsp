<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<link rel="stylesheet" type="text/css" href="/css/ProductButton.css"/>

<table width="100%">
	<tr><td style="font-size:20px;font-weight:bold;">${strings.get(0)}</td></tr>
	
	<tr><td>
	<table id="baskets" width="100%">
		<tr style="border-bottom:1px solid lightgray;">
			<td colspan="2"></td>
			<td align='right'><div style="border-left:1px solid lightgray;">${strings.get(1)}</div></td>
			<td align='right'><div style="border-left:1px solid lightgray;">${strings.get(2)}</div></td>
			<td align='right'><div style="border-left:1px solid lightgray;"><input type="checkbox" id="checkbox_allcheck" name='allcheck' onclick="Product_checking_all(this);" checked="true"></div></td>
		</tr>
		<c:set var="usercode" value='<%=session.getAttribute("usercode")%>' />
		<c:forEach var="item2" items="${service.selectBasket_Product_usersbasket(usercode)}" varStatus="status">
			<tr style="border-bottom:1px solid lightgray;">
				<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item2.product_index)[0]}" />
				<c:set var="p_pi" value="${service.selectProduct_product_index(item2.product_index)[0]}" />
				
				<script>
					all_basket_product_index.push('${item2.product_index}')
				</script>
				
				<td><img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" onclick='location.href="/product?p=${item2.product_index}"' width='120' height='120' class="Products_button"></td>
				<td align='left' width="100%">
					<table>
						<tr><td ><a href="/product?p=${item2.product_index}" target="_blank">${decoder.Base64StringEncode(p_pi.name)}</a></td></tr>
						<tr><td style="font-size:12px;color:gray;">${strings_productkind.get(Integer.parseInt(decoder.Base64StringEncode(p_pi.kind))+1)}</td></tr>
						<tr>
							<td><input onclick="DeleteDialogOpen('${item2.product_index}')" class="SmallButton" type="button" value='${strings.get(3)}'></td>
						</tr>
					</table>
				</td>
				<td align='right'>
					<div id="product_pay${decoder.Base64StringEncode(item2.product_index)}"></div>
					<script>
					Product_Pay_Field_Load('${decoder.Base64StringEncode(item2.product_index)}','${decoder.Base64StringEncode(p_pi.pay)}')
					</script>
				</td>
				<td align='right'>
					<input style="font-size:20px;width:120px;" 
					id="num${decoder.Base64StringEncode(item2.product_index)}" 
					type="number" 
					value='${decoder.Base64StringEncode(item2.num)}' 
					onchange="productnumchange('${p_pi.index}',this,'${decoder.Base64StringEncode(item2.product_index)}',${decoder.Base64StringEncode(p_pi.pay)})" 
					min="1" max="9">
				</td>
				<td align='right'>
					<input type="checkbox" id="checkbox${item2.product_index}" name='prodcheck' onclick="Product_checking('${item2.product_index}',this);" >
					<script>
						document.getElementById('checkbox${item2.product_index}').checked=("${item2.checked}"=="MQ==" ? true : false )
					</script>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	</td></tr>
	

	
</table>

<div id="checkingupdate"></div>

<script>
document.getElementById('checkbox_allcheck').checked=
	(${Integer.parseInt(service.selectBasket_Product_usersbasket_checkedcount(ordererIndex)[0])}==${Integer.parseInt(service.selectBasket_Product_usersbasket_count(ordererIndex)[0])} ? true : false )

function bp_Delete(idx){
	$.get("/basketdelete?b_productindex="+idx, function(res) {
		checked_basket_product.splice(0,checked_basket_product.length);
		all_basket_product_index.splice(0,all_basket_product_index.length);
        $("#basketlist").html(res);
        userbasketorder_Load()
        OrderDialogClose()
    });
}
function Product_checking(index,obj){//개별체크/해제
	if (obj.checked==true) 
		checked_basket_product.push(index)//이 인덱스를 배열에 추가한다.(일괄 주문 리스트에 추가됨)
	else
		checked_basket_product.splice(checked_basket_product.indexOf(index),1);//이 인덱스를 배열에서 삭제한다.(일괄 주문 리스트에서 제외)
	
	$.get("/basketupdatecheck?chk="+(obj.checked==true ? "1" : "0")+"&p="+index, function(res) {
        $("#checkingupdate").html(res);
        userbasketorder_Load();
    });
	//alert(checked_basket_product)
}

function Product_checking_all(obj){//모두 체크/해제
	prodcheck = document.getElementsByName("prodcheck");
	checked_basket_product.splice(0,checked_basket_product.length)//우선 배열을 초기화
	
	for(i=0; i < prodcheck.length; i++) {
		prodcheck[i].checked = obj.checked;//모두 체크하거나 해제한다.(name이 prod_check인 체크박스를)
		if (obj.checked==true) //올 체크
			checked_basket_product=all_basket_product_index.slice()
	}
	
	$.get("/basketupdateallcheck?chk="+(obj.checked==true ? "1" : "0"), function(res) {
        $("#checkingupdate").html(res);
        userbasketorder_Load();
    });
	
}
</script>




<c:set var="usercode" value='<%=session.getAttribute("usercode")%>' />
<c:forEach var="item" items="${service.selectBasket_Product_usersbasket_checked(usercode)}" varStatus="status">
	<script>
		checked_basket_product.push('${item.product_index}')
	</script>
</c:forEach>



</html>