var xhr=null;

function startRequest(){
	//XMLHttpRequest 객체 얻어온다. (웹브라우저에서)
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();	
	}else if(window.ActiveXObject){
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xhr.open("GET" , "xhr.txt" , true);
	xhr.send(null);
	xhr.onreadystatechange=resultProcess;
}

function resultProcess(){
	//alert(xhr.readyState + "," + xhr.status);
	
	if(xhr.readyState==4){
		if(xhr.status==200){
			//alert(xhr.responseText);
			processText();
		}
	}
}

function processText(){
	var div = document.getElementById("requestDisp");
	div.innerHTML = xhr.responseText;
}