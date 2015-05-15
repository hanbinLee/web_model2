<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head><title></title></head>
	<body>
		<table border="1" width="600" cellpadding="0" cellsapcing="0">
			<tr>
				<td align="center" bgclolor="#DEDEDE" width="100">사번</td>
				<td align="center" bgclolor="#DEDEDE" width="100">이름</td>
				<td align="center" bgclolor="#DEDEDE" width="100">입사년월일</td>
				<td align="center" bgclolor="#DEDEDE" width="100">직종</td>
				<td align="center" bgclolor="#DEDEDE" width="100">급여</td>
				<td align="center" bgclolor="#DEDEDE" width="100">부서번호</td>
			</tr>
			<c:forEach var="sawon" items="${sawonList }">
				<tr>
					<td align="center" bgclolor="#DEDEDE" width="100">${sawon.employeeId }</td>
				<td align="center" bgclolor="#DEDEDE" width="100">${sawon.firstName }</td>
				<td align="center" bgclolor="#DEDEDE" width="100"><fmt:formatDate value="${sawon.hireDate }" pattern="yyyy-MM-dd" /></td>
				<td align="center" bgclolor="#DEDEDE" width="100">${sawon.jobId }</td>
				<td align="center" bgclolor="#DEDEDE" width="100">${sawon.salary }</td>
				<td align="center" bgclolor="#DEDEDE" width="100">${sawon.departmentId }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>