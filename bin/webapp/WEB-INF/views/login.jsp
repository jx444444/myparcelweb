<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
	<title>${strings.get(0)}</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<body>


<table width="100%">
	<tr>
		<td height="80px" style="border-radius:9px;background-color:#134F68;" >
			<div id="tmenu"/>
		</td>
	</tr>
	
	<tr>
		<td align='center'>
			<form action="/login_submit" method="post">
			<table style="text-align:center;padding:20px;margin:10px;border-radius:5px 5px 5px 5px;border: 1px solid lightgray;">
				<tr>
					<td style='padding:7px;font-size:24px;'>${strings.get(0)}</td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="text" class='login_textfield' name="login_email_textfield" placeholder='${strings.get(1)}'></td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="password" class='login_textfield' name="login_pwd_textfield" placeholder='${strings.get(2)}'></td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="submit" id='login_loginbutton' value='${strings.get(0)}'></td>
				</tr>
				<tr>
					<td style="padding:20px;"><input type="button" onclick="location.href='/signup'" id='login_loginbutton' value='${strings.get(3)}'></td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
	
</table>

<script>
$(document).ready(function () {
	$(document).ready( function() {
        $.get("/topmenu", function(res) {
            $("#tmenu").html(res);
        });
    });
})
</script>


</body>
</html>
