<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str1" value="Function태그를 사용합니다."/>
	<c:set var="str2" value="사용" />
	<c:set var="str3" value="1,2,3,4,5,6,7,8,9,10"/>
	
	<div>
		str1: <c:out value="${str1 }"/>
		str2: <c:out value="${str2 }"/>
		str3: <c:out value="${str3 }"/>
	</div>
	<hr/>
	
	<div>
		문자열 길이: ${fn:length(str1) }<br/>
		대문자 : ${fn:toUpperCase(str1) }<br/>
		소문자 : ${fn:toLowerCase(str1) }<br/>
		문자열추출: ${fn:substring(str1,3,6) }<br/>
		문자열1에서 문자열2에 포함되어 있는 문자열 이후 : ${fn:substringAfter(str1,str2) }<br/>
		문자열1에서 문자열2에 포함되어 있는 문자열 이전 : ${fn:substringBefore(str1,str2) }<br/>
		
		문자열 치환 : ${fn:replace(str1," ","-")}<br/>
		문자열 위치: ${fn:indexOf(str1,"t")}<br/>
		시작 문자열 : ${fn:startsWith(str1,'Fun')}<br/>
		끝 문자열 : ${fn:endsWith(str1,'사용합니다')}<br/>
		
		문자열1에 문자열 2가 포함되면 참 : ${fn:contains(str1,str2) }<br/>
		문자열1에서 문자열2가 포함하면 참(대소문자 구분안함) : ${fn:containsIgnoreCase(str1,str2) }<br/>
		
		문자열 분리해서 배열로 반환:
		<c:set var="array" value="${fn:split(str3, ' , ') }"/>
		<c:forEach var="i" items="${array }">
			<c:out value="${i }"/>
		</c:forEach>
		
		문자열 합치기
		join(array,"-") : ${fn:join(array,"-")}<br/>
	</div>
</body>
</html>