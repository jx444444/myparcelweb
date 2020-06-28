<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
	<title>${strings.get(0)}</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/Star.css"/>
<link rel="stylesheet" type="text/css" href="/css/ProductButton.css"/>
<body>


<script>
function product_star_Avg_view(id){
	$(document).ready( function() {
	    $.get("/searchlist_star?id="+id, function(res) {
	        $("#product_star").html(res);
	    });
	});
}
</script>


<table width="100%">
	<tr>
		<td height="80px" style="border-radius:9px;background-color:#134F68;" >
			<div id="tmenu"/>
		</td>
	</tr>
	<tr>
		<td height='15px'></td>
	</tr>
	<tr>
		<td align='center'>
			<c:forEach var="item" items="${service.selectProduct_product_index(p)}" varStatus="status">
				<table style="width:100%;text-align:center;padding:3px;border-bottom:1px solid lightgray;border-top:1px solid lightgray;padding:3px;">
					<tr>
						<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item.index)[0]}" />
						<td width="50%" align="center" style="border-right:1px solid lightgray;">
							<table style="table-layout:fixed;">
								<tr>
									<td style="padding:10px;">
									<img id='maximum_prevealimage' src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='360' height='360'>
									</td>
								</tr>
								<tr>
									<td align="center" style="padding:10px;">
										<div class="pImageXscroll" align="center">
										<c:forEach var="pimages" items="${service.selectPreveal_Image_product_index(p)}" varStatus="status">
												<img onmouseover='MaximumPrevealimageChange(this.src)' onmouseout="" src="/preveal_images/${pimages.image_name}.${decoder.Base64StringEncode(pimages.fn_Extension)}" width='60' height='60'>
										</c:forEach>
										</div>
									</td>
								</tr>
							</table>
						</td>
						
						<td width="50%" style="padding:10px;">
							<table style="height:400px">
								<tr>
									<td>KRW <b style="font-size:30px;">${decoder.Base64StringEncode(item.pay)}</b></td>
								</tr>
								<tr>
									<td><b>${decoder.Base64StringEncode(item.by)}</b></td>
								</tr>
								<tr>
									<td>
										<table>
										<tr>
										<td><div class="stars" id="product_star"></div>
										<script>
										product_star_Avg_view('${decoder.Base64StringEncode(item.index)}')
										</script></td>
										<td><input type="button" id='product_givestar' value="${strings.get(5)}" onclick='GiveStarButton("${decoder.Base64StringEncode(item.index)}")'></td>
										</tr></table>
									</td>
								</tr>
								<tr>
									<td>${decoder.Base64StringEncode(item.explanatory)}</td>
								</tr>
								<tr>
									<td style="height:100%"></td>
								</tr>
								<tr>
									<td>${strings.get(1)} : <input id="product_num" style="font-size:16px;width:120px;border:1px solid gray;border-radius:5px 5px 5px 5px;" type="number" min='1' value='1'></td>
								</tr>
								<tr>
									<td><input type="submit" id='product_buy' value='${strings.get(2)}' onclick='OrderButton_Add("${decoder.Base64StringEncode(p)}",document.getElementById("product_num"))'></td>
								</tr>
								<tr>
									<td>
										<div id="product_basketbutton"></div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td align="center">
			<table style="width:80%;">
					<tr><td >
							
							<c:forEach var="tagitem" items="${service.selectProduct_index_tag(p)}" varStatus="status">
								<c:if test="${service.selectProduct_productpage_anothertag(p,tagitem).size() > 0 }" >
									${tagitem}
									
									<table style="width:100%;text-align:center;padding:3px;border-bottom:1px solid lightgray;table-layout: fixed;">
										<tr>
											<td>
												<div style="width:100%;" class="pImageXscroll" align="center">
												<table><tr>
												<c:forEach var="item3" items="${service.selectProduct_productpage_anothertag(p,tagitem)}" varStatus="status">
													<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item3.index)[0]}" />
													<c:set var="p_pi" value="${service.selectProduct_product_index(item3.index)[0]}" />
													<td>
														<img onclick='location.href="/product?p=${item3.index}"' src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='240' height='240' class="Products_button"/>
													</td>
												</c:forEach>
												</tr></table>
												</div>
											</td>
										</tr>
									</table>
									
								</c:if>
							</c:forEach>
							
					</td></tr>
			</table>
		</td>
	</tr>
	
</table>


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
function GiveStarButton(p){
	//location.href="/orderwindow?p="+p+"&num="+num.value;
	user = "<%=session.getAttribute("id")%>";
	$.get("/product_star?id="+p, function(res) {
        	$("#orderDialog").html(res);
        	if ( user!=null && user!="" && user!="null" ){
		        document.getElementById('orderDialog').style.opacity="1";
		    	document.getElementById('orderDialog').style.pointerEvents="auto";
		    	document.getElementById('orderCloseDialog').style.opacity="1";
		    	document.getElementById('orderCloseDialog').style.pointerEvents="auto";
        	}
    });
}
function OrderButton_Add(p,num){
	//location.href="/orderwindow?p="+p+"&num="+num.value;
	user = "<%=session.getAttribute("id")%>";
	$.get("/orderwindow?p="+p+"&num="+num.value, function(res) {
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



BasketButton()
</script>


</body>
</html>
