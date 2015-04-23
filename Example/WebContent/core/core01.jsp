<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		JSTL CORE : 변수관련 작업, 제어문(IF , FOR),URL 처리 
		출력             :EL , c:out   
	</div>
	<br/>
	
	<div>
		<c:out value="JSTL 연습입니다."/>
		<c:out value="${'JSTL 연습'}" />
		<br/>
		<c:out value="10"/>
		<c:out value="${20 }"/>
		<br/>
		
		${'JSTL 연습입니다.' }, ${20 }
		<br/>	
		
		<c:set var="str" value="우ha하"/>
		${str } , <c:out value="${str}"/> , <c:out value="str" /> 
	</div>
</body>
</html>