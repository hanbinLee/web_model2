<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>

<link type="text/css" href="reply.css" rel="stylesheet"/>

<script type="text/javascript" src="../xhr/xhr.js"></script>		<!-- 없앨 거야 -->
<script type="text/javascript" src="replyWrite.js"></script>
<script type="text/javascript" src="replyDelete.js"></script>
<script type="text/javascript" src="replyUpdate.js"></script>

<script type="text/javascript" src="../jquery/jquery.js"></script>

</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	<div>한줄 댓글이 가능합니다.</div>
	
	<div>
		<input id="writeReply" type="text" name="write" size="45"/>
		<input type="button" value="한줄 댓글 작성" onclick="writeToServer('${root}','${boardNumber }')"/>
	</div>
	
	<div id="listAllDiv">
		<div class="replyDiv" style="display:none;">	<!-- 안보이게 함 -->		
			<span class="cssBunho"></span>
			<span class="cssReply"></span>
			<span class="cssUpDel">
				<a href=""></a>&nbsp;
				<a href=""></a>				
			</span>
		</div>
			
		<c:forEach var="reply" items="${replyList }">
			<div class="replyDiv" id="${reply.bunho }">		
				<span class="cssBunho">${reply.bunho }</span>
				<span class="cssReply">${reply.line_reply }</span>
				<span class="cssUpDel">
					<a href="javascript:upSelectToServer('${root }','${reply.bunho }')">수정</a>
					<a href="javascript:deleteToServer('${root }','${reply.bunho }')">삭제</a>				
				</span>
			</div>
		</c:forEach>
	</div>	
</body>
</html>