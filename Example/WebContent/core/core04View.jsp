<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 예제입니다.</title>
</head>
<body>
	<h4>${param.msg}</h4>
	<br/>
	<c:out value="${param.str}"/>
	<br/>
	
	<c:forTokens var="str" items="${param.str }" delims=",">
		<h4>fruit:<c:out value="${str }"/><br/></h4>
	</c:forTokens>	
	
	<c:forEach var="fruit" items="${paramValues.fruit }">
		<c:out value="${fruit }"/> <%-- or <h4>${fruit} --%>
	</c:forEach>
	
	<c:forTokens var="city" items="서울,인천,대구,부산,광주" delims=",">
		<h2>${city }</h2>
	</c:forTokens>
	
	<c:forTokens var="velocity" items="비행기 , 자동차 , 버스 , 승합차 | 자전거 . 오토바이" delims=", | .">
		<c:out value="${velocity }"/>
	</c:forTokens>
</body>
</html>