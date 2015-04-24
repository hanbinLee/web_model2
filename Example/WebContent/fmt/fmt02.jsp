<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	NUMBER :<fmt:formatNumber value="12345.678" type="number"/><br/>
	CURRENCY : <fmt:formatNumber value="12345.678" type="currency"/>
	PERCENT : <fmt:formatNumber value="12345.678" type="percent"/>
	PATTERN: <fmt:formatNumber value="12345.678" pattern=".00"/>
	
	문자열 숫자 변환
	<c:set var="strSu" value="${'1000' }"/>  <br/>
	<c:out value="${strSu+1 }"/>	<%--자동 autoBoxing  --%>
	<fmt:parseNumber value="${strSu+1 }"/><br/>
	
	<c:set var="today" value="<%=new java.util.Date() %>"/><br/>
	날짜:
		<fmt:formatDate value="${today }" type="date"/><br/>
	시간:
	<fmt:formatDate value="${today }" type="time"/><br/>
	날짜시간:
	<fmt:formatDate value="${today }" type="both"/><br/>
	패턴:
	<fmt:formatDate value="${today }" pattern="yy-MM-dd HH:mm:ss"/><br/>
	
	문자열날짜
	<fmt:parseDate var="now" value="${'1980-12-25 01:22:33'}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
	<fmt:formatDate value="${now }" type="date"/><br/>
</body>
</html>