<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.c.dto.*" import="com.c.myParcel.*" import="java.lang.*" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="pImageXscroll" align="center" style="width:1800px;">

<table border='1' cellpadding='8'>
	<tr>
	   <td colspan='5' align='center'><b>user</b></td>
   </tr>
	<tr style="color:blue;">
	   <td>index</td>
	   <td>email</td>
	   <td>password</td>
	   <td>money</td>
	   <td>name</td>
   </tr>
	<c:forEach var="item" items="${service.selectMember()}" varStatus="status">
		<tr>
		   <td rowspan='3'>${item.index}(${decoder.Base64StringEncode(item.index)})</td>
		   <td>${decoder.Base64StringEncode(item.email)}</td>
		   <td>${decoder.Base64StringEncode(item.password)}</td>
		   <td>${decoder.Base64StringEncode(item.money)}</td>
		   <td>${decoder.Base64StringEncode(item.name)}</td>
		</tr>
		<tr>
			<td></td>
		   	<td colspan='4'>
		   		BASKET
		   		<table width='100%' cellpadding='6'>
		   		<c:forEach var="item2" items="${service.selectBasket_Product_usersbasket(item.index)}" varStatus="status">
					<tr>
						<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item2.product_index)[0]}" />
						<c:set var="p_pi" value="${service.selectProduct_product_index(item2.product_index)[0]}" />
						<td><img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='120' height='120'></td>
						<td align='left'>${decoder.Base64StringEncode(p_pi.name)}</td>
						<td align='right' style="font-size:8px;color:gray;">
							<table align='right'>
								<tr><td>${decoder.Base64StringEncode(p_pi.pay)}원</td></tr>
								<tr><td>${DateFormat.DateStringFormat(p_pi.day)}</td></tr>
							</table>
						</td>
					</tr>
				</c:forEach>
				</table>
		   	</td>
	   </tr>
	   <tr>
			<td></td>
		   	<td colspan='4'>
		   		ORDER
		   		<table width='100%' cellpadding='6'>
		   		<c:forEach var="item2" items="${service.selectOrder_userorder(item.index)}" varStatus="status">
					<tr>
						<td align='left'>${decoder.Base64StringEncode(p_pi.name)}</td>
						<td align='right' style="font-size:8px;color:gray;">
							<table align='right'>
								<tr><td>배송지 : ${decoder.Base64StringEncode(item2.shipping_place)}</td></tr>
								<tr><td>주문일 : ${DateFormat.DateStringFormat(item2.day)}</td></tr>
							</table>
						</td>
					</tr>
				</c:forEach>
				</table>
		   	</td>
	   </tr>
	</c:forEach>
</table>
<br><br>
<table border='1' cellpadding='10'>
	<tr>
	   <td colspan='10' align='center'><b>product</b></td>
   </tr>
	<tr style="color:blue;">
	   <td>index</td>
	   <td>name</td>
	   <td>pay</td>
	   <td>explanatory</td>
	   <td>by</td>
	   <td>kind</td>
	   <td>day</td>
	   <td>STAR</td>
	   <td>tag</td>
	   <td>brand</td>
   </tr>
	<c:forEach var="item" items="${service.selectProduct()}" varStatus="status">
		<tr>
		   <td>${item.index}</td>
		   <td>${decoder.Base64StringEncode(item.name)}</td>
		   <td>${decoder.Base64StringEncode(item.pay)}</td>
		   <td>${decoder.Base64StringEncode(item.explanatory)}</td>
		   <td>${decoder.Base64StringEncode(item.by)}</td>
		   <td>${decoder.Base64StringEncode(item.kind)}</td>
		   <td>${item.day.toString()}</td>
		   <td align='center'>
		   		<table border='1' cellpadding='12'>
		   			<tr>
		   				<td>Count</td>
		   				<td>Avg</td>
		   			</tr>
		   			<tr>
		   				<td>${service.selectProduct_Star_count(item.index)}</td>
		   				<td>${Math.round(Float.parseFloat(service.selectProduct_Star_avg(item.index)[0]))}</td>
		   			</tr>
		   		</table>
		   </td>
		   <td>${decoder.Base64StringEncode(item.tag)}</td>
		   <td>${decoder.Base64StringEncode(item.brand)}</td>
	   </tr>
	</c:forEach>
</table>
<br><br>
<table border='1' cellpadding='8'>
	<tr>
	   <td colspan='4' align='center'><b>basket_product</b></td>
   </tr>
	<tr style="color:blue;">
	   <td>user</td>
	   <td>product_index</td>
	   <td>day</td>
	   <td>num</td>
   </tr>
	<c:forEach var="item" items="${service.selectBasket_Product()}" varStatus="status">
		<tr>
		   <td>${item.user}</td>
		   <td>${item.product_index}</td>
		   <td>${item.day}</td>
		   <td>${item.num}</td>
	   </tr>
	</c:forEach>
