<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Redirect</title>
</head>
<body>
	<h4>redirect 태그</h4>
	<c:set var="su" value="${param.su }"/>
	<c:set var="su2" value="${param.su2 }"/>
	<c:if test="${su==1 }">
		<c:redirect url="core01.jsp"/>
	</c:if>
	
	<c:if test="${su==2 }">
		<c:redirect url="core02.jsp"/>
	</c:if>
	
	<c:if test="${su==3 }">
		<c:redirect url="core03.jsp"/>
	</c:if>

</body>
</html>