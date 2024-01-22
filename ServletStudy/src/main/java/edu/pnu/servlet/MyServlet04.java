package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myservlet04")
public class MyServlet04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyService04");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h2>국가별 수도</h2>");
		out.println("<table style = 'border : 1px solid black; border-collapse : separate;'>");
		out.println("<tr>");
		out.println("<td>번호</td><td>나라</td><td>수도</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>1</td><td>대한민국</td><td>서울</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>2</td><td>미국</td><td>워싱턴</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>3</td><td>일본</td><td>도쿄</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>4</td><td>중국</td><td>베이징</td>");
		out.println("</tr>");
		out.println("</table>");
		out.close();
	}
}
