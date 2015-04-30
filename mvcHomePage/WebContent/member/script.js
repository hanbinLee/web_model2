function registerForm(form){
	var returnValue=false;
	var str="";
	
	for(var i=0;i<form.interestValue.length;i++){
		if(form.interestValue[i].checked==true){
			str+=form.interestValue[i].value+",";
			
			returnValue=true;
		}
	}
	
	form.interest.value=str;
	
	if(returnValue==false){
		alert("하나라도 체크하세요");
		form.interestValue[0].focus();
	}
	
	return returnValue;
}

function idCheck(form,root){
	//alert(form.id.value+","+root);
	
	if(form.id.value==""){
		alert("아디를 입력하세요");
		form.id.focus();
		return false;
	}
	
	var url=root+"/member/idCheck.do?id="+form.id.value;
	window.open(url,"","width=250,height=150");
}

function searchZipcode(root){
	
	var url=root+"/member/zipcode.do";
	//alert(url);
	window.open(url,"","width=250,height=150");
}

function writeZipcode(code,code2){
	//	alert(code);
		opener.memberForm.zipcode.value=code;
		opener.memberForm.address.value=code2;
		self.close();
	}