</table>
<br><br>
<table border='1' cellpadding='8'>
	<tr>
	   <td colspan='5' align='center'><b>preveal_image</b></td>
   </tr>
	<tr style="color:blue;">
	   <td>product_index</td>
	   <td>imagenum</td>
	   <td>image_name</td>
	   <td>fn_Extension</td>
	   <td>IMAGE PREVIEW</td>
   </tr>
	<c:forEach var="item" items="${service.selectPreveal_Image()}" varStatus="status">
		<tr>
		   <td>${decoder.Base64StringEncode(item.product_index)}[<b> ${item.product_index} </b>]</td>
		   <td>${decoder.Base64StringEncode(item.imagenum)}</td>
		   <td>${decoder.Base64StringEncode(item.image_name)}[<b> ${item.image_name} </b>]</td>
		   <td>${decoder.Base64StringEncode(item.fn_Extension)}</td>
		   <td><img src="/preveal_images/${item.image_name}.${decoder.Base64StringEncode(item.fn_Extension)}" width='120' height='120'></td>
	   </tr>
	</c:forEach>
</table>
<br><br>
<table border='1' cellpadding='8'>
	<tr>
	   <td colspan='6' align='center'><b>order</b></td>
   </tr>
	<tr style="color:blue;">
		<td>index</td>
	   	<td>user</td>
	   	<td>shipping_place</td>
	   	<td>day</td>
   </tr>
	<c:forEach var="item" items="${service.selectOrder()}" varStatus="status">
		<tr>
			<td>${item.index}</td>
		   	<td>${decoder.Base64StringEncode(item.user)}(${item.user})</td>
		   	<td>${decoder.Base64StringEncode(item.shipping_place)}</td>
		   	<td>${item.day}</td>
		   	<td>
		   		<table style="border-collapse:collapse" border="1">
					<tr>
						<td align="center" colspan="3">상품</td>
						<td align="center" width="10%">수량</td>
					</tr>
					
					<c:forEach var="item2" items="${service.selectOrderproductpart_orderindex(item.index)}" varStatus="status2">
					<tr>
						<c:set var="pi_pi" value="${service.selectPreveal_Image_product_index(item2.product_index)[0]}" />
						<td><img src="/preveal_images/${pi_pi.image_name}.${decoder.Base64StringEncode(pi_pi.fn_Extension)}" width='120' height='120'></td>
						<td>${item2.product_index}(${decoder.Base64StringEncode(item2.product_index)})</td>
						<td>${item2.order_index}(${decoder.Base64StringEncode(item2.order_index)})</td>
						<td>${item2.num}(${decoder.Base64StringEncode(item2.num)})</td>
					</tr>
					</c:forEach>
				</table>
		   	</td>
	   </tr>
	</c:forEach>
</table>
<br><br>
<table border='1' cellpadding='8'>
	<tr>
	   <td colspan='3' align='center'><b>product_star</b></td>
   </tr>
	<tr style="color:blue;">
	   <td>user</td>
	   <td>product_index</td>
	   <td>star</td>
   </tr>
	<c:forEach var="item" items="${service.selectProduct_Star()}" varStatus="status">
		<tr>
		   <td>${item.user}</td>
		   <td>${item.product_index}</td>
		   <td>${decoder.Base64StringEncode(item.star)}</td>
	   </tr>
	</c:forEach>
	
</table>



<br><br><br><br><br><br><br>

<form action="/productadd" method="post" enctype="multipart/form-data">
상품등록
<table border='1' cellpadding='8'>
		<tr>
			<td>상품명(name)</td>
			<td><input type="text" name="pname" value="AmazonBasics 라이트닝에서 USB A 전환 케이블, 1.8m (6피트)"></td>
		</tr>
		<tr>
			<td>가격(pay)</td>
			<td><input type="number" value='0' name="pay" value="11000"></td>
		</tr>
		<tr>
			<td>비고(explanatory)</td>
			<td><input type="text" name="explanatory" value="Apple MFi certified charging and syncing cable for your Apple devices"></td>
		</tr>
		<tr>
			<td>등록자(by)</td>
			<td><input type="text" name="by" value="AmazonBasics"></td>
		</tr>
		<tr>
			<td>종류(kind)</td>
			<td><input type="text" name="kind"></td>
		</tr>
		<tr>
			<td>태그(tag)(,으로 나눔)</td>
			<td><input type="text" name="tag" value="iphone cord,휴대폰 케이블,USB 케이블"></td>
		</tr>
		<tr>
			<td>브랜드(brand)</td>
			<td><input type="text" name="brand" value="AmazonBasics"></td>
		</tr>
		<tr>
			<td rowspan="2" >이미지파일(file)</td>
			<td><input type="file" name="file" accept="image/*" multiple="multiple" id="fileinput" ></td>
		</tr>
		<tr>
			<td><div id="imagefilepreview"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input style="width:100%;height:100%;" type="submit" value="등록하기"></td>
		</tr>
</table>
</form>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</div>

<script>
$(function() {
    // Multiple images preview in browser
    var imagesPreview = function(input, placeToInsertImagePreview) {

        if (input.files) {
            var filesAmount = input.files.length;

            for (i = 0; i < filesAmount; i++) {
                var reader = new FileReader();
                reader.onload = function(event) {
                    $($.parseHTML('<img width="64px" height="64px">')).attr('src', event.target.result).appendTo(placeToInsertImagePreview);
                }
                reader.readAsDataURL(input.files[i]);
            }
        }

    };

    $('#fileinput').on('change', function() {
    	$("#imagefilepreview").empty();
        imagesPreview(this, '#imagefilepreview');
    });
});
</script>


</body>
</html>