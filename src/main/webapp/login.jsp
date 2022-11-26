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
		<header class="header_container logo">what's<br>in<br>your<br><img alt="youtube logo" src="./resources/images/youtube.jpg">?</header>
		<div class="main_container login_box">
			<h1>로그인</h1>
			<form 
				action="http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=login"
				method="post">
				<div class="login_input">
					<input type="text" name="id" autofocus required placeholder="아이디 입력" />
					<input type="password" name="passwd" required placeholder="비밀번호 입력" />
					<input class="button" type="submit" name="login" value="로그인">
					<p class="check_message">
						<c:if test="${check == 1}" var="result">
							잘못된 아이디/비밀번호 입니다.<br>다시 로그인 해주세요.
						</c:if>
						<c:if test="${check == 2}" var="result">
							회원탈퇴 했습니다.<br>
							이용하려면 다시 가입하거나 다른 아이디로 로그인 해주세요.
						</c:if>
					</p>
					<a class="gray_message" href="http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=signup" target="_self">
						첫 이용시 회원가입
					</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>