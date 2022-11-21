<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</body>
</html>