package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/leapyear")
public class LeapYear extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8");
		String year = req.getParameter("year");
		PrintWriter out = resp.getWriter();
		
		int y = Integer.parseInt(year);
		
		if(y % 400 == 0) {
			out.print(year + "년은 윤년입니다.");
		}
		else if(y % 100 == 0) {
			out.print(year + "년은 평년입니다.");
		}
		else if(y % 4 == 0) {
			out.print(year + "년은 윤년입니다.");
		}
		else {
			out.print(year + "년은 평년입니다.");
		}
		
		out.close();
	}
}
