<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실패</title>
</head>
<body>
<%
String e = request.getAttribute("msg").toString();
out.print(e);
%>
<br /><br />
<a href="InsertForm.jsp">돌아가기</a>
</body>
</html>