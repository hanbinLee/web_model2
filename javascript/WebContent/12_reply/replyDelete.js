/**
 * 
 */

function deleteToServer(root, bunho){
	//alert(root+","+bunho);	
	
	//기존데이터인 경우 -> body의 자식인 replyDiv를 삭제
	var url=root+"/12_reply/replyDelete.do";
	var params="bunho="+bunho;
	sendRequest("GET", url, deleteFromServer, params);
	
	
	//새데이터인 경우 -> newReply의 자식인 replyDiv를 삭제
	
	
	
	
}

function deleteFromServer(){
	if(xhr.readyState==4&&xhr.status==200){
		alert(xhr.responseText);
		//xhr.responseText : response를 통해 check를 받음.
		//삭제가 잘 됐으면 1, 잘 안됐으면 0
		
	}
}