<%@page import="java.sql.PreparedStatement"%>
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
	<h2>회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	JDBConnect jdbc = new JDBConnect();
	
	String [] id = {"musthave", "willhave", "dohave"};
	String [] pass = {"1234", "1234", "1234"};
	String [] name = {"머스트해브", "윌해브", "두해브"};
	
	for(int i = 0; i < id.length; i++){
		String sql = "INSERT INTO member(id,pass,name) VALUES (?, ?, ?)";
		PreparedStatement psmt = jdbc.getConnection().prepareStatement(sql);
		psmt.setString(1, id[i]);
		psmt.setString(2, pass[i]);
		psmt.setString(3, name[i]);
		int inResult = psmt.executeUpdate();
		out.println(inResult + "행이 입력되었습니다.");
	}
	
	for(int i = 1; i < 100; i++){
		String title = "제목" + i + "입니다.";
		String content = "내용" + i + "입니다.";
		String sql = "INSERT INTO board(title,content,id) VALUES (?, ?, ?)";
		PreparedStatement psmt = jdbc.getConnection().prepareStatement(sql);
		psmt.setString(1, title);
		psmt.setString(2, content);
		psmt.setString(3, id[i%3]);
		int inResult = psmt.executeUpdate();
		out.println(inResult + "행이 입력되었습니다.");
	}
	
	
	

	jdbc.close();
	%>
</body>
</html>