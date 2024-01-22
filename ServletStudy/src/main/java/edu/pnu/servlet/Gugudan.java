package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8");
		String snum = req.getParameter("num");
		PrintWriter out = resp.getWriter();
		int num = 2;
		if (snum != null) {
			try {
				num = Integer.parseInt(snum);
				for(int i = 1; i < 10; i++) {
					out.println(num + " * " + i + " = " + num*i);
				}
			} catch (Exception e){
				out.println("숫자를 입력하세요");
			}
		}
		else {
			for(int i = 1; i < 10; i++) {
				out.println(num + " * " + i + " = " + num*i);
			}
		}
		
		out.close();
	}
}
