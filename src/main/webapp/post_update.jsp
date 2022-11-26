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
		<header class="header_container logo">
			what's<br>in<br>your<br> <img alt="youtube logo"
				src="./resources/images/youtube.jpg">?
		</header>
		<div class="main_container column_box">
			<h1>Update Your Post</h1>
			<form
				action="http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=update"
				method="post">
				<ul class="post_ul">
					<li>유튜버 이름 : <input type="text" name="creator"
						value="${post.creator}" autofocus required
						placeholder="채널명을 입력하세요" />
					<li>카테고리 : <select name="category">
							<option value="운동">운동</option>
							<option value="게임">게임</option>
							<option value="노래">노래</option>
							<option value="동물">동물</option>
							<option value="커플">커플</option>
							<option value="뷰티">뷰티</option>
							<option value="기타">기타</option>
					</select>
					<li>간단한 소개 : <input type="text" name="content"
						value="${post.content}" required placeholder="간단한 소개글을 작성해주세요" />
					<li>업로드 날 : <input type="text" name="upload_date"
						value="${post.upload_date}" readonly />
				</ul>
				<input class="button input_btn" type="submit" name="submit" value="수정하기">
				<input class="button" type="reset" name="reset" value="다시 작성">
			</form>
			<button class="button goForum"
				onclick="location.href='http://localhost:8080/kimtaeyoung_free/ForumServlet?cmd=category&category=전체'">
				목록</button>
		</div>
	</div>
</body>
</html>