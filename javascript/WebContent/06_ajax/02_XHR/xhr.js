/**
 * 
 */
var xhr=null;

function createXHR(){
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
}

function startRequest(){
	var createForm = document.getElementById("createForm");
	var id=createForm.id.value;
	var password=createForm.password.value;
	
	//alert(id + "," + password);
	createXHR();
	
	//요청 GET 방식
	//xhr.open("get", "xhr.jsp?id=" + id + "&password=" + password, true);
	//xhr.send(null);
	
	//요청 POST 방식
	xhr.open("post" , "xhr.jsp" , true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("id="+id+"&password="+password);
	
	//이벤트
	xhr.onreadystatechange=resultProcess;
}

function resultProcess(){
	if(xhr.readyState == 4 && xhr.status == 200){
		//alert(xhr.responseText);
		document.getElementById("resultDisp").innerHTML = xhr.responseText;
	}
}