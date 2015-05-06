function formCheck(form){

}

function deleteCheck(urlNum){
	//alert(urlNum);
	
	var value=confirm("정말로 삭제하시겠습니까?");
	
	if(value){
		location.href=urlNum;
	}else{
		alert("삭제가 취소되었습니다.");
	}
}
