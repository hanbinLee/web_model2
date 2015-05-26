/**
 * 
 */
function writeToServer(root, boardNumber){
	//alert(root+" , "+boardNumber);	
	var writeReply=$("#writeReply").val();	//댓글 내용
	
	//alert(writeReply + "," + boardNumber );
	
	
	var sendData="boardNumber="+boardNumber+"&lineReply="+writeReply;
	var url=root+"/12_reply/replyWrite.do?"+sendData;
	
	$.ajax({
		url:url ,
		type:"get",
		dataType:"text",
		success:function(data){
			var result = data.split(",");
			var bunho = result[0].trim();
			var reply=result[1].trim();
			
			//alert(bunho + "," + reply);
			$("#writeReply").val("");
			$("#listAllDiv > div:eq(0)").css("display" , "block");
			$("#listAllDiv > div:eq(0)").attr("id" , bunho);
			$("#listAllDiv  span:eq(0)").text(bunho);
			$("#listAllDiv  span:eq(1)").text(reply);
			
			$("#listAllDiv  a:eq(0)").text("삭제");
			$("#listAllDiv  a:eq(0)").attr("href" , "javascript:deleteToServer('\'"+root+"'\',"+bunho+")");
			//root 를 \로 감싸줘야한다 ?????? el로 넘기는게 아니라서 그런거란다.
			$("#listAllDiv  a:eq(1)").text("수정");
			$("#listAllDiv  a:eq(1)").attr("href" , "javascript:upSelectToServer('\'"+root+"'\',"+bunho+")");
			
			var goUrl = root+"/12_reply/replyList.do";
			//alert(goUrl);
			location.href=goUrl;
		},
		error:function(xhr , status , error){
			alert("xhr : " + xhr + "\n status : " + status + "\n error : " + error);
		}
	});
}

/*
function writeFromServer(){
	if(xhr.readyState==4&&xhr.status==200){
		//alert(xhr.responseText);	//ReplyWriteAction.java에서 (bunho와 lineReply를 가진)String str을 Text로 받음.
		writeReplyProcess(xhr.responseText);
	}
}

function writeReplyProcess(responseText){
	var result=responseText.split(",");	//0번지는 글번호, 1번지는 답글내용이 됨.
	var bunho=result[0].trim();			//공백 제거
	var reply=result[1].trim();	
	//alert(bunho+", "+reply);
	
	//newReply라는 id의 div에 이런 형식으로 가져온 데이터들을(bunho, reply) 뿌려주자
	
	<div class="replyDiv" id="${reply.bunho }">	
		<span class="cssBunho">${reply.bunho }</span>
		<span class="cssReply">${reply.line_reply }</span>
		<span class="cssUpDel">
			<a href="">수정</a>
			<a href="">삭제</a>			
		</span>
	</div>
	
	
	var newReply=document.getElementById("newReply");	//replyList.jsp에서 새 댓글을 뿌려줄 공간을 미리 만들어 둠.
	
	var div=document.createElement("div");	//위의 주석에서 class가 replyDiv인 div를 만든 것.
	div.className="replyDiv";				//style 설정
		//삭제할 때 기존데이터인지 지금 새로 입력한 데이터인지 구분지어서 다른 방법으로 삭제해야한다.
		//		->그래서 새로 입력한 데이터의 div는 id를 그냥 bunho가 아니라 newBunho를 추가해서 설정
	div.id="newBunho"+bunho;
	
	var spanBunho=document.createElement("span");
	spanBunho.className="cssBunho";
	spanBunho.innerHTML=bunho;
	
	var spanReply=document.createElement("span");
	spanReply.className="cssReply";
	spanReply.innerHTML=reply;
	
	var spanUpDel=document.createElement("span");
	spanUpDel.className="cssUpDel";
	
	var aUpdate=document.createElement("a");
	aUpdate.href="";
	aUpdate.innerHTML="수정&nbsp";
	
	var aDelete=document.createElement("a");
	aDelete.href="";
	aDelete.innerHTML="삭제&nbsp";
	
	spanUpDel.appendChild(aUpdate);
	spanUpDel.appendChild(aDelete);
	
	div.appendChild(spanBunho);
	div.appendChild(spanReply);
	div.appendChild(spanUpDel);
	
	//newReply.appendChild(div);
	newReply.insertBefore(div, newReply.firstChild);
	//div를 newReply의 firstChild의 전에(before) insert해라.
	//replyList.do페이지에서 새로고침 없이 하나 이상의 댓글을 작성하면
	//newReply div에 자식들로 여러개가 붙게 되는데
	//그냥 appendChild로 하면 그 아래 아래로 붙게 된다.
	//newReply div의 항상 위에 붙게 하기 위해서 insertBefore함수를 사용
	//새로 작성한 댓글인 div를 항상 첫번째 자식으로 붙게 한다.
	
	document.getElementById("writeReply").value="";	
	//댓글을 입력하면 입력창을 비워줌
		
}
*/
