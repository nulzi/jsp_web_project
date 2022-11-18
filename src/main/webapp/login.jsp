<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header_container">
		<h2>what's in your youtube?</h2>
	</div>
	<hr>
	<form class="login"
		action="http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=login"
		method="post">
		<div class="login_input">
			<input type="text" name="id" autofocus required placeholder="아이디 입력" />
			<input type="password" name="passwd" required placeholder="비밀번호 입력" />
		</div>
		<c:if test="${check == 1}" var="result">
			오류가 발생했습니다. 다시 로그인 해주세요.
		</c:if>
		<input class="login_button" type="submit" name="login" value="로그인">
	</form>
	처음이시라면
	<a href="http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=signup"
		target="_blank">회원가입</a>
</body>
</html>