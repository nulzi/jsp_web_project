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
	<c:if test="${check == 1}" var="result">
		<h2>${user.username}님 회원가입을 축하합니다</h2>
		<a href="http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=login"
			target="_self">로그인하러가기</a>
	</c:if>
	<c:if test="${check == 0}" var="result">
		<h2>죄송합니다. 오류가 발생했습니다.<br>다시 회원가입해주세요.</h2>
		<a href="signUp.html">다시 가입하기</a>
	</c:if>
</body>
</html>