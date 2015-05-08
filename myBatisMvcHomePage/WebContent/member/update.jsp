<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	
	<div align="center">
		<font size="2"><b>회원수정</b></font>
	</div>

	<div align="center">
		<form class="form_style" name="updateForm" action="${root }/member/updateOk.do" method="post" onsubmit="return  registerForm(this)">
			<div class="line">
				<label class="title">아이디</label>
				<span class="content">
					<input type="text" name="id" value="${member.id }" disabled="disabled" />	
					<input type="hidden" name="id" value="${member.id }"/>
				</span>
			</div>
			
			<div class="line">
				<label  class="title">비밀번호</label>
				<span class="content">
					<input type="password" name="password" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">비밀번호확인</label>
				<span class="content">
					<input type="password" name="passwordCheck"/>
				</span>
			</div>
	
			<div class="line">
				<label class="title">이름</label>
				<span class="content">
					<input type="text" name="name" value="${member.name }" disabled="disabled"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">주민번호</label>
				<span class="content">
					<input type="text" name="jumin1" size="11" maxlength="6" value="${member.jumin1 }" disabled="disabled"/>
					-<input type="text" name="jumin2" size="12" maxlength="7" value="${member.jumin2 }" disabled="disabled" />
				</span>	
			</div>
			
			<div class="line">
				<label class="title">이메일</label>
				<span class="content">
					<input type="text" name="email" size="25" value="${member.email }"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">우편번호</label>
				<span class="content">
					<input type="text" name="zipcode" value="${member.zipcode }"/>
					<input type="button" value="우편번호검색" onclick="searchZipcode('${root}')"/>
				</span>
		  	</div>
			
			<div class="line">
				<label class="title">주소</label>
				<span class="content">
					<input type="text" name="address" size="48" value="${member.address}" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">직업</label>
				<span class="content">
					<select name="job">
						<option></option>
						<option value="회사원">회사원</option>
						<option value="학생">학생</option>
						<option value="전문직">전문직</option>
						<option value="기타">기타</option>
					</select>
				</span>
				
			</div>
			
			<div class="line">
				<label class="title">메일수신</label>
				<span class="content">
					<input type="radio" name="mailing" value="yes" />yes
					<input type="radio" name="mailing" value="no" />no
				</span>
			</div>
			
			<div class="line">
				<label class="title">관심분야</label>
				<span class="content">
					<input type="checkbox" name="interestValue" value="경제"/> 경제 &nbsp;
					<input type="checkbox" name="interestValue" value="IT"/> IT &nbsp;
					<input type="checkbox" name="interestValue" value="음악"/> 음악 &nbsp;
					<input type="checkbox" name="interestValue" value="미술"/> 미술 &nbsp;
					<input type="hidden" name="interest" value=""/>
				</span>
			</div>
			
			<div class="line" style="width:498px; border-width:2px; text-align:center;">
				<input type="submit" value="가입" />
				<input type="reset" value="취소" />
			</div>
		</form>
	</div>
	
<script type="text/javascript">
	for(var i=0;i<updateForm.mailing.length;i++){
		if(updateForm.mailing[i].value=="${member.mailing}"){
			
			updateForm.mailing[i].checked=true;
		}
	}

	for(var i=0;i<updateForm.job.length;i++){
		if(updateForm.job[i].value=="${member.job}"){
			updateForm.job[i].selected=true;
		}
	}

	//alert(updateForm.job[2].value);

	var str="${member.interest}";
	var result=str.split(',');

	//alert(str[0]);

	for(var i=0;i<updateForm.interestValue.length;i++){
		for(var j=0;j<result.length;j++){
			if(updateForm.interestValue[i].value==result[j]){
				updateForm.interestValue[i].checked=true;
			}	
		}
	}

</script>
	
</body>
</html>