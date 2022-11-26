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
	<h2>
		creator name: ${post.creator}<br>
	</h2>
	category: ${post.category}
	<br> writer: ${post.user_id}
	<br> content: ${post.content}
	<br> upload_date: ${post.upload_date}
	<br>
	<button
		onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=total'">
		목록
	</button>
				<c:if test="${isOwner}" var="result">
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=update&creator=${post.creator}'">
						수정</button>
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=delete&creator=${post.creator}'">
						삭제</button>
				</c:if>
</body>
</html>