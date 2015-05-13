/**
 * 
 */

function startRequest(){
	var xhr;
	
	//XMLHttpRequest 객체 얻어온다. (웹브라우저에서)
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();	
	}else if(window.ActiveXObject){
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
}