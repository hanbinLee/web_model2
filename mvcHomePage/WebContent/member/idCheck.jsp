<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/> 
	
	<c:choose>
		<c:when test="${check ==1 }">
			<div align="center">
				이미 사용중인 아이디 입니다.
				<form action="${root }/member/idCheck.do" method="post">
					<input type="text" name="id"/>
					<input type="submit" value="확인"/>
				</form>
			</div>
		</c:when>
		
		<c:otherwise>
			<div align="center">
				사용 가능한 아이디 입니다.
				<script type="text/javascript">
						opener.memberForm.id.value="${id}";
				</script>
				<input type="button" onclick="javascript:self.close()" value="닫기">
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>