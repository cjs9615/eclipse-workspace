package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/binary")
public class Binary extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8");
		String num = req.getParameter("num");
		int n = Integer.parseInt(num);
		String result = "";
		PrintWriter out = resp.getWriter();
		if(n == 0) {
			result = "0";
		}
		while(true) {
			if(n == 0) break;
			else if(n%2 == 0) {
				n = n/2;
				result = "0" + result;
			}
			else {
				n = n/2;
				result = "1" + result;
			}
				
		}
		out.println("입력 : " + num + " => " + result + "(2)");
		out.close();
	}
}
