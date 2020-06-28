<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
	<title>${strings.get(3)}</title>
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
			<form action="/signup_submit" method="post">
			<table style="text-align:center;padding:20px;margin:10px;">
				<tr>
					<td style='padding:7px;font-size:24px;'>${strings.get(3)}</td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="text" class='login_textfield' name="signup_name_textfield" placeholder='${strings.get(4)}'></td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="text" class='login_textfield' name="signup_email_textfield" placeholder='${strings.get(1)}'></td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="password" class='login_textfield' name="signup_pwd_textfield" placeholder='${strings.get(2)}${strings.get(7)}'></td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="password" class='login_textfield' name="signup_pwd_check_textfield" placeholder='${strings.get(5)}'></td>
				</tr>
				<tr>
					<td style="padding:7px;"><input type="submit" id='signup_signupbutton' value='${strings.get(6)}'></td>
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
