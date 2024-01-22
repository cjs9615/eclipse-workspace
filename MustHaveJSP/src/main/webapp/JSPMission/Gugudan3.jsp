<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan3</title>
</head>
<body>
	<form method="post" action="GugudanMain.jsp">
		<input type="radio" name="sel" value="type1" />Type1
		<br />
		<input type="radio" name="sel" value="type2" checked="checked" />Type2
		<br />
		<textarea name="val" cols="20" rows="1"></textarea>단수/열수
		<br />
		<input type="submit" value="선택" />
		
	</form>
</body>
</html>