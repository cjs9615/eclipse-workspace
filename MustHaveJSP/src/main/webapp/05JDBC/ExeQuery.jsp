<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>
	<%
	JDBConnect jdbc = new JDBConnect();
	
	String sql = "select id, pass, name, regidate from member";
	Statement stmt = jdbc.getConnection().createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	out.print("<table border='1'>");
	while (rs.next()) {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		
		out.print(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", id, pw, name, regidate));
	}
	out.print("</table>");
	
	sql = "select title, content, id, postdate from board";
	stmt = jdbc.getConnection().createStatement();
	
	rs = stmt.executeQuery(sql);
	out.print("<table border='1'>");
	while (rs.next()) {
		String title = rs.getString(1);
		String content = rs.getString(2);
		String id = rs.getString(3);
		java.sql.Date postdate = rs.getDate("postdate");
		
		out.print(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", title, content, id, postdate));
	}
	out.print("</table>");
	
	jdbc.close();
	%>
</body>
</html>