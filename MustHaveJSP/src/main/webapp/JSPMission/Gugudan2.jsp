<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan2</title>
</head>
<body>
<%
String col = request.getParameter("col");
if(col == null) col = "2";
int c = Integer.parseInt(col);
for(int i = 2; i <= 9; i+=c) {
	for(int j = 1; j <= 9; j++) {	
		for(int k = 0; k < c; k++) {
			if(i+k < 10) {
				out.print((i+k) + " * " + j + " = " + (i+k)*j);
				%> &nbsp;
				<%
			}					
		}
		%><br/>
		<%
	}
	%><br/>
	<%
}
%>
</body>
</html>