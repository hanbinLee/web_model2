<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src=../xhr/xhr.js></script>
<script>
	function toServer(root){
		var form = document.getElementById("createForm");
		var department = form.departmentName.value;
		//alert(root);
		var url=root+"/sawon/listOk.do";
		
		if(department != "부서선택"){
			var params = "departmentName=" + department;
			sendRequest("GET",url,fromServer,params);
		}
	}
	
	function fromServer(){
		if(xhr.readyState ==4 && xhr.status ==200){
			document.getElementById("resultDisp").innerHTML = xhr.responseText;
		}
	}
</script>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	
	<form id="createForm">
		<select name="departmentName" onchange="toServer(' ${root}')">
			<option>부서선택</option>
			<option value="Marketing">Marketing</option>
			<option value="IT">IT</option>
			<option value="Sales">Sales</option>
		</select>
	</form>
	
	<div id="resultDisp"></div>
</body>
</html>