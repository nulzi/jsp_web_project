<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="domain.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p id="sect"><%=request.getAttribute("greetings")%>
	</p>
	<div>
		<%
		ForumVO post = (ForumVO) request.getAttribute("post");
		%>
		<table>
			<tr>
				<th>계정</th>
				<th>이름</th>
				<th>학번</th>
				<th>학과</th>
				<th>핸드폰</th>
			</tr>
			<tr>
				<td><%=post.getCreator()%></td>
				<td><%=post.getCategory()%></td>
				<td><%=post.getUser_id()%></td>
				<td><%=post.getContent()%></td>
				<td><%=post.getUpload_date()%></td>
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
</body>
</html>