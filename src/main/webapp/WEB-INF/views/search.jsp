<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<html>
<head>
	<title>${strings.get(0)} ${searchword}</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/MainStyle.css"/>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/Star.css"/>
<body>


<table width="100%">
	<tr>
		<td height="80px" style="border-radius:9px;background-color:#134F68;">
			<div id="tmenu"/>
		</td>
	</tr>
	
	<tr><td>
			<table width="100%">
				<tr>
					<td colspan="2">
						<table width="100%">
							<tr>
								<td align="right">
									<select id="searchalign" onchange="SearchlistLoad(0,'','')">
										<option selected="selected">${strings.get(5)}</option>
										<option>${strings.get(6)}</option>
										<option>${strings.get(2)}</option>
										<option>${strings.get(7)}</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td width="20%" valign="top" style="border-right:1px solid lightgray;padding:4px;">
						
						<table style="width:100%;font-weight:bold;border-collapse:collapse;padding:11px">
							<tr><td style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;">
								<table>
									<tr><td>
									${strings.get(1)}
									</td></tr>
									<tr><td>
									<div id="searchtag"></div>
									</td></tr>
								</table>
							</td></tr>
							<tr><td style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;">
								<table>
									<tr><td>
									${strings.get(2)}
									</td></tr>
									
									<%String lang = session.getAttribute("lang")+""; %>
									<tr><td onclick="SearchlistLoad(4,'','')" style="cursor:pointer;">
										<%if(lang.equals("1")){%>
										${strings.get(4)}
										<%} %>
										<b style="color:#00ff00;">★★★★☆</b>
										<%if(lang.equals("1")==false){%>
										${strings.get(4)}
										<%} %>
									</td></tr>
									
									<tr><td onclick="SearchlistLoad(3,'','')" style="cursor:pointer;">
										<%if(lang.equals("1")){%>
										${strings.get(4)}
										<%} %>
										<b style="color:#00ff00;">★★★☆☆</b>
										<%if(lang.equals("1")==false){%>
										${strings.get(4)}
										<%} %>
									</td></tr>
									
									<tr><td onclick="SearchlistLoad(2,'','')" style="cursor:pointer;">
										<%if(lang.equals("1")){%>
										${strings.get(4)}
										<%} %>
										<b style="color:#00ff00;">★★☆☆☆</b>
										<%if(lang.equals("1")==false){%>
										${strings.get(4)}
										<%} %>
									</td></tr>
									
									<tr><td onclick="SearchlistLoad(1,'','')" style="cursor:pointer;">
										<%if(lang.equals("1")){%>
										${strings.get(4)}
										<%} %>
										<b style="color:#ff0000;">★☆☆☆☆</b>
										<%if(lang.equals("1")==false){%>
										${strings.get(4)}
										<%} %>
									</td></tr>
									
								</table>
							</td></tr>
							<tr><td style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;">
								<table>
									<tr><td>
									${strings.get(3)}
									</td></tr>
									<tr><td>
									<div id="searchbrand"></div>
									</td></tr>
								</table>
							</td></tr>
						</table>
						
					</td>
					<td width="80%" valign="top">
						<div id="list"/>
					</td>
				</tr>
			</table>
	</td></tr>
</table>


<script>


$(document).ready(function () {
	$(document).ready( function() {
        $.get("/topmenu", function(res) {
            $("#tmenu").html(res);
            document.getElementById('serach_textfield').value='${searchword}'
            document.getElementById('serach_filter').selectedIndex='${filter}'
            	SearchlistLoad(0,"","");
        });
    });
})


function SearchlistLoad(star,tag,brand){
	searchword = document.getElementById('serach_textfield').value;
	filter = document.getElementById('serach_filter').selectedIndex;
	align = document.getElementById('searchalign').selectedIndex;
	$.get("/searchlist?sch="+searchword+"&flt="+filter+"&st="+star+"&tag="+tag+"&br="+brand+"&agn="+align, function(res) {
        $("#list").html(res);
    });
	$.get("/searchlist_tag?sch="+searchword+"&flt="+filter+"&st="+star+"&tag="+tag+"&br="+brand, function(res) {
        $("#searchtag").html(res);
    });
	$.get("/searchlist_brand?sch="+searchword+"&flt="+filter+"&st="+star+"&tag="+tag+"&br="+brand, function(res) {
        $("#searchbrand").html(res);
    });
}
</script>



</body>
</html>
