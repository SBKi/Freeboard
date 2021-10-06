<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div>
		<form action="loginAction.do" method="post">
			<input type="text" name="userid" placeholder="아이디(이메일) 입력하세요.">
			<input type="password" name="password" placeholder="비밀번호 입력하세요.">
			<input type="submit" value="Login">			
			<input type="button" value="HOME" onclick="location.href='./'">
		</form>
	</div>
</body>
</html>