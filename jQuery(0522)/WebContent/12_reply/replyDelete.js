/**
 * 
 */
var root=null;

function deleteToServer(requestRoot, bunho){
	//alert(root+","+bunho);	
	root=requestRoot;
	
	//기존 댓글이던 새로운 댓글이던 상관없이 일단 먼저 DB에서 삭제해 주자.
	var url=root+"/12_reply/replyDelete.do";
	var params="bunho="+bunho;
	sendRequest("GET", url, deleteFromServer, params);

}

function deleteFromServer(){
	if(xhr.readyState==4&&xhr.status==200){
		//alert(xhr.responseText);
		//xhr.responseText : response를 통해 삭제된 댓글의 bunho를 받음
		deleteProcess(xhr.responseText);
	}
}

function deleteProcess(responseText){
	var bunho=parseInt(responseText);
	//이제 DB에서 삭제된 bunho번의 댓글을 replyList.jsp에서도 지워줘야지
	
	var divBunho=document.getElementById(bunho);
	//기존의 댓글이면 댓글 번호와 댓글 내용을 감싸는 div의 id가 bunho로 되어있고,
	//새로운 댓글이면 댓글 번호와 댓글 내용을 감싸는 div의 id가 newBunho+bunho로 되어있다.	
	//alert(bunho);
	//alert(divBunho);
	
	if(divBunho!=null){
		//기존의 댓글을 삭제한 경우 -> body의 자식인 replyDiv를 삭제
		document.body.removeChild(divBunho);
	}else{
		//새로운 기존의 댓글을 삭제한 경우 -> newReply의 자식인 replyDiv를 삭제
		var newReply=document.getElementById("newReply");
		var newBunhoDiv=document.getElementById("newBunho"+bunho);
		
		newReply.removeChild(newBunhoDiv);		
	}
}