<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="catergories_list_container">
		youtube img
		<hr>
		환영합니다. ${user_username}님<br>
		<button onclick="location.href='http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=logout'">
			로그아웃
		</button>
		<ul>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=total">전체</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=game">게임</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=animal">동물</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=song">노래</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=couple">커플</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=exercise">운동</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=beauty">뷰티</a></li>
			<li><a href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=etc">기타</a></li>
		</ul>
	</div>
	<div class="forum_container">게시글</div>
</body>
</html>