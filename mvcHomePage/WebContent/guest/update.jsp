<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>방명록 수정</title>
	<script type="text/javascript" src="script.js"></script>
	<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div align="center">
		<form class="form_style" action=""  method="post" onsubmit="">
			<input type="hidden" name="num" value="${guest.num}"/>
			<input type="hidden" name="pageNumber" value=""/>
			<div class="title">
				<label>이름</label>
				<input type="text" name="name" size="15" value="" disabled/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				
				<label>비밀번호</label>
				<input type="password" name="password"  value=""/>
			</div>
			
			<div class="content">
				<textarea rows="5" cols="55" name="message"></textarea>
			</div>
			
			<div class="title" style="text-align:right;" >
				<input type="submit" value="수정"/>
				<input type="reset" value="취소"/>
			</div>
		</form>
	</div>
</body>
</html>