<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan1</title>
</head>
<body>
<%

	String dan = request.getParameter("dan");
	if(dan == null) dan = "2";
	int d = Integer.parseInt(dan);
	for(int i = 1; i < 10; i++){
		out.print(dan + " * " + i + " = " + (d*i));
		%><br/>
		<% 
	}
	%>
		
</body>
</html>