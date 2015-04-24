<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core04</title>
<script type="text/javascript">
	function sub(form){
		var str="";
		
		for(var i=0;i<form.fruit.length;i++){
			if(form.fruit[i].checked){
				str+=form.fruit[i].value+",";
			}
		}
		form.str.value=str;
	}
</script>
</head>
<body>
	<form action="core04View.jsp" method="post" onsubmit="return sub(this)">
		<label>메세지</label>
		<input type="text" name="msg"/>
		<br/>
		
		<input type="checkbox" name="fruit" value="사과"/>
		<label>사과</label>
		
		<input type="checkbox" name="fruit" value="딸기"/>
		<label>딸기</label>
		
		<input type="checkbox" name="fruit" value="바나나"/>
		<label>바나나</label>
		
		<input type="hidden" name="str" />
		
		<input type="submit" value="전송" />
		<input type="reset" value="취소" />
	</form>
</body>
</html>