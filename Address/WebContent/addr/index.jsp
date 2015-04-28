<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<a href="${root }/addr/write.do">주소록 작성</a> &nbsp;&nbsp;
	<a href="${root }/addr/select.do">주소록 검색</a> &nbsp;&nbsp;
	<a href="${root }/addr/delete.do">주소록 삭제</a> &nbsp;&nbsp;
	<!-- 
	<a href="${root }/addr/write.do">주소록 수정</a> &nbsp;&nbsp;
	 --> 
</body>
</html>