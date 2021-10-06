<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day12 Gallery</title>
<style type="text/css">
input {  padding: 10px; border: 1px solid gray; border-radius:5px;  }
.thumbnail { padding-bottom: 10px; border:none; }
.thumbnail img{ width:100%;height: 300px; object-fit:cover; margin-bottom: 10px;}
.container {width:30%; float:left; padding:10px;border: none;}
</style>
</head>
<body>
	<form action="regist.do" method="post" enctype="multipart/form-data">
		<input type="text" name="title" placeholder="제목 입력하세요."><br>
		<input type="file" name="pic" accept="image/*"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	<!-- 업로드 후 view를 이 jsp로 함 아래에 업로드 이미지가 나오도록 -->
	
	<c:forEach var="item" items="${list }">
		<div class="container">
			<div class="thumbnail">
				<img alt="gallery" src="/img/${item.filename }">
				<!-- <Context docBase="C:\Users\Beomki\ShinBeomki" path="/img" reloadable="true"/> -> tomcat(server.xml)에서 수정 -->
			</div>
			<div>
				<strong>${item.title }</strong>
			</div>
		</div>
	</c:forEach>
	
</body>
</html>