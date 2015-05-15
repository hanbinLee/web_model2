<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../xhr/xhr.js"></script>
<script>
	function toServer(root){
		url = root + "/parsingXML/pXML.do";
		sendRequest("GET" , url , fromServer , null);
	}
	
	function fromServer(){
		if(xhr.readyState == 4 && xhr.status ==200){
			processXML(xhr.responseXML);
		}
	}
	
	function processXML(responseXML){
		var arry = new Array();
		var xmlDoc=responseXML;
		
		var location=xmlDoc.getElementsByTagName("location"); //null값이 넘어오면 proxy 작업을 해줘야 가져올수 있음
		
		arry.push("location : " + location.length);
		alert(arry.join("\n"));
	}
</script>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	
	<input type="button" value="클릭" onclick="toServer('${root}')"/>
	<div id="resultDisp"></div>
</body>
</html>