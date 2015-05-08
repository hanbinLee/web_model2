<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우편번호</title>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/> 
	
	<form action="${root }/member/zipcode.do" method="post">
		<div align="center">동 이름을 입력하세요.</div>
		<input type="text" name="zipcode"/>
		<input type="submit" value="확인"/>
	</form>
	
</body>
</html>