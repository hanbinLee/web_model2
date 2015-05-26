/**
 * 
 */

function select(root , bunho){
	alert("root : " + root +", bunho : " + bunho);
	
	var sendData="bunho="+bunho;
	var url=root+"/12_reply/replySelect.do?"+sendData;
	
	$.ajax({
		url:url,
		type:"get",
		dataType:"text",
		success:function(data){
			var result = data.split("/");
			var content = result[0].trim();
			var bunho = result[1].trim();
			//alert(content + "," + bunho);
			var addDiv = "<div>" +"<input type=text id='temp' value="+content +">" + "<input type=button  value='수정' onclick=" +"javascript:update("+$("#temp").val()+"," + bunho+ ") /></div>";
			$("#"+bunho).append(addDiv);
		}
	});
	
	
}

function update(content, bunho){
	alert(content + ",");
}