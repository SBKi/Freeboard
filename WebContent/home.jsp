<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 커뮤니티 :: 자유게시판</title>
</head>
<body>
<c:if test="${sessionScope.readIdx == null }">
	<%	
		StringBuilder readIdx = new StringBuilder("/");
		session.setAttribute("readIdx", readIdx);
	%>
</c:if>
	<a href="list.do">커뮤니티 게시판</a><br>
	<a href="gallery.do">갤러리 게시판</a><br>

	<c:if test="${sessionScope.user==null }">
		<a href="login.do">로그인</a>
	</c:if>
	<c:if test="${sessionScope.user!=null }">
		<br> ${user.name }(${user.email })  님 반갑습니다. <br>
		<a href="logout.do">로그아웃</a>
	</c:if>
</body>
</html>