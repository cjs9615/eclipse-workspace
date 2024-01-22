<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GugudanMain</title>
</head>
<body>
<%
String sel = request.getParameter("sel");
String val = request.getParameter("val");

if(val.equals("")) {
%>
	숫자를 입력하세요(2~9)
<%
	return;
}

if (sel.equals("type1")) {
	response.sendRedirect("Gugudan1.jsp?dan=" + val);
}
else {
	response.sendRedirect("Gugudan2.jsp?col=" + val);
}
%>
</body>
</html>