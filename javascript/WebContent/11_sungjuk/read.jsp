<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>

<script type="text/javascript" src="../xhr/xhr.js"></script>
<script type="text/javascript">
	function toServer(root){
		//alert(root);
		var url=root+"/sungjuk/read.do";		
		sendRequest("GET", url, fromServer, null);
	}
	function fromServer(){
		if(xhr.readyState==4&&xhr.status==200){
			//alert(xhr.responseText);
			//processJson(xhr.responseText);	//●경우1 : 하나의 데이터를 가져오는 경우
			processSawon(xhr.responseText);		//●경우2 : 여러개의 데이터를 가져오는 경우
		}
	}	
	function processJson(responseText){	
		var obj=JSON.parse(responseText);	//JSON이 된 데이터에서 JSON에서 데이터를 접근하는 방법으로 데이터를 꺼내가지고 뿌리면 됨.
		//alert(obj.bunho+", "+obj.name+", "+obj.average);
		var str=obj.bunho+"<br/>"+obj.name+"<br/>"+obj.average;
		
		document.getElementById("resultDisp").innerHTML=str;	 		
	}
	
	function processSawon(responseText){
		var obj=JSON.parse(responseText);
		
		var str="<div>";
		
		for(var i=0;i<obj.length;i++){
			str+="<div>" + obj[i].employeeId + "</div>";
			str+="<div>" + obj[i].firstName + "</div>";
			str+="<div>" + obj[i].hireDate + "</div>";
			str+="<div>" + obj[i].jobId + "</div><br/>";
		}
		
		str+="</div>";
		document.getElementById("resultDisp").innerHTML=str;
	}

</script>

</head>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
<body onload="toServer('${root}')">
	<div id="resultDisp"></div>
</body>
</html>