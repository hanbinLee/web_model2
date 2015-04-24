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
	
	<br/><br/>
	
	<div>
		<jsp:useBean id="name" class="jstl.Name"/>
		<c:set target="${name }" property="lastName" value="홍"/>
		<c:set target="${name }" property="firstName" value="${'길동' }"/>
	</div>
	
	<div>
		성 : <c:out value="${name.lastName }" /><br/>
		이름: ${name.firstName}<br/>
	</div>
	
	<div>
		<c:remove var="str"/>
		STR : <c:out value="${str }"/>
	</div>
	
	<c:catch var="e">
	<%=10/0 %>
	</c:catch>
	<c:out value="${e }"/>
</body>
</html>