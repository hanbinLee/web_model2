<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css"/>
<title>Start</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	<c:out value="${root }"/><br/>
	
	<c:if test="${memberLevel==null }">
		<a href="${root }/member/register.do">회원가입</a>
		<a href="${root }/member/login.do">로그인</a>
	</c:if>
	
	<c:if test="${memberLevel!=null }">
		<a href="${root }/member/logout.do">로그아웃</a>
		<a href="${root }/member/update.do?id=${id}">회원수정</a>
		<a href="${root }/member/delete.do">회원탈퇴</a>
		
		<c:if test="${memberLevel=='AA' }">
			<a href="">관리자</a>
		</c:if>
	</c:if>
</body>
</html>