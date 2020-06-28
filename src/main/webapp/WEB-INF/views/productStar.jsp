<table id="givestar_window">
	<tr>
		<td align="center">
			${strings.get(5)}
		</td>
	</tr>
	<tr>
		<td align="center">
			<table><tr><td>
			<input class="star star-5" id="star-5_update" type="radio" name="starbutton_update_${id}" onclick='starbutton(5)'/>
			<label class="star star-5" for="star-5_update"></label>
			<input class="star star-4" id="star-4_update" type="radio" name="starbutton_update_${id}" onclick='starbutton(4)'/>
			<label class="star star-4" for="star-4_update"></label>
			<input class="star star-3" id="star-3_update" type="radio" name="starbutton_update_${id}" onclick='starbutton(3)'/>
			<label class="star star-3" for="star-3_update"></label>
			<input class="star star-2" id="star-2_update" type="radio" name="starbutton_update_${id}" onclick='starbutton(2)'/>
			<label class="star star-2" for="star-2_update"></label>
			<input class="star star-1" id="star-1_update" type="radio" name="starbutton_update_${id}" onclick='starbutton(1)'/>
			<label class="star star-1" for="star-1_update"></label>
			</td></tr></table>
		</td>
	</tr>
</table>


<div id="starupdate_update${id}"></div>
<script>
var num = ${num}
if(num>0){
	document.getElementsByName('starbutton_update_${id}')[5-num].checked = true;
}
	
function starbutton(star){
	$.get("/starupdate?id=${encoder.Base64StringEncode(id)}&num="+star, function(res) {
        $("#starupdate_update${id}").html(res);
        product_star_Avg_view( '${id}' );
    });
}	
</script>