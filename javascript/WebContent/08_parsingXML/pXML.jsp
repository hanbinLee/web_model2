<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../xhr/xhr.js"></script>
<script>
	function toServer(){
		url = "pXMLResult.jsp";
		sendRequest("GET" , url , fromServer , null);
	}
	
	function fromServer(){
	//	alert(xhr.readyState + "," + xhr.status);
		
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById("resultDisp").innerHTML = xhr.responseText;
		}
	}
</script>
</head>
<body>
	<input type="button" value="클릭" onclick="toServer()"/>
	<div id="resultDisp"></div>
</body>
</html>