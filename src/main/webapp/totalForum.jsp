<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/public.css" type="text/css" />
</head>
<body>
	<div class="app_container">
		<header class="header_container category_side">
			<span class="small_logo"> <a
				href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=전체">
					what's in your <img width=60 height=40 alt="youtube logo"
					src="./resources/images/youtube.jpg">?
			</a>
			</span>
			<div class="category_list_container">
				<div class="user_info">
					<img width="16" height="20" alt="user"
						src="./resources/images/user.png"> ${user_username}님 환영합니다.<br>
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=logout'">
						로그아웃</button>
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/UserServlet?cmd=user_delete'">
						회원탈퇴</button>
				</div>
				<nav class="category_list">
					<ul>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=전체">
							전체
							<img alt="category items" src="./resources/images/전체.png"/>
							</a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=게임">게임
							<img alt="category items" src="./resources/images/게임.png"/></a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=동물">동물
							<img alt="category items" src="./resources/images/동물.png"/></a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=노래">노래
							<img alt="category items" src="./resources/images/노래.png"/></a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=커플">커플
							<img alt="category items" src="./resources/images/커플.png"/></a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=운동">운동
							<img  alt="category items" src="./resources/images/운동.png"/></a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=뷰티">뷰티
							<img alt="category items" src="./resources/images/뷰티.png"/></a></li>
						<li><a
							href="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=기타">기타
							<img alt="category items" src="./resources/images/기타.png"/></a></li>
					</ul>
				</nav>
			</div>
		</header>
		<div class="main_container forum_box">
			<div class="forum_container">
				<div class="forum_header">
					<h1>${category}게시판 </h1>
					<button class="button"
						onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=add'">게시글
						추가</button>
				</div>
				<br>
				<p>${isSuccess}</p>
				<jsp:include page="forumContent.jsp">
					<jsp:param value="${category}" name="category" />
					<jsp:param value="${forumList}" name="forumList" />
				</jsp:include>
			</div>
		</div>
	</div>
</body>
</html>