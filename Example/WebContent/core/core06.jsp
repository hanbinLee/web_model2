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
	<c:url var="core01" value="core01.jsp"/>
	<a href="${core01 }">JSTL 내부자원이동</a>	<br/>
	<a href="http://localhost:8081/Example/core/core01.jsp">HTML 내부자원이동</a><br/>
	
	<c:url var="naver" value="http://www.naver.com"/>
	<a href="${naver }">JSTL TAG 외부자원 이동</a><br/>
	
	<a href="http://www.naver.com">HTML TAG 외부자원 이동</a><br/>
	
	내부자원<c:import url="core01.jsp"/> 
	외부자원(JSTL버전과 웹브라우저 버전에 따라 CSS는 못가져올수도있음)<c:import url="http://www.naver.com"/>
</body>
</html>