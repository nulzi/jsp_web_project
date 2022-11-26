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
			<p>${isSuccess }</p>
			<h1>
				<a class="black_arrow" href="http://www.youtube.com/results?search_query=${post.creator}">${post.creator} 보러가기</a><br>
			</h1>
			category: ${post.category} <br> writer: ${post.user_id} <br>
			content: ${post.content} <br> upload_date: ${post.upload_date} <br>
			<div>
				<button class="button"
					onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=전체'">
					목록</button>
				<c:if test="${isOwner}" var="result">
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=update&creator=${post.creator}'">
						수정</button>
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=delete&creator=${post.creator}'">
						삭제</button>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>