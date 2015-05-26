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

<script src="../jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../xhr/xhr.js"></script>
<script type="text/javascript" src="replyWrite.js"></script>
<script type="text/javascript" src="replyDelete.js"></script>
<script src="replyUpdate.js"></script>
</head>

<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>

	<div>한줄 댓글이 가능합니다.</div>
	
	<div>
		<input id="writeReply" type="text" name="write" size="45"/>
		<input type="button" value="한줄 댓글 작성" onclick="writeToServer('${root}','${boardNumber }')"/>
	</div>
	
	<!-- 새로 입력한 레코드가 뿌려질 곳 : 기존 데이터 위에 뿌려진다. (자식태그가 된다?) -->
	<!-- 위의 button을 누르면 writeToServer함수가 실행되면서 newReply태그에 자식태그가 붙는다. -->
	<!-- replyWrite.js에서 DB로부터 받은 bunho와 reply값을 div를 하나 만들어 담은 후 (기존데이터에서 replyDiv 역할의 div) -->
	<!-- 그 div를 아래의 newReply의 자식으로 붙인다. -->
	<div id="newReply"></div>
	
	
	<div id="listAllDiv">
	<!-- 기존 데이터들이 뿌려질 곳 -->
		<div class="replyDiv" style="display:none;">		
				<span class="cssBunho"></span>
				<span class="cssReply"></span>
				<span class="cssUpDel">
					<a href=""></a>&nbsp;
					<a href=""></a>				
				</span>
		</div>
			
		<c:forEach var="reply" items="${replyList }">
			<div class="replyDiv" id="${reply.bunho }">		<!--※ -->
				<span class="cssBunho">${reply.bunho }</span>
				<span class="cssReply">${reply.line_reply }</span>
				<span class="cssUpDel">
					<a href="javascript:select('${root }','${reply.bunho }')">수정</a>
					<a href="javascript:deleteToServer('${root }','${reply.bunho }')">삭제</a>				
				</span>
			</div>
		</c:forEach>
	</div>
	<!-- ※ 댓글을 삭제할 때 하나의 댓글은 크게 replyDiv로 감싸져 있으니까 replyDiv를 삭제하면 된다. -->
	<!-- 댓글들마다 각자 고유한 값으로 가지는 것이 bunho이므로 replyDiv div의 id로 댓글의 bunho를 설정 -->	
	
</body>
</html>