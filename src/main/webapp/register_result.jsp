<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="domain.*"%>
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
			<h1>${isSuccess}</h1>
			<table>
				<tr>
					<th>크리에이터</th>
					<td>${post.creator}</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>${post.category}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${post.user_id }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${post.content }</td>
				</tr>
				<tr>
					<th>업로드 날</th>
					<td>${post.upload_date }</td>
				</tr>
			</table>
			<c:if test="${check == 0}" var="result">
				<button class="button"
					onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=add'">
					다시 작성</button>
			</c:if>
			<c:if test="${check == 1}" var="result">
				<button class="button"
					onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=전체'">
					목록</button>
			</c:if>
		</div>
	</div>
</body>
</html>