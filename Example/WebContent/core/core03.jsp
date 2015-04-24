<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 예제</title>
</head>
<body>
	<label>제어문 for문 입니다.</label>
	<c:forEach var="i" begin="1" end="10" step="2">
		<c:out value="${i}" />
	</c:forEach>
	<br/>
	
	<c:forEach var="j" begin="1" end="10">
		<c:if test="${j%2==0 }">
			<c:out value="${j}"/>
		</c:if>
	</c:forEach>
	
	<c:forEach var="k" begin="1" end="10">
		<c:set var="tot" value="${tot+k }"/> <%--tot가 자동으로 0으로 초기화됨 --%>
	</c:forEach>
	
	<div>
		1~10까지의 합 : <c:out value="${tot }"/>
	</div><br/>
	
	<%
		ArrayList<String> list=new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("딸기");
	%>
	
	<c:set var="arrayList" value="<%=list %>"/>
	
	<c:forEach var="fruit" items="${arrayList }">
		<c:out value="${fruit }"/>
	</c:forEach>
</body>
</html>