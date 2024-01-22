<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert 실행 페이지</title>
</head>
<body>
	<h2>인서트 쿼리</h2>
	<form action="InsertProcess.jsp" method="post">
	아이디 : <input type="text" name="id" value=""  placeholder="아이디"/>
	<br />
	패스워드 : <input type="text" name="pwd" value="" placeholder="패스워드"/>
	<br />
	이름 : <input type="text" name="name" value="" placeholder="이름"/>
	<br />
	<input type="submit" value="저장" />
	</form>
	<br />
	<a href="../../06Session/LoginForm.jsp">시작화면으로</a>
</body>
</html>