<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우편번호 검색</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	
	<c:choose>
		<c:when test="${fn:length(list)==0}">
			<div align="center">해당 데이터가 존재하지 않습니다.</div>	
		</c:when>
		
		<c:otherwise>
				<div align="center">
					<c:out value="${fn:length(list)}명 검색되었습니다"/>
				</div><br/>
				
				<c:forEach var="list" items="${list }">
					<div align="center">
						<c:set var="code" value="${list.zipcode }"/>
						<c:set var="code2" value="${list.sido }${list.gugun }${list.dong }${list.ri }${list.bunji}"/>
						<a href="javascript:writeZipcode('${code }','${code2}')">
							<c:out value="${code}${code2 }"/>
						</a>
					</div>	
					<br/>
				</c:forEach>
		</c:otherwise>
	</c:choose>
		<div align="center">
			<input type="button" onclick="javascript:self.close()" value="취소">
		</div>
</body>
</html>