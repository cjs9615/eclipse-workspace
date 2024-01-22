package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan3")
public class Gugudan3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String dan = req.getParameter("dan");
		PrintWriter out = resp.getWriter();

		int d = Integer.parseInt(dan);
		out.println("<table style = 'border: 1px solid #444444; border-collapse: collapse;'>");
		for(int i = 2; i <= 9; i+=d) {
			for(int j = 1; j <= 9; j++) {	
				out.print("<tr>");
				for(int k = 0; k < d; k++) {
					if(i+k < 10) {
						out.print("<td style = 'border: 1px solid #444444;'>" + (i+k) + " * " + j + " = " + (i+k)*j + "</td>");
					}					
				}
				out.println("<tr>");
			}
			out.println();
		}
		out.println("</table>");
		out.close();
	}
}
