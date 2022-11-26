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
	<div class="forum_content">
		<c:forEach var="post" items="${postList}" begin="0" varStatus="status">
				<span class="post_content"
					onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=post&creator=${post.creator}'">
					<img width="30" height="20" alt="icon" src="./resources/images/${post.category}.png"><br>
					${post.creator} <br> 
					${post.upload_date}
				</span>
				<c:if test="${status.count % 5 == 0}"><hr></c:if>
		</c:forEach>
	</div>
</body>
</html>