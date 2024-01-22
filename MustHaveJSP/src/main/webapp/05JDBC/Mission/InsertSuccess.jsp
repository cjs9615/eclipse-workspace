<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공</title>
</head>
<body>
<%
String cnt = request.getParameter("cnt");
out.println(cnt + "행이 입력되었습니다.");
%>
<br /><br />
<a href="InsertForm.jsp">돌아가기</a>
</body>
</html>