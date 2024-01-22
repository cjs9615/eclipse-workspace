<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");

try{
	JDBConnect jdbc = new JDBConnect();
	
	if(id == null || id.isEmpty() || pwd == null || pwd.isEmpty()) {
		request.setAttribute("msg", "아이디 또는 패스워드를 입력하세요.");
		request.getRequestDispatcher(
				"InsertFail.jsp")
			.forward(request, response);
		return;
	}
	String sql = "INSERT INTO member(id,pass,name) VALUES (?, ?, ?)";
	PreparedStatement psmt = jdbc.getConnection().prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pwd);
	psmt.setString(3, name);
	int cnt = psmt.executeUpdate();
	response.sendRedirect("InsertSuccess.jsp?cnt=" + cnt);
	
} catch (Exception e){
	request.setAttribute("msg", "삽입을 실패하였습니다.");
	request.getRequestDispatcher(
			"InsertFail.jsp")
		.forward(request, response);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>