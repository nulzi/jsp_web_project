<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/public.css" type="text/css" />
</head>
<body>
	<div class="app_container">
		<header class="header_container logo">
			what's<br>in<br>your<br> <img alt="youtube logo"
				src="./resources/images/youtube.jpg">?
		</header>
		<div class="main_container column_box">
			<c:if test="${check == 1}" var="result">
				<h1>${user.username}님의 가입을 축하합니다</h1>
				<a class="gray_message arrow"
					href="http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=login"
					target="_self">로그인하러가기</a>
			</c:if>
			<c:if test="${check == 0}" var="result">
				<h1>
					죄송합니다.<br>중복되는 아이디입니다.<br>다시 가입해주세요.
				</h1>
				<a class="gray_message arrow" href="signUp.html">다시 가입하기</a>
			</c:if>
		</div>
	</div>
</body>
</html>