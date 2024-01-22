<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 낙하 물체의 위치 구하기</title>
</head>
<body>
	<form name="frm" method="get" action="FreeFall.do">
		시간 : <input type="text" name="t" /><br />
		<input type="submit" value="결과확인" />
	</form>
	<p>${ t }초 후 위치 : </p>
</body>
</html>