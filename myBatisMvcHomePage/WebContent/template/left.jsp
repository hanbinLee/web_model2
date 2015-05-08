<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>

<c:set var="root" value="${pageContext.request.contextPath }"/>

<c:if test="${sessionScope.id == null }">
	<c:set var="str1" value="<a href='${root }/member/login.do'>�α���</a>"/>
	<c:set var="str2" value="<a href='${root }/member/register.do'>ȸ������</a>"/>
</c:if>
<c:if test="${sessionScope.id !=null }">
	<c:set var="str1" value="<a href='${root }/member/logout.do'>�α׾ƿ�</a>"/>
	<c:set var="str2" value="<a href='${root }/member/update.do'>ȸ������</a>"/>
	<c:set var="str3" value="<a href='${root }/member/delete.do'>ȸ��Ż��</a>"/>
	<c:set var="memberLevel" value="${sessionScope.memberLevel }"/>
</c:if>

<tr valing="top">
	<td width="180" height="359" bgcolor="D1DBDB">
		<table width="200" height="500" cellpadding="0" cellspacing="0">
			<tr>
				<td height="30">${str1 }</td>
			</tr>
			<tr>
				<td height="30">
					<a href="">HOME</a>
				</td>
			</tr>
			<tr>
				<td height="50"><p>�� ȸ�� <br />
					&nbsp;&nbsp;${str2 }
					&nbsp;&nbsp;${str3 }
				</td>
			</tr>
			<tr>
				<td height="50"><p> ��  �Խ���<br />
					&nbsp;&nbsp;<a href="${root }/board/list.do ">|�ϹݰԽ���</a><br />
					&nbsp;&nbsp;<a href="${root }/fileBoard/list.do ">|�ڷ�Խ���</a><br />
				</p></td>
			</tr>
			<tr>
				<td height="50"><p> ��  ����<br />
					&nbsp;&nbsp;<a href="${root }/guest/write.do">|�����ۼ�</a><br />
				</p></td>
			</tr>
			<tr>
				<td height="50"><p>�� ����<br/>
					&nbsp;&nbsp;|���Ϻ����� <br />
					&nbsp;&nbsp;|���Ϸ� ���� ���� <br />
				</p></td>
			</tr>
			 
			 <c:if test="${memberLevel=='AA' }">
				<tr>
					<td height="50">
							&nbsp;&nbsp;<a href="${root }/member/manager.do">������</a>
					</td>
				</tr>
			</c:if>
		</table></td>
		<td width="860">
			<table width="800" height="359" cellpadding="0" cellspacing="0">
			<tr>
				<td height="348">