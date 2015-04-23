<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Example 01</title>
<%
	int x=10;
%>
</head>
<body>
	<ol>
		<li>수 출력 : ${10}</li>
		<li>수 출력 : ${10.5}</li>
		<li>수 출력 : ${'apple'} , ${"apple"}</li>
		<li>수 출력 : ${'h'} , ${"h"}</li>
		<li>수 출력 : <%=x %> </li>
		<%--<li>${x }</li> error --%>
		<li>수 출력: ${x } 안되요 "c:set" 배움</li>
		
		<li>덧   셈 : ${2+5 }</li>
		<li>나눗셈: ${4/5 }</li>
		<li>나머지: ${11%7 }</li>
		<li>보다작다:${2<3 },${2 lt 3}</li>
		<li>크다 : ${2>3},${2 gt 3}</li>
		<li>작거나 같다 : ${3.1 <=3.2 },${3.1 le 3.2}</li>
		<li>크거나 같다 : ${3.1 >=3.2 },${3.1 gt 3.2 }</li>
		<li>논리연산자 : ${"&&(AND), ||(OR), !(NOT)"}</li>
		<li>빈문자열 : ${null }</li>
	</ol>
</body>
</html>