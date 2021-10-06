<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동아리 커뮤니티</title>
<script type="text/javascript">
function post_data() {

}
</script>
<link rel="stylesheet" href="css/temp.css">
</head>
<body>
<h3>동아리 커뮤니티 글 수정</h3>
<hr>
<form name="frm1" method="post" action="modify.do?page=${pageNo}" onsubmit="return post_data()">
 <input type="hidden" name="idx" value="${bean.idx}"> 
 <table>
 	<tr><th width="35%">제목</th>
 		<td><input type="text" name="subject" value="${bean.subject}" size="50" required></td>
 	</tr>
 	<tr><th>작성자</th>
 		<td><input type="text" name="name" value="${bean.name }" size="50" disabled></td>
 	</tr>
 	
 	<tr><th>글 비밀번호</th>
 		<td><input type="password" name="password"></td>
 	</tr>
 	<tr><th>내용</th>  
 		<td><textarea  rows="20" cols="80" name="content" required="required">${bean.content}</textarea></td>
 	</tr>
 	<tr><td colspan="2" align="center">
 	<input type="submit" value="저장" class="btn">
 	<input type="reset"  value="다시쓰기" class="btn">
 	<input type="button" value="목록" class="btn" onclick="location.href='list.do?page=${pageNo}'">
 	</td></tr>
 </table>
 </form>
</body>
</html>
