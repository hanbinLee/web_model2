<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="fruit" value="apple" />
	
	<c:if	test="${fruit=='apple' }">
		<b>${fruit }</b><br/>
		<b><c:out value="${fruit }"/></b><br/>
	</c:if>
	
	<c:if test="${fruit != 'apple' }">
		<b>apple 아님</b><br/>
	</c:if>
	
	<h4>제어문 choose 예제입니다.</h4>
	
	<c:choose>
		<c:when test="${fruit=='apple' }"> 
			<c:out value="사과입니다."/>
		</c:when>
		
		<c:when test="${fruit=='banana'}">
			<c:out value="바나나입니다."/>
		</c:when>
		
		<c:when test="${fruit=='orange' }">
			<c:out value="오렌지입니다."/>
		</c:when>
		
		<c:otherwise>
			<c:out value="기타등등" />
		</c:otherwise>
	</c:choose>
</body>
</html>