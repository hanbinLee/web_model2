/**
 * 
 */
var root=null;

function upSelectToServer(requestRoot, bunho){
	root=requestRoot;
	var url=root+"/12_reply/replySelect.do";
	var params="bunho="+bunho;
	sendRequest("GET", url, upSelectFromServer, params);	
}

function upSelectFromServer(){
	if(xhr.readyState==4&&xhr.status==200){
		//alert(xhr.responseText);
		upSelectProcess(xhr.responseText);
	}
}

function upSelectProcess(responseText){
	var result=responseText.split(",");
	var bunho=result[0].trim();
	var reply=result[1].trim();
	//alert(bunho+","+reply);
	
	/*댓글에 수정을 눌렀을때 upBunho+bunho란 id의 태그를 만들어서 수정할 댓글이 있는 div의 자식으로 자식으로 붙게.*/
	var div=document.createElement("div");
	div.id="upBunho"+bunho;
	/*자식으로 붙은후에 나중에 수정완료를하면 이 자식글은 지워야하므로 아이디값을 넣어 줘야 한다.*/
	
	var inputText=document.createElement("input");
	inputText.type="text";
	inputText.value=reply;
	
	var inputBtn=document.createElement("input");
	inputBtn.type="button";
	inputBtn.value="수정";
	inputBtn.onclick=function(){
		updateToServer(bunho, inputText.value);
	}
	div.appendChild(inputText);
	div.appendChild(inputBtn);
	
	var bunhoDiv=document.getElementById(bunho);
	//alert(bunho+","+reply+","+bunhoDiv);
	
	if(bunhoDiv !=null){
		//기존댓글의 수정일 경우
		bunhoDiv.appendChild(div);
	}else{
		//새 댓글의 수정일 경우
		var newBunho=document.getElementById("newBunho"+bunho);
		newBunho.appendChild(div);
	}	
}

function updateToServer(bunho, reply){
	//여기서 reply는 수정된 새로운 reply
	//alert(bunho+","+reply);
	var url=root+"/12_reply/replyUpdate.do";
	var params="bunho="+bunho+"&reply="+reply;
	sendRequest("GET", url, updateFromServer, params);	
	
}

function updateFromServer(){
	if(xhr.readyState==4&&xhr.status==200){
		//alert(xhr.responseText);
		updateProcess(xhr.responseText);
	}
}

function updateProcess(responseText){
	var result=responseText.split(",");
	var bunho=result[0].trim();
	var reply=result[1].trim();
	//alert(bunho+":"+reply);
	
	var bunhoDiv=document.getElementById(bunho);
	
	if(bunhoDiv!=null){
		//기존 댓글을 수정한 경우
		var span=bunhoDiv.getElementsByTagName("span");
		span[1].innerHTML=reply;
		
		//수정할 때 필요한 입력 창과 버튼을 담고있는 div 삭제 
			//방법1
		//bunhoDiv.removeChild(bunhoDiv.lastChild);		
			//방법2
		var upBunhoDiv=document.getElementById("upBunho"+bunho);
		bunhoDiv.removeChild(upBunhoDiv);
	}else{
		//새로운 댓글을 수정한 경우
		var newBunhoDiv=document.getElementById("newBunho"+bunho);
		var span=newBunho.getElementsByTagName("span");
		newBunhoDiv.childNodes[1].innerHTML=reply;
		
		//수정할 때 필요한 입력 창과 버튼을 담고있는 div 삭제 
			//방법1
		//newBunhoDiv.removeChild(bunhoDiv.lastChild);		
			//방법2
		var upBunhoDiv=document.getElementById("upBunho"+bunho);
		newBunhoDiv.removeChild(upBunhoDiv);
	}
	
	
	
}